package impl;

import java.util.Iterator;

public class BellmanFord {
	
	// The main function that finds shortest distances from src
    // to all other vertices using Bellman-Ford algorithm.  The
    // function also detects negative weight cycle
    public void calculateShortestPathFromSource(Graph graph, Node source)
    {   
        //for storing distances
        float[] distances = new float[graph.getNodesCount()];
 
        // Step 1: Initialize distances from src to all other
        // vertices as INFINITE
        for (int i = 0; i < distances.length; i++)
        {
            distances[i] = Float.MAX_VALUE;
        }
        distances[source.getId()] = 0;
 
        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        relaxAllEdges(graph, distances);
 
        // Step 3: check for negative-weight cycles.  The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        //  path, then there is a cycle.
        boolean hasNegativeWeightCycle = hasNegativeWeightCycle(graph, distances);
        
        if(!hasNegativeWeightCycle)
        {
            printResult(graph, source, distances);
        }
    }

	private void relaxAllEdges(Graph graph, float[] distances) {
		for (int i = 1; i < graph.getNodesCount() - 1; i++)
        {
            for (int j = 0; j < graph.getNodesCount() - 1; j++)
            {
            	Iterator<Edge> it = graph.neighbours(j).iterator();
            	while(it.hasNext())
            	{
            		Edge e = it.next(); //edge (u, v)
            		// if dist(u) + w(u, v) < dist(v) then
            		// dist(v) = dist(u) + w(u, v)
            		// pred(v) = u
            		int source = e.getSrc().getId();
            		int destination = e.getDest().getId();
            		float weight = e.getWeight();
            		if (distances[source] + weight < distances[destination])
            		{
            			distances[destination] = distances[source] + weight;
            		}
            	}
            }
        }
	}

	private boolean hasNegativeWeightCycle(Graph graph, float[] distances) {
		for (int i = 0; i < graph.getNodesCount() - 1; i++)
        {
        	Iterator<Edge> it = graph.neighbours(i).iterator();
        	while(it.hasNext())
        	{
        		Edge e = it.next(); //edge (u, v)
        		// if dist(u) + w(u, v) < dist(v) then
        		// graph contains negative-weight cycle
        		int source = e.getSrc().getId();
        		int destination = e.getDest().getId();
        		float weight = e.getWeight();
        		if (distances[source] + weight < distances[destination])
        		{
                    System.out.println("Graph contains negative-weight cycle!");
                    return true;
        		}
        	}
        }
		return false;
	}
 
    // A utility function used to print the solution
    private void printResult(Graph graph, Node source, float dist[])
    {
        for (Node node : graph.getNodes())
        {
        	if(node.getName().equals(source.getName()))
			{
				continue;
			}
        	System.out.print(source.getName() + " -> " + node.getName() + ": ");
			float distance = dist[node.getId()];
			String formatedDist = (long) distance == distance ? "" + (long) distance : "" + distance;
			System.out.println(formatedDist);
        }
    }

}

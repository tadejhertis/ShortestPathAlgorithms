package impl;

import java.util.Iterator;
import java.util.List;

public class BellmanFord extends Algorithm 
{
	
    public void calculateShortestPathFromSource(Graph graph, Node source)
    {   
		source.setDistance(0f);

		List<Node> nodes = graph.getNodes();
		for(Node first : nodes)
        {
			for(Node second : nodes)
		    {
				Iterator<Edge> it = graph.getEdgesOfNode(second.getId()).iterator();
				while(it.hasNext())
				{
					Edge e = it.next();
					calculateMinimumDistance(e.getDestination(), e.getWeight(), e.getSource());
				}
		    }
        }
 
        // Step 3: check for negative-weight cycles.  The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        //  path, then there is a cycle.
        boolean hasNegativeWeightCycle = hasNegativeWeightCycle(graph);
        
        if(!hasNegativeWeightCycle)
        {
            printResult(graph, source);
        }
    }

	private boolean hasNegativeWeightCycle(Graph graph) 
	{
		List<Node> nodes = graph.getNodes();
		for(Node node : nodes)
        {
        	Iterator<Edge> it = graph.getEdgesOfNode(node.getId()).iterator();
        	while(it.hasNext())
        	{
        		Edge e = it.next();
        		Node source = e.getSource();
        		Node destination = e.getDestination();
        		float weight = e.getWeight();
            	if (source.getDistance() + weight < destination.getDistance())
        		{
                    System.out.println("Graph contains negative-weight cycle!");
                    return true;
        		}
        	}
        }
		return false;
	}

}
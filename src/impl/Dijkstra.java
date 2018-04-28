package impl;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra {
	
	public void calculateShortestPathFromSource(Graph graph, Node source) 
	{
	    
		source.setDistance(0f);
	 
	    Set<Node> settledNodes = new HashSet<>();
	    Set<Node> unsettledNodes = new HashSet<>();
	 
	    unsettledNodes.add(source);
	 
	    while (unsettledNodes.size() != 0) 
	    {
	        Node currentNode = getLowestDistanceNode(unsettledNodes);
	        unsettledNodes.remove(currentNode);
	        for (Entry < Node, Float> adjacencyPair: currentNode.getAdjacentNodes().entrySet()) 
	        {
	            Node adjacentNode = adjacencyPair.getKey();
	            Float edgeWeight = adjacencyPair.getValue();
	            if (!settledNodes.contains(adjacentNode)) 
	            {
	                calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
	                unsettledNodes.add(adjacentNode);
	            }
	        }
	        settledNodes.add(currentNode);
	    }
	    printResult(graph, source);
	}
	
	private Node getLowestDistanceNode(Set < Node > unsettledNodes) 
	{
	    Node lowestDistanceNode = null;
	    float lowestDistance = Float.MAX_VALUE;
	    for (Node node : unsettledNodes) {
	        float nodeDistance = node.getDistance();
	        if (nodeDistance < lowestDistance) {
	            lowestDistance = nodeDistance;
	            lowestDistanceNode = node;
	        }
	    }
	    return lowestDistanceNode;
	}
	
	private void calculateMinimumDistance(Node evaluationNode, Float edgeWeigh, Node sourceNode) 
	{
			    Float sourceDistance = sourceNode.getDistance();
			    if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) 
			    {
			        evaluationNode.setDistance(sourceDistance + edgeWeigh);
			        LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			        shortestPath.add(sourceNode);
			        evaluationNode.setShortestPath(shortestPath);
			    }
	}
	
	private void printResult(Graph graph, Node source)
	{
		for(Node node : graph.getNodes())
		{
			if(node.getName().equals(source.getName()))
			{
				continue;
			}
			System.out.print(source.getName() + " -> " + node.getName() + ": ");
			float distance = node.getDistance();
			String formatedDist = (long) distance == distance ? "" + (long) distance : "" + distance; 
			System.out.println(formatedDist);
		}
	}

}

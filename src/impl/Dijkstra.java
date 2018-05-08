package impl;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra extends Algorithm {
	
	public void calculateShortestPathFromSource(Graph graph, Node source) 
	{
	    
		source.setDistance(0f);
	 
	    Set<Node> settledNodes = new HashSet<>();
	    Set<Node> unsettledNodes = new HashSet<>();
	 
	    unsettledNodes.add(source);
	 
	    while (!unsettledNodes.isEmpty()) 
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
	
	//...
	
	private Node getLowestDistanceNode(Set<Node> unsettledNodes) 
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

}

package impl;

import java.util.Collections;
import java.util.List;

public abstract class Algorithm 
{
	
	abstract public void calculateShortestPathFromSource(Graph graph, Node source);
	
	protected void calculateMinimumDistance(Node destinationNode, Float edgeWeight, Node sourceNode) 
	{
		Float sourceDistance = sourceNode.getShortestPath();
		Float pathWeight = sourceDistance + edgeWeight;
		if (pathWeight < destinationNode.getShortestPath()) 
		{
			destinationNode.setShortestPath(pathWeight);
		}
	}
	
	// ...
	
	protected void printResult(Graph graph, Node source)
	{
		List<Node> nodes = graph.getNodes();
		Collections.sort(nodes);
		for(Node node : graph.getNodes())
		{
			if(node.getName().equals(source.getName()))
			{
				continue;
			}
//			if(node.getShortestPath() == Float.MAX_VALUE)
//			{
//				continue;
//			}
			System.out.print(source.getName() + " -> " + node.getName() + ": ");
			float distance = node.getShortestPath();
			String formatedDist = (long) distance == distance ? "" + (long) distance : "" + distance; 
			System.out.println(formatedDist);
		}
	}

}

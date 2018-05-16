package impl;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
 
    private PriorityQueue<Edge>[] edges;
    private List<Node> nodes = new ArrayList<>();
 
    // Creates a graph with n nodes
    public Graph(int n)
    {
        edges = new PriorityQueue[n];
        for (int i = 0; i < n; i++)
        {
            edges[i] = new PriorityQueue<Edge>();
        }
    }
    
    public void addEdge(Node source, Node destination, float weight)
    {
    	edges[source.getId()].add(new Edge(source, destination, weight));
    	source.addDestination(destination, weight);
    }
    
	public void addNode(Node nodeA) 
	{
        nodes.add(nodeA);
    }
    
    public PriorityQueue<Edge> getEdgesOfNode(int node)
    {
    	return edges[node];
    }
    
    // ...
    
    public Node getNodeById(int id)
    {
    	for(Node node : nodes)
    	{
    		if(node.getId() == id)
    		{
    			return node;
    		}
    	}
    	return null;
    }
    
    public Node getNodeByLabel(String label)
    {
    	for(Node node : nodes)
    	{
    		if(node.getName().equals(label))
    		{
    			return node;
    		}
    	}
    	return null;
    }

	public PriorityQueue<Edge>[] getEdges() 
	{
		return edges;
	}

	public List<Node> getNodes() 
	{
		return nodes;
	}

}

package impl;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {
 
    private int nodesCount;
    private PriorityQueue<Edge>[] edges;
    private Set<Node> nodes = new HashSet<>();
 
    // Creates a graph with n nodes
    public Graph(int n)
    {
    	nodesCount = n;
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
    
//    public void addEdge(int sourceId, int destinationId, float weight)
//    {
//    	edges[sourceId].add(new Edge(sourceId, destinationId, weight));
//    	Node sourceNode = getNodeById(sourceId);
//    	Node destinationNode = getNodeById(destinationId);
//    	sourceNode.addDestination(destinationNode, weight);
//    }
    
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
    
    public PriorityQueue<Edge> neighbours(int node)
    {
    	return edges[node];
    }

	public int getNodesCount() {
		return nodesCount;
	}

	public void setNodesCount(int nodesCount) {
		this.nodesCount = nodesCount;
	}

	public PriorityQueue<Edge>[] getEdges() {
		return edges;
	}
	
	public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

	public Set<Node> getNodes() {
		return nodes;
	}

}

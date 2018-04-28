package impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
	
	private int id;
	private String name;  
    private List<Node> shortestPath = new LinkedList<>();    
    private Float distance = Float.MAX_VALUE;
     
    Map<Node, Float> adjacentNodes = new HashMap<>();
 
    public void addDestination(Node destination, float distance) 
    {
        adjacentNodes.put(destination, distance);
    }

	public Node(int id, String name) 
    {
        this.id = id;
        this.name = name;
    }
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public List<Node> getShortestPath() 
	{
		return shortestPath;
	}

	public void setShortestPath(List<Node> shortestPath) 
	{
		this.shortestPath = shortestPath;
	}

	public Float getDistance() 
	{
		return distance;
	}

	public void setDistance(Float distance) 
	{
		this.distance = distance;
	}

	public Map<Node, Float> getAdjacentNodes() 
	{
		return adjacentNodes;
	}

}

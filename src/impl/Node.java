package impl;

import java.util.HashMap;
import java.util.Map;

public class Node implements Comparable<Node> {
	
	private int id;
	private String name;  
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
	
	// ...
	// Getters and Setters
	
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

	@Override
	public int compareTo(Node o) 
	{
		Node other = (Node) o;
		return Float.compare(this.distance, other.distance);

	}

}

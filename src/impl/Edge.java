package impl;

public class Edge implements Comparable<Edge> 
{
	
	private Node source;
	private Node destination;
	private float weight;
    
	public Edge(Node source, Node destination, float weight) 
	{
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
	
	// ...
	// Getters and Setters

	public Node getSource() 
	{
		return source;
	}

	public void setSource(Node source) 
	{
		this.source = source;
	}

	public Node getDestination() 
	{
		return destination;
	}

	public void setDestination(Node destination) 
	{
		this.destination = destination;
	}
	
	public float getWeight() 
	{
		return weight;
	}

	public void setWeight(float weight) 
	{
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) 
	{
		Edge other = (Edge) o;
		return Float.compare(this.weight, other.weight);
	}

}

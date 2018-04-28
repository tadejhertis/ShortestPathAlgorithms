package impl;

public class Edge implements Comparable<Object> 
{
	
	private Node src;
//	private int srcId;
	private Node dest;
//	private int destId;
	private float weight;
    
	public Edge(Node src, Node dest, float weight) 
	{
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
	
//	public Edge(int srcId, int destId, float weight) 
//	{
//        this.srcId = srcId;
//        this.destId = destId;
//        this.weight = weight;
//    }

	public Node getSrc() 
	{
		return src;
	}

	public void setSrc(Node src) 
	{
		this.src = src;
	}

	public Node getDest() 
	{
		return dest;
	}

	public void setDest(Node dest) 
	{
		this.dest = dest;
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
	public int compareTo(Object o) 
	{
		Edge other = (Edge) o;
		return Double.compare(this.weight, other.weight);
	}

}

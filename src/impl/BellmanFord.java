package impl;

import java.util.Iterator;
import java.util.List;

public class BellmanFord extends Algorithm 
{
	
    public void calculateShortestPathFromSource(Graph graph, Node source)
    {   
		source.setShortestPath(0f);

		List<Node> nodes = graph.getNodes();
		for(int i = 1; i < nodes.size() - 1; i++)
        {
			for(Node node : nodes)
		    {
				Iterator<Edge> it = graph.getEdgesOfNode(node.getId()).iterator();
				while(it.hasNext())
				{
					Edge e = it.next();
					calculateMinimumDistance(e.getDestination(), e.getWeight(), e.getSource());
				}
		    }
        }
		
        boolean hasNegativeWeightCycle = checkNegativeWeightCycle(graph);
        
        if(hasNegativeWeightCycle)
        {
        	printNegativeCycle();
        }
        else
        {
            printResult(graph, source);
        }
    }

    // ...
    
	private boolean checkNegativeWeightCycle(Graph graph) 
	{
		for(Node node : graph.getNodes())
        {
        	Iterator<Edge> it = graph.getEdgesOfNode(node.getId()).iterator();
        	while(it.hasNext())
        	{
        		Edge e = it.next();
        		Node source = e.getSource();
        		Node destination = e.getDestination();
            	if (source.getShortestPath() + e.getWeight() < destination.getShortestPath())
        		{
                    return true;
        		}
        	}
        }
		return false;
	}
	
	// ... 
	
	private void printNegativeCycle()
	{
	    System.out.println("Graph contains negative-weight cycle!");
	}

}
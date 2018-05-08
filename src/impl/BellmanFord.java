package impl;

import java.util.Iterator;
import java.util.List;

public class BellmanFord extends Algorithm 
{
	
    public void calculateShortestPathFromSource(Graph graph, Node source)
    {   
		source.setDistance(0f);

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
 
        // Step 3: check for negative-weight cycles.  The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        //  path, then there is a cycle.
        boolean hasNegativeWeightCycle = checkNegativeWeightCycle(graph);
        
        if(!hasNegativeWeightCycle)
        {
            printResult(graph, source);
        }
    }

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
            	if (source.getDistance() + e.getWeight() < destination.getDistance())
        		{
                    System.out.println("Graph contains negative-weight cycle!");
                    return true;
        		}
        	}
        }
		return false;
	}

}
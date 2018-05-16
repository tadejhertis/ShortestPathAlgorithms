package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import impl.BellmanFord;
import impl.CSVParser;
import impl.Dijkstra;
import impl.Edge;
import impl.Graph;
import impl.Node;

public class TestSimulation {
	
	@Test
	public void testRunSimulation()
	{
		CSVParser parser = new CSVParser();
		
		List<Node> nodes = parser.parseNodesFileWithLabels("./src/resources/slovenijaNodes.csv");
		
		Graph graph = new Graph(nodes.size());
		for(Node node : nodes)
		{
			graph.addNode(node);
		}
		
		List<Edge> edges = parser.parseEdgesFileWithLabels("./src/resources/slovenijaEdges.csv", graph);
	
		for(Edge edge : edges)
		{
			graph.addEdge(edge.getSource(), edge.getDestination(), edge.getWeight());
		}
		
		
		
		long elapsedTime = 0;
		
		System.out.println("Bellman-Ford algoritem:");
		Date startDate = new Date();
        new BellmanFord().calculateShortestPathFromSource(graph, nodes.get(0));
		Date endDate = new Date();
		
	    elapsedTime = endDate.getTime() - startDate.getTime();
	    System.out.println("Bellman-Ford elapsed time: " + elapsedTime );
		
        System.out.println("Dijkstra algoritem:");
		startDate = new Date();
		new Dijkstra().calculateShortestPathFromSource(graph, nodes.get(0));
		endDate = new Date();
		
	    elapsedTime = endDate.getTime() - startDate.getTime();
	    System.out.println("Dijkstra elapsed time: " + elapsedTime );
	    
	}

}

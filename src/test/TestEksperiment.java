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

public class TestEksperiment 
{
	
	@Test
	public void testRunExperiment()
	{
		CSVParser parser = new CSVParser();
		
		List<Node> nodes5 = parser.parseNodesFile("./src/resources/ekspNodes5.csv");
		
		Graph graph5 = new Graph(nodes5.size());
		for(Node node : nodes5)
		{
			graph5.addNode(node);
		}
		
		List<Edge> edges5 = parser.parseEdgesFile("./src/resources/ekspEdges5.csv", graph5);
	
		for(Edge edge : edges5)
		{
			graph5.addEdge(edge.getSource(), edge.getDestination(), edge.getWeight());
		}
		
		List<Node> nodes20 = parser.parseNodesFile("./src/resources/ekspNodes20.csv");
		
		Graph graph20 = new Graph(nodes20.size());
		for(Node node : nodes20)
		{
			graph20.addNode(node);
		}
		
		List<Edge> edges20 = parser.parseEdgesFile("./src/resources/ekspEdges20.csv", graph20);
	
		for(Edge edge : edges20)
		{
			graph20.addEdge(edge.getSource(), edge.getDestination(), edge.getWeight());
		}
		
		List<Node> nodes50 = parser.parseNodesFile("./src/resources/ekspNodes50.csv");
		
		Graph graph50 = new Graph(nodes50.size());
		for(Node node : nodes50)
		{
			graph50.addNode(node);
		}
		
		List<Edge> edges50 = parser.parseEdgesFile("./src/resources/ekspEdges50.csv", graph50);
	
		for(Edge edge : edges50)
		{
			graph50.addEdge(edge.getSource(), edge.getDestination(), edge.getWeight());
		}
		
		List<Node> nodes80 = parser.parseNodesFile("./src/resources/ekspNodes80.csv");
		
		Graph graph80 = new Graph(nodes80.size());
		for(Node node : nodes80)
		{
			graph80.addNode(node);
		}
		
		List<Edge> edges80 = parser.parseEdgesFile("./src/resources/ekspEdges80.csv", graph80);
	
		for(Edge edge : edges80)
		{
			graph80.addEdge(edge.getSource(), edge.getDestination(), edge.getWeight());
		}
		
		long elapsedTime = 0;
		
//		System.out.println("Bellman-Ford algoritem (5):");
		Date startDate = new Date();
        new BellmanFord().calculateShortestPathFromSource(graph5, nodes5.get(0));
		Date endDate = new Date();
		
	    elapsedTime = endDate.getTime() - startDate.getTime();
	    System.out.println("Bellman-Ford elapsed time (5): " + elapsedTime );
		
//        System.out.println("Dijkstra algoritem (5):");
		startDate = new Date();
		new Dijkstra().calculateShortestPathFromSource(graph5, nodes5.get(0));
		endDate = new Date();
		
	    elapsedTime = endDate.getTime() - startDate.getTime();
	    System.out.println("Dijkstra elapsed time (5): " + elapsedTime );
	    
//	    System.out.println("Bellman-Ford algoritem (20):");
		startDate = new Date();
        new BellmanFord().calculateShortestPathFromSource(graph20, nodes20.get(0));
		endDate = new Date();
		
	    elapsedTime = endDate.getTime() - startDate.getTime();
	    System.out.println("Bellman-Ford elapsed time (20): " + elapsedTime );
		
//        System.out.println("Dijkstra algoritem (20):");
		startDate = new Date();
		new Dijkstra().calculateShortestPathFromSource(graph20, nodes20.get(0));
		endDate = new Date();
		
	    elapsedTime = endDate.getTime() - startDate.getTime();
	    System.out.println("Dijkstra elapsed time (20): " + elapsedTime );
	    
//	    System.out.println("Bellman-Ford algoritem (50):");
		startDate = new Date();
        new BellmanFord().calculateShortestPathFromSource(graph50, nodes50.get(0));
		endDate = new Date();
		
	    elapsedTime = endDate.getTime() - startDate.getTime();
	    System.out.println("Bellman-Ford elapsed time (50): " + elapsedTime );
		
//        System.out.println("Dijkstra algoritem (50):");
		startDate = new Date();
		new Dijkstra().calculateShortestPathFromSource(graph50, nodes50.get(0));
		endDate = new Date();
		
	    elapsedTime = endDate.getTime() - startDate.getTime();
	    System.out.println("Dijkstra elapsed time (50): " + elapsedTime );
	    
//	    System.out.println("Bellman-Ford algoritem (80):");
		startDate = new Date();
        new BellmanFord().calculateShortestPathFromSource(graph80, nodes80.get(0));
		endDate = new Date();
		
	    elapsedTime = endDate.getTime() - startDate.getTime();
	    System.out.println("Bellman-Ford elapsed time (80): " + elapsedTime );
		
//        System.out.println("Dijkstra algoritem (80):");
		startDate = new Date();
		new Dijkstra().calculateShortestPathFromSource(graph80, nodes80.get(0));
		endDate = new Date();
		
	    elapsedTime = endDate.getTime() - startDate.getTime();
	    System.out.println("Dijkstra elapsed time (80): " + elapsedTime );
	}

}

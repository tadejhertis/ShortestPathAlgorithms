package test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import impl.Algorithm;
import impl.BellmanFord;
import impl.Dijkstra;
import impl.Graph;
import impl.Node;

public class TestAlgorithms 
{
	Node nodeA = null;
	Node nodeB = null;
	Node nodeC = null;
	Node nodeD = null; 
	Node nodeE = null;
	Node nodeF = null;
	Integer nodesCount = null;
	 
	Algorithm algorithm = null;
	Graph graph = null;
	
	@Before
    public void init() {
		nodeA = new Node(0, "A");
		nodeB = new Node(1, "B");
		nodeC = new Node(2, "C");
		nodeD = new Node(3, "D"); 
		nodeE = new Node(4, "E");
		nodeF = new Node(5, "F");
		nodesCount = 6;
		 
		graph = new Graph(nodesCount);
		 
		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);
        
		graph.addEdge(nodeA, nodeB, 10);
		graph.addEdge(nodeA, nodeC, 15);
		
		graph.addEdge(nodeB, nodeD, 12);
		graph.addEdge(nodeB, nodeF, 15);
		
		graph.addEdge(nodeC, nodeE, 10);
		
		graph.addEdge(nodeD, nodeE, 2);
		graph.addEdge(nodeD, nodeF, 1);
		
		graph.addEdge(nodeF, nodeE, 5);
    }
	
	@Test
	public void testBellmanFord()
	{
		System.out.println("Bellman-Ford algoritem:");
		
		long elapsedTime = 0;
		
        //node A is source
		Date startDate = new Date();
        algorithm = new BellmanFord();
        algorithm.calculateShortestPathFromSource(graph, nodeA);
        Date endDate = new Date();
        elapsedTime = endDate.getTime() - startDate.getTime();
        System.out.println("Elapsed time: " + elapsedTime );
	}
	
	@Test
	public void testDijkstra()
	{
		System.out.println("Dijkstra algoritem:");
		
		long elapsedTime = 0;
		
		 //node A is source
		Date startDate = new Date();
		new Dijkstra().calculateShortestPathFromSource(graph, nodeA);
		Date endDate = new Date();
        elapsedTime = endDate.getTime() - startDate.getTime();
        System.out.println("Elapsed time: " + elapsedTime );
	}

}

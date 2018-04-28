package test;

import impl.Dijkstra;
import impl.Graph;
import impl.Node;

public class TestDijkstraDecimalWeights {
	
	public static void main(String[] args) {
		Node nodeA = new Node(0, "A");
		Node nodeB = new Node(1, "B");
		Node nodeC = new Node(2, "C");
		Node nodeD = new Node(3, "D");
		Node nodeE = new Node(4, "E");
		 
		Graph graph = new Graph(5);
		 
		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		
		graph.addEdge(nodeA, nodeB, 5.2f);
		graph.addEdge(nodeA, nodeD, 12.8f);
		graph.addEdge(nodeA, nodeC, 10.3f);
		
		graph.addEdge(nodeB, nodeD, 5.9f);
		graph.addEdge(nodeB, nodeE, 15.2f);
		
		graph.addEdge(nodeC, nodeB, 1.5f);
		graph.addEdge(nodeC, nodeD, 2.3f);
		
		graph.addEdge(nodeD, nodeE, 8.5f);
		
		graph.addEdge(nodeE, nodeC, 2.7f);
		 
		System.out.println("Dijkstra algoritem:");
		new Dijkstra().calculateShortestPathFromSource(graph, nodeA);

	}

}

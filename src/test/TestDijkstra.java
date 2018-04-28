package test;

import impl.Dijkstra;
import impl.Edge;
import impl.Graph;
import impl.Node;

public class TestDijkstra {

	public static void main(String[] args) {
		Node nodeA = new Node(0, "A");
		Node nodeB = new Node(1, "B");
		Node nodeC = new Node(2, "C");
		Node nodeD = new Node(3, "D"); 
		Node nodeE = new Node(4, "E");
		Node nodeF = new Node(5, "F");
		 
		Graph graph = new Graph(6);
		 
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
		 
		System.out.println("Dijkstra algoritem:");
		new Dijkstra().calculateShortestPathFromSource(graph, nodeA);

	}

}

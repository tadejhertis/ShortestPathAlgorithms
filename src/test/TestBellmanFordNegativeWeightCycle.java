package test;

import impl.BellmanFord;
import impl.Graph;
import impl.Node;

public class TestBellmanFordNegativeWeightCycle {

	public static void main(String[] args) {
		
		Node nodeA = new Node(0, "A");
		Node nodeB = new Node(1, "B");
		Node nodeC = new Node(2, "C");
		Node nodeD = new Node(3, "D");
		Node nodeE = new Node(4, "E");
		Node nodeF = new Node(5, "F");
		Node nodeG = new Node(6, "G");
		Node nodeH = new Node(7, "H");
		int nodesCount = 8;
		 
        Graph graph = new Graph(nodesCount);
        
        graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);
		graph.addNode(nodeG);
		graph.addNode(nodeH);
		
		graph.addEdge(nodeA, nodeB, 4);
		graph.addEdge(nodeA, nodeC, 4);
		
		//B nowhere
		
		graph.addEdge(nodeC, nodeE, 4);
		graph.addEdge(nodeC, nodeF, -2);
		
		graph.addEdge(nodeD, nodeA, 3);
		graph.addEdge(nodeD, nodeC, 2);
		
		graph.addEdge(nodeE, nodeD, 1);
		graph.addEdge(nodeE, nodeG, -2); //*
		
		graph.addEdge(nodeF, nodeB, 3);
		graph.addEdge(nodeF, nodeE, -3);
		
		graph.addEdge(nodeG, nodeF, 2);
		graph.addEdge(nodeG, nodeH, 2); //*
		
		graph.addEdge(nodeH, nodeE, -2); //*
        //* part of a negative-weight circle -2 + 2 - 2 = -2 < 0

		System.out.println("Bellman-Ford algoritem:");
        new BellmanFord().calculateShortestPathFromSource(graph, nodeA);

	}

}

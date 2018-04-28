package test;

import java.util.List;

import impl.BellmanFord;
import impl.CSVParser;
import impl.Dijkstra;
import impl.Edge;
import impl.Graph;
import impl.Node;

public class TestParser {

	public static void main(String[] args) {
		
		CSVParser parser = new CSVParser();
		
		List<Node> nodes = parser.parseNodesFile("./src/resources/testNodes.csv");
		
		Graph graph = new Graph(nodes.size());
		for(Node node : nodes)
		{
			graph.addNode(node);
		}
		
		List<Edge> edges = parser.parseEdgesFile("./src/resources/testEdges.csv", graph);
	
		for(Edge edge : edges)
		{
			graph.addEdge(edge.getSrc(), edge.getDest(), edge.getWeight());
		}
		
		System.out.println("Bellman-Ford algoritem:");
        new BellmanFord().calculateShortestPathFromSource(graph, nodes.get(0));
		
        System.out.println("Dijkstra algoritem:");
		new Dijkstra().calculateShortestPathFromSource(graph, nodes.get(0));

	}

}

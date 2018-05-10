package impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
	
	public List<Node> parseNodesFile(String filePath) 
	{
        String line = "";
        String cvsSplitBy = ",";
        List<Node> nodes = new ArrayList<Node>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
        	int nodesCount = 0;
            while ((line = br.readLine()) != null) 
            {
            	if(nodesCount == 0)
            	{
            		nodesCount++;
            		continue; //skip header
            	}
                // use comma as separator
                String[] lines = line.split(cvsSplitBy);
                String idString = lines[0].substring(1, lines[0].length());
                int id = Integer.parseInt(idString);
                Node node = new Node(id, lines[1]);
                nodes.add(node);
                nodesCount++;
                //System.out.println("Node [id= " + node.getId() + " , name=" + node.getName() +  "]");
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return nodes;
    }
	
	public List<Edge> parseEdgesFile(String filePath, Graph graph) 
	{
        String line = "";
        String cvsSplitBy = ",";
        List<Edge> edges = new ArrayList<Edge>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
        	int edgesCount = 0;
            while ((line = br.readLine()) != null) 
            {
            	if(edgesCount == 0)
            	{
            		edgesCount++;
            		continue; //skip header
            	}
                // use comma as separator
                String[] lines = line.split(cvsSplitBy);
                String sourceString = lines[0].substring(1, lines[0].length());
                int sourceId = Integer.parseInt(sourceString);
                Node sourceNode = graph.getNodeById(sourceId);
                String destinationString = lines[1].substring(1, lines[1].length());
                int destinationId = Integer.parseInt(destinationString);
                Node destinationNode = graph.getNodeById(destinationId);
                int weight = Integer.parseInt(lines[6]);
                Edge edge = new Edge(sourceNode, destinationNode, weight);
                edges.add(edge);
                edgesCount++;
                //System.out.println("Edge [source= " + edge.getSrc() + " , destination=" + edge.getDest() +  " , weight=" + edge.getWeight() + "]");

            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return edges;
    }

}

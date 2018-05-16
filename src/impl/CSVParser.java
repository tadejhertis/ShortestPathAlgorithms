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
        	int firstLine = 0;
            while ((line = br.readLine()) != null) 
            {
            	if(firstLine == 0)
            	{
            		firstLine++;
            		continue; //skip header
            	}
                // use comma as separator
                String[] lines = line.split(cvsSplitBy);
                String idString = lines[0].substring(1, lines[0].length());
                int id = Integer.parseInt(idString);
                Node node = new Node(id, lines[1]);
                nodes.add(node);
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
        	int firstLine = 0;
            while ((line = br.readLine()) != null) 
            {
            	if(firstLine == 0)
            	{
            		firstLine++;
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
                //System.out.println("Edge [source= " + edge.getSrc() + " , destination=" + edge.getDest() +  " , weight=" + edge.getWeight() + "]");

            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return edges;
    }
	
	public List<Node> parseNodesFileWithLabels(String filePath) 
	{
        String line = "";
        String cvsSplitBy = ",";
        List<Node> nodes = new ArrayList<Node>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
        	int firstLine = 0;
        	int nodesCount = 0;
            while ((line = br.readLine()) != null) 
            {
            	if(firstLine == 0)
            	{
            		firstLine++;
            		continue; //skip header
            	}
                // use comma as separator
                String[] lines = line.split(cvsSplitBy);
                Node node = new Node(nodesCount, lines[1]);
                nodes.add(node);
                nodesCount ++;
                //System.out.println("Node [id= " + node.getId() + " , name=" + node.getName() +  "]");
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return nodes;
    }
	
	public List<Edge> parseEdgesFileWithLabels(String filePath, Graph graph) 
	{
        String line = "";
        String cvsSplitBy = ",";
        List<Edge> edges = new ArrayList<Edge>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
        	int firstLine = 0;
            while ((line = br.readLine()) != null) 
            {
            	if(firstLine == 0)
            	{
            		firstLine++;
            		continue; //skip header
            	}
                // use comma as separator
                String[] lines = line.split(cvsSplitBy);
                String sourceString = lines[0];
                Node sourceNode = graph.getNodeByLabel(sourceString);
                String destinationString = lines[1];
                Node destinationNode = graph.getNodeByLabel(destinationString);
                int weight = Integer.parseInt(lines[6]);
                Edge edge = new Edge(sourceNode, destinationNode, weight);
                edges.add(edge);
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

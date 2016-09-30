package weightedgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class WeightedGraph {

	private Map<String, ArrayList<Node>> possiblePaths;
	private Stack<Node> paths;
	
	public WeightedGraph(ArrayList<String> connections){
		possiblePaths = new HashMap<String, ArrayList<Node>>();
		
		for(String s : connections)
			createMap(s);
		
		paths = new Stack<Node>();
	}
	
	public void printStack(){
		System.out.println(possiblePaths.toString());
	}
	//TODO: potentialy put markers on paths so program knows its been to them and doesnt traverse again
	public void createMap(String connection){
		String[] c = connection.split(" ");
		
		String start = c[0];
		String end = c[1];
		int distance = Integer.parseInt(c[2]);
		
		if (possiblePaths.containsKey(start)){
			ArrayList<Node> currentPaths = possiblePaths.get(start); //gets the list of the current paths from that node
			Node path = new Node(start, end, distance);
			currentPaths.add(path); //adds the path wanted to the list
			possiblePaths.put(start, currentPaths); //updates the list of paths
		}
		else {
			ArrayList<Node> currentPaths = new ArrayList<Node>(); //creates a new list of paths
			Node path = new Node(start, end, distance);
			currentPaths.add(path); //adds the path wanted to the list
			possiblePaths.put(start, currentPaths);//updates the list of paths
		}
		
		if (possiblePaths.containsKey(end)){
			ArrayList<Node> currentPaths = possiblePaths.get(end); //gets the list of the current paths from that node
			Node path = new Node(end, start, distance);
			currentPaths.add(path); //adds the path wanted to the list
			possiblePaths.put(end, currentPaths); //updates the list of paths
		}
		else {
			ArrayList<Node> currentPaths = new ArrayList<Node>(); //creates a new list of paths
			Node path = new Node(end, start, distance);
			currentPaths.add(path); //adds the path wanted to the list
			possiblePaths.put(end, currentPaths);//updates the list of paths
		}
	}
	
	public int getShortestDistance(String start, String end, int shortestDistance){
		
	}
	
	//think about creating helper methods
	
	private int sumStack(){
		Node[] pathsArray = (Node[]) (paths.toArray());
		int sum = 0;
		for(Node n : pathsArray)
			sum += n.getDistance();
		
		return sum;
	}
	
	public static void main(String[] args){
		ArrayList<String> c = new ArrayList<String>();
		
		c.add("A B 50");
		c.add("B C 50");
		c.add("A D 50");
		
		System.out.println(c);
		WeightedGraph w = new WeightedGraph(c);
		
		w.printStack();
		}
	
}

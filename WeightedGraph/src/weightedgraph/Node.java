package weightedgraph;

/**
 * A virtual representation of a destination where the properties of such a node
 * contain what it is, what it is connected to, and other properties like the distance
 * between it and it's connection, the speed on such a connection, etc.
 * @author Mihir Tiwari
 * @version 1.0, 9/8/2016
 */
public class Node {

	private String currentNode, connection;
	private int distance;
	
	public Node(String currentNode, String connectingNode, int distanceBetween){
		this.currentNode = currentNode;
		connection = connectingNode;
		distance = distanceBetween;
	}
	
	/**
	 * Gets the node that you are currently at
	 * @return currentNode The node you are currently at
	 */
	public String getCurrentNode(){
		return currentNode;
	}
	
	/**
	 * Gets the connection that the current node has
	 * @return connection The connection of the current node
	 */
	public String getConnection(){
		return connection;
	}
	
	/**
	 * Gets the distance between the current node and its connection
	 * @return distance The distance between the current node and its connection
	 */
	
	public int getDistance(){
		return distance;
	}
	
	/**
	 * Returns the node in a string formatted as "the_current_node --> the_connection" 
	 * and then its properties on the next line(s)
	 */
	public String toString(){
		return currentNode + " --> " + connection + "\nDistance: " + distance;
	}
}

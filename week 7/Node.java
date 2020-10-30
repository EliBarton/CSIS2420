package week7;
/**
 * Node - Generates the nodes for the linked list.
 * 
 * @author @professorgordon
 *
 */
public class Node 
{
	Node next;
	String data;
	
	public Node(String string)
	{
		this.data = string;
		this.next = null;
	}
}

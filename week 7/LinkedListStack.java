package week7;
/**
 * LinkedListStack Class - Stack implementation using 
 * 		a LinkedList coded from scratch, rather than
 * 		using the Java API classes.
 *
 * Methods:	LinkedListStack() - Constructor
 * 			push(int data)
 * 			pop() - Returns value of top node and removes node
 * 			peek() - Returns top node value w/o removing node
 * 			size() - Returns number of nodes in the stack
 * 			isEmpty() - Returns whether stack is empty or not.
 * 			printStack(LinkedListStack head)
 *
 * @author @professorgordon
 *
 */
public class LinkedListStack 
{
	Node head;
 
	public LinkedListStack() 
	{
		head = null;
	}
 
	public void push(String string) 
	{
		Node oldHead = head;
		head = new Node(string);
		head.next = oldHead;
	}
 
	public String pop()
	{
		if (head == null) 
		{
			return "";
		}
		else
		{
			String value = head.data;
			head = head.next;
			return value;
		}
	}
 
	public String peek()
	{
		if (!isEmpty()) 
		{ 
			return head.data; 
		} 
		else
		{ 
			System.out.println("Stack is empty"); 
			return ""; 
		} 
	}
	
	public int size()
	{
		Node temp = head;
		int nodeCount = 0;
		while (temp != null)
		{
			temp = temp.next;
			nodeCount++;
		}
		return nodeCount;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}

	public void printStack(Node head) 
	{
		Node temp = head;
		System.out.println("\nStack: ");
		while (temp != null)
		{
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}

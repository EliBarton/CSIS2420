package week6;

public class LinkedList2
{

	Node2 head;
	
	public void append(int key, String fname, String lname, double balance)
	{
		if (head == null)
		{
			head = new Node2(key, fname, lname, balance);
			return;
		}
		Node2 current = head;
		while (current.next != null)
		{
			current = current.next;
		}
		current.next = new Node2(key, fname, lname, balance);
	}
	
	public void prepend(int key, String fname, String lname, double balance)
	{
		Node2 newHead = new Node2(key, fname, lname, balance);
		newHead.next = head;
		head = newHead;
	}
	
	public void deleteWithValue(int key)
	{
		if (head == null) return;
		
		if (head.key == key)
		{
			head = head.next;
			return;
		}
		Node2 current = head;
		while (current.next != null)
		{
			if (current.next.key == key)
			{
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	public String searchList(int key)
	{
		String result = "Not found";
		if (head == null) return "List Empty";
		Node2 current = head;
	
		if (head.key == key)
		{
			result = "Key: " + head.key 
					+ "  Name: " + head.fname + " " 
					+ head.lname + "  Balance: "
					+ head.balance;
		}
		else
		{
			while (current.next != null)
			{
				if (current.next.key == key)
				{
					result = "Key: " + current.next.key 
							+ "  Name: " + current.next.fname + " " 
							+ current.next.lname + "  Balance: "
							+ current.next.balance;
				}
				current = current.next;
			}
		}
		return result;
	}
	
	public String searchList(String fn, String ln)
	{
		String result = "Not found";
		if (head == null) return "List Empty";
		Node2 current = head;
	
		if (head.fname.equals(fn) && head.lname.equals(ln))
		{
			result = "Key: " + head.key 
					+ "  Name: " + head.fname + " " 
					+ head.lname + "  Balance: "
					+ head.balance;
		}
		else
		{
			while (current.next != null)
			{
				if (current.next.fname.equals(fn) && current.next.lname.equals(ln))
				{
					result = "Key: " + current.next.key 
							+ "  Name: " + current.next.fname + " " 
							+ current.next.lname + "  Balance: "
							+ current.next.balance;
					break;
				}
				current = current.next;
			}
		}
		
		return result;
	}

	public String searchList(double balance)
	{
		String result = "Not found";
		if (head == null) return "List Empty";
		Node2 current = head;
	
		if (head.balance == balance)
		{
			result = "Key: " + head.key 
					+ "  Name: " + head.fname + " " 
					+ head.lname + "  Balance: "
					+ head.balance;
		}
		else
		{
			while (current.next != null)
			{
				if (current.next.balance == balance)
				{
					result = "Key: " + current.next.key 
							+ "  Name: " + current.next.fname + " " 
							+ current.next.lname + "  Balance: "
							+ current.next.balance;
					break;
				}
				current = current.next;
			}
		}
		
		return result;
	}

	public int length()
	{
		int len = 1;
		if (head == null) return len - 1;
		Node2 current = head;
		while (current.next != null)
		{
			len++;
			current = current.next;
		}
		return len;	
	}

	public void printList()
	{
		Node2 current = head;
		System.out.print("List: ");
		while (current != null)
		{
			System.out.print("\n\tKey: " + current.key + " [" + 
					current.fname + " " + 
					current.lname + "] Balance [" + 
					current.balance + "]" + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public void insert(int key, String fname, String lname, double balance, int insertKey) {
		if (head == null)
		{
			head = new Node2(key, fname, lname, balance);
			return;
		}
		Node2 current = head;
		while (current.key != insertKey)
		{
			current = current.next;
		}
		current.next = new Node2(key, fname, lname, balance);
	}
}

package week6;

public class LinkedListDemo 
{

	public static void main(String[] args)

	{
		LinkedList ll = new LinkedList();
		
		ll.append(5);
		ll.append(6);
		ll.append(8);
		ll.append(9);
		ll.append(1);
		ll.printList();
		
		ll.prepend(2);
		ll.printList();
		
		ll.deleteWithValue(8);
		ll.deleteWithValue(2);
		ll.deleteWithValue(1);
		ll.printList();
	}
	
}

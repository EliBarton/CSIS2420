package week6;
import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListDemo3 
{
	public static void main(String[] args) 
	{
	    LinkedList<Integer> intList = new LinkedList<Integer>();
	    intList.add(5);
	    intList.add(6);
	    intList.add(8);
	    intList.add(9);
	    intList.add(1);
	    printList(intList);
	    intList.addFirst(2);
	    printList(intList);
	    intList.removeFirstOccurrence(8);
	    intList.removeFirstOccurrence(2);
	    intList.removeFirstOccurrence(1);
	    printList(intList);
	}

	private static void printList(LinkedList<Integer> intList) 
	{
	    Iterator<Integer> it = intList.iterator();
	    System.out.print("List: ");
	    while (it.hasNext())
	    {
	    	System.out.print(it.next() + " -> ");
	    }
	    System.out.println("null");
	}
}

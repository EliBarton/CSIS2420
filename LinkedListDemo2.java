package week6;

public class LinkedListDemo2
{
	public static void main(String[] args)
	{
		LinkedList2 ll = new LinkedList2();
		ll.append(5,"Lester","Scroggs",43.56);
		ll.append(6,"Bert","Smith",27.99);
		ll.append(8,"Bob","Jones",45.92);
		ll.append(9,"Sally","Gomez",84.17);
		ll.append(1,"Mario","Plumm",20.00);
		ll.printList();
		System.out.println("\tList Length: " + ll.length());
		ll.prepend(2,"Ralph","Martinez",56.29);
		ll.printList();
		System.out.println("\tList Length: " + ll.length());
		ll.deleteWithValue(8);
		ll.deleteWithValue(2);
		ll.deleteWithValue(1);
		ll.printList();
		System.out.println("\tList Length: " + ll.length());
		// Search by Key
		System.out.println("\nSearch by Key Result: " + ll.searchList(9));
		System.out.println("Search by Key Result: " + ll.searchList(5));
		System.out.println("Search by Key Result: " + ll.searchList(99));
		// Search by fname & lname (inclusive)
		System.out.println("\nSearch by Name Result: " + ll.searchList("Sally", "Gomez"));
		System.out.println("Search by Name Result: " + ll.searchList("Bert", "Smith"));
		System.out.println("Search by Name Result: " + ll.searchList("Daffy", "Duck"));
		// Search by balance
		System.out.println("\nSearch by Balance Result: " + ll.searchList(43.56));
		System.out.println("Search by Balance Result: " + ll.searchList(99.99));
		
	}
}

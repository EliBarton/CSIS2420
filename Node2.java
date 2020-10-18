package week6;

public class Node2
{
	Node2 next;
	int key;
	String fname;
	String lname;
	double balance;
	
	public Node2(int key, String fname, 
			String lname, double balance)
	{
		this.key = key;
		this.fname = fname;
		this.lname = lname;
		this.balance = balance;
	}
}

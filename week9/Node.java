package week9;

public class Node {

	Node LeftChild;
	Node RightChild;
	int IP;
	String User;

	/**
	 * Constructor. Assigns the variables to the node.
	 * @param leftChild   The left child node.
	 * @param rightChild  The right child node.
	 * @param iP   The ip of the node.
	 * @param user  The username of the node.
	 */
	
	public Node(Node leftChild, Node rightChild, int iP, String user) {
		super();
		LeftChild = leftChild;
		RightChild = rightChild;
		IP = iP;
		User = user;
	}

	/**
	 * Inserts the node into a node tree.
	 * @param newIP The IP from the csv file for the new node.
	 * @param newusername The Username from the csv file for the new node.
	 */
	
	public void insertInto(int newIP, String newusername) {
		if (newIP < IP) {
			if (LeftChild != null) {
				LeftChild.insertInto(newIP, newusername);
			}else {
				LeftChild = new Node(null, null, newIP, newusername);
			}
		}else {
			if (RightChild != null) {
				RightChild.insertInto(newIP, newusername);
			}else {
				RightChild = new Node(null, null, newIP, newusername);
			}
		}
	}
	
	/**
	 * Counts how many nodes are in the tree.
	 * @return
	 */
	
	public int countTree() {
		int total = 0;
		if (LeftChild != null) {
			total += LeftChild.countTree();
		}
		if (RightChild != null) {
			total += RightChild.countTree();
		}
		return total + 1;
	}
	
	/**
	 * Searches the children nodes for a node with the desired IP.
	 * @param desiredIP
	 * @return
	 */
	
	public Node searchByIP(int desiredIP) {
		if (IP == desiredIP) {
			return this;
		}else {
			if (desiredIP > IP) {
				if (RightChild != null) {
				System.out.println("went right");
				return RightChild.searchByIP(desiredIP);
				}else {
					return null;
				}
			}else {
				if (LeftChild != null) {
				System.out.println("went left");
				return LeftChild.searchByIP(desiredIP);
				}else {
					return null;
				}
			}

		}
	}
	
	/**
	 * Searches the children nodes for a desired username.
	 * @param desiredUser
	 * @return
	 */
	
	public Node searchByUsername(String desiredUser) {
		Node result;
		if (User.equalsIgnoreCase(desiredUser)) {
			return this;
		}else {
			if (LeftChild != null) {
				result = LeftChild.searchByUsername(desiredUser);
				if (result != null) {
					return result;
				}
			}
			if (RightChild != null) {
				result = RightChild.searchByUsername(desiredUser);
				if (result != null) {
					return result;
				}
			}
			
			
		}
		return null;
	}
	
	/**
	 * Goes to every node in the tree in order of IP and tells it to print it's information.
	 */
	
	public void printByIP() {
		if (LeftChild != null) {
			LeftChild.printByIP();
		}else {
			System.out.println("10.0.0." + Integer.toString(IP) + " " + User);
			return;
		}
		if (RightChild != null) {
			RightChild.printByIP();
		}else {
			System.out.println("10.0.0." + Integer.toString(IP) + " " + User);
			return;
		}
	}
}

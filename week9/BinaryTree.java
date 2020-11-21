package week9;

public class BinaryTree {
	
	Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	public void insertInto(int IP, String username) {
		if (root == null) {
			root = new Node(null, null, IP, username);
		}else {
			root.insertInto(IP, username);
		}
	}
	

}

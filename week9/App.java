package week9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The main program. Runs the UI and tells the nodes and tree to do various things.
 * @author eli
 *
 */

public class App {
	
	static BinaryTree nodeTree;
	
	/**
	 * Initializes the tree and starts up the main menu.
	 * @param args
	 * @throws IOException
	 */
	
	public static void main(String[] args) throws IOException {
		nodeTree = new BinaryTree();
		menu();
	}
	
	/**
	 * The main menu. Allows you to choose between 6 options by inputting numbers 1-6.
	 * @throws IOException
	 */
	
	private static void menu() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("");
		System.out.println("");
		System.out.println("---------------------");
		System.out.println("1 Build Users Tree");
		System.out.println("2 Find by IP Address");
		System.out.println("3 Find by Username");
		System.out.println("4 Report Number of Nodes");
		System.out.println("5 Print Entire Tree");
		System.out.println("6 Exit");
		System.out.println("---------------------");
		System.out.println("Enter 1, 2, 3, 4, 5, or 6:");
		
		String input = reader.readLine();
		
		if (input.startsWith("1")){
			buildTree();
		}
		else if (input.startsWith("2")){
			IPsearch();
		}
		else if (input.startsWith("3")){
			UserSearch();
		}
		else if (input.startsWith("4")){
			System.out.println(Integer.toString(nodeTree.root.countTree()));
			menu();
		}
		else if (input.startsWith("5")){
			nodeTree.root.printByIP();
			menu();
		}
		else if (input.startsWith("6")){
			System.out.println("Thank you. Goodbye.");
			return;
		}else {
			System.out.println("You didn't input a number 1-6. Try again.");
			menu();
		}
	}
	
	/**
	 * Reads from the Users.csv file and creates a binary tree with the data.
	 */
	
	private static void buildTree() {
		String dataFile = "Users.csv";
		
			
			int numLines = 0;
			BufferedReader br = null;
	        String line = "";
	        String csvSplitBy = ",";
	    try 
	    { 
	    	// You will need to change the path for your environment
	    	File path = new File("/home/eli/eclipse-workspace/Week 9/src/");
	    	File usersFile = new File(path + "/" + dataFile); 
	    	BufferedReader reader;
				reader = new BufferedReader(new FileReader(usersFile));

	        // Count the number of lines in the data file
	        System.out.print("Counting lines in the data file ... ");
			while (reader.readLine() != null) numLines++;
			reader.close();
			System.out.println(numLines);

	    	// Get data set from file and load array with values
	        br = new BufferedReader(new FileReader(usersFile));
	    	for (int i = 0; i < numLines; i++)
	    	{
	    		line = br.readLine();
	    		String[] line2 = line.split(csvSplitBy);
				nodeTree.insertInto(Integer.parseInt(line2[0]), line2[1]);
				System.out.println("node inserted");
	    	}
	    	System.out.println(Integer.toString(nodeTree.root.IP));
	    	menu();
	    
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	/**
	 * Asks the user for an IP to search for. Then it tells the tree root to search for that IP.
	 * @throws IOException
	 */
	
	private static void IPsearch() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("");
		System.out.println("");
		System.out.println("Enter the IP you want to search for:");
		String input = reader.readLine();
		
		Node nodeFound = nodeTree.root.searchByIP(Integer.valueOf(input));
		
		if (nodeFound != null) {
		System.out.println("Node found: 10.0.0." + Integer.toString(nodeFound.IP) + " " + nodeFound.User);
		}else {
			System.out.println("Node 10.0.0." + input + " does not exist");
		}
		menu();
	}
	
	/**
	 * Asks the user for a username to search for. It tells the tree root to search for that username.
	 * @throws IOException
	 */
	
	private static void UserSearch() throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("");
		System.out.println("");
		System.out.println("Enter the User you want to search for:");
		String input = reader.readLine();
		
		Node nodeFound = nodeTree.root.searchByUsername(input);
		
		if (nodeFound != null) {
			System.out.println("Node found: 10.0.0." + Integer.toString(nodeFound.IP) + " " + nodeFound.User);
			}else {
				System.out.println("Node " + input + " does not exist");
			}
			menu();
	}
}

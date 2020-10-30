package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This is the code that runs the Santa's Toy Factory application.
 * It uses the LinkedListStack class to keep track of the toys.
 * 
 * @author eli
 *
 */

public class Application {
	
	/**
	 * The main method that initializes the game.
	 * @param args
	 * @throws IOException
	 */
	
	public static void main(String[] args) throws IOException {
		LinkedListStack sleigh = new LinkedListStack();

		System.out.println("Welcome to Santa's Toy Factory!");
		System.out.println("");
		System.out.println("Your job is to make toys in order so santa can pick up the right present from the top of the pile.");
		System.out.println("");
		System.out.println("Santa's only got 1 night to get through everything, so any mistakes are dire.");
		System.out.println("");
		
		MainMenu(sleigh);

	}
	
	/**
	 * This is the main menu that lets you choose between 6 different options of what to do,
	 * @param sleigh - The stack of toys in the sleigh
	 * @throws IOException
	 */
	
	private static void MainMenu(LinkedListStack sleigh) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("");
		System.out.println("");
		System.out.println("Press numbers on the keyboard to select options.");
		System.out.println("1. Make a toy and add it to the sleigh");
		System.out.println("2. Check the list and order of kids");
		System.out.println("3. Ask what a kid wants");
		System.out.println("4. Take the top present off the sleigh and throw it away");
		System.out.println("5. Check the contents of the sled");
		System.out.println("6. Send santa to deliver the presents");
		
		String input = reader.readLine();
		
		if (input.startsWith("1")){
			factory(sleigh);
		}
		if (input.startsWith("2")){
			CheckList(sleigh);
		}
		if (input.startsWith("3")){
			AskKid(sleigh);
		}
		if (input.startsWith("4")){
			sleigh.pop();
			System.out.println("The top present has been thrown away");	
			MainMenu(sleigh);
		}
		if (input.startsWith("5")){
			sleigh.printStack(sleigh.head);
			MainMenu(sleigh);
		}
		if (input.startsWith("6")){
			CheckPresents(sleigh);
		}
	}
	
	/**
	 * This code takes you to the factory where you can make and add toys to the sleigh.
	 * @param sleigh - stack of toys
	 * @throws IOException
	 */
	
	private static void factory(LinkedListStack sleigh) throws IOException {
		System.out.println("");
		System.out.println("");
		System.out.println("What toy do want to make and place in the sleigh?");
		System.out.println("1. Bear");
		System.out.println("2. Bike");
		System.out.println("3. Doll");
		System.out.println("4. Laptop");
		System.out.println("5. Tomato");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		
		if (input.startsWith("1")){
			sleigh.push("Bear");
		}
		if (input.startsWith("2")){
			sleigh.push("Bike");
		}
		if (input.startsWith("3")){
			sleigh.push("Doll");
		}
		if (input.startsWith("4")){
			sleigh.push("Laptop");
		}
		if (input.startsWith("5")){
			sleigh.push("Tomato");
		}
		System.out.println("The toy has been built and placed in the sleigh.");
		MainMenu(sleigh);
	}
	
	/**
	 * This code displays the list of kids in the order that santa gives them the present
	 * @param sleigh
	 * @throws IOException
	 */
	
	private static void CheckList(LinkedListStack sleigh) throws IOException {
		System.out.println("");
		System.out.println("");
		System.out.println("The list and order of kids is:");
		System.out.println("Carol, Emily, Bob, Sarah, Billy, and Henry");
		MainMenu(sleigh);
	}
	
	/**
	 * This method lets you ask a kid what they want.
	 * @param sleigh - stack of toys
	 * @throws IOException
	 */
	
	private static void AskKid(LinkedListStack sleigh) throws IOException {
		System.out.println("");
		System.out.println("");
		System.out.println("What kid do you want to ask?");
		System.out.println("1. Sarah");
		System.out.println("2. Bob");
		System.out.println("3. Carol");
		System.out.println("4. Henry");
		System.out.println("5. Billy");
		System.out.println("6. Emily");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		
		if (input.startsWith("1")){
			System.out.println("Sarah says she wants something she can use to get to school faster");
		}
		if (input.startsWith("2")){
			System.out.println("Bob says he wants something to throw at people he doesn't like");
		}
		if (input.startsWith("3")){
			System.out.println("Carol says she wants something that will have tea parties with her");
		}
		if (input.startsWith("4")){
			System.out.println("Henry wants an animal to be good friends with");
		}
		if (input.startsWith("5")){
			System.out.println("Billy wants something he can use to do his CSIS 2420 assignment");
		}
		if (input.startsWith("6")){
			System.out.println("Emily wants something she can sell on the black market for big bucks");
		}
		MainMenu(sleigh);
	}
	
	/**
	 * This method shows the results.
	 * The results are different depending on what each child gets and how many presents are in the sleigh.
	 * @param sleigh - stack of toys
	 */
	
	private static void CheckPresents(LinkedListStack sleigh) {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Results:");
		System.out.println("");
		if (sleigh.isEmpty()) {
			RanOut();
			return;
		}
		System.out.println("Henry:");
		if (sleigh.peek().matches("Bear")) {
			System.out.println("Henry is happy with his present; a bear is the perfect friend");
		}else if (sleigh.peek().matches("Tomato")) {
			System.out.println("Henry is very happy with his present because he is stupid and thinks that tomatoes are animals");
		}else {
			System.out.println("Henry is not happy with his present. He still tried to be friends but he really wanted an animal friend, not this crap.");
		}
		sleigh.pop();
		if (sleigh.isEmpty()) {
			RanOut();
			return;
		}
		System.out.println("");
		System.out.println("Billy:");
		if (sleigh.peek().matches("Laptop")) {
			System.out.println("Billy is very happy with his present! He does his CSIS assignment right away");
		}else {
			System.out.println("Billy is not happy with his present. He failed his CSIS assignment and lost his scholarship.");
		}
		sleigh.pop();
		if (sleigh.isEmpty()) {
			RanOut();
			return;
		}
		System.out.println("");
		System.out.println("Sarah:");
		if (sleigh.peek().matches("Bike")) {
			System.out.println("Sarah is very happy with her present. She can get to school in a fraction of the time");
		}else if (sleigh.peek().matches("Bear")) {
			System.out.println("Sarah is happy with her present. Bears can travel suprisingly fast, so she gets to school quickly.");
		}else if (sleigh.peek().matches("Laptop")) {
			System.out.println("Sarah is unsure about her present. She gets to school in a few seconds but she misses all her friends");
		}else {
			System.out.println("Sarah is not happy about her present. She can't get to school on time.");
		}
		sleigh.pop();
		if (sleigh.isEmpty()) {
			RanOut();
			return;
		}
		System.out.println("");
		System.out.println("Bob:");
		if (sleigh.peek().matches("Tomato")) {
			System.out.println("Bob is very happy with his gift. He throws his tomato at you because he wanted two tomatoes");
		}else if(sleigh.peek().matches("Laptop")) {
			System.out.println("Bob is happy with his gift. It's a little bit hard to throw, but with practice he can hit people from 20 feet away.");
		}else if (sleigh.peek().matches("Bear")) {
			System.out.println("Bob is unsure about his gift. The bear doesn't like being thrown.");
		} else {
			System.out.println("Bob does not like his gift. It doesn't feel right to throw.");
		}
		sleigh.pop();
		if (sleigh.isEmpty()) {
			RanOut();
			return;
		}
		System.out.println("");
		System.out.println("Emily:");
		if (sleigh.peek().matches("Bear")) {
			System.out.println("Emily is very happy with her gift. The bear she sold got her $8,000.");
		} else if (sleigh.peek().matches("Tomato")) {
			System.out.println("Emily is happy with her gift. Suprisingly, someone was asking for a tomato on the black market and she got $1,000");
		}else {
			System.out.println("Emily is not happy with her gift. She could barely sell it for $2");
		}
		sleigh.pop();
		if (sleigh.isEmpty()) {
			RanOut();
			return;
		}
		System.out.println("");
		System.out.println("Carol:");
		if (sleigh.peek().matches("Doll")) {
			System.out.println("Carol is very happy with her present. The doll is so fun to party with.");
		}else {
			System.out.println("Carol is not happy with her present. It doesn't drink tea and it doesn't party.");
		}
		sleigh.pop();
		if (sleigh.isEmpty()) {
			System.out.println("Congratulations! Everyone got a present and santa made it back safely. A job well done.");
		}else {
			System.out.println("You put in too many presents into Santa's sleigh. The extra weight made the reindeers faint from exaustion and Santa fell 2,000 feet to his doom.");
		}
	}
	
	/**
	 * This method runs whenever santa runs out of presents in his sleigh before he's done giving them out.
	 */
	
	private static void RanOut() {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Santa ran out of presents and the children woke up with nothing. "
				+ "Santa banishes you to live with polar bears the rest of your days.");
	}
	
}

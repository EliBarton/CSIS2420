package week6;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class GenRandAccounts 
{
	public static void main(String[] args) 
	{
		String dataFile = "AccountNumbers.csv";
		int min = 100000;
		int max = 999999;
		int numAccounts = 50000;
		Random rand = new Random();
		 
		 Date startDate = Calendar.getInstance().getTime();
		    long d_StartTime = new Date().getTime();
			
			int numLines = 0;
			BufferedReader br = null;
	        String line = "";
	        String csvSplitBy = ",";
	    try 
	    { 
	    	// You will need to change the path for your environment
	    	File path = new File("/home/eli");
	    	File accountsFile = new File(path + "/" + dataFile); 
	    	
	    	if (accountsFile.exists()) 
	    	{
	    		accountsFile.delete();     
	        }
	        if (accountsFile.createNewFile()) 
	        { 
	        	System.out.println("File created: " + path + "/" + accountsFile.getName()); 
				FileWriter csvWriter = new FileWriter(path + "/" + accountsFile.getName());
	    		for (int i = 1; i <= numAccounts; i++)
	            {
					csvWriter.write(Integer.toString(rand.nextInt((max - min) + 1) + min) + "\n");
	            }
				csvWriter.close();
				System.out.printf("Number of Accounts Written to File: %,d", numAccounts);
	        }
	        else
	        { 
	        	System.out.println("File already exists."); 
	        } 
	       
	        String dataFile2 = "/home/eli/AccountNumbers.csv";
	    	BufferedReader reader = new BufferedReader(new FileReader(dataFile2));

	        // Count the number of lines in the data file
	        System.out.print("Counting lines in the data file ... ");
			while (reader.readLine() != null) numLines++;
			reader.close();
			System.out.println(numLines);
			LinkedList2 accounts = new LinkedList2();

	    	// Get data set from file and load array with values
	    	System.out.println("Building linked list from the data file ...");
	        br = new BufferedReader(new FileReader(dataFile2));
	    	for (int i = 0; i < numLines; i++)
	    	{
	    		line = br.readLine();
				accounts.append(i, line, line, Integer.valueOf(line));
	    	}
	    	
	    	LinkedList<Integer> accounts2 = new LinkedList<Integer>();
	    	
	    	// Get data set from file and load array with values
	    	System.out.println("Building linked list from the data file ...");
	        br = new BufferedReader(new FileReader(dataFile2));
	    	for (int i = 0; i < numLines; i++)
	    	{
	    		line = br.readLine();
				accounts2.add(Integer.valueOf(line));
	    	}
	    	
	    	startDate = Calendar.getInstance().getTime();
		    d_StartTime = new Date().getTime();
		    accounts.append(50001, "50001", "50001", Integer.valueOf("50001"));
		    Date endDate = Calendar.getInstance().getTime();
		    long d_endTime = new Date().getTime();
		    System.out.printf("Start Date: %s, (End Date : %s %n", startDate, endDate);
		    System.out.printf("Milli: %s, D_Start: %s, D_End: %s) %n", d_endTime - d_StartTime, d_StartTime, d_endTime);
		    
		    startDate = Calendar.getInstance().getTime();
		    d_StartTime = new Date().getTime();
		    accounts2.add(50001);
		    endDate = Calendar.getInstance().getTime();
		    d_endTime = new Date().getTime();
		    System.out.printf("Start Date: %s, (End Date : %s %n", startDate, endDate);
		    System.out.printf("Milli: %s, D_Start: %s, D_End: %s) %n", d_endTime - d_StartTime, d_StartTime, d_endTime);
	    } 
	    catch (IOException e) 
	    {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace(); 
	    } 
	}
}

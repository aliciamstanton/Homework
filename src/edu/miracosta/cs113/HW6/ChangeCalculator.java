
// Package where file can be found 
package edu.miracosta.cs113.HW6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.*;
import java.util.*;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculator 
{

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents.
     *
     * In addition to returning the number of unique combinations, this method will print out each combination to the
     * console. The format of naming each combination is up to the user, as long as they adhere to the expectation
     * that the coins are listed in descending order of their value (quarters, dimes, nickels, then pennies). Examples
     * include "1Q 2D 3N 4P", and "[1, 2, 3, 4]".
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
	
	// Data Structure of choice - ArrayList
	private static ArrayList<Coin> combinations = new ArrayList<>();
	

	// 	Empty Constructor
	public ChangeCalculator()
	{
		
	}
	
	
	// Calculate Change Method 
    public static int calculateChange(int cents) 
    {
        // TODO:
        // Implement a recursive solution following the given documentation.

        // Recursive call to method 
    	return calculateChange(cents, 0, new Coin());
    }
    
    // Additional method to calculate combinations
    public static int calculateChange(int cents, int count, Coin newCoin)
    {
    	
    	// Base Case
    	if(cents == 0)
    	{
    		// Need to check if the combination is already in the ArrayList
    		if(combinations.contains(newCoin))
    		{
    			return 0;
    		}
    		
    		// Otherwise we can add it to the arrayList
    		else
    		{
    			combinations.add(newCoin);
    			return 1;
    		}
    	}
    	
    	
    	// If we are not at the base case then we can recurse until we reach zero cents
    	else
    	{
    		// Create a counter 
    		int currentCount = 0;
    		
    		// Create a base case that will check for each coin 
    		
    		// Pennies
    		if(cents >= 1)
    		{
    			// Create a temp coin
    			Coin temp = new Coin(newCoin);
    			
    			// Add a penny
    			temp.addPenny();
    			
    			// Recursive call
    			currentCount += calculateChange((cents - 1), 1, temp);
    		}
    		
    		// Nickels
    		if(cents % 5 == 0 && cents >= 5)
    		{
    			// Create a temp
    			Coin temp = new Coin (newCoin);
    			
    			// Add a nickel
    			temp.addNickel();
    			
    			// Recursive Call
    			currentCount += calculateChange((cents - 5), 1, temp);
    		}
    		
    		// Dimes
    		if(cents % 10 == 0 && cents >= 10)
    		{
    			// Temp coin
    			Coin temp = new Coin(newCoin);
    			
    			// Add dime
    			temp.addDime();
    			
    			// Recursive call
    			currentCount += calculateChange((cents - 10), 1, temp);
    		}
    		
    		// Quarters
    		if(cents % 25 == 0 && cents >= 25)
    		{
    			// Create temp
    			Coin temp = new Coin(newCoin);
    			
    			// Add quarter
    			temp.addQuarter();
    			
    			// Recursive call
    			currentCount += calculateChange((cents - 25), 1, temp);
    		}
    		
    		// Update the count
    		count = currentCount;
    		
    		// return the count
    		return count;
    	}
    
    }

    /**
     * Calls upon calculateChange(int) to calculate and print all possible unique combinations of quarters, dimes,
     * nickels, and pennies that equal the given value in cents.
     *
     * Similar to calculateChange's function in printing each combination to the console, this method will also
     * produce a text file named "CoinCombinations.txt", writing each combination to separate lines.
     *
     * @param cents a monetary value in cents
     */
    public static void printCombinationsToFile(int cents) 
    {
        // TODO:
        // This when calculateChange is complete. Note that the text file must be created within this directory.
    	
    	// Call the recursive method
    	calculateChange(cents);
    	
    	// Create the text file in the directory
    	String outputFile = "src/edu.miracosta.cs113/HW6/CoinCombinations.txt";
    	
    	// Make a try/catch block that will make sure the file is available
    	try
    	{
    		// Open the file stream
    		File fileOut = new File(outputFile);
    		
    		// Create a file writer
    		FileWriter newFile = new FileWriter(fileOut);
    		
    		// Create a for loop that will iterate over each item in the data structure
    		
    		
    		// Close the file stream
    		newFile.close();
    	}
    	
    	// Catch the exception
    	catch(IOException e)
    	{
    		System.out.println(e);
    	}
    }

} // End of class ChangeCalculator

package edu.miracosta.cs113.HW7;

// provide import statements
import java.util.*;



// This functions as the driver for the MorseCode Homework
public class Main 
{
	// Main method 
	public static void main(String[]args)
	{
		
		
		// Create the morseCodeTree 
		MorseCodeTree mct = new MorseCodeTree();
		
		
		// Create int to drive user response
		int userResponse = 0;
		
		// Create a Scanner to allow user input 
		Scanner keyboard = new Scanner(System.in);
	
	
	
		// Create a do - while loop to read and execute user input 
		do 
		{
			
			// Show menu options to the user 
			System.out.println("1. Test output for all morse code letters.");
			System.out.println("2. Enter an input textFile name with morse code to decode.");
			System.out.println("3. Enter a line of morse code through the console to decode.");
			System.out.println("4. Exit the program.");
			
			// Provide a menu of options for the user 
			System.out.println("Please select one of the options above:");
			
			// Get the user response 
			userResponse = keyboard.nextInt();
			
		
		
		
		
		} while(userResponse != 4);
	

	}
}

package edu.miracosta.cs113.HW7;

// provide import statements
import java.util.*;

// Create import statements for File Stream
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;





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
		
		// Create a scanner that will open the file stream
		Scanner inputFile;
		
		// String to hold the users response for fileName
		String fileName = "";
		
		// Create a string that will hold any user defined text to translate in the console 
		String userMorseToDecipher = "";
		
		
		// Welcome the user 
		System.out.println("Welcome to the MorseCode Translator! \n");
	
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
			
			
			// Create a switch statement that will run based
			// on the userResponse 
			
			switch(userResponse)
			{
			
				case 1:
				{
					System.out.println("Printing morse code/alphabet table.");
				break;
				}
			
				case 2: 
				{
					System.out.print("Please enter the name of a file you'd like to translate"
							+ "from morse code to plaintext: ");
					
					// Prompt the user for a file name 
					fileName = keyboard.next();
					
					
					// Attempt to open the file 
					try 
					{
						inputFile = new Scanner(new FileInputStream(fileName));
						
						// If we can succesfully open the file then we can start decoding
						System.out.println("Decoding, please hold...");
						
						// Continue reading from the file until we reach the end 
						while(inputFile.hasNext())
						{
							// TO DO 
						}
					}
					
					// Catch if we can't find the file 
					catch(FileNotFoundException e)
					{
						System.out.println("File was not found.");
					}
					
					break;
				}
				
				case 3:
				{
					System.out.println("Please enter in a line of morse code you'd like to translate: ");
					userMorseToDecipher = keyboard.nextLine();
					break;
					
				}
				
				default:
				{
					System.out.println("The input provided does not match one of the options");
					System.out.print("Please enter a valid option: ");
					userResponse = keyboard.nextInt();
					break;
				}
			
			}
			
		
		
		
		
		} while(userResponse != 4);
	

	}
}

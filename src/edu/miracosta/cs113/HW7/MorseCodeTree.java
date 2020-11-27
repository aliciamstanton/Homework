package edu.miracosta.cs113.HW7;

// Import 
import java.util.*;
import java.io.*;



/**
 * MorseCodeTree : A BinaryTree, with Nodes of type Character to represent each letter of the English alphabet,
 * and a means of traversal to be used to decipher Morse code.
 *
 * @version 1.0
 */
public class MorseCodeTree extends BinaryTree<Character> 
{

    // TODO:
    // Build this class, which includes the parent BinaryTree implementation in addition to
    // the `translateFromMorseCode` and `readMorseCodeTree` methods. Documentation has been suggested for the former,
    // where said exceptional cases are to be handled according to the corresponding unit tests.
	
	

    /**
     * Non-recursive method for translating a String comprised of morse code values through traversals
     * in the MorseCodeTree.
     *
     * The given input is expected to contain morse code values, with '*' for dots and '-' for dashes, representing
     * only letters in the English alphabet.
     *
     * This method will also handle exceptional cases, namely if a given token's length exceeds that of the tree's
     * number of possible traversals, or if the given token contains a character that is neither '*' nor '-'.
     *
     * @param morseCode The given input representing letters in Morse code
     * @return a String representing the decoded values from morseCode
     * 
     * 
     */
	
	
	// Constructor for MorseCode Tree 
	public MorseCodeTree()
	{
		
		// Create the tree from the text file 
		createTree();
		
	}
	
	// Method to create the tree from file 
	public void createTree()
	{
		
		File file = new File("src/edu/miracosta/cs113/HW7/MorseAlphabet.txt");
		
		// Try - Catch to make sure that we can read the file 
		try
		{
			BufferedReader morseReader = new BufferedReader(new FileReader(file));
			
			String newMorse;
			
			while((newMorse = morseReader.readLine()) != null)
			{
				insertNodeIntoTree(newMorse);
			}
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("File not Found");
		}
			
		
	}
	
	
	
	
	
	
	
    public String translateFromMorseCode(String encodedMessage) 
    {
    	
    	// The goal of this method is to take a string and convert each of its characters 
    	// into its English equivalent 
    	
    	// First make sure that the message only contains values we would find in the tree 
    	for(int index = 0; index < encodedMessage.length(); index++)
    	{
    		if(encodedMessage.charAt(index) == '-')
    		{
    			continue;
    		}
    		
    		if(encodedMessage.charAt(index) == '*')
    		{
    			continue;
    		}
    		
    		if(encodedMessage.charAt(index) == ' ')
    		{
    			continue;
    		}
    		
    		// Otherwise, we cannot process the data and we need to throw an input mismatch exception 
    		else 
    		{
    			throw new InputMismatchException();
    		}
    	}
    	
    	// Once we have ensured that the coded message has items we can read, then we 
    	// need to separate it into individual tokens to decode 
    	
    	// Create a StringTokenizer 
    	StringTokenizer morseToken = new StringTokenizer(encodedMessage, " ");
    	
    	// Create a new message that will eventually be returned from this method 
    	String decodedMessage = " ";
    	
    	// Iterate over the tokens until there are no tokens left
    	while(morseToken.hasMoreTokens())
    	{
    		// Create a temp character to hold 
    		char tempToken = ' ';
    		
    		// DECODE THE TOKEN - TO DO
    		
    		if(tempToken != '!')
    		{
    			// Append 
    			decodedMessage += tempToken;
    		}
    		
    		else 
    		{
    			continue;
    		}
    	}
    	
        return decodedMessage;
    }
    
    // Method for readMorseCodeTree 
    public void readMorseCodeTree()
    {
    	
    }

} // End of class MorseCodeTree
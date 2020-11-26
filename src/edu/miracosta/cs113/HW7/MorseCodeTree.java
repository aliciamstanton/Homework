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
     */
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
    	
    	
    	
        return "";
    }
    
    // Method for readMorseCodeTree 
    public void readMorseCodeTree()
    {
    	
    }

} // End of class MorseCodeTree
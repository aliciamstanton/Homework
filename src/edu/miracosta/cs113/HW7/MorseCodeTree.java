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

	
	String [] arrayOfString;
	
    // Create a node 
	public Node<Character> root;
	
	
	// Constructor for MorseCode Tree 
	public MorseCodeTree()
	{
		
		root = new Node<Character>(' ');
		
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
		
		catch(IOException e)
		{
			System.out.println("Other error detected.");
		}
			
		
	}
	
	
	// Method to insert the node at the correct location in the tree
	public void insertNodeIntoTree(String newLineFromFile)
	{
		
		arrayOfString = newLineFromFile.split("");
		Node<Character> tempRoot = root;
		
		// Determine the node location 
		for(int i = 2; i < arrayOfString.length - 1; i++)
		{
			
			if(arrayOfString[i].contentEquals("*"))
			{
				tempRoot = tempRoot.left;
			}
			
			else if(arrayOfString[i].contentEquals("-"))
			{
				tempRoot = tempRoot.right;
			}
			else 
			{
				continue;
			}	
			
		}
		
		
		
		
		// Then insert the node in the tree 
		if(arrayOfString[arrayOfString.length - 1].equals("*"))
		{
			
			Node<Character> nodeForInsert = new Node<Character>(arrayOfString[0].charAt(0)); 
			tempRoot.left = nodeForInsert;
			
		}
		
		else if(arrayOfString[arrayOfString.length - 1].equals("-"))
		{
			
			Node<Character> nodeForInsert = new Node<Character>(arrayOfString[0].charAt(0));
			tempRoot.right = nodeForInsert;
	
		}
		
		
	}
	
	
	// Method to process portions of the message with the binary Tree 
	public char characterDecoder(String currentMessage, Node<Character> nodeInTree)
	{
		
		// First create a character that we will take from the message 
		char currentValue;
		
		// First check to see if we have already processed the entire text 
		if(currentMessage.length() == 0)
		{
			if(nodeInTree != null)
			{
				return nodeInTree.data;
			}
			
		}
		
		// Otherwise we have more items to process 
		else 
		{
			
			currentValue = currentMessage.charAt(0);
			currentMessage = currentMessage.substring(1, currentMessage.length());
			
			if(currentValue == '*')
			{
				if(nodeInTree != null)
				{
					nodeInTree = nodeInTree.left;
					return characterDecoder(currentMessage, nodeInTree);
				}
			}
			
			else if(currentValue == '-')
			{
				if(nodeInTree != null)
				{
					nodeInTree = nodeInTree.right;
					return characterDecoder(currentMessage, nodeInTree);
				}
				
			}
					
					
		}
	
		return nodeInTree.data;
	}
	

	// Method to translate from MorseCode to plainText 
	
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
    		
    		// DECODE THE TOKEN 
    		tempToken = characterDecoder(morseToken.nextToken(), root);
    		
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
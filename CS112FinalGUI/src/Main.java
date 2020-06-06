// This will be the main method that runs the GUI "Store"

// Author: Alicia Stanton

// Date: April 25, 2020

// CS 112 Final Project 

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Main 
{
	public static void main(String[] args)
	{
	
	// We want to launch the store 
	Store newStore = new Store();
	
	// At the end we want to make sure the GUI is visible to the user
	newStore.setVisible(true);
		
		// Driver program for ROT13 Cipher
		
	    // First we need to create a card object that we can pass into the cipher1 below
		/*Card newPayment = new Card();
		
		newPayment.setCardNum("654654");
		
		newPayment.setCVV("321321");
		
		newPayment.setCardHolder("Alicia");
		
		

	    // Create a ROT13 object and pass in the card object 
	    ROT13 cipher1 = new ROT13(newPayment); 

	    // Test to make sure that the encryption works - NEED TO MAKE UPDATES TO ENSURE THAT ENCRYPTION OCCURS PROPERLY 
	    cipher1.Encrypt();

	    // Print out the encryption to make sure that it works
	    System.out.println(cipher1.Encrypt());

	    // Test to make sure that the decryption works 
	    cipher1.Decrypt();

	    // Print out the decryption to make sure that it works - NEED TO MAKE UPDATES TO ENSURE THAT DECRYPTION OCCURS PROPERLY 
	    System.out.println(cipher1.Decrypt());

	    // Suppose that we want to write this information to a binary file

	     // Create a stream, but open in a try/catch block
	     ObjectOutputStream fileOut = null;

	     try
	     {
	       fileOut = new ObjectOutputStream(new FileOutputStream("protection.txt", true));

	       // We are scanning in card objects, so we can go through the three strings for each object
	       // String is not primitive so we will need to use the writeUTF method
	       fileOut.writeUTF(cipher1.getCipherText().getCardNum());
	       fileOut.writeUTF(cipher1.getCipherText().getCVV());
	       fileOut.writeUTF(cipher1.getCipherText().getCardHolder());

	       fileOut.close();
	     }
	     catch(FileNotFoundException e)
	     {
	       System.out.println("We were unable to write your data to a file");
	     }
	     catch(IOException z)
	     {
	       System.exit(0);
	     }
	    */ 

	}
}

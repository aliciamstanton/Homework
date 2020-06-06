import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class ROT13 extends InfoStream
{
  // Instance Variables ------------------------------------
  private Card cipherText = new Card();
  private Card plainText;
  private Card decryptedText = new Card();
  //--------------------------------------------------------
  
 
  // Constructors-------------------------------------------
  // Empty Constructor
  public ROT13() 
  {

  }

  // Full Constructor - WE WANT TO TAKE IN A CARD OBJECT; InfoStream should also be taking in a card object therefore we are not creating any new information
public ROT13(Card plainText)
{
  super(plainText);
}

// Copy Constructor - WANT TO TAKE IN A CARD OBJECT; InfoStream should also be taking in a card object 
public ROT13(ROT13 theObject)
{
  super(theObject);
}
//-----------------------------------------------------------

 // Getters and Setters--------------------------------------

 // cipherText
 @Override
 public Card getCipherText()
 {
   return this.cipherText;
 }
 
//---------------------------------------------------------


//********************** Encryption Starts Here ********************

// Need to consider the credit length exception because we
// are dealing with the credit card number 
@Override 
public Card Encrypt() 
{

// Creation of the Numerical Alphabet **************

     // First want to create a proper numerical alphabet for these items using an arrayList 
     String numericalAlpha = "1234567890";

     // We now want to turn this into an arrayList - 
     ArrayList<Character> numericalPlainAlpha = new ArrayList<Character>();

     // Create a single char value to iterate over
     char plainValue;

     // Iterate over each item individually
     for(int i = 0; i < numericalAlpha.length(); i++)
     {
       // Take each value 
       plainValue = numericalAlpha.charAt(i);

       // Add each of these values to the plain alphabet
       numericalPlainAlpha.add(plainValue);
     }
//***************************************************

//  Creation of the plain Alphabet *******************
     String plainAlpha = "abcdefghijklmnopqrstuvwxyz";

     ArrayList<Character> PlainAlphaSet = new ArrayList<Character>();

     // Now we need to create a char value
     char alphaValue;

     // We want to iterate over the entire list and add these to the ArrayList
     for(int i = 0; i < plainAlpha.length(); i++)
     {
       // Grab each value 
       alphaValue = plainAlpha.charAt(i);

       // Add it to the PlainAlphaSet
       PlainAlphaSet.add(alphaValue);
     }

//***********************************************************


// Encrypting - Card Number ***********************
// Necessary Variables ------------------

     // Char value that allows us to iterate letter by letter
     char numValue;
     
     // Char value that lets us grab the item we want 13 spaces right 
     char desiredResult;
     // First get the index of the value  within the numericalPlainAlpha
     int index;

     // Create a String that we can put all these items into as a result 
     String cardNumCipher = "";

     // End of Necessary Variables ------------

// Beginning of Encryption - Card Number **********************

     // Loop 
     for(int i = 0; i < super.getPlainText().getCardNum().length();i++)
     {
       // Grabs each value one by one 
       numValue = super.getPlainText().getCardNum().charAt(i);
    
    // Grabs the index of the value we put in one at a time and where it is located in the numericalPlainAlpha
      index = numericalPlainAlpha.indexOf(numValue);

      // Shift this index by 13 and reset the value
      index += 13;

      // What should we do if the new index is larger than the original list? Mod by the size of the list
      index %= numericalPlainAlpha.size();

      // Take this new index and find the value at that index within the numericalPlainAlpha to get the encrypted value
      desiredResult = numericalPlainAlpha.get(index);

    // Add each character above to the cipherText below
      cardNumCipher += desiredResult;
     }

     // Set the card Number property
     cipherText.setCardNum(cardNumCipher);

// Ending of Encryption - Card Number *************************

// Encrypting - CVV********************************************
// Necessary Variables-----------------

// Char value that allows us to iterate letter by letter
char CVVValue;

// Char value that allows us to grab a value 13 spaces to the right 
char encryptedCVV;

// An index value to keep track of where we are 
int CVVIndex;

// Empty String to hold new encrypted result
String CVVCipher = "";

// End of necessary variables ----------------


// Beginning Encryption - CVV **************************************

// Loop
for(int i = 0; i < super.getPlainText().getCVV().length(); i++)
{
  // Grabs each value one by one 
  CVVValue = super.getPlainText().getCVV().charAt(i);

// Finds the index within the plain list 
  CVVIndex = numericalPlainAlpha.indexOf(CVVValue);

  // Shift the index by 13
  CVVIndex += 13;

  // Account for when the index is larger than the list
  CVVIndex %= numericalPlainAlpha.size();

  // Take this new index and find the desired encrypted value
  encryptedCVV = numericalPlainAlpha.get(CVVIndex);

  // Add each character above to the ciphertext below
  CVVCipher += encryptedCVV;
}

// Add this item to the CipherText card object
cipherText.setCVV(CVVCipher);

// Ending Encryption - CVV ******************************************

// Encrypting - Card Holder *******************************
// Necessary Variables ------------------

     // Create a character value that we can use to iterate over 
     char plainChar;

     // Second char value that allows us to grab the updated letter
     char cipherChar;

     // Create a string that we can put all these values in 
     String encryptedHolder ="";

     // Create a second string that makes sure that all values are lowercase 
     String encryptedHolderLower;

     // We want to create an index we can iterate over 
     int cardIndex;

     // End of Necessary Variables ---------------

     encryptedHolderLower = super.getPlainText().getCardHolder().toLowerCase();

// Beginning of Encryption - Card Holder ********************

     // Loop
     for(int i = 0; i < super.getPlainText().getCardHolder().length(); i++)
     {

       // Grab each value
       plainChar = encryptedHolderLower.charAt(i);

       // We want to find the index of where this would be in the PlainAlphaSet
       cardIndex = PlainAlphaSet.indexOf(plainChar);

       // We want to add 13 to the index to ensure that the shift is complete
       cardIndex += 13; 

       // We need to fail safe incase the index is larger than the set by using modulus
       cardIndex %= PlainAlphaSet.size();

       // Take this new index and return the value found at that index in the PlainAlphaSet
       cipherChar = PlainAlphaSet.get(cardIndex);

       // Add each character to the end of the string to encrypt the entire name
       encryptedHolder += cipherChar;
     }

     // Add this item to the CipherText card object
     cipherText.setCardHolder(encryptedHolder);

     // Ending of Encryption - Card Holder **********************

// Return the card Value CipherText
return cipherText;

}

// *************************** ENCRYPTION ENDS HERE ****************************************

// *************************** DECRYPTION STARTS HERE **************************************

// Need to consider that we might run into a credit length Exception because we are calling the setCardNum method
@Override
public Card Decrypt() 
{

// Creation of the Numerical Alphabet **************

     // First want to create a proper numerical alphabet for these items using an arrayList 
     String numericalAlpha = "1234567890";

     // We now want to turn this into an arrayList - 
     ArrayList<Character> numericalPlainAlpha = new ArrayList<Character>();

     // Create a single char value to iterate over
     char plainValue;

     // Iterate over each item individually
     for(int i = 0; i < numericalAlpha.length(); i++)
     {
       // Take each value 
       plainValue = numericalAlpha.charAt(i);

       // Add each of these values to the plain alphabet
       numericalPlainAlpha.add(plainValue);
     }
  // End of Numerical Alphabet *************************

  //  Creation of the plain Alphabet *******************
     String plainAlpha = "abcdefghijklmnopqrstuvwxyz";

     ArrayList<Character> PlainAlphaSet = new ArrayList<Character>();

     // Now we need to create a char value
     char alphaValue;

     // We want to iterate over the entire list and add these to the ArrayList
     for(int i = 0; i < plainAlpha.length(); i++)
     {
       // Grab each value 
       alphaValue = plainAlpha.charAt(i);

       // Add it to the PlainAlphaSet
       PlainAlphaSet.add(alphaValue);
     }

  // End of Plain Alphabet *********************************


  // Decrypting - Card Number **********************

// Step 1: create a character value that we can iterate over
    char encryptedValue;

    // Create a int value as the index to iterate over
    int indexDecrypt;

    // char value to grab the unencrypted cipherText
    char unEncryptedValue;

    // String value where we can show the result 
    String unEncryptedString = "";

    // End of Necessary Variables -------------

// Beginning of Decryption - Card Number ****************

    for(int i = 0; i < cipherText.getCardNum().length(); i++)
    {
      // Grab the value
      encryptedValue = cipherText.getCardNum().charAt(i);

      // Determine its index in the plainAlphaSet 
      indexDecrypt = numericalPlainAlpha.indexOf(encryptedValue);

      // Subtract 13 spaces from the index to shift back
      indexDecrypt -= 13;

    
      // NEED TO ACCOUNT FOR WHEN THE INDEXDECRYPT IS NEGATIVE 
      if(indexDecrypt <= -10)
      {
        indexDecrypt = 20 + (indexDecrypt);
      }
      if(indexDecrypt <= 0)
      {
        indexDecrypt = 10 + (indexDecrypt);
      }

      // POSSIBLE SOLUTION?
        indexDecrypt %= 10;
      

      unEncryptedValue = numericalPlainAlpha.get(indexDecrypt);

  
      unEncryptedString += unEncryptedValue;
    }


    // Set the card number property 
    decryptedText.setCardNum(unEncryptedString);

     // Ending of Decryption - Card Number ********************


// Beginning of Decryption - CVV *******************************
// Necessary Variables--------------------------

// create a char value to iterate over
char decryptCVV;

// Create an int index to iterate with
int CVVDecryptIndex;

// Create another char to grab the unencrypted text 
char CVVChanged;

// Create an empty String where we can show the result 
String unEncryptedCVV = "";

// End of necessary variables ----------------------

// Beginning of Decryption - CVV ******************

for(int i = 0; i < cipherText.getCVV().length(); i++)
{
  // Grab the value
  decryptCVV = cipherText.getCVV().charAt(i);

  // Determine its index in the numerical plain alpha
  CVVDecryptIndex = numericalPlainAlpha.indexOf(decryptCVV);

  // Subtract 13 spaces from the index
  CVVDecryptIndex -= 13;


  // NEED TO ACCOUNT FOR WHEN THE INDEXDECRYPT IS NEGATIVE 
   if(CVVDecryptIndex <= -10)
      {
        CVVDecryptIndex = 20 + (CVVDecryptIndex);
      }
      if(CVVDecryptIndex <= 0)
      {
        CVVDecryptIndex = 10 + (CVVDecryptIndex);
      }
      
      // POSSIBLE SOLUTION?
      CVVDecryptIndex %= 10;


      // Get the decrypted value 
      CVVChanged = numericalPlainAlpha.get(CVVDecryptIndex);

      // Add these items to the empty string
      unEncryptedCVV += CVVChanged;
}



// Add this property to the decryptedText
decryptedText.setCVV(unEncryptedCVV);

// Ending Decryption - CVV ****************************

// Beginning Decryption - Card Holder *******************

// Necessary Variables -------------------

 // Step 1: Create a char value we can iterate over
 char encryptedName;

 // Create an int value as the index we can iterate over
 int indexNameDecrypt;

 // char value where we can show the result
 char decryptedNameChar;

 // String value where we can show the entire result
 String unEncryptedName = "";

 // String that allows us to uppercase the value before being returned

 String unEncryptedNameUpper = "";

// End of Necessary Variables -----------------------

for(int i = 0; i < cipherText.getCardHolder().length(); i++)
 {
   // Grab the value a character at a time
   encryptedName = cipherText.getCardHolder().charAt(i);

   // Determine its index in the plainAlphaSet
   indexNameDecrypt = PlainAlphaSet.indexOf(encryptedName);

   // Subtract 13 spaaces from the index to shift back
   indexNameDecrypt -= 13;

   // Make sure to account for when the index is NEGATIVE
   if(indexNameDecrypt <= 0)
   {
     indexNameDecrypt = 26 + indexNameDecrypt;
   }

   // If the number is larger than the size of the list above, then we can mod and get the remainder (also works for negative values)

   indexNameDecrypt %= PlainAlphaSet.size();

   // Get the letter at the new index
   decryptedNameChar = PlainAlphaSet.get(indexNameDecrypt);
    

   // Update the string value
   unEncryptedName += decryptedNameChar;

// Allows us to upper case each letter in the card holder name before returning the result 
   unEncryptedNameUpper = unEncryptedName.toUpperCase();
 }


 // Add this to the property for the decryptedText
 decryptedText.setCardHolder(unEncryptedNameUpper);

// Return the decryptedText
return decryptedText;

}

//********************************** END OF DECRYPTION *******************************


  // Equals Method-------------------------------------------
  public boolean Equals(Object other)
  {
    // Self Check
    if(this == other)
    {
      return true;
    }
    // Null Check
    if(other == null)
    {
      return false;
    }

    // Class Check
    if(this.getClass() != other.getClass())
    {
      return false;
    }

    // Type Cast
    ROT13 rotty = (ROT13) other;

    // Property Check - can just check the CipherText, if they encrypt to the same thing they should have been the same to start 
    if(this.cipherText == rotty.getCipherText())
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  

  //---------------------------------------------------------

  //To String Method-----------------------------------------
  public String toString()
  {
    return "ENCRYPTED VALUES: \n" + "Card Number: " + cipherText.getCardNum() + "\nCVV Number: " + cipherText.getCVV() + "\nCard Holder: " + cipherText.getCardHolder() + "\n\nDECRYPTED VALUES: \n" + "Card Number: " + decryptedText.getCardNum() + "\nCVV Number: " + decryptedText.getCVV() + "\nCard Holder: " + decryptedText.getCardHolder();
  }

  //---------------------------------------------------------
}
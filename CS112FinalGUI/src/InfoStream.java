// Goal: Define items that are the same for both Atbash and ROT13
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class InfoStream implements DataSecurity
{
  // What items will be the same for both Ciphers?
  // We want to take in Card objects in our info InfoStream

  // Instance Variables------------------------------
  private Card plainTextCard;
  private Card cipherTextCard;
  //-------------------------------------------------

  // Create a Scanner
  Scanner input = new Scanner(System.in);
  
  // Constructors-----------------------------------

  // Full Constructor - should take in a Card object; We will use create these values using a Setter Methods
  // Need to call the Exception since we are creating the plaintext object which calls to the setCardNum method 
public InfoStream() 
{
  setPlainText();
}

public InfoStream(Card payment1)
{
  this.plainTextCard = payment1;
}

  // Copy Constructor - Don't need to check the Cipher text because, if the plainText is the same then the Ciphertext should also be the same 
  public InfoStream(InfoStream theObject)
  {
    this.plainTextCard = theObject.getPlainText();
  }
  //------------------------------------------------
  
  // Getters and Setters -------------------------------------
  // PlainText
  public Card getPlainText()
  {
    return this.plainTextCard;
  }

  // Set plainText - Need to consider the credit length Exception because we are setting the card number  -------------------------------------------------
public void setPlainText() 
{
 // Create a new card object to add these items to our Card ArrayList 
 Card payment1 = new Card();

// Set the card Number 
System.out.print("Please enter the Card Number: ");
payment1.setCardNum(input.next());

// Set the CVV 
System.out.print("Please enter the CVV: ");
payment1.setCVV(input.next());

// Set the Card Holder Name - Refactor to take in First and Last 
System.out.print("Please enter the card holder: ");
payment1.setCardHolder(input.next());

this.plainTextCard = payment1;
}

 //---------------------------------------------------------------- 


// Get CipherText - should never be setting the CipherText within this class 
public Card getCipherText()
{
  return this.cipherTextCard;
}
//--------------------------------------------------------------------
  
  //********* ERROR HERE ************************
// Equals ------------------------------------------------------------
@Override
  public boolean equals(Object other)
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
  InfoStream e = (InfoStream) other;

// Property Check - Can check just the plainText as the cipherText and 
if(this.plainTextCard == e.getPlainText())
{
  return true;
}
else
{
  return false;
}
  
}
//----------------------------------------------------------

// To String -----------------------------------------------
public String toString()
{
  return "Card Number: " + this.getPlainText().getCardNum() + "\nCVV: " + this.getPlainText().getCVV() + "\nCard Holder: " + this.getPlainText().getCardHolder();
}

//----------------------------------------------------------
  
  
  // Methods from Interface DataSecurity -------------------
@Override
 public Card Encrypt() 
 {
   return this.plainTextCard;
 }

@Override
 public Card Decrypt() 
 {
   return this.cipherTextCard;
 }
 //-------------------------------------------------------
}
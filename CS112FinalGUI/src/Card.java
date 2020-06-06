
import java.util.Scanner;

public class Card extends Payment 
{
  // What data do we need from every card payment?
  private String cardNumber;
  private String CVV;
  private String cardHolder; 
  private String expirationDate;
  private String paymentType;

  
// Constructors------------------------------------------
  // Empty Constructor
  public Card()
  {
    // Call to Super
    super();

    // New instance variables

    // Default card number - 16 digits
    this.cardNumber = "0000000000000000";
    
    // Default CVV - 3 digits
    this.CVV = "000";

    // Default name - Empty
    this.cardHolder = "N/A";

    // Default expiration date 
    this.expirationDate = "12/31/20";

    //Always will be Card
    this.paymentType = "Card";
  }

  // Full Constructor - We want to make sure our credit card number is the right length, so we will throw the exception here using the set notation 
  public Card(String payDateIn, double amountIn, String cardNumIn, String cvvIn, String holderIn, String expireIn) 
  {
    // Call to Super
    super(payDateIn, amountIn);

    this.cardNumber = cardNumIn;
    //this.setCardNum(cardNumIn);

    this.CVV = cvvIn;
    this.cardHolder = holderIn;
    this.expirationDate = expireIn;
    this.paymentType = "Card";
  }

  // Copy Constructor

//-------------------------------------------------------

// Getters and Setters-----------------------------------

// payment date - call to Super
public String getDate()
{
  return super.getDate();
}

public void setDate(String dateIn)
{
  super.setDate(dateIn);
}

//payment amount - Call to Super 
public double getAmount()
{
  return super.getAmount();
}

public void setAmount(double amountIn)
{
  super.setAmount(amountIn);
}

// card number
public String getCardNum()
{
  return this.cardNumber;
}

// Will want to account for the exception here in case we are 
// provided a value that is not 16 digits long 
public void setCardNum(String cardNumIn)
{
  /*if(cardNumIn.length() != 16)
  {
    throw new CreditLengthException();
  }
  
  
  else
  {
  this.cardNumber = cardNumIn;
  }
  */

 this.cardNumber = cardNumIn;
}

// CVV Number
public String getCVV()
{
  return this.CVV;
}

public void setCVV(String cvvIn)
{
  this.CVV = cvvIn;
}

// Card Holder 
public String getCardHolder()
{
  return this.cardHolder;
}

public void setCardHolder(String holderIn)
{
  this.cardHolder = holderIn;
}

// Expiration date
public String getExpiration()
{
  return this.expirationDate;
}

public void setExpiration(String expireIn)
{
  this.expirationDate = expireIn;
}

// Payment Type - We will never ask the user to set this value, it will always be defaulted to Card
public String getType()
{
  return this.paymentType;
}

//------------------------------------------------------

  // Equals 
  @Override
  public boolean equals(Object other)
  {
    // Self check
    if(this == other)
    {
      return true;
    }

    // Null check
    if(other == null)
    {
      return false;
    }

    // Class check
    if(this.getClass() != other.getClass())
    {
      return false;
    }
    
    // Type Cast
    Card cc = (Card) other;

    // Property check - check the cardNum, CVV, cardHolder
    if(this.cardNumber.equals(cc.getCardNum()) && this.CVV.equals(cc.getCVV()) && this.cardHolder.equals(cc.getCardHolder()))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  // To String
  public String toString()
  { 
    return "Card Number: " + this.cardNumber + "\nCVV: " + this.CVV + "\nCard Holder: " + this.cardHolder;
  }



// Abstract Inherited Methods ---------------------------
   @Override
   public void paymentAccepted()
   {
      System.out.println("Your payment has been accepted!");
   }

   @Override 
   public void paymentDeclined()
   {
     System.out.println("Your payment has been declined!");
   }

   @Override
   public void paymentType()
   {
     System.out.println("Card");
   }
//-------------------------------------------------------
}
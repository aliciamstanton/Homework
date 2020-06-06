public abstract class Payment
{
  // What variables can be defined here that the child classes will use? - Do NOT need to be abstract

  // NEED TO CONSIDER THE DOLLAR AMOUNT OUTPUT STYLE (2 DECIMALS)

  // Instance variables-------------------------------
  private String paymentDate;
  private double paymentAmount;
  private boolean paymentStatus; // REVISIT 
  //--------------------------------------------------

// Constructors --------------------------------------
// Empty Constructor
public Payment()
{
  // Payment date default to 1/1/2020
  this.paymentDate = "1/1/2020";
  // Payment amount default to 0.00
  this.paymentAmount = 0.00;
}

// Full Constructor
public Payment(String dateIn, double amountIn)
{
  this.paymentDate = dateIn;
  this.paymentAmount = amountIn;
}

// Copy Constructor
public Payment(Payment theObject)
{
  this.paymentDate = theObject.getDate();
  this.paymentAmount = theObject.getAmount();
}
//---------------------------------------------------


// Getters and Setters-------------------------------

public String getDate()
{
  return this.paymentDate;
}

public void setDate(String dateIn)
{
  this.paymentDate = dateIn;
}

public double getAmount()
{
  return this.paymentAmount;
}

public void setAmount(double paymentIn)
{
  this.paymentAmount = paymentIn;
}
//---------------------------------------------------

// Equals--------------------------------------------
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
  if(this.getClass() == other.getClass())
  {
    return true;
  }

  // Type Cast
  Payment p = (Payment) other;

  // Property Check
  if(this.paymentDate.equals(p.getDate()) && this.paymentAmount == p.getAmount())
  {
    return true;
  }
  else
  {
  return false;
  }
}
//---------------------------------------------------

// To String-----------------------------------------
public String toString()
{
  return "Payment Date: " + this.paymentDate + "\nPayment Amount: $" + this.paymentAmount;
}
//---------------------------------------------------

// Abstract Methods for Payment Status - KEEP----------
public abstract void paymentAccepted();

public abstract void paymentDeclined();

public abstract void paymentType();
//-----------------------------------------------------

}
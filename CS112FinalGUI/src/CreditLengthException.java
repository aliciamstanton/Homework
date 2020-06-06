public class CreditLengthException extends Exception
{
  // Allows us to use the generic from the parent class 
 public CreditLengthException()
 {
   super("A credit card number has 16 digits");
 }

// Allows us to use a unique message when the exception is called
 public CreditLengthException(String message)
 {
   super(message);
 }

}
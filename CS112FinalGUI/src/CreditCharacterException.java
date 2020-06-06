
public class CreditCharacterException extends Exception 
{
  public CreditCharacterException()
  {
    super("Please make sure to use only values from 0-9");
  }

  public CreditCharacterException(String message)
  {
    super(message);
  }

}
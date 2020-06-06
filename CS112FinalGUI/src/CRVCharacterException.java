
public class CRVCharacterException extends Exception 
{
  public CRVCharacterException()
  {
    super("Please make sure to use only values from 0-9");
  }

  public CRVCharacterException(String message)
  {
    super(message);
  }

}
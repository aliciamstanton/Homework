// Package declaration under HW3

package edu.miracosta.cs113.HW3;

// Definition of Class Term which implements the Comparable Interface 
public class Term implements Comparable, Cloneable
{
	
	// Private Member variables
	
	// Exponent
	private int exponent;
	
	// Coefficient
	private int coefficient;
	
	
	// Default Constructor
	public Term()
	{
		this.exponent = 1;
		this.coefficient = 1;
	}
	
	/*// Full Constructor
	Term(int coefficient, int exponent)
	{
		this.exponent = exponent;
		this.coefficient = coefficient;
	} */
	
	
	
	
	// Secondary Full Constructor - using setAll Method
	public Term(int coefficient, int exponent)
	{
		this.setAll(coefficient, exponent);
		
	}
	
	// Copy Constructor
	public Term(Term object)
	{
		// Want to take the exponent from the first object and set it to the calling object
		this.exponent = object.getExponent();
		
		// Take the Coefficient from the argument and copy it to the calling object
		this.coefficient = object.getCoefficient();
		
	}
	
	
	
	
	public Term(String term)
    {
		
        int coefficient = 0, exponent = 0;
        
        
     
        if(term.isEmpty())
        {
        	exponent = 0;
        	coefficient = 0;
        }
        
        
        
 
        else 
        {

            // Term contains variable
            if (term.indexOf("x") != -1)
            {
                // Split string in between X variable
            	
            	String[] splitTerm = term.split("x");
            	
            	
            	String coeffPortion = "";
            	
            	// Portion before the X 
            	
            	coeffPortion = splitTerm[0];
            	
            	
            	// If the string portion for the coefficient is longer than 1
            	// it means that the coefficient is not a positive or negative 1
            	
            	if(coeffPortion.length() > 1)
            	{
            		coefficient = Integer.parseInt(coeffPortion);
            	}
            	else if(coeffPortion.length() == 1)
            	{
            		if(coeffPortion.charAt(0) == '-')
            		{
            			coefficient = -1;
            		}
            		else
            		{
            			coefficient = 1;
            		}
            	}
            	
            	
            	
            	if(splitTerm.length > 1)
                {
            		
            		String exponentPortion = "";
            		
            		exponentPortion = splitTerm[1].substring(1);
            		
            		exponent = Integer.parseInt(exponentPortion);
            		
                }
                else
                {
                    exponent = 1;
                }
            }
            
            else
            { 
            	// Term does not contain variable - there is no exponent 
            	coefficient = Integer.parseInt(term);
                exponent = 0;
            } 

        }
        
        
        this.setAll(coefficient, exponent);
    }
	
	
	
	
	// Getter - Exponent
	public int getExponent()
	{
		return this.exponent;
	}
	
	// Getter - Coefficient
	public int getCoefficient()
	{
		return this.coefficient;
	}
	
	// Setter - Exponent
	public void setExponent(int exponent)
	{
		this.exponent = exponent;
	}
	
	// Setter - Coefficient
	public void setCoefficient(int coefficient)
	{
		this.coefficient = coefficient;
	}
	
	
	// Clone Method - Want to call to super 
	@Override
	public Object clone()
	{
		try
		{
			return super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			return null;
		}
			
	}
	
	
	
	// Set All
	public void setAll(int coefficient, int exponent)
	{
		// Set the coefficient 
		this.setCoefficient(coefficient);
		this.setExponent(exponent);	
	}
	
	// Equals
	@Override
	public boolean equals(Object other)
	{
		// Self Check - if this is true, then the objects are equal 
		if(this == other)
		{
			return true;
		}
		
		// Null Check - if the comparing object is null, then they can't be the same
		if(other == null)
		{
			return false;
		}
		
		// Type/Class Check - if these aren't the same class type, then they can't be the same 
		if(this.getClass() != other.getClass())
		{
			return false;
		}
		
		// Typecast - so that we can perform property check 
		Term t = (Term) other;
		
		// Property Check 
		if((this.exponent == t.exponent) && this.coefficient == t.coefficient)
		{
			return true;
		}
		else
		{
		
			return false;
		
		}
	}
	
	// ToString 
	public String toString()
	{
		// Create an empty string to hold the term we will return
		String fullTerm = "";
		
		
	
		
		
		// Will not run if coefficient is zero
        if (this.coefficient != 0)
        { 

            // Handles Coefficient
            if (coefficient > 0)
            { // Adds plus symbol where needed
                fullTerm += "+";
                if (coefficient > 1)
                {
                    fullTerm += this.coefficient;
                }
            }
            else if(coefficient < 0)
            {
            	
            	// Add minus symbol where needed
                if (coefficient == -1)
                {
                    fullTerm += "-";
                } 
                else
                {
                	
                    fullTerm += this.coefficient;
                }
            }
            
         
            // Handles Exponent - 
            if (this.exponent != 0)
            {
            	
            	if(this.exponent == 1)
            	{
            	
            		fullTerm += "x";
            	}

            	else
                {
                    fullTerm +=  "x^" + this.exponent;
                }
            }
        }
        return fullTerm;
    }
		
		
	// Must be implemented in order to use the Comparable Interface 
	// Goal is to make sure that the exponents are ordered correctly 
	@Override
	public int compareTo(Object other)
	{
		// Type cast to the respective class
		Term termCompare = (Term) other;
		
		if(this.exponent > termCompare.getExponent()) 
		{
			return 1;
		}
		else if(this.exponent < termCompare.getExponent()) 
		{
			return - 1;
		}
		else 
		{
			return 0;
		}
	
	
	}
	

}

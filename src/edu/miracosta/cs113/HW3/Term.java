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
	
	
	
	// String Constructor of Term 
	public Term(String term)
    {
		
		// Preset the coefficient and exponent to make sure that they have a value
        int coefficient = 0, exponent = 0;
        
        
        
        // If the term we are passing is empty, then we can set the exponent and coefficient to zero 
        if(term.isEmpty())
        {
        	exponent = 0;
        	coefficient = 0;
        }
        
     
        // Otherwise we want to split the term into pieces to change the coefficient 
        // and exponent from a string to an integer 
        else 
        {
        	

            // If the term contains 'x' then we should have a coefficient and exponent 
            if (term.indexOf("x") != -1)
            {
                // Split string in between X variable
            	String[] splitTerm = term.split("x");
            	
            	
            	// Create a coefficient Portion to hold the value before the X 
            	String coeffPortion = "";
            	
            	// Portion before the X 
            	coeffPortion = splitTerm[0];
            	
            	
            	// If the string portion for the coefficient is longer than 1
            	// it means that the coefficient is not a positive or negative 1
            	
            	if(coeffPortion.length() > 1)
            	{
            		coefficient = Integer.parseInt(coeffPortion);
            	}
            	
            	// If the coeffPortion is 1, then it should be a positive or negative one 
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
            	
            	
            	// If the term splits on the x into more than one term, then we should
            	// have an exponent and coefficient 
            	if(splitTerm.length > 1)
                {
            		// Create a string to hold the exponent portion 
            		String exponentPortion = "";
            		
            		// Want to strip off the carat symbol to only get the number portion of the exponent 
            		exponentPortion = splitTerm[1].substring(1);
            		
            		// Then parse this into an integer 
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
        
        // Use the setAll method to set the coefficient and the exponent 
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

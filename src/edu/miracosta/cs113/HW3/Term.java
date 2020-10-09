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
	
	// String Constructor
	public Term(String term)
	{
		
		// Create a string value to hold the coefficient portion and the exponent portion
		String coeffPortion = "";
		String expPortion = "";
		// Create local variables that will hold the exponent and coefficient 
		int exponent = 0;
		int coefficient = 0;
		
		// If the term has nothing in it, then both the exponent and coefficient are zero
		if(term.isEmpty())
		{
			exponent = 0;
			coefficient = 0;	
		}
		
		// If the term is not empty, then we need to consider how to deal with it
		else 
		{
			// Create a variable index that will hold where 'x' is found, if it exists in the string
			int variableIndex = 0;
			
			// If 'x' is not found in the term, then we have only a coefficient and no exponent
			variableIndex = term.indexOf('x');
			
			if(variableIndex == -1)
			{
				// Need to set the coefficient, but don't need to set the exponent
				exponent = 0;
				
				// Parse the string as is 
				coefficient = Integer.parseInt(term);		
			}
			
			// Need to consider if the term has an exponent or not
			else 
			{
				
				// We want to iterate up to where the 'X' is found to get the coefficient 
				for(int index = 0; index < variableIndex; index++)
				{
					coeffPortion += term.charAt(index);
				}
				
				// Then we want to parse this to be an integer value
				coefficient = Integer.parseInt(coeffPortion);
				
				// Now we want to find the index of the "^" to determine what the exponent is
				int caratIndex = term.indexOf("^");
				
				// Iterate over the string to find the last portion
				for(int loopIndex = caratIndex + 1; loopIndex < term.length(); loopIndex++)
				{
					expPortion += term.charAt(loopIndex);
				}
				
				// Now we want to parse this to be an integer
				exponent  = Integer.parseInt(expPortion);
				
				
			}
				
		}
		
		
		// Call the setAll method to set both the coefficient and exponent for the Term object
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
	public String ToString()
	{
		// Create an empty string to hold the term we will return
		String fullTerm = "";
		
		
		// If there is no exponent, then we can just return the coefficient 
		if(this.exponent == 0)
		{
			fullTerm += "" + this.getCoefficient();
		}
		
		// If the exponent is 1, this can be implictly shown 
		else if(this.exponent == 1)
		{
			fullTerm += this.getCoefficient() + "x";
			
		}
		
		// If the exponent is anything from 2 or greater, then we need to show it explictly 
		else
		{
			fullTerm += this.getCoefficient() + "x^" + this.getExponent();
			
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

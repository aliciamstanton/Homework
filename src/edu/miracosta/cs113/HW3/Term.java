// Package declaration under HW3

package edu.miracosta.cs113.HW3;

// Definition of Class Term which implements the Comparable Interface 
public  class Term implements Comparable
{
	
	// Private Member variables
	
	// Exponent
	private int exponent;
	
	// Coefficient
	private int coefficient;
	
	
	// Default Constructor
	Term()
	{
		this.exponent = 1;
		this.coefficient = 1;
	}
	
	// Full Constructor
	Term(int exponent, int coefficient)
	{
		this.exponent = exponent;
		this.coefficient = coefficient;
	}
	
	// Copy Constructor
	Term(Term object)
	{
		// Want to take the exponent from the first object and set it to the calling object
		this.exponent = object.getExponent();
		
		// Take the Coefficient from the argument and copy it to the calling object
		this.coefficient = object.getCoefficient();
		
	}
	
	// String Constructor
	Term(String term)
	{
		
	}
	
	// Getter - Exponent
	int getExponent()
	{
		return this.exponent;
	}
	
	// Getter - Coefficient
	int getCoefficient()
	{
		return this.coefficient;
	}
	
	// Setter - Exponent
	void setExponent(int exponent)
	{
		this.exponent = exponent;
	}
	
	// Setter - Coefficient
	void setCoefficient(int coefficient)
	{
		this.coefficient = coefficient;
	}
	
	
	// Clone Method 
	@Override
	void clone()
	{
		
	}
	
	// Replace All
	void replaceAll(String thing1, String thing2)
	{
		
	}
	
	// Set All
	void setAll(int exponent, int coefficient)
	{
		
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
		
		if(this.exponent == 0)
		{
			fullTerm += "" + this.getCoefficient();
		}
			
		return fullTerm;
	}
	

	// Must be implemented in order to use the Comparable Interface 
	@Override
	public int compareTo(Object o)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	 
	

}

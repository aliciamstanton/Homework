// Package declaration under HW3

package edu.miracosta.cs113.HW3;

// Definition of Class Term which implements the Comparable Interface 
public  class Term 
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
	
	// Equals
	
	// ToString 
	
	
	
	
	
	
	
	
	
	
	
	


	/*@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	 */
	

}

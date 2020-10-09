
// Package declaration for the Polynomial Class 
package edu.miracosta.cs113.HW3;

// Can use the predefined Linked List in the Java Library - implemented here 
import java.util.LinkedList;


// Class Definition of Polynomial Class 
public class Polynomial 
{
	
	// Single Data Member - not initialized with a size 
	private LinkedList<Term> polyTerm;
	
	// Default Constructor - initialize polyTerm as empty Linked List 
	public Polynomial()
	{
		this.polyTerm = new LinkedList<Term>();
		
	}
	
	// Copy Constructor
	public Polynomial(Polynomial object)
	{
		// Create a new instance of the linked List 
		this.polyTerm = new LinkedList<Term>();
		
		// If the polynomial is null - then there is nothing to copy 
		if(object != null)
		{
			// Iterate over each term in the argument polynomial
			for(int index = 0; index < object.getNumTerms(); index++)
			{
				// Create a temp term 
				Term tempTerm;
				tempTerm = object.getTerm(index);
				
				// Then add it to the calling object
				polyTerm.add(tempTerm);
			}
		}
		
	}
	
	// Getter for Number of Terms - Just returns the size of the linked list
	public int getNumTerms()
	{
		return this.polyTerm.size();
		
	};
	
	// Getter for a Specific term
	public Term getTerm(int index)
	{
		// Create a temp term to show the one you want to access 
		Term tempTerm;
		
		tempTerm = this.polyTerm.get(index);
		
		return tempTerm;
	}
	
	// Replace all items into a string format 
	/*public void replaceAll(String thing1, String thing2)
	{
		
	}
	*/
	
	// Add a Term
	public void addTerm(Term termT)
	{
		// Local Term variables to work through 
		Term currentTerm;
		
		// If the list size is zero, then we just add the term 
		if(this.polyTerm.size() == 0)
		{
			this.polyTerm.add(termT);
		}
		
		// Otherwise, we need to compare exponents to see where the term should go 
		else
		{
			// Want to iterate over the entire polynomial and find 
			// if there are any places where the exponents match
			for(int index = 0; index < this.getNumTerms() - 1; index++)
			{
				// Take the term at the index, so that we can work with it
				currentTerm = this.polyTerm.get(index);
				
				
				// What should we do if the exponent is bigger than the current term - add it
				// The compareTo method is already testing exponents 
				if(termT.compareTo(currentTerm) == 1)
				{
					polyTerm.add(index, termT);	
					return;
				}
				
				// If the exponents match, then we want to add the coefficients 
				else if(termT.compareTo(currentTerm) == 0)
				{
					// Get the coefficient of the term we want to add
					int termToAddCoeff = termT.getCoefficient();
					
					// Get the coefficient of the current term in the list
					int currentTermCoeff = currentTerm.getCoefficient();
					
					// Create an int that will hold the sum of the two coefficients
					int sumCoeff = termToAddCoeff + currentTermCoeff;
					
					// Then we want to reset the coefficient for the current term
					// to account for this, as we aren't adding a new position
					currentTerm.setCoefficient(sumCoeff);
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	// Add Entire Polynomials
	public void add(Polynomial p)
	{
		// Need to iterate over the argument poly to know how many terms to add
		for(int index = 0; index < p.getNumTerms(); index++)
		{
			this.polyTerm.addTerm(p.getTerm(index));
			
		}
		
	}
	
	// Clear method - Clears the entire polynomial 
	public void clear()
	{
		this.polyTerm.clear();
		
	}
	
	// Equals Method
	@Override
	public boolean equals(Object obj)
	{
		
		// Null Check
		if(obj == null)
		{
			return false;
		}
		
		// Self Check
		if(this == obj)
		{
			return true;
		}
		
		// Class Check
		if(this.getClass() != obj.getClass())
		{
			return false;
		}
		
		// Typecast 
		Polynomial currentPoly = (Polynomial) obj;
		
		// If they don't have the same number of terms, then they can't be the same 
		if(this.getNumTerms() != currentPoly.getNumTerms())
		{
			return false;
		}
		
		// Assuming that they have the same number of terms, then we need to iterate 
		// and compare each term individually - TO DO
		else
		{
			
		}
		
		return false;
	}
	
	// To String
	@Override
	public String toString()
	{
		// Create a temprorary string for this method 
		String temp = "";
		
		// If the list has nothing in it, or is null, then print zero 
		if(this.polyTerm == null || this.polyTerm.size() == 0)
		{
			temp += "0";
		}
		else
		{
			for(Term singleTerm : polyTerm)
			{
				temp += singleTerm.toString() + "+";
			}
		}
		
		// Return the temp value
		return temp;
	}
	
	
	

}

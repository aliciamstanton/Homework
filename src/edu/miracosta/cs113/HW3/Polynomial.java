
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
		
	}
	
	// Getter for Number of Terms - Just returns the size of the linked list
	public int getNumTerms()
	{
		return this.polyTerm.size();
		
	};
	
	// Getter for a Specific term
	public Term getTerm(int index)
	{
		return Term;
	}
	
	// Replace all items into a string format 
	public void replaceAll(String thing1, String thing2)
	{
		
	}
	
	// Add a Term
	public void addTerm(Term termT)
	{
		
	}
	
	// Add Entire Polynomials
	public void add(Polynomial p)
	{
		
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
		
	}
	
	
	

}

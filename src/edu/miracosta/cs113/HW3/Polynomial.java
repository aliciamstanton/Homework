
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
				Term tempTerm = new Term();
				tempTerm = object.getTerm(index);
				
				// Then add it to the calling object
				polyTerm.add(new Term(tempTerm));
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
	
	
	
	// Add a Term
	/*public void addTerm(Term termT)
	{
		// Local Term variables to work through 
		Term currentTerm, adjacentTerm, lastTerm;
		
		// If the list size is zero, then we just add the term 
		if(this.polyTerm.size() == 0)
		{
			this.polyTerm.add(termT);
		}
		
		// Otherwise, we need to compare exponents to see where the term should go 
		else
		{
			// An easy addition occurs if the term to add has a smaller exponent
			// than the last element already in the polynomial. We don't need to
			// iterate over the entire LinkedList. 
			
			// Get the lastTerm in the list 
			int lastItemIndex = this.getNumTerms() - 1;
			
			// Get the term at the last index in the list
			lastTerm = this.getTerm(lastItemIndex);
			
			// If the term we want to add has a smaller exponent than the end 
			// we can just add it at the end 
			if(termT.compareTo(lastTerm) == -1)
			{
				polyTerm.addLast(termT);
				
			}
			
			
			else 
			{
			// Want to iterate over the entire polynomial and find 
			// if there are any places where the exponents match
			for(int index = 0; index < this.getNumTerms() - 1; index++)
			{
				// Take the term at the index, so that we can work with it
				currentTerm = this.polyTerm.get(index);
				
				adjacentTerm = this.polyTerm.get(index + 1);
				
				
				// What should we do if the exponent is bigger than the current term - add it
				// The compareTo method is already testing exponents 
				if(termT.compareTo(currentTerm) == 1)
				{
					polyTerm.add(index, termT);	
					
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
				
				// Need to consider if the term we want to add has an exponent
				// less than the current term, however, this will return -1 multiple
				// times - need to check the next term 
				else if(termT.compareTo(currentTerm) == -1 && termT.compareTo(adjacentTerm) == 1)
				{
					// We can add it after the index its lower than, but before the index
					// its higher than
					polyTerm.add((index + 1), termT);
					
					
				}
					
			}
		}
			
	}
	}
		
		
		*/
	
	
	
	public void addTerm(Term termToAdd)
    {
        // local variable
        Term lastTerm, currentTerm, nextTerm;
        
        int lastIndex;

        // If list is empty, add term to index 0
        if (this.polyTerm.size() == 0)
        {
            this.polyTerm.add(termToAdd);
        }
      
        else  // there is more then 1 element in list
        {
        	
        	if (this.polyTerm.size() == 1)
            {
                lastTerm = polyTerm.get(0);
                
                if (termToAdd.compareTo(lastTerm) == 1)
                {
                    polyTerm.add(0, termToAdd);
                }
                
                else
                {
                    polyTerm.add(termToAdd);
                }
       
            } 
        	
        	else 
        	{
            // loop up too last index
            for (int i = 0; i < this.getNumTerms() - 1; i++)
            {
                currentTerm = this.getTerm(i);
                nextTerm = this.getTerm(i + 1);

                // if term to add exponent bigger then current term's exponent
                if (termToAdd.compareTo(currentTerm) == 1)
                {
                    polyTerm.add(i, termToAdd);
                    return;
                }

                // else if term to Add Exponent matches current term's exponent
                else if (termToAdd.compareTo(currentTerm) == 0)
                {
                
                	 Term temp = null;
                	 
                	 
         	        int coefficientSum;

         	        
         	            // Add both coefficients
         	            coefficientSum = termToAdd.getCoefficient() + currentTerm.getCoefficient();

         	            if (coefficientSum == 0)
         	            {
         	                polyTerm.remove(i);
         	            }
         	            else
         	            {
         	                temp = new Term(coefficientSum, termToAdd.getExponent());
         	            }
         	        
                   
                    if (temp != null)
                    {
                        polyTerm.set(i, temp);
                    }
                    
                    
                    return;
                }

                // if term to add exponent is smaller then current term exponent
                // and larger then the next term exponent
                if (termToAdd.compareTo(currentTerm) == -1
                        && termToAdd.compareTo(nextTerm) == 1)
                {
                    // Insert term in between current and next
                    polyTerm.add(i + 1, termToAdd);
                    return;
                }
            }

            // reached last index
            lastIndex = this.getNumTerms() - 1;
            lastTerm = this.getTerm(lastIndex);

            
            // Exponents are the same - want to add coefficients 
            if (termToAdd.compareTo(lastTerm) == 0)
            {
            	
            	Term temporary = null;
            	
            	int sumOfCoefficients;
            	
            	// Want to add both coefficients - to avoid repetitive terms 
            	sumOfCoefficients = termToAdd.getCoefficient() + lastTerm.getCoefficient();
            	
            	
            	if (sumOfCoefficients == 0)
 	            {
 	                polyTerm.remove(lastTerm);
 	            }
 	            else
 	            {
 	                temporary = new Term(sumOfCoefficients, termToAdd.getExponent());
 	            }
                
                
                if (temporary != null)
                {
                    polyTerm.set(lastIndex, temporary);
                }
                
            }
            
            else
            {
                polyTerm.add(termToAdd);
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
			 this.addTerm(p.getTerm(index));
			
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
				temp += singleTerm.toString();
			}
			
			
 			if (temp.charAt(0) == '+')
            {
                temp = temp.substring(1);
            }
			
			
		}
		
		// Return the temp value
		return temp;
	}
	
	
	

}

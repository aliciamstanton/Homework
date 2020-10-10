
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
                	 // Create a temporary term 
                	 Term temp = null;
                	 
                	 // Create an integer that can hold the sum of the coefficients 
         	        int coefficientSum;

         	        
         	            // Add both coefficients
         	            coefficientSum = termToAdd.getCoefficient() + currentTerm.getCoefficient();

         	            // If the sum cancels eachother out, we can just remove it from the list 
         	            if (coefficientSum == 0)
         	            {
         	                polyTerm.remove(i);
         	            }
         	            
         	            // Otherwise we want to add it, we can use either tue current term 
         	            // or termToAdd to get the exponent since we have already concluded that they
         	            // are the same 
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
            	// Same process as above, by creating empty term and a sum to hold coefficients 
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

package edu.miracosta.cs113.HW3;

import java.util.Scanner;

public class Driver 
{

	public static void main(String[] args) 
	{
		
		// Create a Menu to show the user
		System.out.println("Welcome to the Polynomial Creater");
		
		String userChoice;
		
		Polynomial PolyA = new Polynomial();
		Polynomial PolyB = new Polynomial();
		Term termA, termB;
		

		System.out.println("Please choose an option below: ");
		System.out.println("1. Create Polynomial A");
		System.out.println("2. Create Polynomial B");
		System.out.println("3. Add Term to Polynomial A");
		System.out.println("4. Add Term to Polynomial B");
		System.out.println("5. Clear Polynomial A");
		System.out.println("6. Clear Polynomial B");
		System.out.println("7. Add Polynomial A to Polynomial B");
		System.out.println("8. Exit Program");
		
		Scanner input = new Scanner(System.in);
		
		
		// Create a string response to hold the user response
		 userChoice = input.next();
		
		// Create a switch statement that will run each item in the list
		switch(userChoice)
		{
		
				// Case 1 - Create Poly A 
				case "1":
				{
					// Notify the user that they are creating the polynomial 
					System.out.println("You've created the first polynomial: ");
					
					// Clarify that it has no terms at this time 
					System.out.println("The polynomial right now has: " + PolyA.getNumTerms() + " terms.");
					break;
			
				}
				
				// Case 2 - Create Poly B 
				case "2":
				{
					// Notify the user that they are creating another polynomial 
					System.out.println("You've created the second polynomial: ");
					
					// Notify that there are no terms at this time 
					System.out.println("The polynomial right now has: " + PolyB.getNumTerms() + " terms");
					break;
				}
				
				// Case 3 - Add Term Poly A
				case "3":
				{
					// Notify the user that they are adding a new term and ask them for it 
					System.out.println("Adding a term to Polynomial A.");
					System.out.println("Please enter the term: ");
					String userTermA = input.next();
					
					// Use the string constructor to create the new temr 
					termA = new Term(userTermA);
					
					// Add the term to the polynomial 
					PolyA.addTerm(termA);
					
					// Print out the number of terms in the polynomial 
					System.out.println("The polynomial now has: " + PolyA.getNumTerms() + " term(s).");
					
					
					break;
				}
				
				// Case 4 - Add Term Poly B
				case "4":
				{
					// Notify the user that they are adding a new term and ask them for it
					System.out.println("Adding a term to Polynomial B");
					System.out.println("Please etner the term: ");
					String userTermB = input.next();
					
					// Use the string constructor to convert it to a term we can work with
					termB = new Term(userTermB);
					
					// Add the term to the polynomial
					PolyB.addTerm(termB);
					
					// Print out the number of terms in the second polynomial
					System.out.println("The polynomial now has: " + PolyB.getNumTerms() + " term(s).");
					
					break;
				}
				
				// Case 5 - Clear Poly A
				case "5":
				{
					break;
				}
				
				// Case 6 - Clear Poly B
				case "6":
				{
					break;
				}
				
				// Case 7 - Add Poly A and Poly B 
				case "7":
				{
					break;
				}
		
				// Case 8 - Exit the program 
				case "8":
				{
					break;
				}
		
				default:
				{
					System.out.println("None of the choices were valid.");
					break;
				}
		}
		
		
		
		
		
			
			
			
			
			

	}

}

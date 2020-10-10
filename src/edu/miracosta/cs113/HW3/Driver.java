package edu.miracosta.cs113.HW3;

import java.util.Scanner;

public class Driver 
{

	public static void main(String[] args) 
	{
		
		// Create a Menu to show the user
		System.out.println("Welcome to the Polynomial Creater");
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
		String userChoice = input.next();
		
		// Create a switch statement that will run each item in the list
		switch(userChoice)
		{
		
				// Case 1 - Create Poly A 
				case "1":
				{
					
					break;
			
				}
				
				// Case 2 - Create Poly B 
				case "2":
				{
					
					break;
				}
				
				// Case 3 - Add Term Poly A
				case "3":
				{
					
					break;
				}
				
				// Case 4 - Add Term Poly B
				case "4":
				{
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

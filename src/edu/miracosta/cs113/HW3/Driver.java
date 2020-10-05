package edu.miracosta.cs113.HW3;

public class Driver 
{

	public static void main(String[] args) 
	{
		
			System.out.println("Beginning of the Polynomial Program");
			
			// Test the Term class using the default 
			Term polyTerm = new Term();
			
			System.out.println(polyTerm.getExponent());
			System.out.println(polyTerm.getCoefficient());
			
			// Test the Term class using the Full Constructor
			Term polyTerm2 = new Term(2,3);
			
			System.out.println(polyTerm2.getExponent());
			System.out.println(polyTerm2.getCoefficient());
			
			// Want to test out the toString method with a term that has exp at zero
			Term polyTerm3 = new Term(0,3);
			
			System.out.println(polyTerm3.getExponent());
			
			// Now test the toString method
			System.out.println(polyTerm3.toString());
			
			
			

	}

}

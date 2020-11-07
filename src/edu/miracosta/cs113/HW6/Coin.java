
// Class can be found in the HW6 package
package edu.miracosta.cs113.HW6;


// Class name for Coin Object
public class Coin 
{
	// Instance variables for each coin
	int quarters, dimes, nickels, pennies;
	
	// Full Constructor
	public Coin()
	{
		quarters = 0;
		dimes = 0;
		nickels = 0;
		pennies = 0;
	}
	
	// Copy Constructor
	public Coin(Coin newCoin)
	{
		// Copy pennies
		this.pennies = newCoin.getPennies();
		
		// Copy nickels
		this.nickels = newCoin.getNickels();
		
		// Copy dimes
		this.dimes = newCoin.getDimes();
		
		// Copy Quarters
		this.quarters = newCoin.getQuarters();	
		
	}
	
	
	// Getter Methods 
	
	// Pennies
	public int getPennies()
	{
		return this.pennies;
	}
	
	// Nickels
	public int getNickels()
	{
		return this.nickels;
	}
	
	// Dimes
	public int getDimes()
	{
		return this.dimes;
	}
	
	// Quarters
	public int getQuarters()
	{
		return this.quarters;
	}
	

}

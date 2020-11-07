
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
	
	
	// Counter Incrementers
	
	// AddPenny
	public void addPenny()
	{
		pennies = getPennies() + 1;
	}
	
	// AddNickel
	public void addNickel()
	{
		nickels = getNickels() + 1;
	}
	
	// AddDimes
	public void addDime()
	{
		dimes = getDimes() + 1;
	}
	
	// AddQuarter
	public void addQuarter()
	{
		quarters = getQuarters() + 1;
	}
	
	
	// Equals Method
	public boolean equals(Object obj)
	{
		
		// Self check
		if(this == obj)
		{
			return true;
		}
		
		// Null check
		if(obj == null)
		{
			return false;
		}
		
		// Type check
		if(this.getClass() != obj.getClass()) 
		{
			return false;
		}
		
		// Typecast
		Coin change = (Coin) obj;
		
		
		// Property check
		if(this.getPennies() == change.getPennies() && this.getNickels() == change.getNickels()
				&& this.getDimes() == change.getDimes() && this.getQuarters() == change.getQuarters())
		{
			return true;
		}
		
		else
		{
			return false;
		}
		
	}
	

}

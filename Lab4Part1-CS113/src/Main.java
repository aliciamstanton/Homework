// Import arrayList class
import java.util.ArrayList;

// Class Main - Definition/ Driver 
public class Main
{

	// Create an arrayList
	public static ArrayList<String> aList = new ArrayList<String>();
	
	// Constructor that will create aList upon instantiation of class
	public Main()
	{
		aList = new ArrayList<String>();
		
	}
	
	
	
	// Replace Method - We are replacing an old item with a new item in the arrayList
	// TO DO: This needs to replace ALL occurrences of the item 
	public static void replace(ArrayList<String> aList, String oldItem, String newItem)
	{
		// First we want to get the size of the arrayList
		int sizeOfList = aList.size();
		
		// If the size is zero, then we should just enter the new item
		if(sizeOfList == 0)
		{
			aList.add(newItem);
		}
		else 
		{
			
			// Find the index where the item we want to replace is 
			int indexToReplace = aList.indexOf(oldItem);
			
			// Continue finding other places where this element can be found 
			// until -1 is returned, meaning that we have gotten all instances
			while(indexToReplace != -1)
			{
				// Replace the item 
				aList.set(indexToReplace, newItem);
				
				// Move on to the next occurrence if there is one 
				indexToReplace = aList.indexOf(oldItem);
				
			}
			
		}
		
	}
	
	// Delete First Occurrence Method
	public static void delete(ArrayList<String> aList, String target)
	{
		// First we want to make sure that the list has items in it
		int sizeOfList = aList.size();
		
		// We need to make sure the list has items we can try and delete 
		if(sizeOfList > 0)
		{
			
			// Make a placeholder that will find the index of the item we want to delete
			int indexToDelete = aList.indexOf(target);
			
			if(indexToDelete == -1)
			{
				System.out.println("Item is not in the list");
			}
			else
			{
				aList.remove(indexToDelete);
			}
			
		}
		else 
		{
			System.out.println("Item is not in the list");
		}
		
		
	}


//Main Method - Driver
	public static void main(String[] args) 
	{
		
		// Add random items to aList
		aList.add("Welcome");
		aList.add("To");
		aList.add("CS113"); 
		
		// Test the replace method with the assumption that there are NO items in the list
		System.out.println(aList.size());
		
		// Test delete item in list
		delete(aList, "CS113");
		
		System.out.println(aList.size());
		
	}



}


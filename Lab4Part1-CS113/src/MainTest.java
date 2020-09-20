// JUnit Test that will check to make sure that an item is removed from the list 

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MainTest 
{

	
	@Test
	void DeleteTest() 
	{
		// Create an instance of the class we want to test 
		Main dataManipulation = new Main();
		
		// Add some random items to the list
		dataManipulation.aList.add("Welcome");
		dataManipulation.aList.add("To");
		dataManipulation.aList.add("CS113");
		
		// To test the delete method, we can use assertEquals
		
		// Call delete method
		dataManipulation.delete(dataManipulation.aList,  "CS113");
		
		assertEquals(2, dataManipulation.aList.size());
		
		//fail("Not yet implemented");
	}
	
	@Test
	void replaceTest()
	{
		
		Main dataManipulation = new Main();
		
		// Add some random items to the list
				dataManipulation.aList.add("Welcome");
				dataManipulation.aList.add("To");
				dataManipulation.aList.add("CS113");
		
		// Add line that will call the replace method - Replacing all instances of "To")
				dataManipulation.replace(dataManipulation.aList, "CS113", "CS220");
		
		// Assert Equals to make sure that the target item is no longer
		// found in the arrayList 
				assertEquals(-1, dataManipulation.aList.indexOf("CS113"));
		
		
		//fail("Not yet implemented");
	}

}

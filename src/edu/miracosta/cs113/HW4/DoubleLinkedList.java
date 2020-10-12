
// Homework 4 can be found in the HW4 Package 
package edu.miracosta.cs113.HW4;

import java.util.List;
import java.util.ListIterator;

// Class Definition - Must add and override specific methods required through 
// implementation of the List Interface 
public class DoubleLinkedList<E> implements List<E>
{
	
	// Default Constructor
	
	// Full Constructor
	
	// Copy Constructor
	
	// Getter
	
	// Setter
	
	// Equals
	
	// toString
	
	
	// Overridden and Required methods for List Interface 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Inner class that implements the ListIterator Interface
	// Specific methods need to be implemented in order to use the interface 
	private class DoubleIterator implements ListIterator<E>
	{
		
		
		// Inserts element into the list 
		@Override
		public void add(E e)
		{
			
		}
		
		// Returns true if there is another element when traversing in the forward direction
		@Override
		public boolean hasNext() 
		{
			
		}
		
		// Returns true if there is another element when traversing in the reverse direction
		@Override
		public boolean hasPrevious()
		{
			
		}
		
		// Returns the next element in the list and advances the cursor position
		@Override
		public E next()
		{
			
		}
		
		// Returns index of the element that would occur after another call to next()
		@Override 
		public int nextIndex()
		{
			
		}
		
		// Retrieves the previous element and decrements the index backwards
		@Override
		public E previous()
		{
			
		}
		
		// Returns the index of the element that would occur after another call to previous
		@Override
		public int previousIndex()
		{
			
		}
		
		// Removes an element from the list
		@Override
		public void remove()
		{
			
		}
		
		// Replaces a specific element
		@Override 
		public void set(E e)
		{
			
		}	
		
	}
	
	
	
	// Requirement for static inner class Node <E> - taken from text on pg 91 ed.2
	private static class Node<E>
	{
		
		// Data Fields 
	
		// Reference to the data 
		private E data;
		
		// Reference to the next node
		private Node<E> next;
		
		// Constructor - Creates a new node with the next field being null
		private Node(E dataItem)
		{
			data = dataItem;
			next = null;
		}
		
		// Constructor - Creates a new node that references another node
		private Node(E dataItem, Node<E> nodeRef)
		{
			data = dataItem;
			next = nodeRef;
		}	
		
	}
		

}

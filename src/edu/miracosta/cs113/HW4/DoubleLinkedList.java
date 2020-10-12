
// Homework 4 can be found in the HW4 Package 
package edu.miracosta.cs113.HW4;

import java.util.ListIterator;

// Class Definition 
public class DoubleLinkedList 
{
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Inner class that implements the ListIterator Interface
	// Specific methods need to be implemented in order to use the interface 
	private class DoubleIterator implements ListIterator<E>
	{
		
		
		
		
		
		
		
		
		
		
		
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

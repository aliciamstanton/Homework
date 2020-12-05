
// Homework 4 can be found in the HW4 Package 
package edu.miracosta.cs113.HW4;

// Import all items in the Java.util package 
import java.util.*;

import DoubleLinkedList.DoubleListIterator;



// Class Definition
public class DoubleLinkedList<E> implements List<E>
{  
	// Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
  
    	
    	
    	
   // Default Constructor - Set the head and tail to null and start the list size off as zero 
    	public DoubleLinkedList()
    	{
    		head = null;
    		tail = null;
    		size = 0;
    	}
  
    	
    	@Override
    	  public ListIter iterator() 
    	  { 
    		 
    		return new ListIter();
    	  }
    	  
    	  @Override
    	  public ListIter listIterator() 
    	  { 
    		 
    		  return new ListIter();
    	  }
    	  
    	  
    	  public ListIter listIterator(int index)
    	  {
    		  return new ListIter(index);
    	  }
    	  
    	
    	
   
   // Adds element at a specific index within the double-linked list 
  @Override
  public void add(int index, E obj)
  { 
	  listIterator(index).add(obj); // taken from text 
  }
  
  
  // Adds an element at the beginning of the double-linked list 
  public void addFirst(E obj) 
  { 
	 // Can use the list iterator, similar to above and specify the index as zero
	  listIterator().add(obj);
	  
  }
  
  @Override
  public boolean add(E obj)
  {
	  listIterator().add(obj);
	  return true;
  }
  

  // Adds an element at the end of the double-linked list
  public void addLast(E obj) 
  { 
	  // Can use the list iterator, similiar to add method and specify the index using size
	  int currentSize = size();
	  
	  listIterator(currentSize - 1).add(obj);
	 
  }

  // Returns the element at a specified index 
  @Override
  public E get(int index) 
  { 	
	  ListIter iter = new ListIter(index); 
	  boolean doesNextExist = iter.hasNext();
	  
	  if(doesNextExist == false)
	  {
		 throw new IndexOutOfBoundsException();
	  }
	  
	  else 
	  {
      	return iter.next();
	  } 
	  
	  
	  
	  
  }
  
  
  // Get the element located at the first position in the list 
  public E getFirst() 
  { 
	  return head.data;  
  }
  
  
  // Get the element at the last position in the list 
  public E getLast() 
  { 
	  return tail.data;  
  }

  
  // Return the size of the double-linked list 
  @Override
  public int size() 
  {  
	  
	  return size;
	  

  } 

  
  // Remove the element at a specific index 
  @Override
  public E remove(int index)
  {    
	  
	  // Create a value that we can return from this method 
	  E returnValue = null;
	  
	  
	  // Create an iterator that will allow us to iterate over the list 
	  ListIter iter = new ListIter(index);
	  
	  // Want to make sure that the index is within bounds 
	  if(index < 0)
	  {
		  throw new IndexOutOfBoundsException();
	  }
	  else if(index >= size)
	  {
		  throw new IndexOutOfBoundsException();
	  }
	  
	  // If neither of the above applies, then we have a valid index and can work on removing an item 
	  // First consider if there is a next item 
	  if(iter.hasNext())
	  {
		// If so, grab it as the value that we are going to return and remove   
		  returnValue = iter.next();
		  
		  // Call remove to remove it from the DLL 
		  iter.remove();
		  
		  // Return the value that was removed 
		  return returnValue;
		  
	  }
	  
	  // If there is no next item to return then throw a new IllegalStateException 
	  else 
	  {
		  throw new IllegalStateException();
	  }  
	  
  }
  
  
  @Override
	public boolean remove(Object o) 
  {
		int sizeNow = size ;
		int indexNow = indexOf(o) ;
		if (indexNow < 0 || indexNow >= size()) {
			return false ;
		}
		ListIter mover = new ListIter(indexNow) ;
		if (mover.hasNext()) {
			mover.next();
		}
		else {
			throw new IndexOutOfBoundsException();
		}
		mover.remove() ;
		if (sizeNow == (size() -1)) {
			return false ;
		}
		else {
			return true ;
		}
		
	} 
  
  
  
  // Equals method for DoubleLinkedList Class - Compares to DLL Nodes 
  @Override
  public boolean equals(Object other)
  {
	  
	  // Null check
	  if(other == null)
	  {
		  return false;
	  }
	  
	  // Check to see if both are instances of a LinkedList, if not, then they cannot be equal 
	  boolean isLinkedList = other instanceof DoubleLinkedList;
	  
	  if(isLinkedList == false)
	  {
		  return false;
	  }
	 
	 
	  // Typecast
	  DoubleLinkedList d = (DoubleLinkedList) other;
	  
	  
	  // If the lists are not the same size, then they cannot be equal 
	  if(size() != d.size())
	  {
		  return false;
	  }
	  
	  // If they are the same size, then we need to compare each element within the DLL's
	  
	  // Create a node that will point to the head 
	  Node<E> currentPosition = head;
	  
	  // Iterate over the entire DLL to see if the other list (d) contains the same elements 
	  while(currentPosition != null)
	  {
		  if(d.contains(currentPosition.data))
		  {
			  currentPosition = currentPosition.next;
		  }
		  else 
		  {
			  return false;
		  }
		  
	  }
	  
	  return true;  
	  
  }
  
  // Implementing toString
  @Override
  public String toString()
  {
	  
	  
	  // Create a string that we can use to print content
	  String currentPosition = "";
	  
	  
	  // Create a node that will allow us to iterate over the list 
	  Node<E> currentListPosition = head;
	  
	  // If the list is empty, i.e. the head is null then we can append something empty to the string 
	  if(isEmpty() == true)
	  {
		  currentPosition += "";
	  }
	  
	  // Otherwise, there are items in the list that we need to print out to the console 
	  else
	  {
		  // While there are still items left in the DLL to grab, we should append them to the string 
		  while(currentListPosition != null)
		  {
			   currentPosition += currentListPosition.data + ", ";
			   
			   // Iterate to the next item
			   currentListPosition = currentListPosition.next;
		  }
		  
		  currentPosition = currentPosition.substring(0, currentPosition.length() - 2);
	  }
	  
	  // Return the string statement 
	  return currentPosition;  
	  
  }
  
  
  
  // Method to see if the DLL is empty 
  @Override
  public boolean isEmpty() 
  {
	  
	 // If the size is zero, then the list is empty and/or the head is null then the list is also empty 
  	if(size == 0 || head == null)
  	{
  		return true;
  	}
  	
  	return false;
  }

  // Method to confirm whether a value can be found in the DLL 
  @Override
  public boolean contains(Object o) 
  {
  	int isAvailable = indexOf(o);
  	
  	if(isAvailable != -1)
  	{
  		return true;
  	}
  	return false;
  }


  	// Method to remove all elements from the DLL 
  @Override
  public void clear() 
  {
	  // Make the head null 
	  head = null;
	  tail = head;
	  size = 0;
  	
  	
  }

  @Override
  public E set(int index, E element) 
  {
  	// First make sure that the index we've received is valid
	  
	  int currentSize = size();
	  
	  // Top most index that we can set 
	  currentSize--;
	  
	  if(index > currentSize)
	  {
		  throw new IndexOutOfBoundsException();
	  }
	  
	  // Otherwise, we can try and reset the element 
	  else
	  {
		  // Create a new list iterator - use the index to specify where we will start iterating 
		  ListIter newIter = new ListIter(index);
		  
		  // Create a new node that will hold the value that we are going to return as we are resetting it 
		  Node<E> infoToBeReset = new Node<E>();
		  
		  newIter.next();
		  
		  // Set the data of the node that we are going to reset, prior to adding new data 
		  infoToBeReset.data = newIter.lastItemReturned.data;
		  
		  // Now reset the data 
		  newIter.set(element);
		  
		  // Return the data from the old node 
		  return infoToBeReset.data;
		  
	  }
	  
  }

  
  // Method that iterates over DLL to find if a node's data matches that of the object we are looking for 
  @Override
  public int indexOf(Object o) 
  {
	  // Create a counter that starts at zero 
	  int counter = 0;
	  
	  // If the object is null, then it cannot be in the DLL 
	  if(o == null)
	  {
		  return - 1;
	  }
	  
	  else 
	  {
		  // Create a new node that will point to the head of the DLL 
		  Node currentPosition = head;
		  
		  // Iterate over the DLL until we reach the value we are looking for 
		  while(currentPosition != null)
		  {
			 if(o.equals(currentPosition.data))
			 {
				 // Return the current counter 
				 return counter;
			 }
			 
			 // Update the counter to continue iterating through the list 
			 counter++;
			 
			 // Move the iterator to the next element
			 currentPosition = currentPosition.next;
		  }
		  
		  // If we reach the end and have not been able to find the index of the element, then return -1 
		  return - 1;
	  }
  	
  }

  @Override
  public int lastIndexOf(Object o) 
  {
  	 // Create a counter 
	  int counter = 0;
	  
	  // If the item is null, then it cannot be found in the list 
	  if(o == null)
	  {
		  return - 1;
	  }
	  
	  // Otherwise we can iterate from the end, since this is a DLL 
	  else 
	  {
		  Node currentPosition = tail;
		  
		  // Iterate from the back to the front until we find the first instance of the variable 
		  // we are looking for as this will be closest to the end ofthe list 
		  while(currentPosition != null)
		  {
			  // Compare the data with the data in the current Node of the DLL 
			  if(o.equals(currentPosition.data))
			  {
				  int finalIndex = size - counter  - 1;
				  return finalIndex;
				  
			  }
			  
			  // Continue to update the counter 
			  counter++;
			  
			  // Set the iterator to look at the previous value as we are iterating from the tail to the front 
			  currentPosition = currentPosition.prev;
		  }
	  }
	  
	  // If all else fails, the item is not in the DLL and you can return -1 
	  return - 1;
  }

  
  
  
  /* List Iterators */
  
  
  
  public ListIter listIterator(ListIter iter)
  {     
	  return new ListIter( (ListIter) iter);  
  }

  // Inner Classes - Node - MATCHES 
  private static class Node<E>
  {     
	  	private E data;
        private Node<E> next = null;
        private Node<E> prev = null;
        
        // Empty Constructor
        private Node()
        {
        	data = null;
        	next = null;
        	prev = null;
        }

        
        // Partial Constructor 
        private Node(E dataItem) 
        {   
        	data = dataItem; 
        	next = null;
        	prev = null;
        }
        
        
        // Full Constructor 
        private Node(E dataItem, Node<E> nextRef, Node<E> previousRef)
        {
        	data = dataItem;
        	next = nextRef;
        	prev = previousRef;
        }
  }  // end class Node
  
  
  
  // Beginning of implementation for ListIterator<E> interface 

  public class ListIter implements ListIterator<E> 
  {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;   // The current index 
        
        
     // Empty Constructor
        public ListIter()
        {
        	lastItemReturned = null;
        	nextItem = head;
        	for(index = 0; index < size(); index++)
        	{
        		nextItem = nextItem.next;
        	}
        }

     
        
    // Full Constructor for List Iterator   
    public ListIter(int i)  
    {   
    	// If the index is less than zero or greater than the size of the DLL, then throw an exception
    	if (i < 0 || i > size)
        {     
    		throw new IndexOutOfBoundsException("Invalid index " + i); 
    	}
    	
        lastItemReturned = null;
 
        
        // If the index is equal to the size of the list, then there is no next item to return, i.e. null 
        if (i == size)     
        {    
        	index = size;    
        	nextItem = null;     
        } 
        
        // Otherwise, we can start from the beginning aod iterate over the entire DLL 
        else          
        {   
        	nextItem = head;
            for (index = 0; index < i; index++)  
            {
            	nextItem = nextItem.next;   
            }
        }
    }  

    
    // Copy Constructor for ListIter class 
    public ListIter(ListIter other)
    {  
    	nextItem = other.nextItem;
        index = other.index;   
    }
    

    // Returns true, if a call to next will not throw an exception - taken from text 
    @Override
    public boolean hasNext() 
    {   
    	// Returns true if there is another element in the DLL 
    	return nextItem != null;
    	
    } 
    
    
    // Will return true if there is a previous element and no exception will be thrown 
    @Override
    public boolean hasPrevious()
    {   
    	
    	// If the size of the list is zero, then there are no elements and there cannot be a previous element 
    	if(size == 0)
    	{
    		return false;
    	}
    	
    	// If nextItem returns null, but the list size is greater than zero - then there should be a previous element 
        else if  (nextItem == null ) 
        { 
            return true ;
        } 
    	
    	
    	// If the previous item to the next one returns null, then there is no previous element 
        else if (nextItem.prev == null)
        { 
            return false;
        }

    	// Any other conditions should return true 
        else 
        {
            return true;
        }
    	
    	 
    } 
    
    
    // Returns the index one less than the current place in the DLL 
    @Override
    public int previousIndex()
    {  
    	return index - 1;
    } 
    
    
    
    // Returns the index one more than the current place in the DLL 
    @Override
    public int nextIndex() 
    { 
    	return index;
    	
    } 
    
    
    // Sets the data in the last node to a new value 
    @Override
    public void set(E item)  
    { 
    	
    	/*if(lastItemReturned == null)
    	{
    		throw new IllegalStateException();
    	}
    	
    	else if(lastItemReturned != null)
    	{
    		// Create a new node 
    		Node <E> newNode = new Node<E>(o);
    		
    		// Set the data in the node of the last item returned to the new item we are passing in 
    		lastItemReturned.data = o;
    		
    	} */
    	
    	
        
            if (lastItemReturned == null) 
            {
                throw new IllegalStateException();
            }
            lastItemReturned.data = item;
        
    	
    	
    	
    	
    	
    }  

    @Override
    public void remove()
    {
    	
    	if (head == null) { // empty list
			throw new IllegalStateException() ;
		}
		else if (lastItemReturned == null) { // no step over
			throw new IllegalStateException() ;
		}
		else if (lastItemReturned.prev == null && nextItem == null) {
			head = null ;
			tail = null ;
			size = 0 ;
			index = 0 ;
		}
		else if (lastItemReturned.prev == null) {
			nextItem.prev = head ;
			head = nextItem ;
			size-- ;
			index-- ;
		}
		else if (nextItem == null) { // tail
			lastItemReturned.prev.next = null ;
			tail = lastItemReturned.prev ;
			index-- ;
			size-- ;
		}
		else {
			lastItemReturned.prev.next = nextItem ;
			nextItem.prev = lastItemReturned.prev ;
			size-- ;
			index-- ;	
			System.out.println("In the remove");

		}
		lastItemReturned = null; 
    	
    }     
    
    
    
    // Provides the next element in the double-linked list
    // if no such element exists, then an exception is thrown - taken from text
    @Override
    public E next()
    {  
    	// If there is no other element - throw exception 
    	if(!hasNext())
    	{
    		throw new NoSuchElementException();
    	}
    	
    	// If another element exists, update the iterator and the index 
    	else 
    	{
    		lastItemReturned = nextItem;
    		nextItem = nextItem.next;
    		index++;
    		return lastItemReturned.data;
    	}
    	
    }
    
    
    // Returns the previous element in the double-linked list
    // If no element exists, then a new exception is thrown - taken from text 
    @Override
    public E previous() 
    {  
    	
    	if(!hasPrevious())
    	{
    		throw new NoSuchElementException();
    	}
    	
    	// If the next item is null, then we are at the tail 
    	if(nextItem == null)
    	{
    		nextItem = tail;
    	}
    	
    	// Otherwise, we can iterate backwards 
    	else
    	{
    		nextItem = nextItem.prev;
    	}
    	
    	// Update the lastItemReturned 
    	lastItemReturned = nextItem;
    	
    	// Decrement the iterator index 
    	index--;
    	
    	// Return the data in the item to be returned 
    	return lastItemReturned.data;

    }

    
    // Adds a new item between the item that will be returned through next and the item
    // that would be returned through previous.
    @Override 
    public void add(E obj)
    {
    	
    	// First determine if the double linked list is empty - if so, it becomes the head 
    	if(head == null)
    	{
    		// Make a new node that will become the head 
    		head = new Node<E>(obj);
    		
    		// If the list was originally empty then there is only one element and the head is also the tail 
    		tail = head;
    	}
    	
    	// If the nextItem would be the head, then we are adding new elements at the head 
    	else if(nextItem == head)
    	{
    		// Create a new node
    		Node<E> newNode = new Node<E>(obj);
    		
    		// Link it to the nextItem
    		newNode.next = nextItem;
    		
    		// Link nextItem to the new node
    		nextItem.prev = newNode;
    		
    		// The new node is now the head
    		head = newNode;
    	}
    	
    	// If nextItem is null, then the insertion as at the tail of the double-linked list
    	else if(nextItem == null)
    	{
    		// Create a new node
    		Node<E> newNode = new Node<E>(obj);
    		
    		// Link the tail to the new node
    		tail.next = newNode;
    		
    		// Link the new node to the tail
    		newNode.prev = tail;
    		
    		// The new node is the new tail
    		tail = newNode;
    	}
    	
    	// If none of the above is true, then the item is being added at NEITHER the head or tail
    	// and will be added somewhere in the middle of the DLL 
    	else
    	{
    		// Create a new node
    		Node<E> newNode = new Node<E>(obj);
    		
    		// Link it to nextItem.prev
    		newNode.prev = nextItem.prev;
    		nextItem.prev.next = newNode;
    		
    		// Link it to the next item
    		newNode.next = nextItem;
    		nextItem.prev = newNode;
    	}
    	
    	// Make sure to increase the size, the current index and set the lastItemReturned
    	size++;
    	index++;
    	lastItemReturned = null;
    		
    }
    
  }// end of inner class ListIter
  
}// end of class DoubleLinkedList


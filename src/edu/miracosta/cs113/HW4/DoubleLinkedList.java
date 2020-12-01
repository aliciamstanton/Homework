
// Homework 4 can be found in the HW4 Package 
package edu.miracosta.cs113.HW4;

// Import all items in the Java.util package 
import java.util.*;


// Class Definition
public class DoubleLinkedList<E> implements List<E>
{  
	// Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
  
    	
    	
    	
   // Default Constructor
    	public DoubleLinkedList()
    	{
    		head = null;
    		tail = null;
    		size = 0;
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
	  listIterator(0).add(obj);
	  
	  
  }
  

  // Adds an element at the end of the double-linked list 
  public void addLast(E obj) 
  { 
	  // Can use the list iterator, similiar to add method and specify the index using size
	  int currentSize = size();
	  
	  listIterator(currentSize - 1).add(obj);
	 
  }

  // Returns the element at a specified index 
  public E get(int index) 
  { 	
	  ListIterator<E> iter = listIterator(index); 
      	return iter.next();
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
  public int size() 
  {  
	  
	  return this.size();
	  
	 // return -1; 
  } 

  
  // Remove the element at a specific index 
  public E remove(int index)
  {    
	  E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        
        if (iter.hasNext())
        {   returnValue = iter.next();
            iter.remove();
        }
        
        else 
        {  
        	throw new IndexOutOfBoundsException();  
        }
        
        return returnValue;
  }
  
  
  // Equals method for DoubleLinkedList Class
  public boolean equals(Object other)
  {
	  // Self check 
	  if(this == other)
	  {
		  return true;
	  }
	  
	  // Null check
	  if(other == null)
	  {
		  return false;
	  }
	  
	  // Class check 
	  if(this.getClass() != other.getClass())
	  {
		  return false;
	  }
	  
	  // Typecast
	  DoubleLinkedList d = (DoubleLinkedList) other;
	  
	  return false;
  }
  
  // Implementing toString
  public String toString()
  {
	  
	  
	  // Create a string that we can use to print content
	  String currentPosition = " ";
	  
	  // Iterate over the loop while there is still another list item
	  while(listIterator().hasNext())
	  {
		  
		  // Append to the currentPosition
		  currentPosition += listIterator().next().toString();
		  
		  // Want to make sure that there is space/differentiation between variables if another exists
		  if(listIterator().hasNext()) 
		  {
			  
			  // Add space 
			  currentPosition += ", ";
			  
		  }
		  
	  }
	  
	  
	  // Return the string statement 
	  return currentPosition;  
	  
  }
  
  
  
  
  @Override
  public boolean isEmpty() {
  	// TODO Auto-generated method stub
  	return false;
  }

  @Override
  public boolean contains(Object o) {
  	// TODO Auto-generated method stub
  	return false;
  }


  @Override
  public void clear() {
  	// TODO Auto-generated method stub
  	
  }

  @Override
  public E set(int index, E element) {
  	// TODO Auto-generated method stub
  	return null;
  }

  @Override
  public int indexOf(Object o) {
  	// TODO Auto-generated method stub
  	return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
  	// TODO Auto-generated method stub
  	return 0;
  }

  
  
  
  /* List Iterators */
  
  
  public Iterator<E> iterator() 
  { 
	  return new ListIter(0); 
  }
  
  
  public ListIterator<E> listIterator() 
  { 
	  return new ListIter(0);  
  }
  
  
  public ListIterator<E> listIterator(int index)
  {
	  return new ListIter(index);
  }
  
  
  public ListIterator<E> listIterator(ListIterator<E> iter)
  {     
	  return new ListIter( (ListIter) iter);  
  }

  // Inner Classes - Node 
  private static class Node<E>
  {     
	  	private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        
        // Partial Constructor 
        private Node(E dataItem) 
        {   
        	data = dataItem;   
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
    	// If the head is null, then the list is empty therefore there can be no previous element 
    	if(head == null)
    	{
    		return false;
    	}
    	
    	// If the previous element for the next item is null, then return false 
    	else if(nextItem.prev == null)
    	{
    		return false;
    	}
    	
    	// Otherwise return true 
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
    
    
    public void set(E o)  
    { 
    	
    }  // not implemented
    
    
    public void remove()
    {
    	
    }      // not implemented
    
    
    
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


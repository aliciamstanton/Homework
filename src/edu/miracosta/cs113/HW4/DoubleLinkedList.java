
// Homework 4 can be found in the HW4 Package 
package edu.miracosta.cs113.HW4;

// Import all items in the Java.util package 
import java.util.*;


// Class Definition
public class DoubleLinkedList<E> extends AbstractSequentialList<E>
{  
	// Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
  
   
   // Adds element at a specific index within the double-linked list 
  public void add(int index, E obj)
  { 
	  // Fill Here 
  }
  
  
  // Adds an element at the beginning of the double-linked list 
  public void addFirst(E obj) 
  { 
	  // Fill Here 
	  
  }
  

  // Adds an element at the end of the double-linked list 
  public void addLast(E obj) 
  { 
	  // Fill Here
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
	  return -1; 
  } // Fill Here

  
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

  
  public Iterator iterator() 
  { 
	  return new ListIter(0); 
  }
  
  
  public ListIterator listIterator() 
  { 
	  return new ListIter(0);  
  }
  
  
  public ListIterator listIterator(int index)
  {
	  return new ListIter(index);
  }
  
  
  public ListIterator listIterator(ListIterator iter)
  {     
	  return new ListIter( (ListIter) iter);  
  }

  // Inner Classes
  private static class Node<E>
  {     
	  	private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        
        private Node(E dataItem)  //constructor
        {   
        	data = dataItem;   
        }
  }  // end class Node
  
  

  public class ListIter implements ListIterator<E> 
  {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;   // 

        
    public ListIter(int i)  // constructor for ListIter class
    {   
    	if (i < 0 || i > size)
        {     
    		throw new IndexOutOfBoundsException("Invalid index " + i); 
    	}
    	
        lastItemReturned = null;
 
        if (i == size)     // Special case of last item
        {    
        	index = size;     nextItem = null;     
        } 
        
        else          // start at the beginning
        {   
        	nextItem = head;
            for (index = 0; index < i; index++)  nextItem = nextItem.next;   
        }// end else
    }  // end constructor

    
    public ListIter(ListIter other)
    {  
    	nextItem = other.nextItem;
        index = other.index;   
    }
    

    public boolean hasNext() 
    {   
    	return true;   
    } // Fill Here
    
    
    public boolean hasPrevious()
    {   
    	return false;  
    } // Fill Here
    
    
    public int previousIndex()
    {  
    	return 0;   
    } // Fill Here
    
    
    public int nextIndex() 
    { 
    	return 0;   
    } // Fill here
    
    
    public void set(E o)  
    { 
    	
    }  // not implemented
    
    
    public void remove()
    {
    	
    }      // not implemented

    public E next()
    {  
        return lastItemReturned.data; // Fill Here 
    }

    public E previous() 
    {  
    	return lastItemReturned.data; // Fill Here 
    }

    public void add(E obj)
    {

    		// Fill Here
    }
    
  }// end of inner class ListIter
  
}// end of class DoubleLinkedList









































































































/*// Class Definition - Must add and override specific methods required through 
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
	
	// Returns an iterator over the elements in the list 
	@Override
	public Iterator<E> iterator()
	{
		
	}
	
	// Returns a list iterator over the elements in the list
	@Override
	public ListIterator<E> listIterator()
	{
		
	}
	
	// Returns a list iterator over the elemnts in the list starting at specified position
	@Override
	public listIterator<E> listIterator(int index)
	{
		
	}
	
	// Appends a specific element to the end of the list
	@Override
	public boolean add(E e)
	{
		
	}
	
	// Inserts the specified element at the position in the list
	@Override
	public void add(int index, E element)
	{
		
	}
	
	// Clears the linked list
	@Override
	public void clear()
	{
		
	}
	
	
	// Compares objects
	@Override 
	public boolean equals(Object o)
	{
		
	}
	
	
	// Returns true if the list contains a specific object
	@Override
	public boolean contains(Object o)
	{
		
	}
	
	
	// Get method for index
	@Override
	public E get(int index)
	{
		
	}
	
	// Gets the index of a specific element
	@Override
	public int indexOf(Object o)
	{
		
	}
	
	// Returns the index of the last occurrence of a specific object
	@Override 
	public int lastIndexOf(Object o)
	{
		
	}
	
	// Returns true if the list is empty
	@Override
	public boolean isEmpty()
	{
		
	}
	
	// Removes an element at a specific index
	@Override
	public E remove(int index)
	{
		
	}
	
	// Removes the first occurrence of a specific element from the list
	@Override
	public boolean remove(Object o)
	{
		
	}
	
	// Sets an element at a specified position
	@Override
	public E set(int index, E element)
	{
		
	}
	
	// Returns the size of the list
	@Override 
	public int size()
	{
		
	}
	

	
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
		

} */
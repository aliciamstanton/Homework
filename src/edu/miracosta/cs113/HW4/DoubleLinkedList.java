
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

    
    // Copy Constructor for ListIter class 
    public ListIter(ListIter other)
    {  
    	nextItem = other.nextItem;
        index = other.index;   
    }
    

    // Returns true, if a call to next will not throw an exception - taken from text 
    public boolean hasNext() 
    {   
    	//return true; 
    	
    	return nextItem != null;
    	
    	
    } 
    
    
    // Will return true if there is a previous element and no exception will be thrown 
    public boolean hasPrevious()
    {   
    	return (nextItem == null && size != 0) || nextItem.prev != null;
    	
    	
    	//return false;  
    } 
    
    
    public int previousIndex()
    {  
    	
    	return index - 1;
    	
    	//return 0;   
    } 
    
    
    public int nextIndex() 
    { 
    	return index;
    	
    	//return 0;   
    } 
    
    
    public void set(E o)  
    { 
    	
    }  // not implemented
    
    
    public void remove()
    {
    	
    }      // not implemented
    
    
    
    // Provides the next element in the double-linked list
    // if no such element exists, then an exception is thrown - taken from text
    
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
    	
        //return lastItemReturned.data; 
    }
    
    
    // Returns the previous element in the double-linked list
    // If no element exists, then a new exception is thrown - taken from text 
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
    	
    	//return lastItemReturned.data; 

    }

    
    // Adds a new item between the item that will be returned through next and the item
    // that would be returned through previous. 
    public void add(E obj)
    {
    	
    	// First determine if the double linked list is empty - if so, it becomes the head 
    	if(head == null)
    	{
    		head = new Node<E>(obj);
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
public Object[] toArray() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public <T> T[] toArray(T[] a) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean add(E e) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean remove(Object o) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean containsAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean addAll(Collection<? extends E> c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean addAll(int index, Collection<? extends E> c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean removeAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean retainAll(Collection<?> c) {
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

@Override
public List<E> subList(int fromIndex, int toIndex) {
	// TODO Auto-generated method stub
	return null;
}
  
}// end of class DoubleLinkedList


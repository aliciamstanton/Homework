package edu.miracosta.cs113.HW5;

import java.util.*;
public class CircularArrayQueue<E> extends AbstractQueue<E> implements Queue<E> 
{
	
	// Data Members - Taken from Text Implementation
	
	// Front of the queue 
	private int front;
	
	// Index for the rear of the queue
	private int back;
	
	// Current size of the queue
	private int size;
	
	// Current capacity of the queue
	private int capacity;
	
	// Default Capacity for the queue
	private static final int DEFAULT_CAPACITY = 10;
	
	// Underlying array to hold the data 
	private E[] theData;
	
	
	
	// Default Constructor
	public CircularArrayQueue()
	{
		
		// Initialize using the default capacity
		this(DEFAULT_CAPACITY);
	}
	
	
	// Second Constructor - Can be used to implement the array with a specific capacity 
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int initialCapacity) 
	{
		// Redefine the capacity
		capacity = initialCapacity;
		
		// Assign the generic array to this capacity 
		theData = (E[]) new Object[capacity];
		
		// Define the front as index zero
		front = 0;
		
		// Define the rear as one minus the full capacity
		back = capacity - 1;
		
		// Define the initial size as zero (no elements)
		size = 0;	
		
	}
	
	// Will place an item at the back of the queue (insert essentially at the end of the underlying array)
	// Should always return true, according to text 

	@Override
	public boolean offer(E item) 
	{
		// First need to check that the array isn't already full 
		if(size == capacity)
		{
			reallocate();
		}
		
		// If the underlying array has room, then we can just add at the end as normal
		else
		{
			// Increment the size 
			size++;
			
			// Redefine the end of the array
			back = (back + 1) % capacity;
			
			// Assign the item being passed in to the back of the array based on its current size
			theData[back] = item;
			
		}
		
		
		return true;
	}
	
	// Method to increase the capacity of the circular array 
	
	@SuppressWarnings("unchecked")
	private void reallocate() 
	{
		// Define a new capacity that is double the current capacity
		int newCapacity = capacity * 2;
		
		// Create a second array, initialized to the new capacity
		E[] newData = (E[]) new Object[newCapacity];
		
		// Copy all the elements from the original array to the new (bigger) array 
		int j = front;
		
	
		for(int i = 0; i < this.size; i++)
		{
			// Copy element by element 
			newData[i] = theData[j];
			
			j = (j + 1) % capacity;
		}
		
		// Re-assign the front to zero 
		front = 0;
		
		// Re-assign the back to the new size of the array less 1
		back = this.size - 1;
		
		// Re-define the capacity
		capacity = newCapacity;
		
		// Re-assign the array 
		theData = newData;
		
	}

	
	// Method that removes entry at the front and returns it unless the entire array is empty 
	@Override
	public E poll() 
	{
		// If there is nothing in the array, i.e. the size is zero, then return null
		if(size == 0)
		{
			return null;
		}
		
			// Get the element at the front
			E result = theData[front];
			
			//theData[front] = null;
			
			// Re-define the front of the array 
			front = (front + 1) % capacity;
			
			// Decrement the size 
			this.size--;
			
			// Return the item that was removed from the array 
			return result;
		
		
		
	}

	
	// Returns the method at the front of the array, without removing it from the array 
	@Override
	public E peek() 
	{
		// If there is nothing in the array - then we should return null
		if(size == 0)
		{
		return null;
		}
		
		// Otherwise return the item that is currently at the front of the array (index zero)
		return theData[front];
	}

	// Required in order to fully implement the Queue Interface 
	@Override
	public Iterator<E> iterator() 
	{
		return new Iter();
	}


	@Override
	public int size() 
	{
		
		return this.size;
	}
	
	
	// Other methods that need to be implemented 
	
	// Inserts a specific element into the queue (can use offer) if possible 
	// If there is no space and the underlying array is at capacity then throw
	// an IllegalStateException 
	@Override
	public boolean add(E item)
	{
		
		// First check that the underlying array is not at capacity 
		if(size == capacity)
		{
			//throw new IllegalStateException();
			
			reallocate();
			return true;
			
		}
		
		// If there is room in the underlying array then we can use offer method 
		else
		{
			this.offer(item);
			
			// Return true to indicate that this addition was successful 
			return true;	
		}
		
	}
	



	// Retrieves an element but does not remove it from the head of the queue 
	// Should be able to use peek, since this does not remove the element from the array 
	public E element()
	{
		
		// Need to consider if the current array/queue is empty
		if(this.size() == 0)
		{
			throw new NoSuchElementException();
		}
		
		
		// Call the peek method to see if there is an item in the array 
		E elementToReturn = peek();
		
		// If so, return it, otherwise it will return null 
		return elementToReturn;
		
		
		
		
	}
	
	// Removes an element from the head of the queue
	
	public E remove()
	{
		
		// Need to consider if the array/queue is currently empty
		if(this.size() == 0)
		{
			throw new NoSuchElementException();
		}
		
		
		// Pick off an element from the array 
		E elementRemoved = this.poll();
		
		
		
		// Return it from this method 
		return elementRemoved; 
		
	}
	
	// As clarified in text - must implement the Iterator<E> interface in order to fully implement the Queue<E> interface 
	
	private class Iter implements Iterator<E>
	{
		
		// Data members for private inner class
		
		// Index of the next element
		private int index;
		
		// Counter for the number of elements accessed so far 
		private int counter = 0;
		
		// Create a constructor for the Iterator Interface
		public Iter()
		{
			index = front;
		}
		
		// Returns true if we are not at the end of the array/queue yet 
		@Override
		public boolean hasNext() 
		{
			return counter < size;
		}

		// Returns the next element in the array/queue as long as hasNext() does not return null 
		@Override
		public E next() 
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			
			// If there are more elements then we want to access them 
			E nextValue = theData[index];
			
			index = (index + 1) % capacity;
			
			// Increment the counter to indicate how many elements we have already accessed
			counter++;
			
			
			return nextValue;
		}
		
		
		// Method that would remove an item but is not supported using the queue 
		@Override 
		public void remove()
		{
			// Cannot remove unless it is from the front, throw new exception
			throw new UnsupportedOperationException();
			
		}
		
		
	} // End of inner Iterator<E> interface 

	

} // End of CircularArrayQueue Class 

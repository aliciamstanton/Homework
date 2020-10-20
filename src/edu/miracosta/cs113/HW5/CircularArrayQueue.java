package edu.miracosta.cs113.HW5;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;

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
		
		for(int i = 0; i < size; i++)
		{
			// Copy element by element 
			newData[i] = theData[j];
			
			j = (j + 1) % capacity;
		}
		
		// Re-assign the front to zero 
		front = 0;
		
		// Re-assign the back to the new size of the array less 1
		back = size - 1;
		
		// Re-define the capacity
		capacity = newCapacity;
		
		// Re-assign the array 
		theData = newData;
		
	}


	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}

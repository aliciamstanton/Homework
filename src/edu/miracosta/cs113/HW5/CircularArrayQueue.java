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

	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		return false;
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

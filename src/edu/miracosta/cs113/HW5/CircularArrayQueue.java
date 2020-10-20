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
	
	

	public CircularArrayQueue(int initialCapacity) 
	{
		// TODO Auto-generated constructor stub
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

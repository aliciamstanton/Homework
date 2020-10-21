package edu.miracosta.cs113.HW5;

// Import statement
import java.util.*;

public class ArrayListStack<E> implements StackInterface<E> 
{
	// Create an arrayList using generics to implement the stack 
	ArrayList<E> stack;
	
	
	// Constructor for the arrayList
	public ArrayListStack()
	{
		stack = new ArrayList<E>();
	}
	
	

    /**
     * Returns true if the stack is empty; otherwise, returns false
     *
     * @return true if empty, false otherwise
     */
    public boolean empty() 
    {
    	return false;
    	
    }
    	

    /**
     * Returns the object at the top of the stack without removing it
     *
     * @return reference (shallow copy) of object at top of stack
     */
    public E peek()
    {
    	
    	return null;
    	
    }

    /**
     * Returns the object at the top of the stack and removes it
     *
     * @return reference of removed object from top of stack
     */
    public E pop()
    {
    	
    	return null;
    	
    }

    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @param obj object to push onto top of stack
     * @return item that was pushed
     */
    public E push(E obj)
    {
    	
    	return null;
    	
    }
}

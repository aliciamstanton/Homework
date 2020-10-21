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
    	// If stack is empty return true 
    	if(stack.isEmpty())
    	{
    		return true;
    	}
    	
    	// If not empty then return false, i.e. there are elements in the arrayList
    	else 
    	{
    	
    	return false;
    	
    	}
    	
    }
    	

    /**
     * Returns the object at the top of the stack without removing it
     *
     * @return reference (shallow copy) of object at top of stack
     */
    public E peek()
    {
    	
    	if(stack.size() == 0)
    	{
    		return EmptyStackException();
    	}
    	
    	else
    	{
    	// ArrayList has a get method that we can use to retrieve the 
    	// first element without removing it or affecting the size - should work only 
    	// if the stack has elements in it to be returned 
    	return stack.get(0);
    	
    	}
    	
    }

    private E EmptyStackException() 
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
    	
    	// Grab the first element in the ArrayList
    	E firstItem = stack.get(0);
    	
    	// Then we want to remove it from the arrayList
    	stack.remove(firstItem);
    	
    	// Return the item that was removed from the arrayList 
    	
    	return firstItem;
    	
    }

    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @param obj object to push onto top of stack
     * @return item that was pushed
     */
    public E push(E obj)
    {
    	
    	// Want to emulate placing an item on top of the stack - which means that we need
    	// to add at the index zero 
    	stack.add(0, obj);
    	
    	// need to return the item that was placed on the top of the stack/front of the arrayList
    	return obj;
    		
    }
}

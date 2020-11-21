package edu.miracosta.cs113.HW7;


// Import statements - provided in slides
import java.io.*;



public class BinaryTree<E> implements Serializable 
{
	
	
	
	
	
	
	
	
	
	
	
	
	// Inner Node Class - Static 
	protected static class Node<E> implements Serializable 
	{
		// Protected generic data type 
		protected E data;
		
		// Protected Node(s) to represent left and right individually 
		protected Node<E> left;
		protected Node<E> right;
		
		
		// Constructor for Node<E>
		public Node(E data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
	} // End of Inner Node Class 

} // End of BinaryTree Class 

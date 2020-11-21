package edu.miracosta.cs113.HW7;


// Import statements - provided in slides
import java.io.*;



public class BinaryTree<E> implements Serializable 
{
	
	// Protected root node 
	protected Node<E> root;
	
	// No - Parameter Constructor 
	public BinaryTree()
	{
		
		// Set the root to nothing, indicating no items are in the tree
		// at this time 
		root = null;
	}
	
	// Second Constructor that builds tree with a given node at the root
	protected BinaryTree(Node<E> root)
	{
		this.root = root;
	}
	
	
	// Additional constructor that builds a tree from a data value and two trees
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
	{
		root = new Node<E>(data);
		
		if(leftTree != null)
		{
			root.left = leftTree.root;
		}
		else
		{
			root.left = null;
		}
		
		
		if(rightTree != null)
		{
			root.right = rightTree.root;
		}
		
		else
		{
			root.right = null;
		}
	}
	
	
	// Methods to get the LeftSubtree and RightSubtree 
	public BinaryTree<E> getLeftSubtree()
	{
		if(root != null && root.left != null)
		{
			return new BinaryTree<E>(root.left);
		}
		
		else
		{
			return null;
		}
	}
	
	public BinaryTree<E> getRightSubtree()
	{
		if(root != null && root.right != null)
		{
			return new BinaryTree<E>(root.right);
		}
		else
		{
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
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
		
		
		// To String Method
		public String toString()
		{
			return data.toString();
		}
		
	} // End of Inner Node Class 

} // End of BinaryTree Class 
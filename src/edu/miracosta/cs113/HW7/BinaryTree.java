package edu.miracosta.cs113.HW7;


// Import statements - provided in slides
import java.io.*;
import java.util.Scanner;



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
		// Create a new root 
		root = new Node<E>(data);
		
		// If the left node is not null 
		if(leftTree != null)
		{
			// Assign the left node of the root 
			root.left = leftTree.root;
		}
		
		// Otherwise, the left node of the root is null 
		else
		{
			root.left = null;
		}
		
		// If the right tree is not null 
		if(rightTree != null)
		{
			// Then assign the right node of the root 
			root.right = rightTree.root;
		}
		
		// Otherwise assign the right node to null 
		else
		{
			root.right = null;
		}
	}
	
	
	// Methods to get the LeftSubtree and RightSubtree 
	public BinaryTree<E> getLeftSubtree()
	{
		// If the root is not null and the left node of the root is not null 
		if(root != null && root.left != null)
		{
			// Then we can return the left subtree of the root 
			return new BinaryTree<E>(root.left);
		}
		
		// If it is null, then we must return null as there is no Left Subtree 
		else
		{
			return null;
		}
	}
	
	public BinaryTree<E> getRightSubtree()
	{
		// If the root is not null, and the right node of the root is not null 
		if(root != null && root.right != null)
		{
			// Then a right subtree exists and we should return it 
			return new BinaryTree<E>(root.right);
		}
		
		// Otherwise there is no right subtree and we should return null 
		else
		{
			return null;
		}
	}
	
	
	// Is Leaf Method
	public boolean isLeaf()
	{
		// Returns truee if the node has no children which means that its nodes are null 
		return (root.left == null && root.right == null);
	}
	
	// toSting method 
	public String toString()
	{
		// Create a string builder that will hold the string 
		StringBuilder sb = new StringBuilder();
		
		// traverse the entire tree from the root 
		preOrderTraverse(root, 1, sb);
		
		// Return the string representation 
		return sb.toString();
	}
	
	// PreOrderTraverse Method
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb)
	{
		// Iterate over the depth of the tree 
		for(int i = 1; i < depth; i++)
		{
			// Append a space between each node 
			sb.append(" ");
		}
		
		
		// If the node is null, then we append null to the string 
		if(node == null)
		{
			sb.append("null\n");
		}
		
		// Otherwise we should append the value with a new line between each
		// iterating deeper and deeper on the left and right sides of the tree 
		else
		{
			sb.append(node.toString() + "\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}
	
	
	// Method to read binaryTree
	public static BinaryTree<String> readBinaryTree(Scanner scan)
	{
		// Create a string and begin scanning the tree 
		String data = scan.next();
		
		// If the content is null 
		if(data.contentEquals("null"))
		{
			// Return that there is no data 
			return null;
		}
		
		// Otherwise 
		else
		{
			// Read the left subtree 
			BinaryTree<String> leftTree = readBinaryTree(scan);
			
			// Read the right subtree 
			BinaryTree<String> rightTree = readBinaryTree(scan);
			
			// Return a new binary tree representation of the left and right side 
			return new BinaryTree<String>(data, leftTree, rightTree);
		}
		
	}
	
	// Get Data Method - indicated by Unit Test 
	public E getData()
	{
		// Return the data within the current root 
		return this.root.data;
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

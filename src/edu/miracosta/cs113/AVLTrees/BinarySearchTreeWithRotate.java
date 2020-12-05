package edu.miracosta.cs113.AVLTrees;


// Class definition as described in the textbook 
public class BinarySearchTreeWithRotate<E extends Comparable<E>> extends BinarySearchTree<E> 
{
	
	// Rotate Right 
	protected Node<E> rotateRight(Node<E> root)
	{
		// Create a temporary node that will hold the value of the root on the left side 
		Node<E> temp = root.left;
		
		// Assign it to the right side of the temporary node 
		root.left = temp.right;
		
		// Re-assign the right side of the temp node to the root 
		temp.right = root;
		
		// Return the updated temp node 
		return temp;
	}
	
	// Rotate Left 
	protected Node<E> rotateLeft(Node<E> root)
	{
		// Create a temp node that will hold the value of the root on the right side 
		Node<E> temp = root.right;
		
		// Assign the right side to hold the data contained on the left 
		root.right = temp.left;
		
		// Re-assign the left side to the root 
		temp.left = root;
		
		// Return the updated temp node 
		return temp;
	}
	
	

}

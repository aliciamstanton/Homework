package edu.miracosta.cs113.AVLTrees;

public class BinarySearchTreeWithRotate<E extends Comparable<E>> extends BinarySearchTree<E> 
{
	
	// Rotate Right 
	protected Node<E> rotateRight(Node<E> root)
	{
		Node<E> temp = root.left;
		root.left = temp.right;
		temp.right = root;
		return temp;
	}
	
	// Rotate Left 
	protected Node<E> rotateLeft(Node<E> root)
	{
		Node<E> temp = root.right;
		root.right = temp.left;
		temp.left = root;
		return temp;
	}
	
	

}

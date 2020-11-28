package edu.miracosta.cs113.AVLTrees;

public class BinarySearchTreeWithRotate<E extends Comparable<E>> extends BinarySearchTree<E> 
{
	
	protected Node<E> rotateRight(Node<E> root)
	{
		Node<E> temp = root.left;
		root.left = temp.right;
		temp.right = root;
		return temp;
	}

}

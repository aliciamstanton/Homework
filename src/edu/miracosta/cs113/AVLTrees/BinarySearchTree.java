package edu.miracosta.cs113.AVLTrees;



// Implementation of the BinarySearchTree Class 
@SuppressWarnings("Serial")
public class BinarySearchTree< E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>
{
	protected boolean addReturn;
	protected E deleteReturn;
	
	
	
	@Override 
	public boolean add(E item)
	{
		root = add(root,item);
		return addReturn;
	}
	
	
	
	
	
	

}

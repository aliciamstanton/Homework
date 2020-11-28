package edu.miracosta.cs113.AVLTrees;



// Implementation of the BinarySearchTree Class 
@SuppressWarnings("Serial")
public class BinarySearchTree< E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>
{
	protected boolean addReturn;
	protected E deleteReturn;
	
	
	
	
	// Find Method 
	public E find(E target)
	{
		return find(root, target);
	}
	
	// Recursive find method 
	private E find(Node<E> localRoot, E target)
	{
		if(localRoot == null)
		{
			return null;
		}
		
		
		// Compare the target with the data field at the root 
		int compResult = target.compareTo(localRoot.data);
			
		if(compResult == 0)
		{
			return localRoot.data;
			
		}
		else if(compResult < 0)
		{
			return find(localRoot.left, target);
		}
		else
		{
			return find(localRoot.right, target);
		}
	
	}
	
	
	
	
	// Add method 
	public boolean add(E item)
	{
		root = add(root, item);
		return addReturn;
	}
	
	// Recursive Add Method 
	private Node<E> add(Node<E> localRoot, E item)
	{
		if(localRoot == null)
		{
			addReturn = true;
			return new Node<E>(item);
		}
		
		else if(item.compareTo(localRoot.data)== 0)
		{
			addReturn = false;
			return localRoot;
		}
		
		else if(item.compareTo(localRoot.data) < 0)
		{
			localRoot.left = add(localRoot.left, item);
			return localRoot;
		}
		
		else 
		{
			localRoot.right = add(localRoot.right, item);
			return localRoot;
		}
	}
	
	
	

}

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
	
	
	// Delete method 
	public E delete(E target)
	{
		root = delete(root, target);
		return deleteReturn;
	}
	
	// Recursive Delete Method
	private Node<E> delete(Node<E> localRoot, E item)
	{
		if(localRoot == null)
		{
			deleteReturn = null;
			return localRoot;
		}
		
		int compResult = item.compareTo(localRoot.data);
		if(compResult < 0)
		{
			localRoot.left = delete(localRoot.left, item);
			return localRoot;
		}
		else if(compResult > 0)
		{
			localRoot.right = delete(localRoot.right, item);
			return localRoot;
			
		}
		
		else 
		{
			deleteReturn = localRoot.data;
			if(localRoot.left == null)
			{
				return localRoot.right;
			}
			else if(localRoot.right == null)
			{
				
				return localRoot.left;
			
			}
			else 
			{
				if(localRoot.left.right == null)
				{
					localRoot.data = localRoot.left.data;
					localRoot.left = localRoot.left.left;
					return localRoot;
				}
				
				else 
				{
					localRoot.data = findLargestChild(localRoot.left);
					return localRoot;
				}
			}
		}	
		
	}
	
	// Find largestChild method 
	private E findLargestChild(Node<E> parent)
	{
		if(parent.right.right == null)
		{
			E returnValue = parent.right.data;
			parent.right = parent.right.left;
			return returnValue;
		}
		
		else
		{
			return findLargestChild(parent.right);
		}
	}
	
	

}

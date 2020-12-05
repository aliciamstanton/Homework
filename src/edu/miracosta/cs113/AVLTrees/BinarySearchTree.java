package edu.miracosta.cs113.AVLTrees;



// Implementation of the BinarySearchTree Class 
@SuppressWarnings("Serial")

// Class signature as recommended by the text 
public class BinarySearchTree< E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>
{
	// Protected instance members 
	protected boolean addReturn;
	protected E deleteReturn;
	
	
	
	
	// Find Method 
	public E find(E target)
	{
		// Starts from the root, looking for a specific target element 
		return find(root, target);
	}
	
	// Recursive find method 
	// Create a local root node, and a target to find - search separate portions of the 
	// tree until you find the target you're looking for.
	// Recursion will break down portions of the tree until the element 
	// can be found, or will return null if the item is not present in the tree 
	private E find(Node<E> localRoot, E target)
	{
		// If the local root has not been initialized, and contains no data
		if(localRoot == null)
		{
			// Then we have nothing to return and we can return null
			return null;
		}
		
		
		// Compare the target with the data field at the root 
		int compResult = target.compareTo(localRoot.data);
		
		
		// If compareTo returns zero, this is the data we are looking for 
		// and we should return the data. 
		if(compResult == 0)
		{
			return localRoot.data;
			
		}
		
		// If compareTo returns -1, then we want to look at the left side of the 
		// BinarySearchTree in hopes of finding our target. Call the find method 
		// on the left-half of the binarySearchTree 
		else if(compResult < 0)
		{
			return find(localRoot.left, target);
		}
		
		// If we have not found the data at the root, or through recursively 
		// checking the left side of the tree then we should check the right 
		// side of the tree 
		else
		{
			return find(localRoot.right, target);
		}
	
	}
	
	
	// Add method - returns true if the value was successfully inserted into the AVL Tree
	// Returns false if the value was not inserted into the AVL Tree 
	public boolean add(E item)
	{
		// Add the element at the root 
		root = add(root, item);
		return addReturn;
	}
	
	// Recursive Add Method 
	private Node<E> add(Node<E> localRoot, E item)
	{
		
		// If the root is null, then we can automatically return true and create 
		// a new node that will add the new item 
		if(localRoot == null)
		{
			addReturn = true;
			return new Node<E>(item);
		}
		
		// Otherwise we can make comparisons using the compareTo method 
		else if(item.compareTo(localRoot.data)== 0)
		{
			// If compareTo returns 0 then we won't be adding the item 
			// to the AVL tree, because it already exists in the tree 
			// at the localRoot 
			addReturn = false;
			return localRoot;
		}
		
		// If compareTo returns -1, then it would reside on the left-side 
		// of the AVL tree 
		else if(item.compareTo(localRoot.data) < 0)
		{
			// Add it to the left side of the local root and return the local root 
			localRoot.left = add(localRoot.left, item);
			return localRoot;
		}
		
		// If compareTo returns 1, then the itme will be added to the right of the 
		// local root node 
		else 
		{
			localRoot.right = add(localRoot.right, item);
			return localRoot;
		}
	}
	
	
	// Delete method 
	public E delete(E target)
	{
		// Returns the value that was deleted 
		root = delete(root, target);
		return deleteReturn;
	}
	
	// Recursive Delete Method
	private Node<E> delete(Node<E> localRoot, E item)
	{
		// If the root is null, then we are unable to return the item that was
		// deleted from the AVL tree 
		if(localRoot == null)
		{
			deleteReturn = null;
			return localRoot;
		}
		
		
		// otherwise we can try and find the element within the AVL tree 
		int compResult = item.compareTo(localRoot.data);
		
		// If compareTo returns -1, then the item would be found to
		// the left-side of the root node (left side of the binary search tree)
		if(compResult < 0)
		{
			// Delete the data on the left node of the root 
			localRoot.left = delete(localRoot.left, item);
			
			// return it 
			return localRoot;
		}
		
		// If comapreTo returns 1, then the item would be found on the right 
		// side of the binarySearchTree. 
		else if(compResult > 0)
		{
			// Grab the data on the right node of the root 
			localRoot.right = delete(localRoot.right, item);
			
			// return it 
			return localRoot;
			
		}
		
		
		// Otherwise we need to determine if there is data available 
		// to delete from the node 
		else 
		{
			deleteReturn = localRoot.data;
			// If the left side of the node is null
			// then we can return the right side of the node 
			if(localRoot.left == null)
			{
				return localRoot.right;
			}
			
			// If there is nothing in the right side of the node 
		    // Then we can return the left side of the node 
			else if(localRoot.right == null)
			{
				
				return localRoot.left;
			
			}
			
			// If both items are null then we move to the next node 
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
	
	// Find largestChild method - 
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

	@Override
	public boolean contains(E target) 
	{
		return (find(target) != null);
	}

	@Override
	public boolean remove(E target) 
	{
		return (delete(target) != null);
	}
	
	

}

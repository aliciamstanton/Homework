package edu.miracosta.cs113.AVLTrees;


// Class header provided from text 
public class AVLTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E> 
{
	// Value that will indicate whether we should increase the node weight 
	private boolean increase;
	
	
	
	// Method that will return true if the item is added to the AVL tree
	// or false if the item was not added to the AVL 
	@Override
	public boolean add(E item)
	{
		// Initialize the increase value to false 
		increase = false;
		
		// Create the root and add the item being passed in at the root 
		root = add((AVLNode<E>) root, item);
		return addReturn;
	}
	
	// Recursive add method 
	private AVLNode<E> add(AVLNode<E> localRoot, E item)
	{
		// If the root is null, then we can return true 
		// indicating that we can add this item to the AVL 
		if(localRoot == null)
		{
			addReturn = true;
			
			// We are then going to increase the weight of the AVL tree
			// through addition of the new node 
			increase = true;
			
			// Return the item at the new node 
			return new AVLNode<E>(item);
		}
		
		// If compareTo returns 0 then the item would belong around 
		// or is present at the current location 
		if(item.compareTo(localRoot.data)== 0) 
		{
			// Indicates that we are not increasing the weight of the AVL
			// and are not adding the item to the AVL Tree 
			increase = false;
			addReturn = false;
			return localRoot;
		}
		
		// If compareTo returns -1, then the value would need to be added
		// to the left of the current root 
		else if(item.compareTo(localRoot.data) < 0)
		{
			// Add the value in the left node of the root 
			localRoot.left = add((AVLNode<E>) localRoot.left, item);
			
			// If we had to increase the weight of the tree, then 
			// we need to decrement the balance of the root 
			// to make sure that the AVL tree stays in balance 
			if(increase)
			{
				decrementBalance(localRoot);
				
				// If the balance at the local root is not left heavy 
				// then we do not need to increase and can rebalance the
				// left side 
				if(localRoot.balance < AVLNode.LEFT_HEAVY) 
				{
					increase = false;
					return rebalanceLeft(localRoot);
					
				}
			}
		}
		
		
		// If compareTo returns 1, then the value would need to be added 
		// to the right of the current root 
		else if(item.compareTo(localRoot.data) > 0)
		{
			// Add the value in the right node of the root 
			localRoot.right = add((AVLNode<E>) localRoot.right, item);
			
			// If we had to increase the weight, then we would 
			// need to update the balance of the AVL 
			if(increase)
			{
				incrementBalance(localRoot);
				
				// If the root is now right heavy, then we need to rebalance the right 
				if(localRoot.balance > AVLNode.RIGHT_HEAVY)
				{
					increase = false;
					return rebalanceRight(localRoot);
				}
			}
		}
		
		return localRoot;
	}
	
	// Method for rebalanceLeft 
	private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot)
	{
		// Create a left-side child node using the left value of the root 
		AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
		
		// If the balance of the left child is heavy 
		if(leftChild.balance > AVLNode.BALANCED)
		{
			// Move to the right child of the left root node 
			AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
			
			// If this child is lighter, then we need to increment the weight of both
			// the root and the child 
			if(leftRightChild.balance < AVLNode.BALANCED)
			{
				incrementBalance(leftRightChild);
				incrementBalance(localRoot);
			}
			
			// If the child node is heavier than balanced we need to decrement 
			// both the nodes 
			else if(leftRightChild.balance > AVLNode.BALANCED)
			{
				decrementBalance(leftRightChild);
				decrementBalance(leftChild);
			}
			
			// Decrement the balance again and rotate to the left 
			decrementBalance(leftChild);
			localRoot.left = rotateLeft(localRoot.left);
			incrementBalance(localRoot);
			incrementBalance(localRoot);
			
			// Return after rotation around the right node of the local root 
			return (AVLNode<E>) rotateRight(localRoot);
		}
		
		// Otherwise, we need to increment the left child and the root 
		else 
		{
			incrementBalance(leftChild);
			incrementBalance(localRoot);
			incrementBalance(localRoot);
			
			// Return a rotation around the right local Root 
			return (AVLNode<E>) rotateRight(localRoot);
		}
	}
	
	
	
	// Method for rebalanceRight 
	private AVLNode<E> rebalanceRight(AVLNode<E> localRoot)
	{
		// Create a node that will hold the right child node of the root 
		AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;
		
		// If the right child node has a weight higher than balanced 
		if(rightChild.balance > AVLNode.BALANCED)
		{
			// Decrement the weight in this node and the root 
			decrementBalance(rightChild);
			decrementBalance(localRoot);
			decrementBalance(localRoot);
			
			// Return once a rotation around the left has been complete 
			return (AVLNode<E>) rotateLeft(localRoot);
		}
		
		
		// Otherwise create a new node that holds the child node (left) of the right 
		// child node of the root - 2 levels down 
		else 
		{
			AVLNode<E> rightLeft = (AVLNode<E>) localRoot.right.left;
			incrementBalance((AVLNode<E>) localRoot.right);
			
			// If this child node is lower than balanced, then 
			// we need to increment this node and the parent node 
			if(rightLeft.balance < AVLNode.BALANCED)
			{
				incrementBalance(rightChild);
				incrementBalance((AVLNode<E>) rightChild.left);
				
			}
			
			// Otherwise, if it is heavier then we need to decrement
			// the root and this child node 
			else if(rightLeft.balance > AVLNode.BALANCED)
			{
				decrementBalance(localRoot);
				decrementBalance((AVLNode<E>) rightChild.left);
			}
			
			// Rotoate around the right node of the root 
			localRoot.right = rotateRight(localRoot.right);
			
			// Decrement the value at the localRoot
			decrementBalance(localRoot);
			decrementBalance(localRoot);
			
			
			// Return after a rotation around the left child node of the root 
			return (AVLNode<E>) rotateLeft(localRoot);
			
		}	
		
	}

	
	// Method for decrementBalance
	private void decrementBalance(AVLNode<E> node)
	{
		// Decrements the weight of the node being referenced 
		node.balance--;
		
		// If the value is now balanced, then no further action is taken 
		if(node.balance == AVLNode.BALANCED)
		{
			increase = false;
		}
	}
	
	
	// Method for incrementBalance
	
	private void incrementBalance(AVLNode<E> node)
	{
		// increment the weight of the node being referenced 
		node.balance++;
		
		// If the node is now balanced, no further action is required 
		if(node.balance == AVLNode.BALANCED)
		{
			increase = false;
		}
	}
	
	
	
	
	
	
	
	
	
		
	
	// Nested InnerClass for AVLNode<E>
	private static class AVLNode<E> extends Node<E>
	{
		
		public static final int LEFT_HEAVY = -1;
		public static final int BALANCED = 0;
		public static final int RIGHT_HEAVY = 1;
		
		private int balance;
		
		public AVLNode(E item)
		{
			super(item);
			balance = BALANCED;
		}
		
		@Override
		public String toString()
		{
			return balance + ": " + super.toString();
		}	
		
	}
}

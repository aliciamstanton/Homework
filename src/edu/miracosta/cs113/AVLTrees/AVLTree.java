package edu.miracosta.cs113.AVLTrees;

public class AVLTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E> 
{
	private boolean increase;
	
	
	@Override
	public boolean add(E item)
	{
		increase = false;
		root = add((AVLNode<E>) root, item);
		return addReturn;
	}
	
	// Recursive add method 
	private AVLNode<E> add(AVLNode<E> localRoot, E item)
	{
		if(localRoot == null)
		{
			addReturn = true;
			increase = true;
			return new AVLNode<E>(item);
		}
		
		if(item.compareTo(localRoot.data)== 0) 
		{
			increase = false;
			addReturn = false;
			return localRoot;
		}
		
		else if(item.compareTo(localRoot.data) < 0)
		{
			localRoot.left = add((AVLNode<E>) localRoot.left, item);
			
			if(increase)
			{
				decrementBalance(localRoot);
				if(localRoot.balance < AVLNode.LEFT_HEAVY) 
				{
					increase = false;
					return rebalanceLeft(localRoot);
					
				}
			}
		}
		
		else if(item.compareTo(localRoot.data) > 0)
		{
			localRoot.right = add((AVLNode<E>) localRoot.right, item);
			
			if(increase)
			{
				incrementBalance(localRoot);
				if(localRoot.balance > AVLNode.RIGHT_HEAVY)
				{
					increase = false;
					return rebalanceRight(localRoot);
				}
			}
		}
		
		return localRoot;
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

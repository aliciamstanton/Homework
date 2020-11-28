package edu.miracosta.cs113.AVLTrees;

public class AVLTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E> 
{
	private boolean increase;
	
	
		
	
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

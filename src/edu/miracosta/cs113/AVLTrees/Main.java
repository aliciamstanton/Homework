package edu.miracosta.cs113.AVLTrees;


// Import statements to ensure that we can generate random numbers
// to place in the BinarySearchTree and the AVLTree
import java.util.Random;
import java.util.*;




// Driver program for the AVL Tree 
public class Main 
{
	public static void main(String[] args)
	{
	
	// Create a binarySearchTree - integer values 
	BinarySearchTree<Integer> newSearchTree = new BinarySearchTree<Integer>();
	
	// Create an AVL Tree of Integers
	AVLTree<Integer> newAVLTree = new AVLTree<Integer>();
	
	// Create a new random object 
	Random randomNumber = new Random();
	
	// Create an array of integers to hold the random numbers we've generated 
	// This array holds 20 random numbers 
	int[] randomValues = new int[20];
	
	
	// Populate the array with 20 random numbers between 0 and 499
	for(int i = 0; i < randomValues.length; i++)
	{
		// Choose the next int and put it at the next available index in the 
		// random values array 
		randomValues[i] = randomNumber.nextInt(500);
		
	}
	
	// Add these items to the search tree
	for(int i = 0; i < randomValues.length; i++)
	{
		// Call the add method and put this in a new node of the binarySearchTree 
		newSearchTree.add(randomValues[i]);
	}
	
	// Add the items to the AVL Tree
	for(int i = 0; i < randomValues.length; i++)
	{
		// Call the add method and put this in a new node of the AVLTree 
		newAVLTree.add(randomValues[i]);
	}
	
	// Call the toString for each 
	System.out.println(newSearchTree.toString());
	
	System.out.println(newAVLTree.toString());
	
	}
}
	
	


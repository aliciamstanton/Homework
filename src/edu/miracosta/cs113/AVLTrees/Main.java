package edu.miracosta.cs113.AVLTrees;

import java.util.Random;

import java.util.*;
// Driver program for the AVL Tree 
public class Main 
{
	public static void main(String[] args)
	{
	
	// Create a binarySearchTree 
	BinarySearchTree<Integer> newSearchTree = new BinarySearchTree<Integer>();
	
	// Create an AVL Tree of Integers
	AVLTree<Integer> newAVLTree = new AVLTree<Integer>();
	
	// Create a new random object 
	Random randomNumber = new Random();
	
	// Create an array of integers to hold the random numbers we've generated 
	int[] randomValues = new int[20];
	
	
	// Populate the array with 20 random numbers between 0 and 499
	for(int i = 0; i < randomValues.length; i++)
	{
		
		randomValues[i] = randomNumber.nextInt(500);
		
	}
	
	// Add these items to the search tree
	for(int i = 0; i < randomValues.length; i++)
	{
		newSearchTree.add(randomValues[i]);
	}
	
	// Add the items to the AVL Tree
	for(int i = 0; i < randomValues.length; i++)
	{
		newAVLTree.add(randomValues[i]);
	}
	
	// Call the toString for each 
	System.out.println(newSearchTree.toString());
	
	System.out.println(newAVLTree.toString());
	
	}
}
	
	


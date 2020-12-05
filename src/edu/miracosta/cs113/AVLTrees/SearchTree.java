package edu.miracosta.cs113.AVLTrees;


// Interface for a SearchTree - Generic Type 
public interface SearchTree<E> 
{
	
	// Add - Inserts item where it belongs in the tree. Return true if inserted
	// Returns false if it is not 
	public boolean add(E item);
	
	// Scans the SearchTree for a target value, returns true if found in the tree
	// otherwise returns false if not 
	public boolean contains(E target);
	
	// Returns a reference to the data in the node that is equal to the target 
	// Will return null if the data is not found in a node 
	public E find(E target);
	
	// Finds a target value and deletes from the search tree. Returns null if not 
	// found. 
	public E delete(E target);
	
	// Returns true if target value has been removed from tree, false otherwise.
	// This does NOT return the value that was removed if true is returned 
	public boolean remove(E target);

}

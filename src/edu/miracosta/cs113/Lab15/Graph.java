
// Indicates that this can be found in the Lab15 package
package edu.miracosta.cs113.Lab15;

import java.util.*;

public class Graph 
{
	// Create a matrix that will hold boolean values 
	boolean adjacencyMatrix[][];
	
	// Int to hold the number of vertices
	int numberOfVertices;
	
	// Constructor
	public Graph(int numberOfVertices)
	{
		this.numberOfVertices = numberOfVertices;
		adjacencyMatrix = new boolean[numberOfVertices][numberOfVertices];
	}
	
	// Method to add edges to matrix 
	public void addEdge(int indexOne, int indexTwo)
	{
		adjacencyMatrix[indexOne][indexTwo] = true;
		adjacencyMatrix[indexTwo][indexOne] = true;
	}
	
	// Method to remove edges 
	public void removeEdge(int indexOne, int indexTwo)
	{
		adjacencyMatrix[indexOne][indexTwo] = false;
		adjacencyMatrix[indexTwo][indexOne] = false;
	}
	
	
	// Method to print the matrix
	public String toString()
	{
		StringBuilder matrix = new StringBuilder();
		
		for(int i = 0; i < numberOfVertices; i++)
		{
			matrix.append(i + ": ");
			for(boolean j : adjacencyMatrix[i])
			{
				matrix.append((j? 1: 0) + " ");
			}
			matrix.append("\n");
		}
		
		return matrix.toString();
	}
	
// End of Class Definition - Driver Below 



// Driver 
public static void main(String args[])
{
	// Create a graph
	Graph newGraph = new Graph(5);
	
	// Add each of the edges
	newGraph.addEdge(0, 1);
	newGraph.addEdge(0, 2);
	newGraph.addEdge(1, 2);
	newGraph.addEdge(2, 0);
	newGraph.addEdge(2, 3);
	
	
}

}

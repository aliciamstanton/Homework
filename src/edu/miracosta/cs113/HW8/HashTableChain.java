package edu.miracosta.cs113.HW8;

import java.util.*;

// Creating a class called HashTableChain 
public class HashTableChain<K, V> implements Map<K,V>
{
	
	// Generating the table 
	private LinkedList<Entry<K,V>>[] table;
	
	// Number of keys 
	private int numKeys;
	
	// Capacity
	private static final int CAPACITY = 101;
	
	// Maximum load factor
	private static final double LOAD_THRESHOLD = 3.0;
	
	
	
	// Inner Class Entry - from Text 
	private static class Entry<K,V> 
	{
		
		// Key and Value
		private K key;
		private V value;
		
		// Create a new Key Value Pair
		public Entry(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		
		// Method to retrieve key
		public K getKey()
		{
			return this.key;
		}
		
		// Method to retrieve value
		public V getValue()
		{
			return this.value;
		}
		
		// Method to set the value
		public V setValue(V val)
		{
			V oldVal = value;
			value = val;
			return oldVal;
		}
			
	}
	
	
	
	
	// Constructor
	public HashTableChain()
	{
		table = new LinkedList[CAPACITY];
	}
	
	// Get Method
	@Override
	public V get(Object key)
	{
		int index = key.hashCode() % table.length;
		if(index < 0)
		{
			index += table.length;
		}
		
		if(table[index] == null)
		{
			return null;
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	

}

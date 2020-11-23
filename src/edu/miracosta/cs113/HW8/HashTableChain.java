package edu.miracosta.cs113.HW8;

import java.util.*;

// Creating a class called HashTableChain 
public class HashTableChain<K, V> implements Map<K,V>
{
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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

}

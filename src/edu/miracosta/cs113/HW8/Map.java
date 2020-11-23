package edu.miracosta.cs113.HW8;

import java.util.Set;

// Class that holds the Map interface
public interface Map<K, V> 
{
	// Must implement entire interface except for putAll() and values() methods 

	// Method stubs from Oracle ------

	public interface Entry<K, V> 
	{
				
		// Method to retrieve key
		public K getKey();
		
				
		// Method to retrieve value
		public V getValue();
			
				
		// Method to set the value
		public V setValue(V val);
				

	}

	// Clear Method 
	public void clear();
	
	
	// Contains Key
	public boolean containsKey(Object key);
	
	// Contains Value Method
	public boolean containsValue(Object value);
	
	// Entry Set method 
	public Set<Map.Entry<K,V>> entrySet();
	
	// Equals Method
	public boolean equals(Object o);
	
	// Get Method 
	public V get(Object key);
	
	// HashCode Method
	public int hashCode();
	
	// IsEmpty Method
	public boolean isEmpty();
	
	// KeySet method
	public Set<K> keySet();
	
	// Put method
	public V put(K key, V value);
	
	// Remove Method
	public V remove(Object key);
	
	// Size Method
	public int size();


}

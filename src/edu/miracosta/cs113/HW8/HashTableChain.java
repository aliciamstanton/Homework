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
	
	
	
	
	
	
	// Constructor - using the capacity of 101 listed above 
	public HashTableChain()
	{
		table = new LinkedList[CAPACITY];
	}
	
	
	
	
	@Override 
	public int hashCode()
	{
		// Create a new hashtable called test with a Key and Value not yet specified 
		Hashtable<K,V> test = new Hashtable<>();
		
		// Iterate over the length of the table 
		for(int i = 0; i < table.length; i++)
		{
			// If the key/value at that given index is null, then continue to the next item in the hashtable 
			if(table[i] == null)
			{
				// Do Nothing 
			}
			
			// Otherwise, we need to add values to the hashtable at each entry 
			else 
			{
				for(Entry<K,V> nextItem : table[i])
				{
					// 	If the next item is not null, then put a new key value pair 
					if(nextItem != null)
					{
						test.put(nextItem.key, nextItem.value);
					}
				}
			}
		}
		
		// Once complete, return the hashcode 
		return test.hashCode();
	}
	
	
	
	
	// Get Method
	@Override
	public V get(Object key)
	{
		// Determine the specific index using the unique key and the remainder of the table length 
		int index = key.hashCode() % table.length;
		
		// If the remainder (index) is less than zero then update the index by the length of the table 
		if(index < 0)
		{
			index += table.length;
		}
		
		// If the value at that index is null, then return null 
		if(table[index] == null)
		{
			return null;
		}
		
		// For every entry (key/value pair in the table at that index
		for(Entry<K,V> nextItem : table[index])
		{
			// Return the value at the key entered in as a parameter for this method 
			if(nextItem.key.equals(key))
			{
				return nextItem.value;
			}
		}
		
		// If the key we are looking to get does not match any currently in the Hashtable,
		// then return null. We have found no values that correspond to that key 
		return null;
	}
	
	// Put Method 
	@Override 
	public V put(K key, V value)
	{
		// Determine the index where we want to enter a new key/value pair 
		int index = key.hashCode() % table.length;
		
		// If the index is less than zero, then add the length of the table to update the index 
		if(index < 0)
		{
			index += table.length;
		}
		
		// If the current key/value at this index is null
		if(table[index] == null)
		{
			// Create a new LinkedList at table[index]
			table[index] = new LinkedList<Entry<K, V>>();
		}
		
		// Range-based for loop that will iterate over each key/value pair 
		for(Entry<K,V> nextItem : table[index])
		{
			// If the key specified as a parameter matches one already in the table then we want to update the 
			// value at this entry 
			if(nextItem.key.equals(key))
			{
				// Grab the old value at this item 
				V oldVal = nextItem.value;
				
				// Reset the value with the new value (passed as a parameter)
				nextItem.setValue(value);
				
				// Return the old value to the user 
				return oldVal;
			}
			
		}
		
		
		table[index].addFirst(new Entry<K,V>(key,value));
		
		// Update the number of keys in the hashtable 
		numKeys++;
		
		// If there are too many keys for the table, then we rehash the table 
		if(numKeys > (LOAD_THRESHOLD * table.length))
		{
			rehash();
		}
		
		// Otherwise return null 
		return null;
		
		
	}
	
	// Provide implementation for Size 
	public int size()
	{
		// Return the number of keys for this hashtable 
		return this.numKeys;
	}
	
	
	// Returns a set view of the underlying hash table (its key/value pairs) by returning 
	// an instance of the inner class EntrySet 
	@Override 
	public Set<Map.Entry<K, V>> entrySet()
	{
		return new EntrySet();
	}
	
	
	
	
	// Makes a set of keys for the hashtable 
	@Override 
	public Set<K> keySet()
	{
		// Create a new set of keys called keySet, using the inner class HashSet 
		Set<K> keySet = new HashSet<K>(size());
		
		// For each Entry of the linkedList 
		for(LinkedList<Entry<K,V>> list : table)
		{
			// If the list entry is not null 
			if(list != null)
			{
				// Then for each entry in the list 
				for(Entry<K,V> entry : list)
				{
					// If not null, add the value and get the key 
					if(entry != null)
					{
						keySet.add(entry.getKey());
					}
				}
			}
		}
		
		// Return the set of keys 
		return keySet;
	}
	
	
	
	// Method that checks to see if the value is contained in the hashtable 
	@Override 
	public boolean containsValue(Object value)
	{
		// Iterate over the length of the table 
		for(int i = 0; i < table.length; i++)
		{
			// If the index at the table is null, then we do nothing 
			if(table[i] == null)
			{
				// Skip
			}
			
			// Otherwise, use a range based for loop and iterate over each entry in the hashtable 
			else
			{
				for(Entry<K,V> nextItem : table[i])
				{
					// If the value of the current entry is the value we are looking for 
					if(nextItem.getValue().equals(value))
					{
						// return true 
						return true;
					}
				}
			}
		}
		
		// Otherwise, return false - indicating that we haven't found the value in the hashtable 
		return false;
	}
	
	
	
	// Clear method 
	@Override
	public void clear()
	{
		// Iterate over the length of the hashtable 
		for(int i = 0; i < table.length; i++)
		{
			// Set all the items to null 
			table[i] = null;
		}
		
		// Indicate that there are no keys in the table after clear has been done 
		numKeys = 0;
	}
	
	
	
	@Override 
	public boolean containsKey(Object key)
	{
		// Create an index and use the length of the table to find it 
		int index = key.hashCode() % table.length;
		
		// If the index is less than zero, then add the length of the table 
		if(index < 0)
		{
			index += table.length;
		}
		
		// If the value at the specific index is null 
		if(table[index] == null)
		{
			// return false, indicating that we didn't find the key at this index 
			return false;
		}
		
		// Iterate over each entry in the table 
		for(Entry<K,V> entry : table[index])
		{
			// Get the key and see if its the one we are looking for 
			if(entry.getKey().equals(key))
			{
				// If so, return true 
				return true;
			}
		}
		
		// Otherwise return false 
		return false;
	}
	
	
	// Re-hash method 
	private void rehash()
	{
		// Create a linkedList that will hold all the old entries of the hashtable 
		LinkedList<Entry<K,V>>[] oldTable = table;
		
		// Make sure that the new table has enough space to accomodate new keys 
		table = new LinkedList[oldTable.length * 2 + 1];
		
		// Set the number of keys to zero 
		numKeys = 0;
		
		// For each entry in the old table 
		for(LinkedList<Entry<K,V>> list : oldTable)
		{
			// If it is not null 
			if(list != null)
			{
				// Then place it into the new table by getting the key and the value 
				for(Entry<K,V> entry : list)
				{
					put(entry.getKey(), entry.getValue());
				}
			}
		}
	}
	
	
	// Remove method 
	@Override 
	public V remove(Object key)
	{
		// Create an index using the hashcode and the length of the table 
		int index = key.hashCode() % table.length;
		
		// If the index of the table is less than zero, then we add the length of the table 
		if(index < 0)
		{
			index += table.length;
		}
		
		// If the current index is null, then we cannot remove anything and should return null 
		if(table[index] == null)
		{
			return null;
		}
		
		// Otherwise, iterate over each entry in the table 
		for(Entry<K,V> entry : table[index])
		{
			// If the key at this entry is the key we are looking for 
			if(entry.getKey().equals(key))
			{
				// Grab the value associated with that key 
				V value = entry.getValue();
				// Remove the entry 
				table[index].remove(entry);
				// Decrement the number of keys 
				numKeys--;
				
				
				// If the table is empty, then there is no key to remove 
				if(table[index].isEmpty())
				{
					// Indicate that this entry is null 
					table[index] = null;
				}
				
				// Return the value 
				return value;
				}
		}
		
		// or return null 
		return null;
		
	}
	
	
	
	//Is Empty method 
	@Override 
	public boolean isEmpty()
	{
		return numKeys == 0;
	}
	
	// ToString method 
	@Override 
	public String toString()
	{
		String toReturn = "";
		
		for(int i = 0; i < table.length; i++)
		{
			if(table[i] == null)
			{
				// Skip
			}
			
			else 
			{
				for(Entry<K,V> nextItem : table[i])
				{
					toReturn += nextItem.getValue() + "\n";
				}
			}
		}
		
		return toReturn;
	}
	
	
	// Equals method 
	@Override 
	public boolean equals(Object obj)
	{
		if(obj == this)
		{
			return true;
		}
		
		if(obj == null)
		{
			return false;
		}
		
		// Typecast
		Hashtable newHash = (Hashtable) obj;
		
		if(newHash.equals(this))
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
	
	
	

	// ****** Additional Inner Classes Below this were provided in the text *********
	
	
	// Additional Inner Class - Provided in Text 
	private class EntrySet extends AbstractSet<Map.Entry<K,V>>
	{
		@Override
		public int size()
		{
			return numKeys;
		}
		
		@Override 
		public Iterator<Map.Entry<K, V>> iterator()
		{
			return new SetIterator();
		}
	}
	
	
	// Additional Inner Class for SetIterator 
	private class SetIterator implements Iterator<Map.Entry<K, V>>
	{
		
		int index = 0;
		Iterator<Entry<K,V>> newIterator = null;
		
		Entry<K,V> lastItem =  null;
		
		/*
		
		public Set<Entry<K,V>> entrySet()
		{
			return new EntrySet();
		} */
		
		@Override 
		public boolean hasNext()
		{
			if(newIterator != null)
			{
				if(newIterator.hasNext()) 
				{
					return true;
				}
				
				else 
				{
					newIterator = null;
					index++;
				}
			}
			
			while(index < table.length && table[index] == null)
			{
				index++;
			}
			
			if(index == table.length)
			{
				return false;
			}
			
			newIterator = table[index].iterator();
			return newIterator.hasNext();
		}
		
		
		// Next Method
		@Override 
		public Entry<K,V> next()
		{
			lastItem = newIterator.next();
			return lastItem;
		}
		
		
		// Remove method
		@Override
		public void remove()
		{
			newIterator.remove();
			lastItem = null;
		}	
		
	}
	
	
	// Inner Class Entry - from Text 
		private static class Entry<K,V> implements Map.Entry<K,V>
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

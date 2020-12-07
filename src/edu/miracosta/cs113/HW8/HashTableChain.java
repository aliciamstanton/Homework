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
		
		return test.hashCode();
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
		
		for(Entry<K,V> nextItem : table[index])
		{
			if(nextItem.key.equals(key))
			{
				return nextItem.value;
			}
		}
		
		return null;
	}
	
	// Put Method 
	@Override 
	public V put(K key, V value)
	{
		int index = key.hashCode() % table.length;
		if(index < 0)
		{
			index += table.length;
		}
		
		if(table[index] == null)
		{
			// Create a new LinkedList at table[index]
			table[index] = new LinkedList<Entry<K, V>>();
		}
		
		for(Entry<K,V> nextItem : table[index])
		{
			if(nextItem.key.equals(key))
			{
				V oldVal = nextItem.value;
				nextItem.setValue(value);
				return oldVal;
			}
			
		}
		
		table[index].addFirst(new Entry<K,V>(key,value));
		numKeys++;
		if(numKeys > (LOAD_THRESHOLD * table.length))
		{
			rehash();
		}
		
		return null;
		
		
	}
	
	// Provide implementation for Size 
	public int size()
	{
		return this.numKeys;
	}
	
	
	@Override 
	public Set<Map.Entry<K, V>> entrySet()
	{
		return new EntrySet();
	}
	
	
	
	@Override 
	public Set<K> keySet()
	{
		Set<K> keySet = new HashSet<K>(size());
		
		for(LinkedList<Entry<K,V>> list : table)
		{
			if(list != null)
			{
				for(Entry<K,V> entry : list)
				{
					if(entry != null)
					{
						keySet.add(entry.getKey());
					}
				}
			}
		}
		
		return keySet;
	}
	
	
	
	@Override 
	public boolean containsValue(Object value)
	{
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
					if(nextItem.getValue().equals(value))
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	
	
	// Clear method 
	@Override
	public void clear()
	{
		for(int i = 0; i < table.length; i++)
		{
			table[i] = null;
		}
		
		numKeys = 0;
	}
	
	
	
	@Override 
	public boolean containsKey(Object key)
	{
		int index = key.hashCode() % table.length;
		
		if(index < 0)
		{
			index += table.length;
		}
		
		if(table[index] == null)
		{
			return false;
		}
		
		for(Entry<K,V> entry : table[index])
		{
			if(entry.getKey().equals(key))
			{
				return true;
			}
		}
		
		return false;
	}
	
	
	// Re-hash method 
	private void rehash()
	{
		LinkedList<Entry<K,V>>[] oldTable = table;
		
		table = new LinkedList[oldTable.length * 2 + 1];
		numKeys = 0;
		
		for(LinkedList<Entry<K,V>> list : oldTable)
		{
			if(list != null)
			{
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
		int index = key.hashCode() % table.length;
		
		if(index < 0)
		{
			index += table.length;
		}
		
		if(table[index] == null)
		{
			return null;
		}
		
		for(Entry<K,V> entry : table[index])
		{
			if(entry.getKey().equals(key))
			{
				V value = entry.getValue();
				table[index].remove(entry);
				numKeys--;
				
				if(table[index].isEmpty())
				{
					
					table[index] = null;
				}
				
				return value;
				}
		}
		
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


class LinearHashTable<K, V> extends HashTableBase<K, V>


{
	// make an object from HashItem class
	HashItem new_One;
	
	//determines whether or not we need to resize
	//to turn off resize, just always return false
    protected boolean needsResize()
    {
    	//linear probing seems to get worse after a load factor of about 70%
		if (_number_of_elements > (0.7 * _primes[_local_prime_index]))
		{
			return true;
		}
		return false;
    }
    
    //called to check to see if we need to resize
    protected void resizeCheck()
    {
    	//Right now, resize when load factor > .7; it might be worth it to experiment with 
		//this value for different kinds of hashtables
		if (needsResize())
		{
			_local_prime_index++;

			HasherBase<K> hasher = _hasher;
			LinearHashTable<K, V> new_hash = new LinearHashTable<K, V>(hasher, _primes[_local_prime_index]);
			
			for (HashItem<K, V> item: _items)
			{
				if (item.isEmpty() == false)
				{
					//add to new hash table
					new_hash.addElement(item.getKey(), item.getValue());
				}
			}
			
			_items = new_hash._items;
		}
    }
    
    public LinearHashTable()
    {
    	super();
    }
    
    public LinearHashTable(HasherBase<K> hasher)
    {
    	super(hasher);
    }
    
    public LinearHashTable(HasherBase<K> hasher, int number_of_elements)
    {
    	super(hasher, number_of_elements);
    }
    
    //copy constructor
    public LinearHashTable(LinearHashTable<K, V> other)
    {
    	super(other);
    }
    
    //concrete implementation for parent's addElement method
    
    
    
    
     
	
    
    public void addElement(K key, V value)
    {
    	//check for size restrictions
    	resizeCheck();
    	
    	//calculate initial hash based on key
    	int hash = super.getHash(key);
    	
    	//MA #1 TODO: 
    	
    	// containselement(key) is used to determine whether or not a specific key is mapped into the hash map.
    	if (containsElement(key)) {
    		//find empty slot to insert (update hash variable as necessary)
    		
    		new_One=new HashItem(key, value, false);
    		_items.set(hash, new_One);
    		return;
    			
    	}
    	while (hash<_items.size()) {
    		
    		// if the slot is empty, add new hashitem to slot
    		if(_items.elementAt(hash).isEmpty()){
    			
    			new_One=new HashItem(key, value, false);
    			_items.set(hash, new_One);
    			_number_of_elements++;
    			return;
    			
    		}
    		//try the next index
    		else
    			hash=(hash+1)%_items.size();
    		_number_of_elements++;
    		
    	}
    	
    	
    	//remember how many things we are presently storing
    	//Hint: do we always increase the size whenever this function is called?
    	
    }
    
    //removes supplied key from hash table
    public void removeElement(K key)
    {
    	//calculate hash
    	int hash = super.getHash(key);
    	
    	//MA #1 TODO: find slot to remove. Remember to check for infinite loop!
    	//ALSO: Use lazy deletion.

    	
    
 
    	// look for the key, if the key was not at the original hash
    	int i=0; //create i=0;
    	while(_items.elementAt(hash).getKey()!=key) {

    	
    	if (_items.elementAt(hash).isTrueEmpty()) {
    		System.out.println("element is not in the hash table");
    	}	
    
    			hash=(hash+1)%_items.size(); //go to the next slot
        		i++;
        		
    		
    	}
    	
    	//if the item is not empty, make it empty
    	
    	_items.elementAt(hash).setIsEmpty(true);
    		_number_of_elements--; 
    	}
    	
    
    	
    	
 
    
    //returns true if the key is contained in the hash table
    public boolean containsElement(K key)
    {
    	int hash = super.getHash(key);
    	HashItem<K, V> slot = _items.elementAt(hash);
    	
    	//left incomplete to avoid hints :)
    	return false;
    }
    
    //returns the item pointed to by key
    public V getElement(K key)
    {
    	int hash = super.getHash(key);
    	HashItem<K, V> slot = _items.elementAt(hash);
    	
    	//left incomplete to avoid hints :)
    	return null;
    }
}
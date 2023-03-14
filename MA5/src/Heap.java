import java.util.Map;

public class Heap<T extends Comparable<T>> extends Queue<T> 
{
	
	private Vector<T> _items = new Vector<>(10);
	
	private void buildHeap()
	{
		for (int i = _items.getSize() / 2 - 1; i >= 0; i --)
		{
			adjustHeap(i);
		}
	}
	
	//MA #5 TODO: Implement!
	//Percolates the item specified at by index down into its proper location within a heap.
	//Used for dequeue operations and array to heap conversions
	private void adjustHeap(int index)
	
	
	
	{
		//left child
		int left = 2*index + 1;
		//right child
		 int right = 2*index + 2;
		 //get the size
		 int size = _items.getSize();
		 
		 
		 //get elements if they exist
		 T current = null;
		 T left_child = null;
		 T right_child = null;
		 if (index < size)
		 {
		  current = _items.getElementAt(index);
		 }
		 if (left < size)
		 {
		  left_child = _items.getElementAt(left);
		 }
		 if (right < size)
		 {
		  right_child = _items.getElementAt(right);
		 }
		 
		 if (current != null)
		 {
		  //find the smallest child
		  int smallest = index;
		  
		  
		
		  //if the left child is less than the element in the index, set index to the left
		  
		  
		  if (left_child != null && left_child.compareTo(current) < 0)
		  {
		   smallest = left;
		  }
		  
		  //if the right child is less than the element in the index and right child is less than left child set index to the right
		  
		  
		  if (right_child != null && right_child.compareTo(current) < 0 && right_child.compareTo(left_child) < 0)
		  {
		   smallest = right;
		  }
		  
		  //if the smallest child is not the current element, swap with it and prelocate down
		  if (smallest != index)
		  {
			  
			  // Temporary variable to hold the intermediate value
			  T temp=_items.getElementAt(smallest);
			  
			  _items.setElementAt(_items.getElementAt(index),smallest);
			   _items.setElementAt(temp,index);
			   adjustHeap(smallest);
		  }
		 }
		 
		 

		
	
}
	

		  

	
	
	
	public Heap()
	{
		
	}
	
	public Heap(Vector<T> unsorted)
	{
		for (int i = 0; i < unsorted.getSize(); i ++)
		{
			_items.push(unsorted.getElementAt(i));
		}
		buildHeap();
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		return _items.getElementAt(0);
	}

	@Override
	public void enqueue(T item) {
		// TODO Auto-generated method stub
		
		//Adds a new item to the heap
		//calculate positions
		//NOTE: in this MA, we STARTED AT 0!!!!!
		int current_position = _items.getSize();
		int parent_position = (current_position - 1) /2;
		
		//insert element (note: may get erased if we hit the WHILE loop)
		//for simplicity purpose, in this MA, we are using the "swapping" method
		//i.e, insert the item first, then swap it all the way up
		_items.addElement(item);
		
		//get parent element if it exists
		T parent = null;
		if (parent_position >= 0)
		{
			parent = _items.getElementAt(parent_position);
		}
		
		if (parent != null)
		{
			//bubble up
			while (current_position > 0 && item.compareTo(parent) < 0)
			{
				_items.setElementAt(parent, current_position);
				current_position = parent_position;
				parent_position = (current_position - 1) / 2;
				if (parent_position >= 0)
				{
					parent = _items.getElementAt(parent_position);
				}
			}
			
			//after finding the correct location, we can finally place our item
			_items.setElementAt(item, current_position);
		}
	}	

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		int last_position = _items.getSize() - 1;
		T last_item = _items.getElementAt(last_position);
		T top = _items.getElementAt(0);
		
		_items.setElementAt(last_item, 0);
		_items.removeElementAt(last_position);
		
		//percolate down after placing the last element in the root for simplicity purpose
		adjustHeap(0);
		return top;
	}

	@Override
	public void addElement(T item) {
		// TODO Auto-generated method stub
		enqueue(item);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return _items.getSize() == 0;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return _items.getSize();
	}

}

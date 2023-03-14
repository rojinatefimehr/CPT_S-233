import java.util.Vector;

public class BinarySearchTree<T extends Comparable<T>> extends Collection<T> {
//public class BinarySearchTree<T> extends Collection<T> {
	
	//keeps track of the remove direction (left or right)
	private int _remove_counter = 0;
	
	//keeps track of BST size
	private int _size_counter = 0;
	
	protected BinaryNode<T> _root = null;
	
	//removes the largest element from the SUBTREE starting at root
	protected BinaryNode<T> removeLargest(BinaryNode<T> root)
	{
		//NULL tree/empty tree
		if (root == null) return null;
		
		//BASE CASE: root is the largest
		if (root.getRightChild() == null)
		{
			return root.getLeftChild();
		}		
		
		//Recursive 		
		BinaryNode<T> new_right = removeLargest(root.getRightChild());
		
		//reconfigure our right pointer to the returned value
		root.setRightChild(new_right);				
		
		return root;
	}
	
	//removes the smallest element
	protected BinaryNode<T> removeSmallest(BinaryNode<T> root)
	{
		//NULL tree/empty tree
		if (root == null) return null;
		
		//without recursion
		BinaryNode<T> pre = null;
		
		//root is the smallest value
		while (root.getLeftChild() != null)
		{
			pre = root;
			root = root.getLeftChild();
		}
		
		//check if pre is null
		if(pre != null)
			pre.setLeftChild(root.getRightChild());
		
		return pre;
	}
	
	protected BinaryNode<T> findLargest(BinaryNode<T> root)
	{
		while(root != null && root.getRightChild() != null)
			root = root.getRightChild();
		return root;
	}
	
	protected BinaryNode<T> findSmallest(BinaryNode<T> root)
	{
		while(root != null && root.getLeftChild() != null)
			root = root.getLeftChild();
		return root;
	}
	
	protected BinaryNode<T> addElementHelper(BinaryNode<T> root, T item)
	{
		// MA3 TODO
		
		//check for null first
		//if null, create new node return pointer to that node		
		if (root==null) {
			return new BinaryNode<T>(item);
		}
		
		//if it is less than root, add to left
		if (item.compareTo(root.getValue())<0) {
			root.setLeftChild(addElementHelper(root.getLeftChild(), item));
		}
		// otherwise, add to the right
		else if (item.compareTo(root.getValue())>0) {
			root.setRightChild(addElementHelper(root.getLeftChild(), item));
		}
		//if not null, compare value, add to correct place
		//you can choose whether to use recursion or not
		//to compare, use this method of the item: item.compareTo(/*arguments to compare to*/)
				
		//always return root because we don't know where the recursion ends
		return root;
	}
	
	protected BinaryNode<T> removeElementHelper(BinaryNode<T> root, T item)
	{
		//check for null
		//if null, return it.
		if (root == null)
		{
			return root;
		}
		
		//three possibilities:
		//we found the item (root value == item)
		//item is less than root (item < root)
		//item is greater than root (item > root)
		if (item.compareTo(root.getValue()) == 0)
		{
			//increment removal counter
			_remove_counter++;
			
			//we found the item
			//do we remove from the left or right?
			if (_remove_counter % 2 == 0)
			{
				//let's assume we are removing from the left when it's an even number
				// MA3 TODO
				//get the largest value from the left 
				
				BinaryNode<T> largest= findLargest (root.getLeftChild());
				//replace this with node
				root.setValue(largest.getValue());
				//delete value from the left
				root.setLeftChild(removeElementHelper(root.getLeftChild(), largest.getValue()));
				
				
			}
			else
			{
				//remove from the right subtree when it's an odd number
				// MA3 TODO
				//get the largest value from the right
				
				BinaryNode<T> smallest= findLargest (root.getRightChild());
				//replace this with node
				root.setValue(smallest.getValue());
				//delete value from the right
				root.setRightChild(removeElementHelper(root.getRightChild(), smallest.getValue()));
				
			}
		}
		else if (item.compareTo(root.getValue()) < 0)
		{
			//item is less than root
			//go on finding it in the left subtree
			BinaryNode<T> result = removeElementHelper(
					root.getLeftChild(),
					item
					);
			
			//the recursive call *might* have altered our
			//left child's structure. Inform root of this change
			root.setLeftChild(result);
		}
		else 
		{
			//item is greater than root
			//finding it in the right subtree
			BinaryNode<T> result = removeElementHelper(
					root.getRightChild(),
					item
					);
			root.setRightChild(result);
		}
		
		return root;
	}

	@Override
	public void addElement(T item) {		
		_root = addElementHelper(_root, item);
		_size_counter++;
	}
	
	public void removeElement(T item) {
		_root = removeElementHelper(_root, item);
		_size_counter--;
	}

	@Override
	public boolean isEmpty() {		
		return _root == null;
	}

	@Override
	public int getSize() {		
		return _size_counter;
	}

}


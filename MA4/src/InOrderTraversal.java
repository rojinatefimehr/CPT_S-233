
public class InOrderTraversal <T extends Comparable<T>> extends AvlTreeTraversal<T> {

	@Override
	
	// In order travles from left-root-right
	
	public void traverse(AvlNode<T> root) {
		// TODO Auto-generated method stb
		if (root == null)
			return;
		
		traverse(root.getLeftChild());
		
		
		System.out.print(root.getValue() + " ");
		
		traverse(root.getRightChild());		
	}

}




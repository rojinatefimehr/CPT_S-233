
public class MA4_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		leftTest();
		System.out.println();
		rightTest();
		System.out.println();
		System.out.println();
	}
	
	//tests left imbalance
	public static void leftTest()
	{
		AvlTree<Integer> avl = new AvlTree<>();
		avl.addElement(10);
		avl.addElement(9);
		avl.addElement(8);	
		avl.addElement(11);
		
		System.out.println("AVL pre-order traversal: ");
		avl.traverse(new PreOrderTraversal<Integer>());	
		System.out.println();
		
		System.out.println("AVL In-order traversal: ");
		avl.traverse(new InOrderTraversal<Integer>());	
	}
	
	//tests right imbalance
	public static void rightTest()
	{
		AvlTree<Integer> avl = new AvlTree<>();
		avl.addElement(1);
		avl.addElement(2);
		avl.addElement(3);
		avl.addElement(5);
		avl.addElement(7);
		
		System.out.println("AVL pre-order traversal: ");
		avl.traverse(new PreOrderTraversal<Integer>());
		System.out.println();
		
		System.out.println("AVL In-order traversal: ");
		avl.traverse(new InOrderTraversal<Integer>());
		System.out.println();
		
	}
	

}

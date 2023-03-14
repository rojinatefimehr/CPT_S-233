
import java.util.Vector;

public class MA2_main
{
    public static void main(String args[])
    {
        BucketHashTable<String, String> ht = new BucketHashTable<>(new SimpleStringHasher());
        MA2_main.hashTableTest(ht);
    }
    
    public static void hashTableTest(BucketHashTable<String, String> ht)
    {
    	  
    	System.out.println("start:");
        ht.addElement("I", "Love");
    	ht.addElement("CptS", "233");
    	ht.addElement("And", "I"); //0
    	ht.addElement("especially", "love"); 
    	ht.addElement("Hashtables", "!"); 
    	    
    	System.out.println();
    	//test inputs
    	//buckets is different than _items in HashTableBase, so we are using getBuckets() this time.
    	Vector<Vector<HashItem<String, String>>> buckets = ht.getBuckets();   
    	
    	// MA2 TODO
    	//Write your own test cases, and show that if they are correct or not. Print out any statement you'd like/need to.
    	//Does your test cases eventually test the resize function? If not, try to
    	System.out.println();
    
    	System.out.println();
    	ht.addElement("1","rojin");
    	ht.addElement("2", "Studnet");
    	ht.addElement("3", "computer");
    	
    
    	
    	//remove test
    	System.out.println();
    	System.out.println("remove test:");
    	ht.removeElement("especially");
    	ht.removeElement("And");
    	ht.removeElement("3");
    	
    }
}
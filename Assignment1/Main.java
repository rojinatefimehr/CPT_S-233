import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {

	//I had a problem to read the csv files, I came across with this code online to attached the csv files into program
		// I saw in the internet in order to read CSV files we need to read them with file, java buffer
		// So I used javaBuffer and writer in the ReadFile class in order to read data from csv classes
	
	static final String FileDir="/Users/rojinatefi/233rojin/Assignment1/src/";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		RaedFiles f=new RaedFiles();
		
		ArrayList<Integer> assignmentValues= new ArrayList<Integer>();
		ArrayList<String> categories= new ArrayList<String>();
		ArrayList<Integer> categoriesValues= new ArrayList<Integer>();
		ArrayList<String> headers= new ArrayList<String>();
//key is the studentID and name
//Value is the list of student assignment scores
		
		Hashtable<String, ArrayList<Integer>> assignmentScores=new Hashtable<String, ArrayList<Integer>>();
		Hashtable <String, ArrayList<Integer>> categoryScores= new Hashtable<String, ArrayList<Integer>>();
		Scanner input;
		
		ArrayList<String> fileList=f.inputFiles();
		
		// go through fileList and get value from the files and catch errors(if there is any problem e.getMessage)
		
		
		  try {
	            for(String fileName : fileList) {
	                int a=1;
	                input = new Scanner(new File(FileDir + fileName));


	                f.getHeaders(input, assignmentValues, categories, categoriesValues, headers, fileName);
	                f.getData(input, assignmentScores, categoryScores);
	            }

	            System.out.println("Program is working");

	            f.details(headers, assignmentValues, assignmentScores);
	            f.summary(headers, categories, categoriesValues, categoryScores);

	        } 
	        

	        catch(Exception e) {
	        	System.out.println(e.getMessage());
	            System.out.println("File is not valid, your file must be <>_<>.csv format " );
	        }
	       
	    
		
	}

}

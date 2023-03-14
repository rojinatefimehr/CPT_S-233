import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class RaedFiles {

	Point p=new Point();
	
	static final String FileDir="/Users/rojinatefi/233rojin/Assignment1/src/";
	
	
	   // creates summary file that contains all students, class grade , and  points

    public void summary(ArrayList<String> headers, ArrayList<String> categories,ArrayList<Integer> categoryValues,
   Hashtable<String, ArrayList<Integer>> categoryScores)
            throws IOException {

        
       
        File file = new File(FileDir + "summary.csv");
        file.createNewFile();
        FileWriter filew = new FileWriter(file);
        BufferedWriter bufferw = new BufferedWriter(filew);

        String topLine = p.removeBrackets(categories.toString());
        String secondLine = p.removeBrackets(categoryValues.toString());

        bufferw.write("#ID, Name,Final Grade," + topLine + "\n");
        bufferw.write(", Overall," + secondLine + "\n");

        Set<String> studentID = categoryScores.keySet();
        String scores;
        double grade;
        for(String studentID1 : studentID) {
            scores = p.removeBrackets(categoryScores.get(studentID1).toString());
            grade = (double) Math.round(p.finalGrade(studentID1, categoryValues, categoryScores) * 100) / 100;

            bufferw.write(studentID1 + "," + grade + "," + scores + "\n");
        }

        bufferw.flush();
        bufferw.close();
    }

    
    //creates the details file which contains all student's records
    public  void details(ArrayList<String> headers, ArrayList<Integer> assignmentValues,
    Hashtable<String, ArrayList<Integer>> assignmentScores)
            throws IOException {

        
        File file = new File(FileDir + "details.csv");
        file.createNewFile();
        FileWriter fwriter = new FileWriter(file);
        BufferedWriter bwriter = new BufferedWriter(fwriter);
        String scores;
        String topLine = p.removeBrackets(headers.toString());
        String secondLine = p.removeBrackets(assignmentValues.toString());

        bwriter.write("#ID,Name," + "," + topLine + "\n");
        bwriter.write(", Overall," +  "," + secondLine + "\n");

        Set<String> studentIDSet = assignmentScores.keySet();

        for(String studentID : studentIDSet) {
            scores = p.removeBrackets(assignmentScores.get(studentID).toString());

            bwriter.write(studentID + "," + scores + "\n");
        }

        bwriter.flush();
        bwriter.close();
    }


   
    // creates a list of student assignment and catagory scores
    
    
    public static void getData (Scanner fileScanner,Hashtable<String, ArrayList<Integer>> assignmentScores,
      Hashtable<String, ArrayList<Integer>> categoryScores)
            throws FileNotFoundException {

        Scanner lineScanner = new Scanner(fileScanner.nextLine());
        lineScanner.useDelimiter(",");

        while(fileScanner.hasNextLine()) {
            String key;
            String line;
            ArrayList<Integer> studentScores;

            line = fileScanner.nextLine();

            lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");

            key = lineScanner.next() + ", " + lineScanner.next() + "; " + lineScanner.next() + ",";

            if(categoryScores.containsKey(key)) {
                studentScores = categoryScores.get(key);
                studentScores.add(Integer.parseInt(lineScanner.next()));
                categoryScores.replace(key, studentScores);
            } else {
                studentScores = new ArrayList<Integer>();
                studentScores.add(Integer.parseInt(lineScanner.next()));
                categoryScores.put(key, studentScores);
            }

            if(assignmentScores.containsKey(key)) {
                studentScores = assignmentScores.get(key);
                while(lineScanner.hasNext()) {
                    studentScores.add(Integer.parseInt(lineScanner.next()));
                }
                assignmentScores.replace(key, studentScores);
            } else {
                studentScores = new ArrayList<Integer>();
                while(lineScanner.hasNext()) {
                    studentScores.add(Integer.parseInt(lineScanner.next()));
                }
                assignmentScores.put(key, studentScores);
            }
        }
    }

//create all files wich start with exam,homework,and quizz, after creation stored the data in the arraylist
    //create a list for headers like exam1,exam2 and the store them in the arraylist
    
    
    public static void getHeaders (Scanner fileScanner, ArrayList<Integer> assignmentValues,ArrayList<String> categories, ArrayList<Integer> categoryValues,
  ArrayList<String> headers, String fileName) {


        String fileCategory = fileName.substring(0, fileName.indexOf('_'));

        Scanner input = new Scanner(fileScanner.nextLine());
        input.useDelimiter(",");
        if(!categories.contains(fileCategory)) {
            String lineSegment;

            categories.add(fileCategory);

            int column = 0;
            while(input.hasNext()) {
                lineSegment = input.next();
                if(column > 2) {
                    headers.add(lineSegment);
                } else column++;
            }

            input = new Scanner(fileScanner.nextLine());
            input.useDelimiter(",");

            column = 0;

            input.next();

            while(input.hasNext()) {
                lineSegment = input.next();
                if(column == 0) {
                    categoryValues.add(Integer.parseInt(lineSegment));
                } else if(column > 0) {
                    assignmentValues.add(Integer.parseInt(lineSegment));
                }
                column++;
            }
        }
    }

    // create a method to get input in the correct format from users and give us the list 
    public ArrayList<String> inputFiles() {
        Scanner input = new Scanner(System.in);
        String fileName;
        ArrayList<String> fileList = new ArrayList<String>();

        System.out.println("  Input files followed by .csv and then hit start ");
        
       
        fileName = input.next();

        // after the user hit start, add files which has not been added 
        while(fileName.compareTo("start") != 0) {
            if(!fileList.contains(fileName)) {
                fileList.add(fileName);
                fileName = input.next();
            } else {
                System.out.println("this file already exist");
                fileName = input.next();
            }
        }

        Collections.sort(fileList);
        return fileList;
    }


}


	
	


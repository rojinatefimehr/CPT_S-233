import java.util.ArrayList;
import java.util.Hashtable;

public class Point {

	
    //remove brackets from the string in the list,in ReadFile class used to read score,etc. 
    public String removeBrackets(String input) {
        input = input.replace('[', ' ');
        input = input.replace(']', ' ');
        return input;
    }

    
    // In summary CSV file the grade should be in percent so this method return grade value in percent 
    
    public  double finalGrade(String studentID, ArrayList<Integer> categoryValues, Hashtable<String, ArrayList<Integer>> categoryScores) {

double score1 = 0;
double score2 = 0;

for(int j = 0; j < categoryValues.size(); j++) {
if(categoryScores.containsKey(studentID)) {
score1 += categoryScores.get(studentID).get(j);
score2 += categoryValues.get(j);
}
}
double finalScore = (score1 / score2);

return (finalScore * 100);
}

    
}


	

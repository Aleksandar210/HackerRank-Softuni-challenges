
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Experiment {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
	
		HashMap<String,ArrayList<String>> data = new HashMap<String,ArrayList<String>>();
	    ArrayList<String> currentListData = new ArrayList<String>();
	    currentListData.add("hello");
	    data.put("Dave",currentListData);
	    
	    data.get("Dave").add("John");
	    
	    ArrayList<String> thisList = data.get("Dave");
	    
	    for(String word:thisList) {
	    	System.out.println(word);
	    }
	}
}
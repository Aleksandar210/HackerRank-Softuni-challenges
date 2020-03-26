package advanced_Softuni;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AdvancedExperiments {

public static void main(String[] args) {
	 String path = "D:\\FileFolder";
String readFrom = path+"\\readFile.txt";
try(BufferedReader bfr = new BufferedReader(new FileReader(readFrom))){
	
	
	
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

 }

}

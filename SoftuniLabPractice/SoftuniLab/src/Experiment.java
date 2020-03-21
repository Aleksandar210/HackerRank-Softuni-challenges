
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Map.Entry;


public class Experiment {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
			
	String regex = "[=\\s\\#]+";
	String data = "High = 89#Low = 28#Medium = 77#Low = 23";
	String[] dataCollected = data.split(regex);
	char c;
	for(int i=0;i<dataCollected.length-1;i+=2) {
		System.out.println(dataCollected[i]);
	}
	
 }
	
	
	
}

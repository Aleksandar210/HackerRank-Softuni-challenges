
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
		
		String rgex = "([\\S\\w])+";
		String name;
		Pattern p = Pattern.compile(rgex);
		Matcher m;
		do {
			name = scan.nextLine();
			if(!name.equalsIgnoreCase("end")) {
				m = p.matcher(name);
				if(m.find()) {
					System.out.println(m.group());
				}
			}
		}while(!name.equalsIgnoreCase("end"));
		
		
		
		
		
 }
}

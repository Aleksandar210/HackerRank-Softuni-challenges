
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.Map.Entry;


public class Experiment {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
	
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("Atanas", 23);
		map.put("Jivko", 12);
		 Optional<Entry<String, Integer>> maxEntry = map.entrySet()
			        .stream().max((Entry<String,Integer> a,Entry<String,Integer> b)->Integer.compare(a.getValue(), b.getValue()));
		 
		 
		 for(Entry<String,Integer> entry: map.entrySet()) {
			 System.out.println(entry.getKey()+" "+entry.getValue());
		 }
	}
}
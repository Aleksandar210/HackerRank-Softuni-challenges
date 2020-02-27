import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import com.sun.javafx.collections.MappingChange.Map;

public class AssociativeArrays {
	static Scanner scan = new Scanner(System.in);
	
public static void main(String[] args) {
	//numberCount();
	//wordSynonim();
	//
}

static void numberCount() {
	String enterNumbers = scan.nextLine();
	String[] numbersSplited = enterNumbers.split(" ");
	HashMap<String, Integer> numbers = new HashMap<String,Integer>(numbersSplited.length);
	for(String number:numbersSplited) {
		if(numbers.get(number)!=null) {
			int count = numbers.get(number);
			numbers.put(number,count++);
		}else {
			numbers.put(number, 1);
		}
		
		
		for(Entry<String, Integer> entry: numbers.entrySet()) {
			System.out.printf("%s -> &d",entry.getKey(),entry.getValue());
		}
	}
	
}

static void wordSynonim() {
	int numberWords = Integer.parseInt(scan.nextLine());
	HashMap<String,ArrayList<String>> wordsAndSynonims = new HashMap<String,ArrayList<String>>(numberWords);
	
	
	for(int i =0;i<numberWords;i++) {
	String word = scan.nextLine();
	String synonim =scan.nextLine();
	ArrayList<String> currentSynonim = wordsAndSynonims.get(word);
	if(currentSynonim==null) {
		currentSynonim = new ArrayList<String>();
		wordsAndSynonims.put(word,currentSynonim);
	}
	currentSynonim.add(synonim);
	}
	
	for(Entry<String, ArrayList<String>> entry: wordsAndSynonims.entrySet()) {
		System.out.println(entry.getKey()+" " + entry.getValue());
	}
	
}


}

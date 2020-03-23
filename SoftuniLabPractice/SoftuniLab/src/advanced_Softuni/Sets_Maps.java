package advanced_Softuni;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.sun.javafx.webkit.KeyCodeMap.Entry;

public class Sets_Maps {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//usernameUnique();
		//repetingNumbers();
		//periodicTable();
		//occurence();
		//phoneBook();
		//getResources();
		//ficEmails();
	}
	
	//----------------------------------------------------------------------
	static void fixEmails() {
		String enter;
		String name="";
		
		Map<String,String> namesEmails = new HashMap<String,String>();
		int indexLine=1;
		String[] domains = new String[]{".uk",".us",".com"};
		do {
			enter = scan.nextLine();
			if(indexLine%2!=0) {
				name = enter;
			}else {
				
				verifyInputMap(namesEmails,domains,enter,name);
				name ="";
			}
			
		}while("stop".equalsIgnoreCase(enter));
		
		for(Map.Entry<String, String> entry:namesEmails.entrySet()) {
			System.out.println(entry.getKey()+" ->"+entry.getValue());
		}
	}
	
	static void verifyInputMap(Map<String,String>map, String[] domains,String currentDomain,String name) {
		for(int i=0;i<domains.length;i++) {
			if(currentDomain.contains(domains[i])) {
				if(currentDomain.length() -  currentDomain.lastIndexOf(domains[i])==3) {
					break;
				}else {
					continue;
				}
			}
		}
		
		map.put(name, currentDomain);
	}
	//----------------------------------------------------------------------
	
	
	
	
	
	
	
	//----------------------------------------------------------------------
	static void getResources() {
		Map<String,Integer> resources = new HashMap<String,Integer>();
		String enter;
		int index =1;
		
		Stack<String> resourceEntered = new Stack<String>();
		do {
			enter = scan.nextLine();
			if(index%2==0) {
				if(resources.get(enter)==null) {
					resources.put(resourceEntered.pop(),Integer.parseInt(enter));
				}else {
					resources.put(resourceEntered.peek(), resources.get(resourceEntered.pop())+Integer.parseInt(enter));
				}
			}else {
				resourceEntered.push(enter);
			}
		}while("stop".equalsIgnoreCase(enter));
		
		for(Map.Entry<String,Integer> entry:resources.entrySet()) {
			System.out.println(entry.getKey()+"-> "+entry.getValue());
		}
	}
	
	//----------------------------------------------------------------------
	
	
	
	
	
	
	
	//----------------------------------------------------------------------
	static void phoneBook() {
		String regex = "(?<name>[a-zA-Z])+([\\-\\s])(?<number>[0-9])+";
		String enter;
		Pattern enterPattern = Pattern.compile(regex);
		Matcher enterMatcher;
		
		Map<String,Integer> names = new HashMap<String,Integer>();
		
		do {
			enter = scan.nextLine();
			if("search".equalsIgnoreCase(enter)||"stop".equalsIgnoreCase(enter)) {
				enterMatcher = enterPattern.matcher(enter);
				if(enterMatcher.find()) {
					names.put(enterMatcher.group("name"),Integer.parseInt(enterMatcher.group("number")));
					
				}
			}else if("search".equalsIgnoreCase(enter)) {
				enter = scan.nextLine();
				if(names.get(enter)==null) {
					System.out.println("Contact doesnt exist");
				}else {
					System.out.println(enter+" ->"+names.get(enter));
				}
			}
		}while("stop".equalsIgnoreCase(enter));
	}
	//----------------------------------------------------------------------
	
	
	
	
	
	
	
	//----------------------------------------------------------------------
	static void occurence() {
		
		Map<Character,Integer> map = new TreeMap<Character,Integer>();
		enterSymbols(map,scan.nextLine());
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey()+" ->"+entry.getValue());
		}
	}
	
	@SuppressWarnings("deprecation")
	static void enterSymbols(Map<Character,Integer> map,String word) {
		char c;
		for(int i =0;i<word.length();i++) {
			c = word.charAt(i);
			if(!Character.isSpace(c)) {
				Optional<Integer> opt = Optional.ofNullable(map.get(c)) ;
				if(opt.isPresent()) {
					map.put(c,map.get(c)+1);
				}else {
					map.put(c, 1);
				}
			}
		}
	}
	//----------------------------------------------------------------------
	
	

	
	//----------------------------------------------------------------------
	static void periodicTable() {
		int numberElements = Integer.parseInt(scan.nextLine());
		Set<String> elems= new HashSet<String>(numberElements);
		while(numberElements>0) {
			
		String enterElements = scan.nextLine();
		String[] dataCollected = enterElements.split("\\s");
		
		if(elems.isEmpty()) {
			elems = Arrays.stream(dataCollected).collect(Collectors.toSet());
		}else {
			addToSetNoOvveride(elems,dataCollected);
		}
		
		numberElements--;
		
		}
		
		System.out.println(elems);
	}
	
	static void addToSetNoOvveride(Set<String> set, String[] arr) {
		for(String elem:arr) {
			set.add(elem);
		}
	}
	
	//----------------------------------------------------------------------
	
	
	
	
	//----------------------------------------------------------------------
	static void repeatingNumbers() {
		int setOne = Integer.parseInt(scan.nextLine());
		int setTwo = Integer.parseInt(scan.nextLine());
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		int sumCapacity =0;
		while(sumCapacity<setOne+setTwo) {
			int addNumber = Integer.parseInt(scan.nextLine());
			if(sumCapacity<setOne) {
				set1.add(addNumber);
			}else {
				set2.add(addNumber);
			}
		}
		
		Set<Integer> repeating = new HashSet<Integer>(set1);
		repeating.retainAll(set2);
		System.out.println(repeating);
	}
	//----------------------------------------------------------------------
	
	
	
	
	
	
	
	
	//----------------------------------------------------------------------
	static  void usernameUnique() {
		Set<String> usernames = new HashSet<String>();
		
		String enterUsername;
		int numberUsernames = Integer.parseInt(scan.nextLine());
	
		while(numberUsernames>0) {
			
			try {
				enterUsername = scan.nextLine();	
			}catch(NullPointerException exception){
				continue;
			}
			numberUsernames--;
			
		}
		
		
	}
	//----------------------------------------------------------------------
	
	

}

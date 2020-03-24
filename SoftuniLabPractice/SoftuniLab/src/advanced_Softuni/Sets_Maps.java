package advanced_Softuni;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import softuni_objectsandclasses_folder.Dragon;



public class Sets_Maps {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//usernameUnique();
		//repetingNumbers();
		//periodicTable();
		//occurence();
		//phoneBook();
		//getResources();
		//fixEmails();
		//cardPoints() //! too much code.
		//partyList();
		//userLogs();
		//serbianUnleashed()
		//heroesIII();
	}
	
	 //--------------------------------------------------------------------------------------------------------------
	static void heroesIII() {
		int numberDragons =  Integer.parseInt(scan.nextLine());
		Map<String,TreeMap<String,Dragon>> dragons = new LinkedHashMap<String,TreeMap<String,Dragon>>();
		
		String enterDragon;
		Pattern dragonP = Pattern.compile("(?<type>[a-zA-Z]+)\\s+\\b(?<name>[a-zA-Z]+)\\b\\s+(?<damage>[0-9]*)\\s+(?<health>[0-9]*)\\s+(?<armour>[0-9]*)");
		Matcher dragonM;
		while(numberDragons>0) {
			enterDragon = scan.nextLine();
			dragonM = dragonP.matcher(enterDragon);
			if(dragonM.find()) {
				
				if(dragons.get(dragonM.group("type"))==null) {
					
					if(dragons.get(dragonM.group("type")).get(dragonM.group("name"))==null) {
						Dragon currentDragon = new Dragon(dragonM.group("name"),Integer.parseInt(dragonM.group("health")),Integer.parseInt(dragonM.group("damage")),Integer.parseInt(dragonM.group("armour")));
						dragons.put(dragonM.group("type"), new TreeMap<String,Dragon>());
						dragons.get(dragonM.group("type")).put(dragonM.group("name"), currentDragon);
					}else {
						Dragon currentDragon = new Dragon(dragonM.group("name"),Integer.parseInt(dragonM.group("health")),Integer.parseInt(dragonM.group("damage")),Integer.parseInt(dragonM.group("armour")));
						dragons.get(dragonM.group("type")).put(dragonM.group("name"), currentDragon);
					}
				}
				
			}
		}
		
		System.out.println();
	}
	static void dragonMenue(Map<String,Map<String,Dragon>> dragons) {
		boolean exit = false;
		while(!exit) {
			int select;
		do {
		System.out.println("1|Display all dragons");
		System.out.println("2|Display by type");
		System.out.println("3|Search by type and name");
		System.out.println("4|cancel");
		System.out.println("Select: ");
		 select = Integer.parseInt(scan.nextLine());
		 
		 switch(select) {
		 case 1:
			 displayAll(dragons);
			 break;
		 case 2:
			 activateSearchByTypeMenue(dragons);
			 break;
		 case 3:
			 activateSearchByTypeName(dragons);
			 break;
		 case 4:
			 exit =true;
			 break;
		 }
		 
		}while(select!=4);
		
		}
		System.out.println();
		System.out.println("Goodbye World!");
	}
	
	//display all function activated when switch case 1!
	
	static void displayAll(Map<String,Map<String,Dragon>> dragons) {
		for(Map.Entry<String, Map<String,Dragon>> mapster:dragons.entrySet()) {
			System.out.println(mapster.getKey());
			System.out.println("-----------------------");
			for(Map.Entry<String, Dragon> currentDragon:mapster.getValue().entrySet()) {
				System.out.println(currentDragon.getValue());
			}
			System.out.println("-------------------------");
			System.out.println();
		}
	}
	
	
	
	
	
	
	//display by type activated when switch case 2
	
	static void displayType(Map<String,Map<String,Dragon>> dragons,String type) {
		System.out.println();
		System.out.println("Dragons of type: "+type);
		for(Map.Entry<String, Dragon> mapster: dragons.get(type).entrySet()) {
			System.out.println(mapster.getValue());
		}
	}
	
	
	
	
	//small function for searching by Type function (related/linked)
	static void activateSearchByTypeMenue(Map<String,Map<String,Dragon>> dragons) {
		 System.out.print("(enter -1 to cancel) Enter type: ");
		 String type = scan.nextLine();
		 if("-1".equals(type)) {
			 return;
		 }
		 if(dragons.containsKey(type)) {
			 displayType(dragons,type);
		 }else {
			 System.out.println("Invalid Type.");
			 activateSearchByTypeMenue(dragons);
		 }
	}
	
	static void activateSearchByTypeName(Map<String,Map<String,Dragon>> dragons) {
		System.out.print("(enter -1 to cancel) Tpye: ");
		String type = scan.nextLine();
		if("-1".equals(type)) {
			return;
		}else {
			if(!dragons.containsKey(type)) {
				System.out.println("No type found");
				activateSearchByTypeName(dragons);
			}else {
			
			searchByName(dragons,type);
				
			}
		}
	}
	
	static void searchByName(Map<String,Map<String,Dragon>>dragons,String type) {
		System.out.print("(enter -1 to cancel) Name: ");
		String name = scan.nextLine();
		if("-1".equals(name)) {
			return;
		}else {
			if(!dragons.get(type).containsKey(name)) {
				System.out.println("No dragon found");
				searchByName(dragons,type);
			}else {
				System.out.println("Dragon found: ");
				System.out.println(dragons.get(type).get(name));
			}
		}
	}
	 //--------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 //--------------------------------------------------------------------------------------------------------------
	static void serbianUnleashed() {
		String regex = "(?<name>[a-zA-Z]+)\\s+\\b(?<venue>[@a-zA-Z]+)\\b\\s+(?<price>[0-9]*)\\s+(?<count>[0-9]*)";
		String enter;
		Pattern concertPattern = Pattern.compile(regex);
		Matcher concertMatcher;
		Map<String, Map<String, Integer>> singerByCity = new HashMap<String,Map<String,Integer>>();
		Map<String,Integer> singerRevenue = new HashMap<String,Integer>();
		while(true) {
			enter = scan.nextLine();
			if("end".equalsIgnoreCase(enter)) {
				break;
			}else {
				
				concertMatcher = concertPattern.matcher(enter);
				
				if(concertMatcher.find()) {
					
					if(singerByCity.get(concertMatcher.group("venue"))==null) {
						singerByCity.put(concertMatcher.group("venue"), new LinkedHashMap<String,Integer>());
						
						int revenueValue = Integer.parseInt(concertMatcher.group("count"));
						revenueValue*=Integer.parseInt(concertMatcher.group("price"));
						singerRevenue.put(concertMatcher.group("name"),revenueValue );
						singerByCity.put(concertMatcher.group("venue"), sortMap(singerRevenue));
					}else {
						int revenueValue = Integer.parseInt(concertMatcher.group("count"));
						revenueValue*=Integer.parseInt(concertMatcher.group("price"));
						singerRevenue.put(concertMatcher.group("name"),revenueValue );
						singerByCity.put(concertMatcher.group("venue"), sortMap(singerRevenue));
					}
					
				}
				
			}
		}
			
		
		System.out.println("Statistics. ");
		for(Map.Entry<String, Map<String,Integer>> mapster: singerByCity.entrySet()) {
			System.out.println(mapster.getKey());
			for(Map.Entry<String, Integer> singerMapster:mapster.getValue().entrySet()) {
				System.out.println(singerMapster.getKey()+" ->"+ singerMapster.getValue());
			}
		}
		
	}
	
	static LinkedHashMap<String,Integer> sortMap(Map<String,Integer> singerRevenue) {
		
		
		LinkedHashMap<String, Integer> newMap=
		singerRevenue.entrySet().stream().sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(a,b)->a,LinkedHashMap::new));
		return newMap;
	}

	 //--------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//----------------------------------------------------------------------
	static void userLogs() {
	
		String enterLog;
		Map<String,Integer> duration = new HashMap<String,Integer>();
		Map<String,Stack<String>> userIpUsed = new HashMap<String,Stack<String>>();
		
		String regex = "(?<ip>[0-9.]+)\\s+(?<name>[a-zA-Z]+)\\s+(?<duration>[0-9]+)";
		Pattern verifyLog = Pattern.compile(regex);
		Matcher matchLog;
		
		
		while(true) {
			enterLog = scan.nextLine();
			if("report".equalsIgnoreCase(enterLog)) {
				break;
			}else {														//if not report
				matchLog = verifyLog.matcher(enterLog);
				if(matchLog.find()) {									//if entered is valid
					
					if(duration.get(matchLog.group("name"))==null){
						duration.put(matchLog.group("name"), Integer.parseInt(matchLog.group("duration")));
						userIpUsed.put(matchLog.group("name"),new Stack<String>());
						userIpUsed.get(matchLog.group("name")).push(matchLog.group("ip"));
					}else {
						int addToDurationSum = Integer.parseInt(matchLog.group("duration"))+duration.get(matchLog.group("name"));
						duration.put(matchLog.group("name"), addToDurationSum);
						userIpUsed.get(matchLog.group("name")).push(matchLog.group("ip"));
					}
					
					
				}
			}
			
			
		}
		
		
		System.out.println("Report results: ");
		for(Map.Entry<String,Integer> user:duration.entrySet()) {
			System.out.print(user.getKey()+" ->"+user.getValue()+" with IP's used: ");
			System.out.print(" "+userIpUsed.get(user.getKey()));
			System.out.println();
		}
	}
	//----------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//----------------------------------------------------------------------
	static void partyList() {
		String enterGuestsList;
		Set<String> vip = new HashSet<String>();
		Set<String> regular = new HashSet<String>();
		
		
		
		do {
			enterGuestsList = scan.nextLine();
			
			if(!"party".equalsIgnoreCase(enterGuestsList)) {
				if(Character.isDigit(enterGuestsList.charAt(0))) {
					vip.add(enterGuestsList);
				}else {
					regular.add(enterGuestsList);
				}
				
				
			}
		}while(!"party".equalsIgnoreCase(enterGuestsList));
		
		String checkGuests;
		do {
			checkGuests = scan.nextLine();
			if(!"stop".equalsIgnoreCase(checkGuests)) {
				if(Character.isDigit(checkGuests.charAt(0))) {
					vip.remove(checkGuests);
				}else {
					regular.remove(checkGuests);
				}
			}
		}while(!"stop".equalsIgnoreCase(checkGuests));
		
		Set<String> attend = new HashSet<String>(vip);
		attend.addAll(regular);
		
		for(String attended:attend) {
			System.out.println(attended);
		}
	}
	
	//----------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	//card point starts here
	//----------------------------------------------------------------------
	static void cardPoints() {
		String enter;
	
		Map<String,Set<String>> userSet = new HashMap<String,Set<String>>();
		Map<String,Integer> userResult = new HashMap<String,Integer>();
		
		do {
			enter = scan.nextLine();
			
			if(!"stop".equalsIgnoreCase(enter)) {
			String[] nameAndDeck = enter.split(":");
			addPointsAndDeck(userResult,userSet,nameAndDeck);
			}
			
			
		}while(!"stop".equalsIgnoreCase(enter));
		
		System.out.println(" ");
		System.out.println("Results: ");
		
		for(Map.Entry<String,Integer> userr:userResult.entrySet()) {
			System.out.print(userr.getKey()+" ->"+userr.getValue()+" points! with a deck: ");
			System.out.print(userSet.get(userr.getKey()));
			System.out.println();
		}
	}
	
	static void addPointsAndDeck(Map<String,Integer> user,Map<String,Set<String>> userSet,String[] data) {
		String getHand = data[1];
		
		String[] cardsInHand = getHand.split(",\\s+");
		
		int currentPoints;
		if(userSet.get(data[0])==null) {
			currentPoints = calculatePoints(cardsInHand);
			userSet.put(data[0], Arrays.stream(cardsInHand).collect(Collectors.toSet()));
			user.put(data[0], currentPoints);
		}else {
			for(String currentCard:cardsInHand) {
				userSet.get(data[0]).add(currentCard);
				
			}
			
			String[] currentHandSet = userSet.get(data[0]).toArray(new String[userSet.get(data[0]).size()]);
			int addNewPoints = user.get(data[0])+calculatePoints(currentHandSet);
			user.put(data[0],addNewPoints);
			
		}
		
	}
	
	static int calculatePoints(String[] cards) {
		int points = 0;
		for(String card:cards) {
			try {
				int number = Integer.parseInt(card.substring(0,1));
				points+=number;
				points+=addPointDueType( card, points);
				
			}catch(NumberFormatException exception) {
				points+=addPointDueCard(card,points);
			}
			}
		return points;
		
	}
	
	
	
	
	
	
	static int addPointDueCard(String card,int points) {
		
		switch(card.substring(0,1).toLowerCase()) {
		case "j":
			points+=11;
			points+=addPointDueType(card,points);
			break;
		case "q":
			points+=12;
			points+=addPointDueType(card,points);
			break;
			
		case "k":
			points+=13;
			break;
			
		case"a":
			points+=14;
			points+=addPointDueType(card,points);
			break;
		}
		return points;
	}
	
	
	
	static int addPointDueType(String card,int points) {
		switch(card.substring(1,2).toLowerCase()) {
		case "d":
			points+=2;
			break;
		case"s":
			points+=4;
			break;
		case"h":
			points+=3;
			break;
		case "c":
			points+=1;
			break;
		}
		return points;
	}
	//----------------------------------------------------------------------
	
	//card point ends here
	
	
	
	
	
	
	
	
	
	
	
	
	
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
		boolean invalid =false;
		for(int i=0;i<domains.length;i++) {
			if(currentDomain.contains(domains[i])) {
				if(currentDomain.length() -  currentDomain.lastIndexOf(domains[i])==3) {
					invalid = true;
				}else {
					continue;
				}
			}
		}
		if(!invalid) {
		map.put(name, currentDomain);
		}
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

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Scanner;



public class AssociativeArrays {
	static Scanner scan = new Scanner(System.in);
	
public static void main(String[] args) {
	//numberCount();
	//wordSynonim();
	//
	//evenLength();
	largestThreeInList();
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

static void oddWordsFound() {
	String enterWords = scan.nextLine();
	String[] words = enterWords.split(" ");
	
	HashMap<String, Integer> oddWords = new HashMap<String,Integer>(words.length);
	
	for(String word: words) {
		if(oddWords.get(word)==null) {
			
			 oddWords.put(word.toLowerCase(),0);
		}else {
		oddWords.put(word.toLowerCase(),oddWords.get(word)+1 );
		}
	}
	
	for(Entry<String,Integer> entry:oddWords.entrySet()) {
		if(entry.getValue()%2!=0) {
			System.out.print(entry.getKey()+" ");
		}
	}
	
}

static void evenLength() {
	String[] words = Arrays.stream(scan.nextLine().split(" ")).filter(s -> s.length()%2==0).toArray(String[]::new);
	for(String word:words) {
		System.out.println(word);
	}
}

static void largestThreeInList() {
List<Integer> numbers = Arrays.asList(scan.nextLine().split(" ")).stream().map(e -> Integer.parseInt(e)).sorted((a,b) -> b.compareTo(a)).collect(Collectors.toList());
if(numbers.size()<3) {
	System.out.println(numbers);
}else {
	for(int i =0;i<3;i++) {
		System.out.println(numbers.get(i));
	}
}
			
}

static void countChars() {
	
	String word = scan.nextLine();
	HashMap<Character, Integer> mapSymbols = new HashMap<Character,Integer>(word.length());
	for(int i =0;i<word.length();i++) {
		char c = word.charAt(i);
		if(mapSymbols.get(c)==null) {
			mapSymbols.put(c,0);
		}else {
			mapSymbols.put(c, mapSymbols.get(c)+1);
		}
		
		for(Entry<Character,Integer> entry: mapSymbols.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
			
		}
	}

}

static void miningTask() {
	String enter;
	int quantity;
	HashMap<String,Integer> resources = new HashMap<String,Integer>();
	do {
		enter = scan.nextLine();
		if(!enter.equalsIgnoreCase("stop")) {
			quantity = Integer.parseInt(scan.nextLine());
			
			resources.put(enter,quantity);
		}
	}while(!enter.equalsIgnoreCase("stop"));
	
	System.out.println();
	for(Entry<String,Integer> entry: resources.entrySet()) {
		System.out.println(entry.getKey()+" "+entry.getValue());
	}
}

static void getItem() {
	HashMap<String,Integer> yourCollectings = new HashMap<String,Integer>();
	String[] enterCollectables = scan.nextLine().split(" ");
	outerForLoop:
	for(int i =0;i<enterCollectables.length-1;i+=2) {
		yourCollectings.put(enterCollectables[i],Integer.parseInt(enterCollectables[i+1]));
		if(yourCollectings.get(enterCollectables[i])>=250) {
			switch(enterCollectables[i].toLowerCase()) {
			case "shards": 
				printItemAndRest(yourCollectings,enterCollectables,i,"Shadowmourne");
				break outerForLoop;
				
			case "fragments":
				printItemAndRest(yourCollectings,enterCollectables,i,"Valanyr");
				
			break outerForLoop;
			case "motes":
				printItemAndRest(yourCollectings,enterCollectables,i,"DragonWarth");
				break outerForLoop;
			}
		}
	}
	
}

static void printItemAndRest(HashMap<String,Integer> yourCollectings,String[] enterCollectables,int i,String item) {
	System.out.println(item);
	if(yourCollectings.get(enterCollectables[i])>255) {
		yourCollectings.put(enterCollectables[i],yourCollectings.get(enterCollectables[i])-250);
		for(Entry<String,Integer> entry:yourCollectings.entrySet()) {
			System.out.println(entry.getKey()+" ->"+entry.getValue());
		}
	}else {
		yourCollectings.put(enterCollectables[i], 0);
		for(Entry<String,Integer> entry:yourCollectings.entrySet()) {
			System.out.println(entry.getKey()+" ->"+entry.getValue());
		}
	}
}

static void products() {
	HashMap<String,int[]> products = new HashMap<String, int[]>();
	String enter;
	String[] enteredData;
	int[] priceAndQuantity = new int[2];
	do {
		enter= scan.nextLine();
		enteredData = enter.split(" ");
		priceAndQuantity[0] = Integer.parseInt(enteredData[1]);
		priceAndQuantity[1] = Integer.parseInt(enteredData[2]);
		
		if(products.get(enteredData[0])==null) {
			products.put(enteredData[0],priceAndQuantity);
		}else {
			int[] temp = products.get(enteredData[0]);
			temp[0]+=priceAndQuantity[0];
			temp[1]+=priceAndQuantity[1];
			products.put(enteredData[0],temp);
			
		}
		
	}while(!enter.equalsIgnoreCase("buy"));
	
	
	for(Entry<String,int[]> entry: products.entrySet()) {
		int total;
		int[] temp = entry.getValue();
		total=temp[0]+temp[1];
		System.out.println(entry.getKey()+": "+total);
	}
	
}

static void softuniParkingLot() {
	HashMap<String,String> users = new HashMap<String,String>();
	int numberCommands = Integer.parseInt(scan.nextLine());
	String enterCommand;
	String[] data;
	while(numberCommands>=0) {
		enterCommand = scan.nextLine();
		data = enterCommand.split(" ");
		if(data.length<3) {
			if(!users.containsValue(data[1])) {
				System.out.println(data[1]+" is not present");
			}else{
				users.remove(data[1]);
			}
		}else {
			if(!users.containsKey(data[1])) {
				users.put(data[1], data[2]);
			}else {
				System.out.println(data[1]+" already registered!");
			}
		}
		numberCommands--;
	}
	
	for(Entry<String,String> entry: users.entrySet()) {
		System.out.println(entry.getKey()+" : "+entry.getValue());
	}
}

static void companyId() {
	String company;
	
	HashMap<String,ArrayList<String>> companyData = new HashMap<String,ArrayList<String>>();
	do {
		company = scan.nextLine();
		ArrayList<String> employesId;
		if(!company.equalsIgnoreCase("end")) {
			employesId  = new ArrayList<String>();
			if(companyData.get(company)==null) {
				companyData.put(company, employesId);
				employesId.add(scan.nextLine());
			}else {
				String enterId = scan.nextLine();
				if(companyData.get(company).contains(enterId)) {
					
				}else {
					employesId.add(enterId);
					companyData.put(company,employesId);
				}
			}
		}
		
		
	}while(!company.equalsIgnoreCase("end"));
	
	for(Entry<String,ArrayList<String>> entry: companyData.entrySet()) {
		System.out.println(entry.getKey()+" "+entry.getValue());
	}
}

static void forceUsers() {
	HashMap<String,ArrayList<String>> forceUserData = new HashMap<String,ArrayList<String>>();
	String enter;
	ArrayList<String> forceUsers;
	String addUser;
	String addForce;
	do {
		enter = scan.nextLine();
		
		if(!enter.equalsIgnoreCase("lumparawoo")) {
			if(enter.equalsIgnoreCase("dark")|| enter.equalsIgnoreCase("light")) {
				if(forceUserData.get(enter)==null) {
					forceUserData.put(enter, forceUsers = new ArrayList<String>());
					forceUsers.add(scan.nextLine());
				}else {
					addUser = scan.nextLine();
					if(forceUserData.get(enter).contains(addUser)) {
						
					}else {
						forceUserData.get(enter).add(addUser);
					}
				}
			}else {
				addForce = scan.nextLine();
				if(!forceUserData.get(addForce).contains(enter)) {
					forceUserData.get(addForce).add(enter);
				}else {
					if(addForce.equalsIgnoreCase("dark") && forceUserData.get("Light").contains(enter)) {
						forceUserData.get("Light").remove(enter);
						forceUserData.get(addForce).add(enter);
					}else {
						forceUserData.get("Dark").remove(enter);
						forceUserData.get(addForce).add(enter);
					}
				}
			}
			
		}
	}while(!enter.equalsIgnoreCase("lumpawaroo"));
	
	for(Entry<String,ArrayList<String>>entry: forceUserData.entrySet()) {
		ArrayList<String> temp = entry.getValue();
		System.out.print(entry.getKey()+" ->");
		for(String p:temp) {
			System.out.print(p+", ");
			
		}
	}
}

static void studentGrades() {
	int number = Integer.parseInt(scan.nextLine());
	HashMap<String,ArrayList<Double>> studentInfo = new HashMap<String,ArrayList<Double>>();
	String name;
	ArrayList<Double> grades;
	while(number>=0) {
		name = scan.nextLine();
		if(studentInfo.get(name)==null) {
			studentInfo.put(name, grades = new ArrayList<Double>());
		}
		studentInfo.get(name).add(Double.parseDouble(scan.nextLine()));
		number--;
	}
	
	for(Entry<String,ArrayList<Double>> entry:studentInfo.entrySet()) {
		
		double average =studentInfo.get(entry.getKey()).stream().mapToDouble(Double::doubleValue).average().getAsDouble();
		System.out.println(entry.getKey()+" "+average);
		
	}
}


static void rankingExams() {
	HashMap<String,String> contestData = new HashMap<String,String>();
	
	String enterContests;
	String[] getContestAndPass;
	do {
		enterContests = scan.nextLine();
		if(!enterContests.equalsIgnoreCase("end of constests")) {
			getContestAndPass = enterContests.split(":");
			contestData.put(getContestAndPass[0], getContestAndPass[1]);
		}
		
	}while(!enterContests.equalsIgnoreCase("end of contests"));
	
	
	String enterContestantSubmisions;
	String[] contestantSubmisionsData;
	HashMap<String,Integer> userData = new HashMap<String,Integer>();
	
	do {
		enterContestantSubmisions = scan.nextLine();
		if(!enterContestantSubmisions.equalsIgnoreCase("end of submisions")) {
			contestantSubmisionsData = enterContestantSubmisions.split("=>");
			enterUserSubmisionsInMap(contestantSubmisionsData,contestData,userData);
			
		}
	}while(!enterContestantSubmisions.equalsIgnoreCase("end of submisions"));
	System.out.println();
	System.out.println("Best Canddate: "+displayBestCandidate(userData));
	System.out.println("Rest of the ranking");
	for(Entry<String,Integer> entry:userData.entrySet()) {
		System.out.println(entry.getKey()+" "+entry.getValue());
	}
	
}

static void enterUserSubmisionsInMap(String[] submisionData, HashMap<String,String> contests,HashMap<String,Integer> userMap ) {
	if(contests.containsKey(submisionData[0])) {
		if(contests.get(submisionData[0]).equalsIgnoreCase(submisionData[1])) {
			if(userMap.get(submisionData[2])==null) {
				userMap.put(submisionData[2], Integer.parseInt(submisionData[3]));
			}else {
				if(Integer.parseInt(submisionData[3])>userMap.get(submisionData[2])) {
					userMap.put(submisionData[2], Integer.parseInt(submisionData[3]));
				}
			}
		}
	}
}

static String displayBestCandidate(HashMap<String,Integer> map) {
	   Optional<Entry<String, Integer>> maxEntry = map.entrySet()
		        .stream().max((Entry<String,Integer> a,Entry<String,Integer> b)->Integer.compare(a.getValue(), b.getValue()));
	   String bestCandidate = maxEntry.toString();
	   map.remove(maxEntry);
	   return bestCandidate;
}








//---------------------------------
static void judgeSystemPoints() {
	String enter;
	String contest;
	String username;
	String[] temp;
	int points;
	HashMap<String,Integer> userData = new HashMap<String,Integer>();
	HashMap<String,HashMap<String,Integer>> contestsAndContestants = new HashMap<String,HashMap<String,Integer> >();
	
	
	do {
		enter = scan.nextLine();
		if(!enter.equalsIgnoreCase("no more time")) {
			temp = enter.split("->");
			username = temp[0];
			contest = temp[1];
			points = Integer.parseInt(temp[2]);
			if(contestsAndContestants.get(contest)==null) {
				contestsAndContestants.put(contest,new HashMap<String,Integer>());
				contestsAndContestants.get(contest).put(username,points);
			}else {
				if(contestsAndContestants.get(contest).get(username)<points) {
					contestsAndContestants.get(contest).put(username,points);
				}
			}
		}
	}while(enter.equalsIgnoreCase("no more time"));
	addAllPointsToContestants(userData,contestsAndContestants);
	for(Entry<String,Integer> entry:userData.entrySet()) {
		System.out.println(entry.getKey()+" "+entry.getValue());
	}
	
}
static void addAllPointsToContestants(HashMap<String,Integer> userData, HashMap<String,HashMap<String,Integer>> contestsData) {
	
	for(Entry<String,HashMap<String,Integer>>entry: contestsData.entrySet()) {
		String contestant;
		int currentPoints = 0;
		for(Entry<String,Integer> entryContestantsPoint:entry.getValue().entrySet()) {
			contestant = entryContestantsPoint.getKey();
			currentPoints = entryContestantsPoint.getValue();
			userData.put(contestant, currentPoints);
		}
	}
	
}
//---------------------------------------------



static void leagueOfLengends() {
	String enter;
	
	String[] extractData;
	HashMap<String,HashMap<String,Integer>> playerInfo = new HashMap<String,HashMap<String,Integer>>();
	ArrayList<String> positionsEnteredDuringRuntime = new ArrayList<String>();
	
	
	
	
	//entering part and action part
	do {
		enter = scan.nextLine();
		if(!enter.equalsIgnoreCase("season is over")) {
			extractData = enter.split("->");
			if(playerInfo.get(extractData[0])==null) {
				playerInfo.put(extractData[0],new HashMap<String,Integer>());
				playerInfo.get(extractData[0]).put(extractData[1], Integer.parseInt(extractData[2]));
			}else {
				if(Integer.parseInt(extractData[2])>playerInfo.get(extractData[0]).get(extractData[1])) {
					playerInfo.get(extractData[0]).put(extractData[1], Integer.parseInt(extractData[2]));
				}
			}
			
			if(!positionsEnteredDuringRuntime.contains(extractData[1])) {
				positionsEnteredDuringRuntime.add(extractData[1]);
			}
			
			
		}else if(!enter.equalsIgnoreCase("season is over") && enter.contains("vs")) {
			extractData = enter.split("vs");
			commenseBattle(playerInfo,extractData[0],extractData[1],positionsEnteredDuringRuntime);
		}
	}while(!enter.equalsIgnoreCase("season is over"));
	
	
	
	
	
	//sorting part
	
 playerInfo.entrySet().stream().sorted(Map.Entry.comparingByKey());
 for(Entry<String,HashMap<String,Integer>> entry:playerInfo.entrySet()) {
	 playerInfo.get(entry.getKey()).entrySet().stream().sorted((a,b)-> Integer.compare(b.getValue(), a.getValue()));
 }
 
 
 for(Entry<String,HashMap<String,Integer>> entry: playerInfo.entrySet()) {
	 System.out.println(entry.getKey());		//put new map with players and points total like the previous one. and sort only one map i think
 }	
}

//method for battle between two players
static void commenseBattle(HashMap<String,HashMap<String,Integer>> map,String player1,String player2,ArrayList<String> list) {
	
	while(list.size()>0) {
		if(map.get(player1).containsKey(list.get(0)) && map.get(player2).containsKey(list.get(0))) {
			if(map.get(player1).get(list.get(0))>map.get(player2).get(list.get(0))) {
				map.remove(player2);
				list.remove(0);
				break;
			}else if(map.get(player1).get(list.get(0))<map.get(player2).get(list.get(0))) {
				map.remove(player1);
				list.remove(0);
				break;
			}
		}
	}
}













static void dragonStatManager() {
	String enterDragons;
	int numberDragons = Integer.parseInt(scan.nextLine());
	String[] extractData;
	ArrayList<Integer> dragonStats = new ArrayList<Integer>();
	HashMap<String,HashMap<String,ArrayList<Integer>>> dragonInfo = new HashMap<>();
	
	do {
		enterDragons = scan.nextLine();
		extractData = enterDragons.split(" ");
		
		if(dragonInfo.get(extractData[0])==null) {
			fillDragonInfo(extractData,dragonStats,dragonInfo);
		}else {
			fillDragonInfo(extractData,dragonStats,dragonInfo);
		}
		numberDragons--;
	}while(numberDragons>=0);
	
	displayStats(dragonInfo);
	
	
}


static void fillDragonInfo(String[] extractData,ArrayList<Integer> dragonStats,HashMap<String,HashMap<String,ArrayList<Integer>>> dragonInfo) {
	switch(extractData.length) {
	case 4:
		dragonStats.add(Integer.parseInt(extractData[2]));
		dragonStats.add(Integer.parseInt(extractData[3]));
		dragonStats.add(null);
		break;
	case 3:
		dragonStats.add(Integer.parseInt(extractData[2]));
		dragonStats.add(null);
		dragonStats.add(null);
		break;
		
		default:
			dragonStats.add(null);
			dragonStats.add(null);
			dragonStats.add(null);
			break;
	}
	dragonInfo.put(extractData[0],new HashMap<String,ArrayList<Integer>>());
	dragonInfo.get(extractData[0]).put(extractData[1], dragonStats);
	
}

static void displayStats(HashMap<String,HashMap<String,ArrayList<Integer>>> dragonInfo){
	ArrayList<Integer> dragonStats = new ArrayList<Integer>();
	
	for(Entry<String,HashMap<String,ArrayList<Integer>>> entry: dragonInfo.entrySet()) {
		for(Entry<String, ArrayList<Integer>> innerEntry: entry.getValue().entrySet()) {
			
			dragonStats.addAll(innerEntry.getValue());
			System.out.println("Damage"+" |"+" Health"+" |"+" Armour");
			for(Integer stat: dragonStats) {
				System.out.print(stat+"  ");
			}
		}
	}
}
	
}




import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.javafx.webkit.KeyCodeMap.Entry;

public class RegualarExpresions {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//fullNames();
		//phoneNumbers();
		//dates();
		//furniture();
		//racer();
		//softuniBar();
		//mailExtract();
		//starDecryptionStarWars();
		//starDecryptionStarWars()
		//
		
	}
	
	
	static void netherRealm() {
		String enter = scan.nextLine();
		ArrayList<String> allNames = new ArrayList<String>();
		Pattern enterNamesPattern = Pattern.compile("[a-zA-Z0-9*/]+");
		Matcher enterNamesMatcher = enterNamesPattern.matcher(enter);
		while(enterNamesMatcher.find()) {
			allNames.add(enterNamesMatcher.group());
		}
		
		String name;
		int health;
		double baseDamage;
		double[] damageAndHealth = new double[2];
		
		TreeMap<String,double[]> demonStats = new TreeMap<String,double[]>();
		for(int i =0;i<allNames.size();i++) {
			name = enter;
			if(demonStats.get(name)==null) {
				if(getDemonHealth(allNames.get(i))==0) {
					continue;
				}else {
					damageAndHealth[0]=getDemonHealth(allNames.get(i));
					damageAndHealth[1]=getDemonBaseDamage(allNames.get(i));
					demonStats.put(enter,damageAndHealth);
					
				}
			}
		}
		
		double[] getCurrentStats;
		for(java.util.Map.Entry<String, double[]> entry:demonStats.entrySet()) {
			getCurrentStats=entry.getValue();
			System.out.println(entry.getKey()+" health -> "+getCurrentStats[0]+" damage-> "+getCurrentStats[1]);
		}
		
	}
	
	static int getDemonHealth(String name) {
		int health=0;
		boolean found= false;
		String regex = "[a-zA-Z]";
		Pattern healthPattern = Pattern.compile(regex);
		Matcher healthMatch ;
		
			healthMatch = healthPattern.matcher(name);
			while(healthMatch.find()) {
				found=true;
				char c = healthMatch.group().charAt(0);
				health+=c;
			
		}
			if(found==false) {
				return 0;
			}
		
		
		return health;
		
	}
	static double getDemonBaseDamage(String enter) {
		boolean found = false;
		double damage=0;
		String getNumbers = "[-]*[0-9]+.[0-9]+|[-]*[0-9]+";
		Pattern numbers = Pattern.compile(getNumbers);
		Matcher numbersMatcher;
		
			 numbersMatcher = numbers.matcher(enter);
			 while(numbersMatcher.find()) {
				 found=true;
					damage+=Double.parseDouble(numbersMatcher.group());
				}
			 if(found==false) {
				 return 0;
			 }
		
		
		String multiplyOrDivide = "[\\*|\\/]";
		Pattern additionalOperationsPattern = Pattern.compile(multiplyOrDivide);
		Matcher aditionalMatcher;
		
			aditionalMatcher = additionalOperationsPattern.matcher(enter);
			while(aditionalMatcher.find()) {
				if(aditionalMatcher.group().contentEquals("*")) {
					damage*=2;
				}else {
					damage/=2;
				}
			
		}
		
		
		return damage;
	}
	
	
	static void starDecryptionStarWars() {
		int numberMessages = Integer.parseInt(scan.nextLine());
		String enterMessage;
		ArrayList<String> dataReceived = new ArrayList<String>();
		while(numberMessages>0) {
			String receiveCodeStar;
			enterMessage = scan.nextLine();
			Pattern star = Pattern.compile("[s,t,a,r,S,T,A,R]+");
			Matcher starMatch  = star.matcher(enterMessage);
			while(starMatch.find()) {
				receiveCodeStar = starMatch.group();
				dataReceived.add(transformMessage(enterMessage,receiveCodeStar));
			}
			numberMessages--;
		}
		
		for(int i =0;i<dataReceived.size();i++) {
			//do regex to find each group data and print statistics
			System.out.println(dataReceived.get(i));
		}
	}
	
	static String transformMessage(String message, String code) {
		int decreaseValue=0;
		for(int i =0;i<code.toCharArray().length;i++){
			decreaseValue+=i;
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<message.toCharArray().length;i++) {
			i-=decreaseValue;
			sb.append(i);
		}
		return sb.toString();
		
	}
	
	static void emailExtrat() {
		String enter=scan.nextLine();
		String regex = "\\b[A-Za-z]+[\\.\\-\\_]*[0-9]*[\\.\\-\\_]*@[a-z]+.[a-z]+";
		Pattern emailPattern = Pattern.compile(regex);
		Matcher matcherMail = emailPattern.matcher(enter);
		while(matcherMail.find()) {
			System.out.println(matcherMail.group());
		}
		
	}
	
	
	static void softuniBar() {
		
		String enterOrder;
		HashMap<String,Integer> customers = new HashMap<String,Integer>();
		do {
			enterOrder =scan.nextLine();
			addCustomerData(customers,enterOrder);
		}while(!enterOrder.equalsIgnoreCase("end of shift"));
		System.out.println();
		 for(java.util.Map.Entry<String, Integer> entry:customers.entrySet()) {
			 System.out.println(entry.getKey()+" "+entry.getValue());
		 }
	}
	
	static void addCustomerData(HashMap<String,Integer> map,String enteredData) {
		String regex ="%(?<name>[A-Z][a-z]+)%<(?<product>[a-zA-Z]+)>(?<separator>[^\\|\\$\\.])*\\|(?<count>[0-9]+)\\|[^\\|\\$\\.]*[0-9]+\\$";
		Pattern customerPattern =  Pattern.compile(regex);
		Matcher customerMatcher = customerPattern.matcher(enteredData);
		int count;
		int price;
		if(customerMatcher.find()) {
			
				count = Integer.parseInt(customerMatcher.group("quantity"));
				price = Integer.parseInt(customerMatcher.group("price"));
				map.put(customerMatcher.group("name"),count*price);
		}
		
	}
	
	static void fullNames() {
		String regex = "([A-Z][a-z]+) ([A-Z][a-z]+)";
		String enterNames = scan.nextLine();
		Pattern p = Pattern.compile(regex);
		Matcher m  = p.matcher(enterNames);
		while(m.find()) {
			System.out.println(m.group()+" ");
		}
	}
	
	static void phoneNumber() {
		String regex = "(\\+[359]{3})([\\s|\\-])([2])\\2[0-9]{3}\\2[0-9]{4}";
		String enterNumbers = scan.nextLine();
		Pattern p = Pattern.compile(regex);
		Matcher m  = p.matcher(enterNumbers);
		while(m.find()) {
			System.out.println(m.group(0)+",");
		}
		
	}
	
	static void dates() {
		String regex = "\\d{2}([\\-|\\.|\\|])\\d{2}\\1\\d{4}";
		String enterDates = scan.nextLine();
		Pattern p = Pattern.compile(regex);
		Matcher m  = p.matcher(enterDates);
		while(m.find()) {
			System.out.printf("%s\n",m.group());
		}
	}

	
	static void furniture() {
		String regex = ">>(?<name>[a-zA-Z]+)<<(?<price>[-+]?[0-9]*\\.?[0-9]*)!(?<quantity>[0-9]+)";
		String enter = scan.nextLine();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(enter);
		while(m.find()) {
			System.out.println("Bought: "+ m.group("name"));
			
		}
		
		
		
	}
	
	static void racer() {
		String enterNames= scan.nextLine();
		String enterData;
		ArrayList<String> racerData = new ArrayList<String>(enterNames.split(",").length);
		do {
			enterData = scan.nextLine();
			racerData.add(enterData);
		}while(!enterData.equalsIgnoreCase("end race"));
		
		sortAndDecryptRacers(racerData);
		
		for(int i =0;i<3;i++) {
			System.out.println((i+1)+" place "+racerData.get(i));
		}
		
	}
	
	static void sortAndDecryptRacers(ArrayList<String> racers) {
		Pattern racerName = Pattern.compile("[a-zA-Z]");
		Pattern racerStats = Pattern.compile("[0-9]");
		Matcher racerNameMatcher;
		Matcher racerStatsMatcher;
		double km;
		String name;
		for(int i =0;i<racers.size();i++) {
			 racerNameMatcher = racerName.matcher(racers.get(i));
			 racerStatsMatcher = racerStats.matcher(racers.get(i));
			 if(racerNameMatcher.find()) {
				 if(racerStatsMatcher.find()) {
					 name = racerNameMatcher.group();
					 km = Double.parseDouble(racerStatsMatcher.group());
					 addRacerData(km,name,racers);
				 }
			 }
		}
		
	}
	
	static void addRacerData(double km,String name, ArrayList<String> racers) {
		String racerNameStat;
		double max=0;
		if(racers.size()==0) {
			max = km;
			racerNameStat = name+" "+String.valueOf(km);
		}else  {
			if(km>max) {
				racerNameStat = name+" "+String.valueOf(km);
				
			}else if(km<max) {
				String[] splitedData;
				double temp;
				for(int i =1;i<=racers.size();i++) {
					splitedData = racers.get(i).split(" ");
					temp = Double.parseDouble(splitedData[1]);
					if(km>temp) {
						racerNameStat = name+" "+String.valueOf(km);
						racers.add(i,racerNameStat);
					}
				}
			}
		}
	}
}

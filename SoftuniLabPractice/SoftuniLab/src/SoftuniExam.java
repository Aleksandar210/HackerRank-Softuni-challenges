import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.function.Predicate;
import softuni_objectsandclasses_folder.GroupHuntingGame;

public class SoftuniExam {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//concert();
		//songEncryption();
		//ttRacer();
	}
	
	
	
	static void huntingGames() {
		System.out.print("Enter number of days: ");
		int days = range(0,100,Integer.parseInt(scan.nextLine()));
		System.out.print("Enter number players: ");
		int players = range(0,1000,Integer.parseInt(scan.nextLine()));
		System.out.print("Enter energy: ");
		double energy = range(0.0,1000.00,Double.parseDouble(scan.nextLine()));
		System.out.print("Enter water: ");
		double water = range(0.0,1000.00,Double.parseDouble(scan.nextLine()));
		System.out.print("Enter food: ");
		double food = range(0.0,1000.00,Double.parseDouble(scan.nextLine()));
		System.out.print("Enter group name: ");
		String name = scan.nextLine();
		GroupHuntingGame group = new GroupHuntingGame(name,players,food,water,energy);
		for(int i =0;i<days;i++) {
			energyCalculations(group,i);
		}
		
		group.checkGroupSurvival();
		group.displayGroupData();
	}
	
	
	static void energyCalculations(GroupHuntingGame group, int day) {
		double choppingWood = Double.parseDouble(scan.nextLine());
		if(day%2==0) {
			group.decreaseEnergy(choppingWood);
			addPercentage(5,group.getEnergy(),group);
			substractPercentage(30,group.getEnergy(),group);
		}else if(day%3==0) {
			group.decreaseEnergy(choppingWood);
			group.decreaseFoodSupply(group.getPlayerCount());
			addPercentage(10,group.getEnergy(),group);
		}else {
			group.decreaseEnergy(choppingWood);
		}
		
	}
	
	
	static void addPercentage(double percentage, double value,GroupHuntingGame group) {
		double add = (percentage/100)*value;
		group.increaseEnergy(add);
	}
	
	static void substractPercentage(double percentage, double value, GroupHuntingGame group) {
		double add = (percentage/100)*value;
		group.increaseEnergy(add);
	}
	
	
	//input range
	//--------------------------------------------------------------------
	static int range(int start, int finish, int number) {
		Predicate<Integer> range = a -> a<=finish || a>=start;
		if(range.test(number)) {
			return number;
		}else {
			System.out.println("Invalid  range of value.");
			System.out.print("try again: ");
			return range(start,finish,Integer.parseInt(scan.nextLine()));
		}
	}
	
	static double range(double start,double finish,double number) {
		Predicate<Double> range = a -> a<=finish || a>=start;
		if(range.test(number)) {
			return number;
		}else {
			System.out.println("Invalid  range of value.");
			System.out.print("try again: ");
			return range(start,finish,Double.parseDouble(scan.nextLine()));
		}
	}
	
	//-----------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	static void ttRacer() {
		Pattern racerPattern= Pattern.compile("([\\#\\$\\%\\&])(?<name>[A-Za-z]+)\\1=(?<length>[0-9]+)!![\\w\\W\\d\\D]+[!!]*");
		Matcher racerMatcher;
		//input
		ArrayList<String> foundRacers = new ArrayList<String>();
		StringBuilder sb;
		String enterCoordinates;
		do {
			
			enterCoordinates = scan.nextLine();
			racerMatcher = racerPattern.matcher(enterCoordinates);
			if(!enterCoordinates.equalsIgnoreCase("stop") &&racerMatcher.find()) {
				String geonoCode= racerMatcher.group().substring(racerMatcher.group().indexOf("!!")+2,racerMatcher.group().lastIndexOf("!!"));
				
				if(Integer.valueOf(racerMatcher.group("length"))==geonoCode.length()) {
					sb = new StringBuilder(geonoCode);
					decryptData(Integer.valueOf(racerMatcher.group("length")),sb);
					foundRacers.add(racerMatcher.group("name")+"->"+sb.toString());
				}else {
					
				}
				
			}
			
		}while(!enterCoordinates.equalsIgnoreCase("stop"));
	}
	
	
	
	
	static void decryptData( int length,StringBuilder currentEntered) {
		int indexChar;
		for(int i =0;i<currentEntered.capacity();i++) {
		if(Integer.valueOf(currentEntered.charAt(i))+length>90 ) {
			
			 indexChar = Integer.valueOf(currentEntered.charAt(i))+length-90;
			indexChar+=65;
			currentEntered.setCharAt(i, (char)indexChar);
			}else if(Integer.valueOf(currentEntered.charAt(i))+length>122) {
				indexChar = Integer.valueOf(currentEntered.charAt(i))+length-122;
				indexChar+=97;
				currentEntered.setCharAt(i, (char)indexChar);
			}else {
				indexChar = Integer.valueOf(currentEntered.charAt(i))+length;
				currentEntered.setCharAt(i, (char)indexChar);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static void songEncryption() {
		ArrayList<String> listWithSongsEncrypted = new ArrayList<String>();
		String regex = "(?<ArtistName>([A-Z][a-z\\'\\s]+)|([A-Z][a-z]+\\s[A-Za-z]+)):(?<SongName>[A-Z\\s]+)";
		Matcher regexMatcher;
		Pattern regexPattern = Pattern.compile(regex);
		String enterArtistAndSong;
		
		int indexChar;
		
		StringBuilder currentEntered;
		do {
			enterArtistAndSong = scan.nextLine();
			
			regexMatcher = regexPattern.matcher(enterArtistAndSong);
			
			if(!enterArtistAndSong.equalsIgnoreCase("end")&&regexMatcher.find()) {
				
				enterArtistAndSong.replace(":", "@");
				currentEntered = new StringBuilder(enterArtistAndSong);
				
				for(int i =0;i<enterArtistAndSong.length();i++) {
					if(Character.isAlphabetic(enterArtistAndSong.charAt(i))) {
						if(Integer.valueOf(enterArtistAndSong.charAt(i))+enterArtistAndSong.length()>90 ) {
							
						 indexChar = Integer.valueOf(enterArtistAndSong.charAt(i))+enterArtistAndSong.length()-90;
						indexChar+=65;
						currentEntered.setCharAt(i, (char)indexChar);
						}else if(Integer.valueOf(enterArtistAndSong.charAt(i))+enterArtistAndSong.length()>122) {
							indexChar = Integer.valueOf(enterArtistAndSong.charAt(i))+enterArtistAndSong.length()-122;
							indexChar+=97;
							currentEntered.setCharAt(i, (char)indexChar);
						}else {
							indexChar = Integer.valueOf(enterArtistAndSong.charAt(i))+enterArtistAndSong.length();
							currentEntered.setCharAt(i, (char)indexChar);
						}
						listWithSongsEncrypted.add(currentEntered.toString());
					}
				}
			}
		}while(!enterArtistAndSong.equalsIgnoreCase("end"));
		
		System.out.println(" ");
		System.out.println("Encrypted songs");
		for(String song: listWithSongsEncrypted) {
			System.out.println(song);
		}
	}
	
	
	
	
	
	
	
	
	static void concert() {
		String enter;
		String[] dataCollectedFromInput;
		ArrayList<String> people = new ArrayList<String>();
		HashMap<String,Integer> bandAndPlays = new HashMap<String,Integer>();
	    HashMap<String,ArrayList<String>> bands = new HashMap<String,ArrayList<String>>();
		int totalTimePlayedOnConcert=0;
		do {
			enter = scan.nextLine();
			if(!enter.equalsIgnoreCase("start concert")) {
				dataCollectedFromInput = enter.split(": ");
				if(dataCollectedFromInput[0].equalsIgnoreCase("add")) {
					addMembersToConcer(dataCollectedFromInput,people,bands);
				}else {
					bandAndPlays.put(dataCollectedFromInput[1],Integer.parseInt(dataCollectedFromInput[2]));
				}
			}
			
		}while(!enter.equalsIgnoreCase("start concert"));
		String bandToShowMembers = scan.nextLine();
		totalTimePlayedOnConcert = totalPlays(bandAndPlays);
		System.out.println("Total time: "+totalTimePlayedOnConcert);
		for(Entry<String,Integer>entry:bandAndPlays.entrySet()) {
			System.out.println(entry.getKey()+" ->"+entry.getValue());
			
		}
		for(int i =0;i<bands.get(bandToShowMembers).size();i++) {
			System.out.println("=>"+bands.get(bandToShowMembers).get(i));
		}
		
		
	}
	
	static void addMembersToConcer(String[] data,ArrayList<String> members ,HashMap<String,ArrayList<String>> map){
		if(map.get(data[1])==null) {
			map.put(data[1],transferDataFromTo(data,members));
		}else {
			map.put(data[1],transferNonDuplicateData(data,members,map));
		}
	}
	
	
	//this method is used only if the map returns null upon band add.
	static ArrayList<String> transferDataFromTo(String[] data, ArrayList<String> members) {
		for(int i =2;i<=data.length;i++) {
			members.add(data[i]);
		}
		return members;
	}
	
	static  ArrayList<String> transferNonDuplicateData(String[] data,ArrayList<String>members,HashMap<String,ArrayList<String>>map){
		members = transferDataFromTo(data,members);
		ArrayList<String> temp;
		for(Entry<String,ArrayList<String>> entry:map.entrySet()) {
			temp = entry.getValue();
			Collections.sort(temp);
			Collections.sort(members);
			for(int i =0;i<members.size();i++) {
				if(members.get(i).contains(temp.get(i))) {
					members.remove(i);
				}
			}
		}
		
		return members;
		
	}
	
	static int totalPlays(HashMap<String,Integer> map) {
		int total=0;
		for(Entry<String,Integer> entry:map.entrySet()) {
			total+=entry.getValue();
		}
		
		return total;
	}
	
	
}

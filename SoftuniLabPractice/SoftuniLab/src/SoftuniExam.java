import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class SoftuniExam {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//concert();
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

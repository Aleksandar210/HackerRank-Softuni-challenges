import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import java.util.stream.Collectors;
public class SoftuniLists {
	static Scanner scan  = new Scanner(System.in);
	public static void main(String[] args) {
		//sumDuplicates();
		
		
	}
	
	
	
	//1
	//------------------------------------------
	//task sumDuplicates and remove them
	static void sumDuplicates() {
		String enterNumbers = scan.nextLine();
		List<Integer> numbers = Arrays.stream(enterNumbers.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
		
		boolean hasDuplicates = checkForDuplicates(numbers);
		
		while(hasDuplicates) {
			sumDuplicatesNumbers(numbers);
			hasDuplicates = checkForDuplicates(numbers);
		}
		
		System.out.println(numbers);
		
		
	}
	//the main method call for the task
	static void sumDuplicatesNumbers(List<Integer> numbers) {
		int sum=0;
		int currentFirstNumber = numbers.get(0);
		String numbersToDelete = "";
		for(int i =1;i<=numbers.size();i++) {
			if(numbers.get(i)==currentFirstNumber) {
				sum+=numbers.get(i);
				numbersToDelete+=String.valueOf(i);
			}
		}
		deleteDuplicateNumbers(numbers,numbersToDelete);
		numbers.add(0,sum);
		
		
		
	}
	

	
	
	//deletes the numbers that are positioned on the indexes presented in the string var
	static void deleteDuplicateNumbers(List<Integer> numbers, String numberIndexes) {
		int[] indexes = Arrays.stream(numberIndexes.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
		for(int i =0;i<indexes.length;i++) {
			numbers.remove(indexes[i]);
		}
	}
	
	
	
	//returns true if there are duplicates numbers
	static boolean checkForDuplicates(List<Integer> numbers) {
		boolean hasDuplicates = false;
		int current = numbers.get(0);
		for(int num:numbers) {
			if(numbers.get(num)==current) {
				hasDuplicates = true;
			}
		}
		return hasDuplicates;
	}
	
	//2
	//gaussNumbers task
	//------------------------------------------------------------------------
	
	static void gaussTrick() {
		String enterLine = scan.nextLine();
		ArrayList<Integer> numbers = parseLineList(enterLine);
		ArrayList<Integer> gaussNumbers= calculateGaussNumbers(numbers);
		
		for(int num:gaussNumbers) {
			System.out.println(gaussNumbers.get(num));
		}
		
	}
	
	static ArrayList<Integer> calculateGaussNumbers(ArrayList<Integer> numbers){
		ArrayList<Integer> gausNumbers = new ArrayList<Integer>();
		
		for(int i =0;i<numbers.size()/2;i++) {
			int first = numbers.get(i)+i;
			int last = numbers.get(numbers.size()-1)-i;
			int currentSum;
			currentSum =  first+last;
			gausNumbers.add(currentSum);
		}
		if(numbers.size()/2!=0) {
			gausNumbers.add(numbers.get(numbers.size()/2));
		}
		
		return gausNumbers;
	}
	
	
	//-----------------------------------------------------------------------------
	
	
	
	
	//3
	//unite two lists
	//-------------------------------------------------------------------------------
	static void uniteTwoLists() {
		String enterLine1 = scan.nextLine();
		ArrayList<Integer> list1 = parseLineList(enterLine1);
		
		String enterLine2 = scan.nextLine();
		ArrayList<Integer> list2 = parseLineList(enterLine2);
		
		ArrayList<Integer> unitedList = new ArrayList<Integer>(list1.size()+list2.size());
		if(list1.size()<list2.size()) {
			uniteLists(list1,list2,unitedList);
		}else {
			uniteLists(list2,list1,unitedList);
		}
		
	}
	
	static void uniteLists(ArrayList<Integer> shorterList, ArrayList<Integer> longerList, ArrayList<Integer> listToUnite) {
		for(int i =0;i<shorterList.size();i++) {
			listToUnite.add(longerList.get(i));
			listToUnite.add(shorterList.get(i));
		}
		
		for(int i=shorterList.size();i<=longerList.size();i++) {
			listToUnite.add(longerList.get(i));
		}
		
	}
	
	
	//-------------------------------------------------------------------------------
	
	
	//4
	//list of products
	//-------------------------------------------------------------------------
	static void listOfProducts() {
		int numberOfProducts = Integer.parseInt(scan.nextLine());
		
		ArrayList<String> products = new ArrayList<String>();
		int count=0;
		while(count<numberOfProducts) {
			String enter = scan.nextLine();
			String cap = enter.substring(0, 1).toUpperCase() + enter.substring(1);
			products.add(cap);
			
		}
		
		Collections.sort(products);
		
		for(int i =0;i<products.size();i++) {
			System.out.println((1+i)+" "+products.get(i));
		}
		
	}
	//-----------------------------------------------------------------------------
	
	
	//5
	//listOfCommands
	//--------------------------------------------------------------------------
	static void listCommands() {
		String enter = scan.nextLine();
		ArrayList<Integer> numbers = parseLineList(enter);
		
		String enterCommand;	
		do {
			enterCommand = scan.nextLine();
			executeCommand(enterCommand,numbers);
		}while(!(enterCommand.equalsIgnoreCase("end")));
	}
	
	static void executeCommand(String command,ArrayList<Integer> numbers) {
		
		String[] digits=command.split("\\D+");
		int[] intarray=new int[digits.length];
		for(int i=0;i<digits.length;i++){
		   intarray[i]=Integer.parseInt(digits[i]);
		}
		
		String letterCommand;
		letterCommand = "Word#$#$% Word 1234".replaceAll("[^A-Za-z]+", "");
		switch(letterCommand.toLowerCase()) {
		case "add": numbers.add(intarray[0]);
		break;
		case "remove": numbers.remove(Integer.valueOf(intarray[0]));
		break;
		case "removeat": numbers.remove(intarray[0]);
		break;
		case "insert": numbers.add(intarray[0],intarray[1]);
		}
	}
	//---------------------------------------------------------------------------
	
	//6
	//advancedCommands
	//----------------------------------------------------------------------------
	static void advancedCommands() {
		String enterNumbers = scan.nextLine();
		ArrayList<Integer> numbers = parseLineList(enterNumbers);
		
		String enterCommand="";
		do {
			enterCommand = scan.nextLine();
			executeCommands(enterCommand, numbers);
		}while(!(enterCommand.equalsIgnoreCase("end")));
		
	}
	
	static void executeCommands(String enteredCommand, ArrayList<Integer> numbers) {
		String[] data = enteredCommand.split(" ");
		
		String letterCommand;
		letterCommand = enteredCommand.replaceAll("[^A-Za-z]+", "");

		switch(letterCommand.toLowerCase()) {
		case "contains": if(numbers.contains(Integer.valueOf(data[1]))) {
			System.out.println("true");
		}else {
			System.out.println("value does not match");
		}
		break;
		case "print even":
			for(int i =0;i<numbers.size();i++) {
				if(numbers.get(i)%2==0) {
					System.out.print(" "+numbers.get(i));
				}
			}
			break;
		case "print odd":
			for(int i =0;i<numbers.size();i++) {
				if(numbers.get(i)%2!=0) {
					System.out.print(" "+numbers.get(i));
				}
			}
			break;
		case "filter":
			switch(data[1]) {
			case">=":
				for(int i =0;i<numbers.size();i++) {
					if(numbers.get(i)>=Integer.parseInt(data[2])) {
						System.out.print(" "+numbers.get(i));
					}
				}
				break;
				
				
			case">":
				for(int i =0;i<numbers.size();i++) {
					if(numbers.get(i)>Integer.parseInt(data[2])) {
						System.out.print(" "+numbers.get(i));
					}
				}
				break;
				
			case"<=":
				for(int i =0;i<numbers.size();i++) {
					if(numbers.get(i)<=Integer.parseInt(data[2])) {
						System.out.print(" "+numbers.get(i));
					}
				}
				break;
				
			case"<":
				for(int i =0;i<numbers.size();i++) {
					if(numbers.get(i)<Integer.parseInt(data[2])) {
						System.out.print(" "+numbers.get(i));
					}
				}
				break;
				
				
				
			}
			
			break;
			
		}
	}
	//---------------------------------------------------------------------------
	
	//7
	//removeNegative&Reverse
	//--------------------------------------------------------------------------
	static void removeAndReverse() {
		String enter = scan.nextLine();
		ArrayList<Integer> numbers = parseLineList(enter);
		Collections.sort(numbers);
		for(int i =0;i<numbers.size();i++) {
			if(numbers.get(i)<0) {
				numbers.remove(i);
			}
		}
		
		Collections.reverse(numbers);
		if(numbers.size()==0) {
			System.out.println("empty");
		}else {
		for(int num:numbers) {
			System.out.print(numbers.get(num)+" ");
		}
		}
	}
	
	
	
	//---------------------------------------------------------------------------
	
	//8
	//
	//-----------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------
	
	//9
		//
		//-----------------------------------------------------------------------------
		
		//-----------------------------------------------------------------------------
		
	
	
	//10
		//
		//-----------------------------------------------------------------------------
		
		//-----------------------------------------------------------------------------
		
	
	
	
	//11
		//
		//-----------------------------------------------------------------------------
		
		//-----------------------------------------------------------------------------
		
	
	//12
		//
		//-----------------------------------------------------------------------------
		
		//-----------------------------------------------------------------------------
		
	
	
	
	
	//tool function for adding line of strings into a list
	static ArrayList<Integer> parseLineList(String numbers){
		int[] numbersParsed = Arrays.stream(numbers.split(" ")).mapToInt(e ->Integer.parseInt(e)).toArray();
		ArrayList<Integer> listWithNumbers = new ArrayList<Integer>(numbersParsed.length);
		for(int num:numbersParsed) {
			int current = numbersParsed[num];
			listWithNumbers.add(current);
		}
		return listWithNumbers;
		
	}
}

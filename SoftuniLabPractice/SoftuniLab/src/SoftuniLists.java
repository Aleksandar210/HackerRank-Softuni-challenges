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
	//Train
	//-----------------------------------------------------------------------------
	static void trainWagons() {
		String enterWagons = scan.nextLine();
		ArrayList<Integer> wagons = parseLineList(enterWagons);
		int maxCapacity = Integer.parseInt(scan.nextLine());
		
		String enterCommands;
	
		do {
			enterCommands = scan.nextLine();
			if(enterCommands.toLowerCase().contains("add")) {
				addWagon(wagons, enterCommands);
			}else {
				
			}
		}while(!(enterCommands.equalsIgnoreCase("end")));
	}
	
	static void addWagon(ArrayList<Integer> wagons, String command) {
		String[] temp = command.split(" ");		//split the command into 2 parts
		
		wagons.add(Integer.parseInt(temp[1]));
	}
	
	static void fitPassangersInFreeWagons(String numberPassangers, ArrayList<Integer> wagons ) {
		int number = Integer.parseInt(numberPassangers);
		for(int i =0;i<wagons.size();i++) {
			if(wagons.get(i)<75) {
				if(number>wagons.get(i)) {
					int availableSpaces = 75-wagons.get(i);
					if(availableSpaces==0) {
						
					}else {
						wagons.set(i,(number-availableSpaces)+wagons.get(i));
						number-=(number-availableSpaces);
					}
					
				}else {
					int availableSpace = 75-wagons.get(i);
					if(availableSpace==0) {
						
					}else {
						wagons.set(i,wagons.get(i)-availableSpace);
						number-=number-availableSpace;
					}
					
				}
			}
			
		}
			
		
	}
	//-----------------------------------------------------------------------------
	
	//9
		//DeleteOccurences
		//-----------------------------------------------------------------------------
		static void deleteOccurences() {
			String enterElements =scan.nextLine();
			String enteredElements = enterElements;
			ArrayList<Integer> numbers = parseLineList(enteredElements);
			
			String givenCommand;
			do {
				givenCommand = scan.nextLine();
				executeCommandsList(givenCommand, numbers);
			}while(!(givenCommand).equalsIgnoreCase("end"));
		}
		
		static void executeCommandsList(String command, ArrayList<Integer> numbers) {
			String[] temp = command.split(" ");
			
			switch(temp[0].toLowerCase()) {
			case "inser":
				int element = Integer.valueOf(temp[1]);
				int position = Integer.valueOf(temp[2]);
				numbers.add(position,element);
				break;
			case "delete":
				while(numbers.remove(Integer.valueOf(temp[1]))) {}
				break;
			}
		}
		//-----------------------------------------------------------------------------
		
	
	
	//10
		//HouseParty
		//-----------------------------------------------------------------------------
		static void housePrty() {
			int numberCommands = Integer.parseInt(scan.nextLine());
			
			ArrayList<String> guestList = new ArrayList<String>();
			String enterGuest;
			int count=0;
			String name="";
			do {
				enterGuest = scan.nextLine();
				String[] temp = enterGuest.split(" ");
				name = temp[0];
				if(enterGuest.contains("is going")) {
			     	addGuest(guestList, name);
				}else {
					removeGuest(guestList,name);
				}
				count++;
			}while(count<numberCommands);
		}
		
		static void addGuest(ArrayList<String> guests, String name) {
			
			if(!checkGuest(guests,name)) {
				guests.add(name);
			}else {
				System.out.println(name + "already in the list");
			}
		}
		
		static boolean checkGuest(ArrayList<String> guests, String name) {
			boolean in = false;
			for(int i =0;i<guests.size();i++) {
				if(guests.get(i).equalsIgnoreCase(name)) {
					in = true;
				}
			}
			
			return in;
		}
		
		static void removeGuest(ArrayList<String> guests, String name) {
			if(checkGuest(guests,name)) {
				guests.remove(name);
			}else {
				System.out.println(name+" he i not in the list");
			}
		}
		//-----------------------------------------------------------------------------
		
	
	
	
	//11
		//operations more
		//-----------------------------------------------------------------------------
		static void moreOperations() {
			String enterCommands = scan.nextLine();
			ArrayList<Integer> numbers = parseLineList(enterCommands);
			
			String giveCommand;
			do {
				giveCommand = scan.nextLine();
				executeCommandsLists(giveCommand,numbers);
			}while(!(giveCommand.equalsIgnoreCase("end")));
			
		}
		static void executeCommandsLists(String command, ArrayList<Integer> numbers) {
			String[] array = command.split(" ");
			int number;
			
			switch(array[0].toLowerCase()) {
			case "add":
			 number	= Integer.parseInt(array[1]);
				numbers.add(number);
				break;
			case "insert":
				number = Integer.parseInt(array[1]);
				int index = Integer.parseInt(array[2]);
				numbers.add(index,number);
				break;
			case "remove":
				 number	= Integer.parseInt(array[1]);
				numbers.remove(number);
				break;
			case"shift": 
				 number	= Integer.parseInt(array[2]);
				if(array[1].equalsIgnoreCase("right")) {
					numbers.set(numbers.size()-1,numbers.get(0)*number);
				}else {
					numbers.set(numbers.get(0),numbers.get(numbers.size()-1)*number);
				}
			}
		}
		//-----------------------------------------------------------------------------
		
	
	//12
		//Bomb sequence
		//-----------------------------------------------------------------------------
		static void bombSequence() {
			String enterNumbers = scan.nextLine();
			ArrayList<Integer> numbers = parseLineList(enterNumbers);
			int specialNumber = Integer.parseInt(scan.nextLine());
			int powerOfSpecialNumber = Integer.parseInt(scan.nextLine());
			String trigerPositions ="";
			for(int i =0;i<numbers.size();i++) {
				if(numbers.get(i) ==specialNumber) {
					detonateBombs(powerOfSpecialNumber, numbers, i);
				}
			}
			
			int count=0;
			int sum = 0;
			while(numbers.size()!=1) {
				
				 sum += numbers.get(count);
			}
			System.out.println(sum);
		}
		static void detonateBombs(int power, ArrayList<Integer> numbers, int index) {
			
			for(int i =0;i<=power;i++) {
				if(i==0) {
					numbers.remove(index+0);
				}else {
					numbers.remove(index+i);
					numbers.remove(index-i);
				}
				
			}
			
		}
		//-----------------------------------------------------------------------------
		
	
		//13
				//CardGame
				//-----------------------------------------------------------------------------
				static void cardGame() {
					String enterCardsPlayer1 = scan.nextLine();
					ArrayList<Integer> player1  = parseLineList(enterCardsPlayer1);
					
					String enterCardsPlayer2 = scan.nextLine();
					ArrayList<Integer> player2  = parseLineList(enterCardsPlayer2);
					
					if(sumOfDeck(player1)>sumOfDeck(player2)) {
						System.out.println("player1 wins with"+sumOfDeck(player1)+sumOfDeck(player2));
					}else {
						System.out.println("player2 wins with"+sumOfDeck(player1)+sumOfDeck(player2));
					}
					
					
				}
				
				static int sumOfDeck(ArrayList<Integer> deck)  {
					int sum=0;
					for(int i =0;i<deck.size();i++) {
						sum+=deck.get(i);
					}
					
					return sum;
				}
				//-----------------------------------------------------------------------------
				
		
		
		//14
				//AppendArrays
				//-----------------------------------------------------------------------------
				static void appendArrays() {
					String enterArrays=scan.nextLine();
					
				ArrayList<Integer> listWithArrays = new ArrayList<Integer>();
				enterElementsInList(getArray(enterArrays),listWithArrays);
				
					
				}
				static int[] getArray(String enteredValues) {
					String withoutSpecial = enteredValues.replace("|"," ");		
					int[] numbers = Arrays.stream(withoutSpecial.split(" ")).mapToInt(e ->Integer.parseInt(e)).toArray();
					return numbers;
				}
				
				static void enterElementsInList(int[] elems, ArrayList<Integer> list) {
					for(int i =0;i<elems.length;i++) {
						list.add(elems[i]);
					}
				}
				//-----------------------------------------------------------------------------
				
		
		
		//15
				//*Anonymous threat
				//-----------------------------------------------------------------------------
				static void anonynousThreat() {
					String data = scan.nextLine();
					ArrayList<String> listWithData = deliverStringData(data);
					
					String commands;
					do {
						commands = scan.nextLine();
						if(commands.toLowerCase().equals("merge")) {
							merge(commands,listWithData);
						}else {
							divide(commands, listWithData);
						}
						
					}while(!(commands.equalsIgnoreCase("3:1")));
					System.out.println(listWithData);
				}
				
				static void merge(String command, ArrayList<String> list) {
					String[] temp = command.split(" ");
					int start = Integer.valueOf(temp[1]);
					int end = Integer.valueOf(temp[2]);
					
					
					int count=0;
					for(int i =start;i<=list.size();i++) {
						count++;
					}
					
					list.set(start,mergeRange(list,start,count) );
					
					
				}
				static String mergeRange(ArrayList<String> list, int start, int end) {
					String sum="";
					for(int i =start;i<=end;i++) {
						sum+=list.get(i);
					}
					return sum;
				}
				
				static void divide(String command, ArrayList<String> list) {
					String[] temp = command.split(" ");
					int divideBy = Integer.valueOf(temp[2]);
					
					String getInstance = list.get(Integer.parseInt(temp[1]));
					
					if(getInstance.length()%2==0) {
						String print="";
						int count=0;
						int start=0;
						int finish =getInstance.length()/divideBy;
						while(count<divideBy) {
						print = getInstance.substring(start,finish);
						start+=finish;
						finish+=finish;
						count++;
						}
					}else {
						int range = getInstance.length()/divideBy;
						double temporary = Math.ceil(range);
						range = (int) temporary;
						//to do substring the rest
					}
					
				}
				
				static ArrayList<String> deliverStringData(String data) {
					ArrayList<String> list = new ArrayList<String>();
					String[] elems =data.split(" ");
					for(int i =0;i<elems.length;i++) {
						list.add(elems[i]);
					}
					return list;
				}
				//-----------------------------------------------------------------------------
				
		
		//16
				//pokemonDontGO
				//-----------------------------------------------------------------------------
				static void pokemonDontGo() {
					String enterSequence = scan.nextLine();
					ArrayList<Integer> sequence = parseLineList(enterSequence);
					
					
					ArrayList<Integer> removedElements = new ArrayList<Integer>();
					int giveIndexToRemove;
					do {
						giveIndexToRemove = Integer.parseInt(scan.nextLine());
						if(giveIndexToRemove>sequence.get(sequence.size()-1)) {
							sequence.set(sequence.get(sequence.size()-1), sequence.get(0));
						}else if(giveIndexToRemove<=0) {
							removedElements.add(sequence.get(0));
							sequence.remove(0);
							
						}else {
							int index = sequence.get(giveIndexToRemove);
							removedElements.add(sequence.get(giveIndexToRemove));
							sequence.remove(giveIndexToRemove);
							increaseAndDecrease(sequence, index);
						}
					}while(sequence.size()!=0);
					System.out.println(sumRemovedIndexes(removedElements));
					
					
				}
				static int sumRemovedIndexes(ArrayList<Integer>removed) {
					int sum=0;
					for(int i =0;i<removed.size();i++) {
						sum+=removed.get(i);
					}
					return sum;
				}
				
				static void increaseAndDecrease(ArrayList<Integer> list,int index) {
					for(int i =0;i<list.size();i++) {
						if(list.get(i)>index) {
							list.set(i,list.get(i)-index );
						}else {
							list.set(i,list.get(i)+index );
						}
					}
				}
				//-----------------------------------------------------------------------------
				
				
				//17
				//Messaging
				//---------------------------------------------------------
				static void messaging() {
					String enterNumbers = scan.nextLine();
					ArrayList<String> numbers = deliverStringData(enterNumbers);
					String text = scan.nextLine();
					
					for(int i =0;i<numbers.size();i++) {
						int temp = sumDigits(numbers.get(i));
						System.out.print(text.charAt(temp));
					}
				}
				static int sumDigits(String text) {
					int sum=0;
					for(int i =0;i<text.length();i++) {
						String c = String.valueOf(text.charAt(i));
						sum+=Integer.parseInt(c);
					}
					return sum;
				}
				//----------------------------------------------------------
	
				//18
				//DrumTest
				//---------------------------------------------------------
				static void drum() {
					double savings = Double.parseDouble(scan.nextLine());
					String integers = scan.nextLine();
					ArrayList<Integer> drumSet = parseLineList(integers);
					String power;
					do {
						power =scan.nextLine();
						
					}while(!(power.equalsIgnoreCase("hit it again,Gabsy!")));
				}
				//----------------------------------------------------------
	
				
				//19
				//
				//---------------------------------------------------------
				
				//----------------------------------------------------------
	
				
				//20
				//
				//---------------------------------------------------------
				
				//----------------------------------------------------------
	
	
	
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

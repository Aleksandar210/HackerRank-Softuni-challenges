package advanced_Softuni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import advanced_Softuni_Classes_Iterables_Comparables.Book;
import advanced_Softuni_Classes_Iterables_Comparables.Clinic;
import advanced_Softuni_Classes_Iterables_Comparables.ComapreByAge;
import advanced_Softuni_Classes_Iterables_Comparables.ComparePersonByName;
import advanced_Softuni_Classes_Iterables_Comparables.CustomIterableStack;
import advanced_Softuni_Classes_Iterables_Comparables.Lake;
import advanced_Softuni_Classes_Iterables_Comparables.Library;
import advanced_Softuni_Classes_Iterables_Comparables.ListIterator;
import advanced_Softuni_Classes_Iterables_Comparables.Person;
import advanced_Softuni_Classes_Iterables_Comparables.Pet;
import advanced_Softuni_Classes_Iterables_Comparables.Town;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
public class IterableAndComparableTasks {
	static Scanner scan = new Scanner(System.in);
	private static int indexLake=0;
public static void main(String[] args) {
	
	//libraryTask();
   //listIteratorCommands();
  //customStackTask();		//finish later
 //lakeNumbers();
}

static void clinicsPets() {
	Map<String,Clinic> clinics = new LinkedHashMap<String,Clinic>();
	String enterCommands = scan.nextLine();
	while(!"end".equalsIgnoreCase(enterCommands)) {
		
	}
}

static void executeCommand(String[] data, String createType,Map<String,Clinic> clinics) {
	switch(data[0].toLowerCase()) {
	case "create":
		if(createType.equalsIgnoreCase("pet")) {
			Pet currentPetCreated = new Pet(data[2],Integer.parseInt(data[3]),data[4]);
		}else {
			Clinic currentClinicCreated = new Clinic(data[2],Integer.parseInt(data[3]));
			if(clinics.get(currentClinicCreated)==null) {
				if(Integer.parseInt(data[3])%2!=0) {
				clinics.put(data[2],currentClinicCreated);
				}else {
					
				}
			}
		}
		break;
		
		
	}
}

static void personComparingTask() {
	String enter = scan.nextLine();
	Set<Person> orderedByAge = new TreeSet<Person>(new ComapreByAge());
	Set<Person> orderedByName = new TreeSet<Person>(new ComparePersonByName());
	while(!"end".equalsIgnoreCase(enter)) {
		String[] personData = enter.split("\\s+");
		Person pers = new Person(personData[0],Integer.parseInt(personData[1]));
		orderedByAge.add(pers);
		orderedByName.add(pers);
	}
	
	System.out.println("By Name: ");
	orderedByName.forEach(e ->System.out.println(e));
	System.out.println();
	System.out.println("OrderedByAge");
	orderedByAge.forEach(e->System.out.println(e));
}



static void towns() {
	HashMap<String, Town> towns = new HashMap<String,Town>();
	String enterData = scan.nextLine();
	while(!"end".equalsIgnoreCase(enterData)) {
		String[] personData = enterData.split("\\s+");
		Person pers = new Person(personData[0],Integer.parseInt(personData[1]),personData[2]);
		if(towns.get(personData[2])==null) {
			towns.put(personData[2], new Town(personData[2]));
			towns.get(personData[2]).add(pers);
		}else {
			towns.get(personData[2]).add(pers);
		}
	}
	
	for(Map.Entry<String, Town> entry: towns.entrySet()) {
		System.out.println(entry.getKey()+" ->");
		List<Person> currentPeopleList = entry.getValue().getPeople();
	 currentPeopleList =  entry.getValue().getPeople().stream().sorted((a,b)->a.compareTo(b))
		.collect(Collectors.toList());
		entry.getValue().forEach(e ->System.out.println(e));
		System.out.println();
	}
}

static void lakeNumbers() {
	
		
	String[] enterNumbers = scan.nextLine().split("\\s+");
	int[] numbers = new int[enterNumbers.length];
	
	 Arrays.stream(enterNumbers).map(e ->{
		 int currentIndex = indexLake;
		 numbers[currentIndex]=Integer.parseInt(e);
		 indexLake++;
		 return e;
	 }).toArray();
	
	Lake lake = new Lake(numbers);
	StringBuilder sb = new StringBuilder();
	lake.forEach(e -> {
		if(e%2==0) {
			System.out.print(e+" ");
		}else {
			sb.append(e+" ");
		}
	});
	System.out.println(sb.toString());
	
	
    
}





static void customStackTask() {
	CustomIterableStack stack = new CustomIterableStack();
	stack.push(23);
	stack.push(14);
	stack.push(141);
	stack.forEach(e->System.out.print(e+ " "));
	
}



static void listIteratorCommands() {
	String enterCommands;
	ListIterator currentList = new ListIterator();
	
	boolean created = false;
	do {
		enterCommands = scan.nextLine();
		if(!created) {
	String[] contents = enterCommands.substring(enterCommands.indexOf("{")+1,enterCommands.indexOf("}"))
					.split("\\s+");
		created = true;
		currentList.create(contents);
		}
		
		executeData(enterCommands,currentList);
	}while(!"end".equalsIgnoreCase(enterCommands));
	
	
}

static void executeData(String command,ListIterator currentIteratorList) {
	switch(command) {
	case "move":
		System.out.println(currentIteratorList.move());
		break;
	case "hasnext":
		System.out.println(currentIteratorList.hasNext());
		break;
	case "print":
		currentIteratorList.print();
		break;
	}
}


static void libraryTask() {
	Library lib = new Library();
	System.out.print("Enter number of books to add: ");
	int numberBookAdd = getInt();
	while(numberBookAdd-- >0) {
		lib.addBook(addBookToLib());
	}
	showBooks(lib);
	
}

static void showBooks(Library currentLib) {
	currentLib.forEach(e ->System.out.println(e));
	
}

static Book addBookToLib() {
	Book currentBookToAdd;
	System.out.print("Enter title: ");
	String title =  scan.nextLine();
	System.out.print("Enter year: ");
	int year = Integer.parseInt(scan.nextLine());
	System.out.print("Enter number of pages: ");
	int pages = Integer.parseInt(scan.nextLine());
	System.out.print("Enter the names of the authors: ");
	String[] names = getStringArr();
	currentBookToAdd = new Book(title,year,pages,names);
	System.out.println();
	return currentBookToAdd;
	
}
static String[] getStringArr() {
	String enterName;
	String[] names = new String[0];
	int index = -1;
	
	do {
		enterName = scan.nextLine();
		if(enterName.equalsIgnoreCase("end")) {
			break;
		}else {
		index+=1;
		if(names.length==0) {
		String[] currentNamesCopy = new String[names.length+1];
		currentNamesCopy[index] = enterName;
		names = currentNamesCopy;
		}else {
			
		String[] currentNamesCopy = new String[names.length+1];
		System.arraycopy(names, 0, currentNamesCopy, 0, names.length);
		currentNamesCopy[index] = enterName;
		names = currentNamesCopy;
		}
		}
	}while(!"end".equalsIgnoreCase(enterName));
	
	return names;
}

static String getString() {
	try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
		return br.readLine();
	} catch (NumberFormatException |IOException e) {
		e.printStackTrace();
		
	}
	return null;
	
}

static int getInt() {
	BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		 int num;
		try {
			num = Integer.parseInt(br.readLine());
			 return num;
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
}
}

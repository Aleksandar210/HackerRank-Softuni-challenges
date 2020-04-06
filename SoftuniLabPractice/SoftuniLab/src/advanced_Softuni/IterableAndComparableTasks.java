package advanced_Softuni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import advanced_Softuni_Classes_Iterables_Comparables.Book;
import advanced_Softuni_Classes_Iterables_Comparables.CustomIterableStack;
import advanced_Softuni_Classes_Iterables_Comparables.Library;
import advanced_Softuni_Classes_Iterables_Comparables.ListIterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class IterableAndComparableTasks {
	static Scanner scan = new Scanner(System.in);
public static void main(String[] args) {
	//libraryTask();
//	listIteratorCommands();
	customStackTask();
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

package advanced_Softuni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import advanced_Softuni_Classes_Iterables_Comparables.Book;
import advanced_Softuni_Classes_Iterables_Comparables.Library;

public class IterableAndComparableTasks {
public static void main(String[] args) {
	
}

static void LibraryTask() {
	Library lib = new Library();
	System.out.print("Enter number of books to add: ");
	int numberBookAdd = getInt();
	while(numberBookAdd-- >0) {
		lib.addBook(addBookToLib());
	}
	
}

static Book addBookToLib() {
	Book currentBookToAdd;
	System.out.print("Enter title: ");
	String title =  getString();
	System.out.print("Enter year: ");
	int year = getInt();
	System.out.print("Enter number of pages: ");
	int pages = getInt();
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
		enterName = getString();
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
	} catch (IOException e) {
		e.printStackTrace();
		
	}
	return null;
	
}

static int getInt() {
	try(BufferedReader br  = new BufferedReader(new InputStreamReader(System.in))){
		 int num =  Integer.parseInt(br.readLine());
		 return num;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return -1;
}
}

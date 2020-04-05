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
	
	lib.addBook();
}

static Book addBookToLib() {
	Book currentBookToAdd;
	System.out.print("Enter title: ");
	String title =  getString();
	System.out.print("Enter year: ");
	int year = getInt();
	System.out.print("Enter number of pages: ");
	int pages = getInt();
	
}
static String[] getStringArr() {
	String enterName;
	String[] names = new String[0];
	int index = -1;
	
	do {
		enterName = getString();
		if(enterName.equalsIgnoreCase("end")) {
			break;
		}
		index+=1;
		if(names.length==0) {
			
		}
		
		
		names[index] = enterName;
	}while(!"end".equalsIgnoreCase(enterName));
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

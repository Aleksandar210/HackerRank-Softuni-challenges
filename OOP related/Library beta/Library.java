import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;






public class Library {
	
	
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String args[]) {
		
		System.out.println("Welcome to the Library and to the start of your work day!");
		
		
		
		  
		  //using arrayList data structure if the reader wants to take multiple books.
		  //perhaps could have used a linked list as well , but most of the stuff here will be removed as well
		ArrayList<Books> booksInLibrary = new ArrayList<Books>();	//the books in the library
		
		ArrayList<Person> readers = new ArrayList<Person>();		//the readers 
		
		 boolean exit=false;
		 while(exit==false) {
	System.out.println("1| ship in new books");
	System.out.println("2| give reader's books ");
	System.out.println("3| close the Library");
	System.out.println("4| Library information ");
	
	System.out.print("chose: ");
	int chose =Integer.parseInt(scan.nextLine());
	switch(chose) {
	
	case 1:
		
		System.out.print("ship book number: ");
		int shipNumber=Integer.parseInt(scan.nextLine());
		 
		  for(int i=0;i<shipNumber;i++) {
			  booksInLibrary.add(new Books());
			  booksInLibrary.get(i).setUniqueNumber(100+(i+10));
		  }
		  break;
		 
	
	case 2:
		
		System.out.println("enter readers in the library: ");
		int numberReaders = Integer.parseInt(scan.nextLine());
		 
		 for(int i =0;i<numberReaders;i++) {
			 readers.add(new Person());
			 readers.get(i).readerUniqueNumber=(100+(i*10));
		 }
		System.out.println();
		System.out.println();
		for(int i =0;i<readers.size();i++) {
			System.out.println("reders in the library: ");
			System.out.print(" | "+readers.get(i).name+" e-mail: "+readers.get(i).email  +  " | ");
		}
		System.out.print("continue. ");
		scan.nextLine();
		System.out.println();
		System.out.println("pick a reader to give book: ");
		
		String pick;
		String pickEmail;
			do {
			System.out.print("enter name:");
			pick=scan.nextLine();
			if(validName(pick,readers)==false){
				System.out.println("try again ");
			}
			}while(validName(pick,readers)==false);
			do {
			System.out.print("enter reader's email: ");
			pickEmail=scan.nextLine();
			if(emailValidation(pickEmail)==false) {
				System.out.println("not a valid email. ");
			}
			
			}while(emailValidation(pickEmail)==false);
			
			int findTheReader = readerNumber(readers,pick,pickEmail);
			readers.get(findTheReader).getBook(booksInLibrary);
			
			 break;
			 
	case 3: 
		 exit=true;
		 break;
		
	case 4:
		System.out.println("books that need to be returned. ");
		displayBookToBeReturned(readers ,booksInLibrary);
		break;
	}
	
		 }
	}
	
	

	static int readerNumber(ArrayList<Person> readers,String readerName,String email) {
		int number=0;
		for(int i =0;i<readers.size();i++) {
			if(readerName==readers.get(i).name && email==readers.get(i).email) {
				number=i;
				break;
			}
			
		}
		return number;
		
	}
	
	
	
	
	//show books that need to be returned
	static void displayBookToBeReturned(ArrayList<Person> readers ,ArrayList<Books> booksInLibrary) {
		for(int i =0;i<booksInLibrary.size();i++) {
		System.out.println();
		for(int j=0;j<readers.size();j++) {
			int tempBooksInUser = readers.get(j).booksSelectedByPerson.get(j);
			int tempBookNumber= booksInLibrary.get(j).bookNumberUnique;
			if(tempBooksInUser==tempBookNumber) {
				System.out.println(readers.get(i).name+" "+readers.get(i).email+"has to return: ");
				booksInLibrary.get(j).showAllData();
			}
			
		}
			
			
		}
	}
	
	
	static boolean validName(String name,ArrayList<Person> readers) {
		boolean valid=false;
		
		for(int i=0;i<readers.size();i++) {
			if(name.equalsIgnoreCase(readers.get(i).name)) {
				valid=true;
			}
		}
		
		return valid;
		
	}
	
	//method to see if the given email isvalid or not
	static boolean emailValidation(String email) {
		boolean validated=false;
		Pattern p = Pattern.compile("@abv.bg");
		Pattern p1 = Pattern.compile("@gmail.com");
		Pattern p2 = Pattern.compile("@yahoo.com");
		
		Matcher match = p.matcher(email);
		Matcher match1 = p1.matcher(email);
		Matcher match2 = p2.matcher(email);
		
		if(match.find() || match1.find() || match2.find()) {
			validated=true;
		}
		
		
		return validated;
	
	}
	
	
	
	
	
		static class Books {
			
			protected String author;
			protected String signature;
			protected int yearOfRelease;
			protected String publisher;
			protected int numberPages;
			protected int quantity;
			protected int  bookNumberUnique;
			
		
			
			public Books(){
				System.out.print("enter author name:");
			this.author=scan.nextLine();
				
				do {
					System.out.println(" Title.");
					System.out.println("enter Title: ");
					this.signature= scan.nextLine();
				
				
				if(signature.length()<1 ||signature.length()>20) {
					System.out.println("title is way too long! ");
					
				}
				
				
				}while(this.signature.length()<1 || this.signature.length()>20);
				do {
				System.out.print("enter year of release: ");
				this.yearOfRelease = Integer.parseInt(scan.nextLine());
				if(yearOfRelease>2020 || yearOfRelease<1700) {
					System.out.println("book is not published or too old, try again");
				}
				}while(this.yearOfRelease>2020 || this.yearOfRelease<1700);
				do {
				System.out.print("enter publisher name: ");
				this.publisher = scan.nextLine();
				if(this.publisher.matches(".*\\d.*")) {
					System.out.println("names dont contain numbers. Try again");
				}
				}while(this.publisher.matches(".*\\d.*"));
			
				
				do {
					System.out.print("enter number of pages: ");
					this.numberPages = Integer.parseInt(scan.nextLine());
					if(this.numberPages<1) {
						System.out.println("there isnt any book then. Try again");
					}
				}while(this.numberPages<1);
				
				System.out.println("enter quantity.   (you may have more than one of this book)");
				System.out.print("enter quanity: ");
				do {
					this.quantity=Integer.parseInt(scan.nextLine());
					if(this.quantity<0) {
						System.out.println("this doesnt make any sense. ");
						System.out.println("Try again. ");
						
					}
				}while(this.quantity<0);
				//this number will be used to access the book at any time or refer to it
				
				
				
					
				
				
		}
			//-----------------------------------------------------------------------
			
			public void showAllData() {
				System.out.print("| "+this.author+" "+this.signature+" "+this.yearOfRelease+"  published by "+this.publisher+" |"); 
				
				
			}
			
			
			//will use this method to see and get hte number of books
			public int getQuantity() {
				return this.quantity;
			}
			
			
			//will use this to set unique number to the book different from other books but the same for this.
			public void setUniqueNumber(int number) {
				this.bookNumberUnique=number;
			}
			
			public int getbookNumberUnique() {
				return this.bookNumberUnique;
			}
			
			
	}
		
		static class Person {
			
			//local variables
			private int selectedBook = 0;
			private int readerUniqueNumber;
			protected String name;
			protected String phone;
			protected String email;
			protected ArrayList<Integer> booksSelectedByPerson = new ArrayList<Integer>();//for selected books
			
			
			
			Person() {
				System.out.println("reader's name");
				this.name=scan.nextLine();
				System.out.print("enter phone number");
				do {
					
				phone = scan.nextLine();
				if(this.phone.length()!=11) {
					System.out.println("invalide  Phone number. Try again.");
				}
				}while(this.phone.length()!=10);
				
				 String mail;	//we will check the email with this variable.
				do {
					
				
				System.out.print("enter E-mail address: ");
				 mail = this.email=scan.nextLine();
					if(emailValidation(mail)==false) {
						System.out.println("invalid E-mail address. Try again");
					}
				
				}while(emailValidation(mail)==false);
				
				
				
			}
			
			
			
			 ArrayList<Integer> getBook(ArrayList<Books> booksInStore) {
				 int selectedBook = 0;
				boolean exit = false;
				
				while(exit==false) {
				System.out.println("1|see the books in store.");
				System.out.println("2|select  books");
				System.out.println("3|get the books you have selected ");
				System.out.println("4| go back");
				System.out.print("chose: ");
				int option = Integer.parseInt(scan.nextLine());
				switch(option) {
				case 1:
					System.out.println();
					for(int i =0;i<booksInStore.size();i++) {
					
					if(booksInStore.get(i).getQuantity()<1) {
						
					System.out.print("|UNAVAILABLE|"+ "    |"+ i + "| ");
					 booksInStore.get(i).showAllData();
					System.out.println();
					}else {
						System.out.print( "|AVAILABLE|" + "|"+ i + "| ");
						 booksInStore.get(i).showAllData();
						
						System.out.println();
					}
					
				}
					scan.nextLine();		//so that the user can have a time to read them 
				System.out.println();
				break;
				case 2: 
					
					System.out.print("select: ");
				do {
				  selectedBook = Integer.parseInt(scan.nextLine());
				 if(selectedBook>booksInStore.size() || selectedBook<0) {
					 System.out.println("we cant find a book by that index.");
					 System.out.println("try again!");
					 System.out.println();
				 }
				}while(selectedBook>booksInStore.size() || selectedBook<0);
				scan.nextLine();
				
				
				System.out.println();
				System.out.println("currently selected.");
				booksInStore.get(selectedBook).showAllData();;
				
				break;
				case 3:
					
					booksSelectedByPerson.add(booksInStore.get(selectedBook).getbookNumberUnique());
					booksInStore.get(selectedBook).quantity=-1;
					break;
				
					
				case 4: exit=true;
				break;
				
					
				}
				
				}
				
				return booksSelectedByPerson;
				
				
			}
			 
			 
			 //getter for the book that the person has selected.
			 public int theSelectedBook() {
				 return this.selectedBook;
			 }
			
			 
			
			
			
			
		}
}

		


		

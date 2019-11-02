import java.util.Scanner;

import java.lang.Math;

public class Main {
	static Scanner scan =  new Scanner(System.in);		//declaring a Scanner  outside main to be used everywhere
	public static void main(String args[]) {
		System.out.print("Enter sentence to encrypt: ");
		String text = scan.nextLine();			//the input text
		text.replaceAll("\\s+","");				//removes whitespaces;
		int[] gridDetails = gridDetails(text);	//array with the return array of function
		
		//String newName = text.substring(0,1);
		//System.out.println(newName);
		
		int rows = gridDetails[0];				
		int columns = gridDetails[1];
		
		
		String[] gridWithWords = fillGridWords(rows,columns,text);		//wors from text enterd in grid
		String encryptedWords = encrypted(rows,columns,gridWithWords); 
		
		System.out.println(encryptedWords);
		
	}
	
	//function that return array with rows and columns
	static int[] gridDetails (String text){
		int[] gridDetails = new int[2];			//array with size 2 for rows and columns
		int length = text.length();				//length of the input text which will be sqrt 
		double lengthDivided = Math.sqrt(length);	//length sqrt with Math
		int columns = (int)Math.ceil(lengthDivided);	//columns
		 int rows = (int)Math.floor(lengthDivided);		//rows
		 gridDetails[0] = rows;
		 gridDetails[1] = columns;
		 return gridDetails;					//returning array with rows an colums
		 
	}
	//function to add grid words
	static String[] fillGridWords(int rows, int columns, String text) {
		
		int checker = (rows*columns) - text.length();	//checks how much white spaces to add 
		if(checker != 0 ) {
				for(int i =0;i<checker;i++) {
					text+=" ";
					
				}
		}
		
		int begin=0;
		int range = columns;
		String[] words = new String[rows];
			
	for(int i=0;i<words.length;i++) {
		
		words[i] = text.substring(begin, range);
		begin+=columns;
		range+=columns;
	}
	

			
	
	
		return words;
	}
	
	static String encrypted(int rows, int columns , String[] words) {
		
		String[] test = new String[1];	//test variable for adding  crypted words
		
		int n = columns;
		String temp="";
		String temp1="";
		int begin = 0 ;
		int range = 1;
		while(n>0) {
		for(int i=0;i<rows;i++) {	//loop to add
			temp = words[i];	//
			temp1 += temp.substring(begin,range);
			
		}
		int z=0;
		n--;
		begin++;
		range++;
		test[z] = temp1;
		
		
		
		
		
		}
		int bgn=0;			//new begin
		int rng =rows;			//new range;
		String wrd = test[0];
		String encWord="";
		String encWord1="";
		int number = columns;
		while(number>0) {
		encWord = wrd.substring(bgn,rng);
		encWord1=encWord;
		bgn+=rows;
		rng+=rows;
		number--;
		}
		
		
		return wrd;
		
		
	}

	
	
	
	
}
	
	
	
		
		
		
	
	
	
	
	
	
	
	
	



//author: Aleksandar Kuzmov 
//FMI student

//Explanation
/*
  
  
 */
 

//
import java.util.Scanner;
import java.lang.Math;


public class FullCounting {
	static Scanner scan  = new Scanner(System.in);
	public static void main(String args[]) {
		System.out.print("Enter number of elemetns ");
		int numberElem = Integer.parseInt(scan.nextLine());
		String line;									//String to enter values on the line
		String[] getValues;                         //we are getting the values on the line inside
		int half = numberElem/2;
		
		int[] first = new int[numberElem];					//tow arrays containing the values (transfered from getV)
		String[] second = new String[numberElem];
		
		//adding values/entering values and more
		for(int i=0;i<numberElem;i++) {
		 line = scan.nextLine();
		 getValues = line.split(" ") ;
		 
		first[i] = Integer.parseInt(getValues[0]);
			 second[i] = getValues[1];
		}
		
		for(int i=0;i<half;i++) {
			System.out.print(" -");
			
		}
		
		//getting the biggest index in the array to do the loop later
		int max = 0;
		for(int i=0;i<first.length-1;i++) {
			if(first[i]<first[i+1]) {
				max=first[i+1];
			}
			
		}
		
		//creating new ararays to put the sortet values
		int[] newFirst = new int[half];
		String[] newSecond=  new String[half];
		
		
		int count = 1;
		int add = 0;		//elemetn on number new arr
		int adStr = 0;		//elemtn on new string arr
		while(count<max+1) {
			
			for(int i=0;i<first.length;i++) {
				if(first[i]==count) {
					newFirst[add]= first[i];
					newSecond[adStr]= second[i];
					add++;
					adStr++;
					
				}
			}
			count++;
			
			
		}
		
		for( int i=0;i<newSecond.length;i++) {
			System.out.print(" "+newSecond[i]);
			
		}
		
		
		
		
	
		
		
		
		
			
	}
		
		
		}
		
		
	



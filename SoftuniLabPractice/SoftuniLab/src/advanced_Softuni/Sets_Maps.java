package advanced_Softuni;

import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Sets_Maps {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//usernameUnique();
		//repetingNumbers();
		//periodicTable();
	}
	
	//----------------------------------------------------------------------
	
	
	//----------------------------------------------------------------------
	
	
	
	
	//----------------------------------------------------------------------
	static void repeatingNumbers() {
		int setOne = Integer.parseInt(scan.nextLine());
		int setTwo = Integer.parseInt(scan.nextLine());
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		int sumCapacity =0;
		while(sumCapacity<setOne+setTwo) {
			int addNumber = Integer.parseInt(scan.nextLine());
			if(sumCapacity<setOne) {
				set1.add(addNumber);
			}else {
				set2.add(addNumber);
			}
		}
		
		Set<Integer> repeating = new HashSet<Integer>(set1);
		repeating.retainAll(set2);
		System.out.println(repeating);
	}
	//----------------------------------------------------------------------
	
	
	
	
	
	
	
	
	//----------------------------------------------------------------------
	static  void usernameUnique() {
		Set<String> usernames = new HashSet<String>();
		
		String enterUsername;
		int numberUsernames = Integer.parseInt(scan.nextLine());
	
		while(numberUsernames>0) {
			
			try {
				enterUsername = scan.nextLine();	
			}catch(NullPointerException exception){
				continue;
			}
			numberUsernames--;
			
		}
		
		
	}
	//----------------------------------------------------------------------
	
	

}

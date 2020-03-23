package advanced_Softuni;

import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Sets_Maps {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//usernameUnique();
	}
	
	
	
	
	
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

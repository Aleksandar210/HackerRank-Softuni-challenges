package FarmerSalesman;
import java.util.Scanner;
public class FarmerSalesman {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		startScreen(scan);
		
			
		
		
	}
	
	
	
	static void startScreen(Scanner scan) {
		boolean exitGame = false;
		char enterAnswer;
		do {
		System.out.println("Welcome to FarmSalesman! ");
		System.out.println("Y/N");
		enterAnswer = scan.nextLine().charAt(0);
		}while(!(enterAnswer=='y' || enterAnswer=='n'));
		
		switch(enterAnswer) {
		case 'y':
			
			break;
		case 'n':
			exitGame = true;
			break;
		}
		
	}
	
	
	
	
	static void startGame() {
		
	}
	
	
	
	
	
}

package FarmerSalesman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Market {
	String marketName;
	private HashMap<String ,HashMap<String,Storage>> productsAvailable = new HashMap<>();
	
	public Market() {
		this.marketName = "VillageMarket";
	}
	
	public void openMarketMenue() {
		Scanner scan = new Scanner(System.in);
		int select;
		boolean exit = false;
		while(exit) {
		do {
			System.out.printf("1|Buy form %s ",this.marketName);
			System.out.printf("2|Exit %s products",this.marketName);
			System.out.print("Select: ");
			select = Integer.parseInt(scan.nextLine());
		}while(select<1 || select> 2);
		switch(select) {
		case 1:
			break;
		case 2:
			break;
		}
		
		
		
		}
	}
	
	private void buyFromMarket() {
		//Storage selectedStorage = selectStorageSupplier();
		
		
	}
	
	//private Storage selectStorageSupplier() {
		
	//}
}

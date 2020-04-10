package advanced_Softuni_Classes_Iterables_Comparables;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Player {
	
	private static final  int HEALTH = 100;
	private static final String DESCRIPTION = "N/A";
	private static final int  RP = 0;
	private String name;
	private String rank;
	private String clazz;
	private int health;
	private String description;
	private int rp;
	private double currencyPlayerHas;
	private BankAccount bankAccount;
	
	public Player(String name,String clazz) {
		setName(name);
		setHealth(HEALTH);
		setClazz(clazz);
		setRP(RP);
	}
	
	
	
	

	@Override
	public String toString() {
		String playerInfo = String.format("%s%n%s%n%s%s",getName(),getClazz(),getRank(),getDescription());
		return playerInfo;
	}
	
	public void changeName() {
		Scanner scan = new Scanner(System.in);
		boolean confirmed = false;
		char answer ;
		do {
		System.out.println("CHANGING USERNAME COSTS 1000RP");
		System.out.println("Do you want to proceed?");
		System.out.println("y/n");
		answer = scan.nextLine().charAt(0);
		if(answer=='y') {
			if(getRP()>=1000) {
				System.out.print("USERNAME: ");
				setName(scan.nextLine());
				
			}else {
				System.out.println("NOT ENOUGH RP");
			}
		}
		}while(!confirmed);
		scan.close();
	}
	
	
	public void buyRP() {
		int select;
		Scanner scan = new Scanner(System.in);
		do {
		System.out.println("1| 5$ -> 1000RP");
		System.out.println("2| 10$ -> 2000RP");
		System.out.println("3| 5$ -> 2500RP");
		System.out.print("select: ");
		
		select = Integer.parseInt(scan.nextLine());
		}while(select<0|| select>3);
		
		switch(select) {
		case 1:
			boolean confirmed = false;
			do {
			System.out.println("Are you sure you want to proceed ?");
			System.out.println("y/n");
			char answer = scan.nextLine().charAt(0);
			if(answer=='y') {
				setRP(1000);
				confirmed=true;
			}else if(answer=='n') {
				confirmed=true;
			}else {
				
			}
			}while(!confirmed);
			break;
			
		case 2:
			boolean confirmed2 = false;
			do {
			System.out.println("Are you sure you want to proceed ?");
			System.out.println("y/n");
			char answer = scan.nextLine().charAt(0);
			if(answer=='y') {
				setRP(2000);
				confirmed=true;
			}else if(answer=='n') {
				confirmed=true;
			}else {
				
			}
			}while(!confirmed2);
			break;
			
		case 3:
			boolean confirmed3= false;
			do {
			System.out.println("Are you sure you want to proceed ?");
			System.out.println("y/n");
			char answer = scan.nextLine().charAt(0);
			if(answer=='y') {
				setRP(2500);
				confirmed=true;
			}else if(answer=='n') {
				confirmed=true;
			}else {
				
			}
			}while(!confirmed3);
			break;
		}
		scan.close();
	}
	
	public void setPlayerCurrency(double sum) {
		this.currencyPlayerHas = sum;
	}
	
	public double getPlayerCurrency() {

	    BigDecimal bd = BigDecimal.valueOf(this.currencyPlayerHas);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();
		
	}
	
	
	public int getRP() {
		return this.rp;
	}
	
	public void setRP(int rp) {
		this.rp = rp;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

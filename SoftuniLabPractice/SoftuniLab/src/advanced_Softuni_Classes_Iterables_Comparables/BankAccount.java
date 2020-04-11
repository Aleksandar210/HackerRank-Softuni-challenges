package advanced_Softuni_Classes_Iterables_Comparables;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {
	private static int USER_ID = 0;
	private static final double DEF_INTEREST_VALUE=0.0;
	private static double interestRate;
	private int id;
private double balance;
private String name;
private Map<LocalDate,Map<LocalDateTime,Double>> historyDeposits;


public BankAccount(String name) {
	USER_ID+=1;
	setId(USER_ID);
	setBalance(0);
	setName(name);
	historyDeposits = new LinkedHashMap<LocalDate,Map<LocalDateTime,Double>>();
	setInterestRate(DEF_INTEREST_VALUE);
	
	
}

public void deposit(double sum) {
	if(sum==0) {
		return;
	}else {
		LocalDateTime currentTimeOfDeposit = LocalDateTime.now();
		LocalDate currentDate =  LocalDate.now();
		
	setBalance(getBalance()+sum);
	if(historyDeposits.get(currentDate)==null) {
		historyDeposits.put(currentDate, new LinkedHashMap<LocalDateTime,Double>());
		
		historyDeposits.get(currentDate).put(currentTimeOfDeposit,sum);
	}
	}
}

public void withdraw(double sum) {
	if(sum<=getBalance()) {
		setBalance(getBalance()-sum);
		
		
	}else {
		throw new IllegalStateException("Unsufficent funds");
	}
}

public void history() {
	for(Map.Entry<LocalDate, Map<LocalDateTime,Double>> entry: historyDeposits.entrySet()) {
		System.out.println("Deposits made on:  "+entry.getKey());
		for(Map.Entry<LocalDateTime,Double> entryTime:entry.getValue().entrySet() ) {
			System.out.println(entryTime.getKey()+" -> "+entryTime.getValue());
		}
	}
}


public void setInterestRate(double addedRate) {
	interestRate = addedRate;
}

public double getInterestRateYear(int years) {
	
	return getBalance()*years * interestRate;
}

public int getId() {
	return id;
}


private void setId(int id) {
	this.id = id;
}


public double getBalance() {
	return balance;
}


public void setBalance(double balance) {
	this.balance = balance;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}



}

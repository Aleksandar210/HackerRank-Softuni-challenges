package DefinignClasses_folder_classes;

public class BankAccount {
	private static final double DEFAULT_RATE = 0.2d;
public static  int idCounter=0;
public static  double interestRate = DEFAULT_RATE;
private int id;
private double balance;


public BankAccount() {
	idCounter++;
	this.id = idCounter;
	this.balance=0;
}

//static method for changing interest rate
public static void setInterestRate(double interest) {
	interestRate = interest;
}

//method to check interest rate for years entered
public double getInterest(int years) {
	return interestRate*years*this.balance;
}

public void deposit(double sum) {
	this.balance+=sum;
}

public int getId() {
	return this.id;
}



}

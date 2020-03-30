package DefinignClasses_fodler_temp;

public class BankAccount {
public static  int idCounter;
public static  double interestRate = 0.2d;
private int id;
private double balance;



//static method for changing intrest rate
public static void setInterestRate(double interest) {
	interestRate = interest;
}


}

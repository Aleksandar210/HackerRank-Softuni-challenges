package advanced_Softuni_Classes_Iterables_Comparables;

public class BankAccount {
	private static int USER_ID = 0;
	private int id;
private double balance;
private String name;


public BankAccount(String name) {
	USER_ID+=1;
	setId(USER_ID);
	setBalance(0);
	setName(name);
}

public void deposit(double money) {
	if(money==0) {
		return;
	}
	setBalance(getBalance()+money);
}

public double withdraw(double sum) {
	if(sum<=getBalance()) {
		setBalance(getBalance()-sum);
		return sum;
		
	}else {
		return 0;
	}
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

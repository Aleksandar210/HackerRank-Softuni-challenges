import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import advanced_Softuni_Classes_Iterables_Comparables.BankAccount;
public class OOP_Basics {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
	}
	
	static void BankAccount() {
		Map<Integer,BankAccount> accaounts = new HashMap<Integer,BankAccount>();
		String enterCommand = scan.nextLine();
		while(!"end".equalsIgnoreCase(enterCommand)) {
			String[] commands = enterCommand.split("\\s+");
			
		}
	}
	static void executeCommand(String[]commands,Map<Integer,BankAccount> accounts) {
		switch(commands[0].toLowerCase()) {
		case "create":
			BankAccount acc = new BankAccount(commands[1]);
			accounts.put(acc.getId(), acc);
			break;
			
		case "deposit":
			if(!accounts.containsKey(Integer.parseInt(commands[1]))) {
				System.out.println("Account not found");
			}else {
			accounts.get(Integer.parseInt(commands[1])).deposit(Double.parseDouble(commands[2]));
			}
			
			break;
		case "withdraw":
			
			break;
		}
	}
	

}

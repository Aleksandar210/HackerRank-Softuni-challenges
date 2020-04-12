
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import advanced_Softuni_Classes_Iterables_Comparables.BankAccount;
import advanced_Softuni_Classes_Iterables_Comparables.Player;
import advanced_Softuni_Classes_Iterables_Comparables.Guild;
public class OOP_Basics {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//BankAccountTaskExtended();
	
	}
	
	
	//BankAccount task Player task and Guild task connected in one (to finish action method)
	//-------------------------------------------------------------------------------
	
	static void BankAccountTaskExtended() {
		Map<Integer,BankAccount> accounts = new HashMap<Integer,BankAccount>();
		Map<String,Player> playersWithoutGuild = new HashMap<String,Player>();
		Map<String,Guild> guildAvailable = new HashMap<String,Guild>();
		
		choseAction(accounts,playersWithoutGuild,guildAvailable);
		
		
		
	}
	
	static void choseAction(Map<Integer,BankAccount> accounts,Map<String,Player>playersWithoutGuild,Map<String,Guild>guildsAvailable) {
		int select;
		do {
		System.out.println("1| Execute BankAccounts commands");
		System.out.println("2| Execute PlayerCreation commands");
		System.out.println("3| Execute GuildCreationCommands");
		System.out.println("4| Back");
		System.out.print("Select: ");
		select = Integer.parseInt(scan.nextLine());
		}while(select<1 || select>4);
		switch(select) {
		case 1:
			int numberCommands = Integer.parseInt(scan.nextLine());
			enterCommandsBankAccount(numberCommands,accounts);
			break;
		case 2:
			int numberPlayers = Integer.parseInt(scan.nextLine());
			enterPlayerCommands(numberPlayers,playersWithoutGuild);
			break;
		case 3:
			
			break;
		}

	}
	
	static void enterCommandsBankAccount(int numberCommands,Map<Integer,BankAccount> accounts) {
		String enterCommand;
		while(numberCommands-- >0) {
			enterCommand = scan.nextLine();
			String[] commands = enterCommand.split("\\s+");
			executeCommand(commands,accounts);
		}
	}
	
	static void enterPlayerCommands(int numberPlayers,Map<String,Player> players) {
		
		
		
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
			if(!accounts.containsKey(Integer.parseInt(commands[1]))) {
				System.out.println("Account not fouhnd");
			}else {
			accounts.get(Integer.parseInt(commands[1])).withdraw(Double.parseDouble(commands[2]));
			}
			break;
		}
	}
	
	//-------------------------------------------------------------------------------
	

}

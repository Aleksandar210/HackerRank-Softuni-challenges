
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import advanced_Softuni_Classes_Iterables_Comparables.BankAccount;
import advanced_Softuni_Classes_Iterables_Comparables.Boat;
import advanced_Softuni_Classes_Iterables_Comparables.Book;
import advanced_Softuni_Classes_Iterables_Comparables.Box;
import advanced_Softuni_Classes_Iterables_Comparables.Car;
import advanced_Softuni_Classes_Iterables_Comparables.Chicken;
import advanced_Softuni_Classes_Iterables_Comparables.ChickenFarm;
import advanced_Softuni_Classes_Iterables_Comparables.Child;
import advanced_Softuni_Classes_Iterables_Comparables.FootballTeam;
import advanced_Softuni_Classes_Iterables_Comparables.GoldEditionBook;
import advanced_Softuni_Classes_Iterables_Comparables.Player;
import advanced_Softuni_Classes_Iterables_Comparables.RadioDataBase;
import advanced_Softuni_Classes_Iterables_Comparables.Team;
import advanced_Softuni_Classes_Iterables_Comparables.Vehicle;
import advanced_Softuni_Classes_Iterables_Comparables.Guild;
import advanced_Softuni_Classes_Iterables_Comparables.Person;
import advanced_Softuni_Classes_Iterables_Comparables.Pizza;
public class OOP_Basics {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//BankAccountTaskExtended();
		//box();
		//chickenFarm();
		//pizzaTask();
		//fooballTeams;
		//childTask();
		//
		//
	
		
		
	}
	
	static void radioDataBase() {
		int numberSongs = Integer.parseInt(scan.nextLine());
		RadioDataBase currentRadio = new RadioDataBase();
		while(numberSongs-- >0) {
			String enterSong = scan.nextLine();
			currentRadio.addSong(enterSong);
		}
		System.out.println(currentRadio.getLength());
	}
	
	static void Animals() {
		
	}
	
	static void books() {
		try {
		String author = scan.nextLine();
		String title = scan.nextLine();
		int price = Integer.parseInt(scan.nextLine());
		Book currentBook = new Book(author,title,price);
		GoldEditionBook currentGolden = new GoldEditionBook(author,title,price);
		System.out.println(currentBook);
		System.out.println(currentGolden);
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			books();
		}
	}
	
	static void childTask() {
		String name = scan.nextLine();
		int age = Integer.parseInt(scan.nextLine());
		try {
		Child currentChild = new Child(name,age);
		System.out.println(currentChild);
		}catch(IllegalArgumentException ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	
	//Encapsulation
	//----------------------------------------------------------------------------
	//---------------------------------------------------
	static void footballTeams() {
		Map<String, FootballTeam> teams = new HashMap<>();
		String enterCommand = scan.nextLine();
		while(!"end".equalsIgnoreCase(enterCommand)) {
			
			executeCommandTeam(enterCommand.split(";"),teams);
			enterCommand = scan.nextLine();
		}
		
		
	}
	
	static void executeCommandTeam(String[] commands,Map<String,FootballTeam> teams) {
		switch(commands[0].toLowerCase()) {
		case "team":
			if(teams.containsKey(commands[1])) {
				System.out.println("Team already exists");
			}else {
				FootballTeam currentTeam = new FootballTeam(commands[1]);
				teams.put(commands[1], currentTeam);
			}
			break;
		case "add":
			if(teams.containsKey(commands[1])) {
				teams.get(commands[1]).addPlayer(commands);
			}else {
				System.out.println("No such team found");
			}
			break;
		case "remove":
			if(teams.containsKey(commands[1])) {
				teams.get(commands[1]).removePlayer(commands[2]);
			}else {
				System.out.println("No such team found");
				
			}
			break;
		case "rating":
			if(teams.containsKey(commands[1])) {
				System.out.println(teams.get(commands[1]).getTeamRating());
			}else {
				System.out.println("No such team found");
			}
			break;
		}
	}
	//----------------------------------------------------
	
	
	
	//-------------------------------------------------------
	static void pizzaTask() {
		String enterPizza = scan.nextLine();
		String[] enterPizzaData = enterPizza.split("\\s+");
		StringBuilder sb = new StringBuilder();
		int numberToppings =0;
		for(int i =0;i<enterPizzaData.length;i++) {
			if(Character.isDigit(enterPizzaData[i].charAt(0))) {
				numberToppings+=Integer.parseInt(enterPizzaData[i]);
			}else {
				sb.append(enterPizzaData[i]);
			}
		}
		Pizza currentPizza = new Pizza(sb.toString());
		String enterDoughData = scan.nextLine();
		currentPizza.setDough(enterDoughData.split("\\s+"));
		while(numberToppings-- >0) {
			String enterToppingData = scan.nextLine();
			currentPizza.addTopping(enterToppingData.split("\\s+"));
		}
		
		System.out.println("Pizza has "+currentPizza.getPizzaCalorie()+" calories");
		
		System.out.println("with ");
		currentPizza.seePizzaToppings();
		
	}
	//-------------------------------------------------------------------------------
	
	
	
	//----------------------
	static void chickenFarm() {
		ChickenFarm currentFarm = new ChickenFarm(10);
		
		int numberChickens = Integer.parseInt(scan.nextLine());
		do {
			enterChickenData(scan.nextLine(),Integer.parseInt(scan.nextLine()));
		}while(numberChickens-- >0);
		
		
	}
	
	static Chicken enterChickenData(String name, int age) {
		Chicken current;
		String currentMessage =" ";
		String currentName = name;
		int currentAge = age;
		if(name.isEmpty() && age!=-1) {
			do {
			System.out.print("Enter valid name: ");
			currentName = scan.nextLine();
			}while(!name.isEmpty());
			enterChickenData(currentName,currentAge);
		}else if(!name.isEmpty() && age==-1) {
			do {
				System.out.print("Enter valid age: ");
				currentAge = Integer.parseInt(scan.nextLine());
				}while(currentAge>0 && currentAge <16);
				enterChickenData(currentName,currentAge);
		}else if(!name.isEmpty() && age!=-1) {
			 Chicken currentChick = new Chicken(currentName,currentAge);
			 return currentChick;
		}else {
			
		
		try {
			System.out.print("Enter name: ");
			currentName = scan.nextLine();
			System.out.println("Enter age: ");
			 currentAge= Integer.parseInt(scan.nextLine());
			
		 current = new Chicken(scan.nextLine(),Integer.parseInt(scan.nextLine()));
		
		}catch(IllegalArgumentException ex) {
			currentMessage = ex.getMessage();
		}finally {
			if(currentMessage.contains("name")) {
				if(currentAge<1 && currentAge>15) {
					System.out.println("Invalid age");
					System.out.println("Invalid name!");
					enterChickenData(currentName,-1);
				}else {
					System.out.println("Invalid name!");
					enterChickenData(currentName,currentAge);
				}
				
			}else {
				enterChickenData(currentName,-1);
			}
		}
		}
		return null;
	}
	//----------------------
	
	
	
	
	// Box task
	static void box() {
		double enter;
		int counter =3;
		int indexCounter =0;
		Box currentBox = null;
		double[] attributesBox = new double[3];
		while(counter-- >0) {
			enter = Double.parseDouble(scan.nextLine());
			attributesBox[indexCounter] = enter;
			indexCounter++;
		}
		try {
		currentBox = new Box(attributesBox[0],attributesBox[1],attributesBox[2]);
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(currentBox);
		
		
	}
	
//------------------------------------------------------------------------------
	static void labTask() {
		Map<String, Team> teams = new HashMap<String, Team>();
		Map<String ,Person> people = new HashMap<String,Person>();
		String enterPlayer;
		String enterTeamName;
		
		System.out.print("Enter number of people: ");
		int numberPlayers = Integer.parseInt(scan.nextLine());
		while(numberPlayers-- >0) {
			Person currentPlayer = null;
			enterPlayer = scan.nextLine();
			
			String[] playerData  = enterPlayer.split("\\s+");
			
			if(playerData.length==4) {
				
				try {
				double currentSalary = Double.parseDouble(playerData[3]);
				currentPlayer = new Person(playerData[0],playerData[1],Integer.parseInt(playerData[2]),currentSalary);
				
				}catch(NumberFormatException ex) {
					currentPlayer = new Person(playerData[0],playerData[1],Integer.parseInt(playerData[2]),playerData[3]); 
				}
				
			}else if(playerData.length==3) {
				currentPlayer = new Person(playerData[0],playerData[1],Integer.parseInt(playerData[2]));
			}else if(playerData.length==2) {
				currentPlayer = new Person(playerData[0],Integer.parseInt(playerData[1]));
				
			}else {
				
			}
				
			
			
		}
		
		
		
		System.out.print("Number teams: ");
		int numberTeams = Integer.parseInt(scan.nextLine());
		while(numberTeams-- >0) {
			Team currentTeam = new Team(scan.nextLine());
			teams.put(currentTeam.getName(), currentTeam);
			
		}
		
		
		
		
		
	}
	//------------------------------------------------------------------------
	
	
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
	
	//Encapsulation
		//----------------------------------------------------------------------------
	
	
	
	
	
	
	
	//Inheritance
	//--------------------------------------------------------------------------
}

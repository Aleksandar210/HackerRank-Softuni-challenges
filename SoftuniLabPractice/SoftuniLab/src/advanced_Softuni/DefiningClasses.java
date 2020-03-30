package advanced_Softuni;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

import DefinignClasses_fodler_temp.BankAccount;
import DefinignClasses_fodler_temp.Car;
import DefinignClasses_fodler_temp.Person;
public class DefiningClasses {
	public static void main(String[] args) {
		//carClassDefine();
		//bankAccountMethod();
		//opinionPool();
		//
	}
	
	static void opinionPool() {
		int numberPeople = getInt();
		java.util.List<Person> people = new LinkedList<>();
		do {
			String enterPersonData = getString();
			String[] data = enterPersonData.split("\\s+");
			people.add(new Person(data[0],Integer.parseInt(data[1])));
		}while(numberPeople>0);
		people = people.stream().filter(e ->e.getAge()>30)
				.sorted((a,b)->a.getName().compareTo(b.getName()))
				.collect(Collectors.toList());
		
		people.forEach(System.out::println);
		
	}
	
	
	
	
	
	
	
	static void bankAccountMethod() {
		String enterCommands;
		String[] commands;
		Map<Integer,BankAccount> accounts = new HashMap<Integer,BankAccount>();
		enterCommands = getString();
		while(!"end".equalsIgnoreCase(enterCommands)) {
			commands = enterCommands.split("\\s+");
			switch(commands.length) {
			case 1:
				BankAccount currentBankAccount = new BankAccount();
				accounts.put(currentBankAccount.getId(), currentBankAccount);
			break;
			case 2:
				BankAccount.interestRate = Double.parseDouble(commands[1]);
				break;
			case 3:
				
				if(accounts.get(Integer.parseInt(commands[1]))==null) {
					System.out.println("Account doesnt exist");
					break;
				}
				BankAccount tempAccount = accounts.get(Integer.parseInt(commands[1]));
				if("deposit".equalsIgnoreCase(commands[0])) {
					
					tempAccount.deposit(Double.parseDouble(commands[2]));
					
					}else {
						System.out.println(tempAccount.getInterest(Integer.parseInt(commands[2])));
						
					}
					
				break;
				default:
					System.out.println("Input ignored!");
					break;
			}
			
			enterCommands = getString();
		}
		
		
	}
	
	
	
	
	
	static void carClassDefine() {
		Car car = new Car(getString(),getString(),getInt());
		System.out.println(car);
		
	}
	
	
	
	
	
	
	
	
	
	//
	static String getString() {
		try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));) {
			String currentString = bfr.readLine();
			return currentString;
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (String) null;
	}

	
	
	
	@SuppressWarnings("null")
	static double getDouble() {
		try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));) {
			double number = Double.parseDouble(bfr.readLine());
			return number;
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Double) null;
	}
	
	
	
	@SuppressWarnings("null")
	static int getInt() {
		try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));) {
			int number = Integer.parseInt(bfr.readLine());
			return number;
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Integer) null;
	}

}

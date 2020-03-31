package advanced_Softuni;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import DefinignClasses_fodler_temp.BankAccount;
import DefinignClasses_fodler_temp.Car;
import DefinignClasses_fodler_temp.Employee;
import DefinignClasses_fodler_temp.Person;
public class DefiningClasses {
	public static void main(String[] args) {
		//carClassDefine();
		//bankAccountMethod();
		//opinionPool();
		//employee();
	}
	
	
	
	static void racer() {
		Map<String,Car> racers = new HashMap<String,Car>();
		int numberCars = getInt();
		String enterRacerData;
		
		do {
			enterRacerData = getString();
			String[] data = enterRacerData.split("\\s+");
			
			if(racers.get(data[0])==null) {
				racers.put(data[0], new Car(data[0],Double.parseDouble(data[1]),Double.parseDouble(data[2])));
			}
			
		}while(numberCars>0);
		
	    String enterCommand;
	    do {
	    	enterCommand = getString();
	    	if("end".equalsIgnoreCase(enterCommand)) {
	    		break;
	    	}else {
	    		
	    	}
	    }while(!"end".equalsIgnoreCase(enterCommand));
	}
	
	
	
	
	static void employee() {
		int numberEmployees =getInt();
		Map<String,Set<Employee>> empNames = new HashMap<String,Set<Employee>>();
		Map<String,Double> depSalaries = new HashMap<String,Double>();
		String enterEmpData;
		while(numberEmployees>0) {
			enterEmpData = getString();
			String[] data = enterEmpData.split("\\s+");
			if(data.length==4) {
				
				if(empNames.get(data[3])==null) {
					empNames.put(data[3], new HashSet<Employee>());
					Employee currentEmployee = new Employee(data[0],Double.parseDouble(data[1]),data[2],data[3]);
					empNames.get(data[3]).add(currentEmployee);
					addAverage(depSalaries,currentEmployee);
				}else {

					Employee currentEmployee = new Employee(data[0],Double.parseDouble(data[1]),data[2],data[3]);
					empNames.get(data[3]).add(currentEmployee);
				}
				
			}else {
				if(empNames.get(data[3])==null) {
					empNames.put(data[3], new HashSet<Employee>());
					Employee currentEmployee = new Employee(data[0],Double.parseDouble(data[1]),data[2],data[3],data[4]);
					empNames.get(data[3]).add(currentEmployee);
					addAverage(depSalaries,currentEmployee);
				}else {

					Employee currentEmployee = new Employee(data[0],Double.parseDouble(data[1]),data[2],data[3],data[4]);
					empNames.get(data[3]).add(currentEmployee);
				}
			}
			numberEmployees--;
		}
		
		employeeMenue(empNames,depSalaries);
	}
	
	static void  employeeMenue(Map<String,Set<Employee>> list,Map<String,Double> averageSalaries) {
		boolean exit = false;
		int select;
		while(!exit) {
			do {
		System.out.println("1| Display departmetn average-salary");
		System.out.println("2| Display department with highest-salary");
		System.out.println("3| search employees");
		System.out.println("4| exit");
		System.out.print("Select: ");
		 select = getInt();
		 switch(select) {
		 case 1:
			 averageSalaryMenue(averageSalaries);
			 break;
		 case 2:
		 highestAverageSalary(averageSalaries);
		 break;
		 case 3:
			 searchEmployee(list);
			 break;
		 case 4:
			 exit =true;
			 break;
		 }
		}while(!exit);
	}
		
	}
	
	static void searchEmployee(Map<String,Set<Employee>> emp) {
		for(Map.Entry<String, Set<Employee>> entry: emp.entrySet()) {
			entry.getKey();
		}
		String enter;
		do {
			
		System.out.print("Enter Department: ");
		enter = getString();
		if(emp.containsKey(enter)) {
			for(Employee empl:emp.get(enter)) {
				System.out.println(empl);
			}
			return;
		}else {
			System.out.println("no department found.");
			return;
		}
		
		}while(!emp.containsKey(enter));
			
			
		
	}
	
	
	static void averageSalaryMenue(Map<String,Double> averageSalaries) {
		boolean back = false;
		int select;
		do {
			System.out.println("1|Search department");
			System.out.println("2|Back");
			System.out.print("select: ");
			select = getInt();
			switch(select) {
			case 1:
				
				int counter =1;
				 System.out.println("Select Department:");
				 for(Map.Entry<String,Double> entry:averageSalaries.entrySet()) {
					 System.out.println(counter+": "+entry.getKey());
					 counter++;
				 }
				 	 System.out.print("Enter Department Name: ");
					 String depName = getString();
					 if(averageSalaries.containsKey(depName)) {
						 System.out.println("Department average Salary:");
						 System.out.println(averageSalaries.get(depName));
						 
						 
					 }else {
						 System.out.println("No Department found!");
					 }
				
				break;
			case 2:
				back =true;
				break;
			}
		
				 
		}while(!back);	 
			 
		 
		
	 
	}
	
	
	
	
	static void addAverage(Map<String,Double> salaries,Employee emp) {
		if(salaries.get(emp.getDepartment())==null) {
			salaries.put(emp.getDepartment(), emp.getSalary());
		}else {
			double tempSalary = salaries.get(emp.getDepartment());
			salaries.put(emp.getDepartment(),emp.getSalary()+tempSalary);
		}
	}
	
	
	static void highestAverageSalary(Map<String,Double> salaries) {
		double max = Double.MIN_NORMAL;
		String depName=null;
		for(Map.Entry<String, Double> entry:salaries.entrySet()) {
			if(entry.getValue()>max) {
				max = entry.getValue();
				depName = entry.getKey();
			}
		}
		
		System.out.printf("%s -> %.2f",depName,max);
	}
	
	
	
	
	
	
	
	
	
	
	
	//-------------------------------------------------------------------------
	
	
	
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

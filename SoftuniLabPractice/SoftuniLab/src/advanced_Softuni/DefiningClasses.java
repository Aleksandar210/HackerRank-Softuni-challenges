package advanced_Softuni;


import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import DefinignClasses_fodler_temp.BankAccount;
//import DefinignClasses_fodler_temp.Car;
import DefinignClasses_fodler_temp.Employee;
import DefinignClasses_fodler_temp_cargoCar_Classes.Car;
import DefinignClasses_fodler_temp_cargoCar_Classes.Engine;
import DefinignClasses_fodler_temp_cargoCar_Classes.Person;

public class DefiningClasses {
	public static void main(String[] args) {
		//carClassDefine();
		//bankAccountMethod();
		//opinionPool();
		//employee();
		//racer();
		//cargoCar();
		//carSales();
		//familyTree();
		
	}
	static String firstName;
	static void familyTree() {
		Person firstPerson;
		String enterMember;
		Map<String,Person> names = new LinkedHashMap<String,Person>();
		Map<String,Person> dates = new LinkedHashMap<String,Person>();
		Map<String,String> namesDate = new HashMap<String,String>();
		boolean addedNameFirst;
		do {
			enterMember = getString();
		    
			
			if(enterMember.contains("-")) {
				String[] personData = enterMember.split("-");
				if(Character.isAlphabetic(personData[0].charAt(0)) && Character.isAlphabetic(personData[1].charAt(0))) {
					String[] namesArray = personData[0].split("\\s+");
					String[] childNames = personData[1].split("\\s+"); 
					names.put(personData[0],new Person(namesArray[0],namesArray[1],true,childNames));
					names.put(names.get(personData[0]).getBothNames(),names.get(personData[0]).getChild());
					
				}else if(Character.isAlphabetic(personData[0].charAt(0)) && Character.isDigit(personData[1].charAt(0))) {
					String[] namesArray = personData[0].split("\\s+");
					String[] childDate = personData[1].split("/"); 
					names.put(personData[0],new Person(namesArray[0],namesArray[1],false,childDate));
					dates.put(names.get(personData[0]).getChild().birthday(),names.get(personData[0]).getChild());
				}else if(Character.isDigit(personData[0].charAt(0)) && Character.isDigit(personData[1].charAt(0))) {
					String[] parentDate = personData[0].split("/");
					String[] childDate = personData[1].split("/"); 
					dates.put(personData[0], new Person(Integer.parseInt(parentDate[0]),Integer.parseInt(parentDate[1]),Integer.parseInt(parentDate[2]),false,childDate));
					dates.put(dates.get(personData[0]).getChild().birthday(),dates.get(personData[0]).getChild());
					
				}else if(Character.isDigit(personData[0].charAt(0)) &&  Character.isAlphabetic(personData[1].charAt(0))) {
					String[] namesArray = personData[1].split("\\s+");
					String[] childDate = personData[0].split("/"); 
					
					dates.put(personData[0],new Person(Integer.parseInt(childDate[0]),Integer.parseInt(childDate[1]),Integer.parseInt(childDate[2]),true,namesArray));
					names.put(dates.get(personData[0]).getChild().getBothNames(), dates.get(personData[0]).getChild());
					
				}
				
			}else {
				String[] personData = enterMember.split("\\s+");
				String bothNames = personData[0]+" "+personData[1];
				if(names.containsKey(bothNames)) {
					names.get(bothNames).setYearBorn(Integer.parseInt(personData[2]));
					names.get(bothNames).setMonth(Integer.parseInt(personData[3]));
					names.get(bothNames).setDay(Integer.parseInt(personData[4]));
					
					
					
				}else if(dates.containsKey(personData[2]+"/"+personData[3]+"/"+personData[4])) {
					dates.get(personData[2]+"/"+personData[3]+"/"+personData[4]).setFirstName(personData[0]);
					dates.get(personData[2]+"/"+personData[3]+"/"+personData[4]).setSecondName(personData[1]);
					
				}else {
				
				}
				
			}
			
			
			
			
		}while(!"end".equalsIgnoreCase(enterMember));
		
		for(Map.Entry<String,Person> name:names.entrySet()) {
			firstName =  name.getKey();
			break;
		}
		
		
		
	}
	
	static String firstPerson(boolean alreadyIn,String personData) {
		if(personData.contains("-")) {
			String[] data = personData.split("-");
			return data[0];
		}else {
			String[] data = personData.split("\\s+");
			
		}
	}
	
	
	
	static void carSales() {
		int numberEngines = getInt();
		HashMap<String,Stack<Engine>> engines = new HashMap<String,Stack<Engine>>();
		while(numberEngines>0) {
			String enterEngine = getString();
			String[] engineData = enterEngine.split("\\s+");
			if(engines.get(engineData[0])==null) {
				engines.put(engineData[0],new Stack<Engine>());
				engines.get(engineData[0]).add(new Engine(engineData[0],Integer.parseInt(engineData[1])));
				
			}else {
				engines.get(engineData[0]).add(new Engine(engineData[0],Integer.parseInt(engineData[1])));
			}
			numberEngines--;
		}
		int numberCars = getInt();
		
		LinkedList<Car> cars = new LinkedList<Car>();
		while(numberCars>0) {
			String enterCarData = getString();
			String[] carData = enterCarData.split("\\s+");
			Engine getEngine = engines.get(carData[1]).pop();
			cars.add(new Car(carData[0],getEngine));
			
			
		}
		
		for(Car car: cars) {
			System.out.println(car.getModel());
			System.out.print(car.getEngine().getModel());
			System.out.println(car.getEngine().getPower());
			System.out.println();
		}
	}
	
	
	
	static void cargoCar() {
		
		Map<String,LinkedList<Car>> carByType = new LinkedHashMap<String,LinkedList<Car>>();
		int numberCars = getInt();
		String enter;
		while(numberCars>0) {
			enter = getString();
			String[] data = enter.split("\\s+");
			String tireData[] = new String[7];
			transferTireDataArray(data,tireData);
			addCarToList(carByType,data,tireData);
			numberCars--;
		}
		String display = getString();
		for(Car currentCar:carByType.get(display)) {
			System.out.println(currentCar.getModel());
		}
	}
	
	
	static void addCarToList(Map<String,LinkedList<Car>> carByType,String[]data,String[] tireData) {
		if(carByType.get(data[4])==null) {
			
			LinkedList<Car> cars =new LinkedList<Car>();
			Car currentCar = new Car(data[0],Integer.parseInt(data[1]),
					Integer.parseInt(data[2]),Integer.parseInt(data[3]),data[4],
					tireData);
			carByType.put(data[0], cars);
		if(currentCar.getCargo().getType().equalsIgnoreCase("fragile")) {
				for(int i =0;i<4;i++) {
				if(currentCar.getTire(i).getPressure()<1) {
					carByType.get(data[4]).add(currentCar);
					break;
				}
				}
			}else {
				if(currentCar.getEngine().getPower()>250) {
					carByType.get(data[4]).add(currentCar);
				}
			}
			
		}else {
			
			Car currentCar = new Car(data[0],Integer.parseInt(data[1]),
					Integer.parseInt(data[2]),Integer.parseInt(data[3]),data[4],
					tireData);
			
			if(currentCar.getCargo().getType().equalsIgnoreCase("fragile")) {
				for(int i =0;i<4;i++) {
				if(currentCar.getTire(i).getPressure()<1) {
					carByType.get(data[4]).add(currentCar);
					break;
				}
				}
			}else {
				if(currentCar.getEngine().getPower()>250) {
					carByType.get(data[4]).add(currentCar);
				}
			}
		}
	}
	
	
	 static void transferTireDataArray(String[] data, String[] tireData) {
		for(int i=5;5<=10;i+=2) {
			tireData[i] = data[i];
			tireData[i+1] = data[i+1];
		}
	}
	
	
	
	
	
	static void racer() {
		Map<String,Car> racers = new HashMap<String,Car>();
		int numberCars = getInt();
		String enterRacerData;
		
		do {
			enterRacerData = getString();
			String[] data = enterRacerData.split("\\s+");
			
			if(racers.get(data[0])==null) {
		//		racers.put(data[0], new Car(data[0],Double.parseDouble(data[1]),Double.parseDouble(data[2])));
			}
			
		}while(numberCars>0);
		
	    String enterCommand;
	    String[] commands;
	    do {
	    	enterCommand = getString();
	    	if("end".equalsIgnoreCase(enterCommand)) {
	    		break;
	    	}else  {
	    		commands = enterCommand.split("\\s+");
	    		if(racers.containsKey(commands[1])) {
	    //			racers.get(commands[1]).Drive(Integer.parseInt(commands[2]));
	    		}else {
	    			
	    		}
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

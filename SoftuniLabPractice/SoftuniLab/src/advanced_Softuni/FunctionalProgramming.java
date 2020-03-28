package advanced_Softuni;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import java.util.stream.Collectors;

import softuni_objectsandclasses_folder.Person;

public class FunctionalProgramming {
	public static void main(String[] args) {
		sortEvenNumbers();
		countUpperCase();
		getSizeSum();
		getOddEvenCount();
		filterByAge();
		vatCalculate();
		evenOrOdd();
		filterByAgeOnlyLambdas();
		printCollection();
		knightHonor();
		smallest();
		arithmetic();
		reverseExclude();
		predicateNames();
		getSmallestElement();
		
		
	}
	
	
	static void getSmallestElement() {
		Optional<Integer> getSmallest = Arrays.stream(getString().split("\\s+"))
				.map(e ->Integer.parseInt(e))
				.reduce((a,b)-> a<b? a :b);
		System.out.println(getSmallest);
	}
	
	
	
	static void predicateNames() {
		int lengthName = getInt();
		
		Predicate<String> checkName = name ->name.length()<=lengthName;
		List<String> names = Arrays.stream(getString().split("\\s+"))
				.filter(checkName)
				.collect(Collectors.toList());
		names.forEach(System.out::println);
		
	}
	
	
	static void reverseExclude() {
		List<Integer> numbers = Arrays.stream(getString().split("\\s+"))
				.map(e ->Integer.parseInt(e))
				.filter(e -> e/2!=0)
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
				
				numbers.forEach(System.out::println);
	}
	
	
	static void arithmetic() {
		
		Function<Integer,Integer> addOne = e -> e++;
		Function<Integer,Integer> multiply = e->e*=2;
		Function<Integer,Integer> substract = e->e--;
		List<Integer> numbers = Arrays.stream(getString().split("\\s+"))
				.map( e ->Integer.parseInt(e))
				.collect(Collectors.toList());
		String enterCommand;
		
		do {
			enterCommand = getString();
			if("end".equalsIgnoreCase(enterCommand)) {
				break;
			}else {
				switch(enterCommand.toLowerCase()) {
				case "add":
					numbers.stream().map(addOne);
					break;
				case "substract":
					numbers.parallelStream().map(substract);
					break;
				case "multiply":
					numbers.stream().map(multiply);
					break;
					default:
						numbers.forEach(System.out::println);
						break;
				}
				
				
			}
			
		}while(!"end".equalsIgnoreCase(enterCommand));
		
	}
	
	
	
	
	
	static void smallest() {
		
		Optional<Integer> smallestNumber  = Arrays.stream(getString().split(",\\s+"))
				.map(e ->Integer.parseInt(e))
				
				.reduce((a,b) -> a<b? a:b);
				
				smallestNumber.ifPresent(System.out::println);
				
				
	}
	
	
	static void knightHonor() {
		List<String> names = Arrays.stream(getString().split(" "))
				.map(name -> "sir"+name)
				.collect(Collectors.toList());
		names.forEach(System.out::println);
	}
	
	
	static void printCollection() {
		List<String> items = Arrays.stream(getString().split(" ")).collect(Collectors.toList());
		items.forEach(System.out::println);
		
	}
	
	
	static void filterByAgeOnlyLambdas() {
		int numberPeople = getInt();
		HashMap<String,Integer> persons = new HashMap<String,Integer>(numberPeople);
		
		if(numberPeople<=0) {
			return;
		}
		
		while(numberPeople>0) {
			String[] enterPersonNameAge = getString().split("\\s+");
			persons.put(enterPersonNameAge[0], Integer.parseInt(enterPersonNameAge[1]));
		}
		String enterComparison =  getString();
		int ageLimit = getInt();
		String print = getString();
		
Predicate<Map.Entry<String,Integer>> isYounger = pers ->pers.getValue()<ageLimit;
Predicate<Map.Entry<String,Integer>> isOlder = pers ->pers.getValue()>=ageLimit;

Predicate<Map.Entry<String, Integer>> finalAgeComparison= isYounger;
if(enterComparison.equalsIgnoreCase("older")) {
	finalAgeComparison = isOlder;
}

Consumer<Map.Entry<String,Integer>> printResult = (pers) -> {
	if("name".equalsIgnoreCase(print)) {
		System.out.println(pers.getKey());
	}else if("age".equalsIgnoreCase(print)) {
		System.out.println(pers.getValue());
	}else {
		System.out.println(pers.getKey()+" "+pers.getValue());
	}
	
};
	

persons.entrySet().stream().filter(finalAgeComparison).forEach(printResult);

			
		
	}
	
	
	
	
	
	
	
	static void evenOrOdd() {
		String enterRange = getString();
		String[] temp = enterRange.split(",\\s+");
		Predicate<Integer> isEven = e -> e%2==0;
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		String filterBy = getString();
		switch(filterBy.toLowerCase()) {
		case "even":
			for(int i = Integer.parseInt(temp[0]);i<Integer.parseInt(temp[1]);i++) {
			if(!isEven.test(i)) {
				enter(i,e ->numbers.add(e));
			}
			}
			break;
			default:
				for(int i = Integer.parseInt(temp[0]);i<Integer.parseInt(temp[1]);i++) {
				if(isEven.test(i)) {
					enter(i,e->numbers.add(e));
				}
				}
		}
		
	}
	
	static void enter(int number, Consumer<Integer> sup) {
		sup.accept(number);
	}
	
	static void filterByAge() {
		int numberLines = getInt();
		List<Person> people = new LinkedList<Person>();
		String enterPersonData;
		while(numberLines>0) {
			
			enterPersonData = getString();
			String[] personDetails = enterPersonData.split("[,\\s]+");
			people.add(new Person(personDetails[0],Integer.parseInt(personDetails[1])));
		
		}
		
		String enterCondition = getString();
		int enterAgeFilter = getInt();
		switch(enterCondition.toLowerCase()) {
		case "younger":
			people = people.stream().filter(e -> e.getAge()<=enterAgeFilter).collect(Collectors.toList());
			break;
		case "odler":
			people = people.stream().filter( e-> e.getAge()>=enterAgeFilter)
			.collect(Collectors.toList());
			break;
			default :
				System.out.println("Invalid condition");
				break;
		}
		String presentBy = getString();
		
		switch(presentBy.toLowerCase()) {
		case "name":
			people.forEach(e -> System.out.println(e.getName()));
			break;
		case "age":
			people.forEach(e -> System.out.println(e.getAge()));
			break;
		case "name age":
			people.forEach(e ->System.out.println(e));
			break;
			default: System.out.println("invalid format");
			break;
		}
		
			
		
	}
	
	
	//-------------------------------------------------------------------------------
	static void vatCalculate() {
		String enterNumbers = getString();
		String[]  numbers = enterNumbers.split("[\\s]+[,]");
		List<Double> results = Arrays.stream(numbers)
				.map(e ->Double.parseDouble(e))
				.map(num -> num*1.2)
				.collect(Collectors.toList());
		System.out.println("Price with VAT");
		results.forEach( e-> System.out.println());
				
		
	}
	//-------------------------------------------------------------------------------
	
	
	
	
	//-------------------------------------------------------------------------------
	static void getOddEvenCount() {
		
		List<Integer> oddNumbers = new LinkedList<Integer>();
		String[] numbersToManipulate = getString().split("[,\\s]+");
		List<Integer> evenNumbers = Arrays.stream(numbersToManipulate)
				.map(e ->Integer.parseInt(e))
				.filter(number -> number%2==0)
				.collect(Collectors.toList());
		
		oddNumbers = Arrays.stream(numbersToManipulate)
				.map(num ->Integer.parseInt(num))
				.filter(e ->e%2!=0)
				.collect(Collectors.toList());
		
		System.out.println("evenCount ->"+evenNumbers.size() + " "+ evenNumbers);
		System.out.println("oddCount ->" + oddNumbers.size()+" "+oddNumbers);
				
				
	}
	
	static void putInOdd(int number,Consumer<Integer> put) {
		Predicate<Integer> isOdd = num -> num%2!=0;
		
		if(isOdd.test(number))
			put.accept(number);
	}
	
	
	//-------------------------------------------------------------------------------
	
	
	
	//-------------------------------------------------------------------------------
	static void getSizeSum() {
		List<Integer> numbers = Arrays.stream(getString().split(", "))
				.map(e ->Integer.parseInt(e)).collect(Collectors.toList());
		int sum = numbers.stream().reduce(0, (a,b)->a+b);
		System.out.println(numbers.size());
		System.out.println(sum);
	}
	//-------------------------------------------------------------------------------
	
	
	
	
	
	
	//-------------------------------------------------------------------------------
	static void countUpperCase() {
		Predicate<String> isUpperCase = e -> e.startsWith("[A-Z]");
		List<String> getUpperCase = Arrays.stream(getString().split(" "))
				.filter(isUpperCase).collect(Collectors.toList());
		System.out.println(getUpperCase.size());
		getUpperCase.forEach(e -> System.out.println());
	}
	//-------------------------------------------------------------------------------
	
	
	
	
	//-------------------------------------------------------------------------------
	static void sortEvenNumbers() {
		String getNumbers = getString();
		
		
		List<String> evenNumbers = Arrays.stream(getNumbers.split(", ")).map((e) -> Integer.parseInt(e))
				.filter(e -> e%2==0).map(e -> String.valueOf(e)).collect(Collectors.toList());
		
		System.out.println(String.join(",",evenNumbers));
		
		evenNumbers = evenNumbers.stream().map(e-> Integer.parseInt(e)).sorted((a,b) ->a.compareTo(b))
				.map(e ->String.valueOf(e)).collect(Collectors.toList());
		System.out.println(String.join(",", evenNumbers));
	}
	//-------------------------------------------------------------------------------
	
	
	
	
	
	
	
	//some bufferedReader experiments;
	//these functions may be used //reason they are here. it is said that the BufferedReader
	//is way faster than the Scanner and I want to try it out and start using it.
	//-------------------------------------------------------------------------------
	
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
//---------------------------------------------------------------------------------------
}

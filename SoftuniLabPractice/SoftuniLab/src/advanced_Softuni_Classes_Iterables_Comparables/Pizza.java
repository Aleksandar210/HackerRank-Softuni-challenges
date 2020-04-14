package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Pizza {
	private static final double DEFAULT_CALORIES =0;
	private String name;
	private Dough dough;
	private Set<String> currentToppingsTypes;
	private Map<String,List<Toping>> currentToppings;
	private Map<String,Double> toppingsGrams;
	private double pizzaCalorie;
	
	public Pizza(String name) {
		setName(name);
		this.currentToppings = new LinkedHashMap<String,List<Toping>>();
		this.toppingsGrams = new LinkedHashMap<String,Double>();
		this.currentToppingsTypes = new HashSet<String>();
		this.pizzaCalorie = DEFAULT_CALORIES;
	}
	
	public void addTopping(String[] toppingData) {
		Scanner scan = new Scanner(System.in);
		Toping currentToping=null;
		try {
			currentToping  = new Toping(toppingData);
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			reEnterToppingData(scan);
		}
		
		this.currentToppingsTypes.add(currentToping.getType());
		if(currentToppings.get(currentToping.getType())==null) {
			this.currentToppings.put(currentToping.getType(),new LinkedList<Toping>());
		}else {
			this.currentToppings.get(currentToping.getType()).add(currentToping);
		}
		if(this.toppingsGrams.containsKey(currentToping.getType())) {
			this.toppingsGrams.put(currentToping.getType(), this.toppingsGrams.get(currentToping.getType())+currentToping.getCaloriesToppings());
			
		}else {
			this.toppingsGrams.put(currentToping.getType(),currentToping.getCaloriesToppings());
			
		}
		
		scan.close();
		
		
	}
	private void reEnterToppingData(Scanner scan) {
		System.out.println("Re-Enter Topping info:");
		String enter = scan.nextLine();
		addTopping(enter.split("\\s+"));
	}
	private void setDough(String[] data) {
		Scanner scan = new Scanner(System.in);
		Dough currentDough = null;
		try {
		currentDough = new Dough(data);
		this.dough=currentDough;
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			reEnterDoughData(scan);
		}
		
		this.dough = currentDough;
		scan.close();
	}
	
	private void reEnterDoughData(Scanner scan) {
		
		System.out.println("Re-Enter Dough data:");
		String enter = scan.nextLine();
		setDough(enter.split("\\s+"));
	}
	
	private void caluclateCaloriesOnPizza() {
		this.pizzaCalorie
		= this.toppingsGrams.entrySet().stream()
				.map(e -> e.getValue())
				.reduce((a,b)->a+b).get();
				
		this.pizzaCalorie+=this.dough.calculateDoughCalories();
				
				
	}
	
	public double getPizzaCalorie() {
		if(this.pizzaCalorie==0) {
			return 0;
		}else {
		return this.pizzaCalorie;
		}
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return  this.name;
	}
	
	
	
	
	
	
	

}

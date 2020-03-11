package FarmerSalesman;

import java.util.ArrayList;

public abstract class Storage {
	private String name;
	private ArrayList<Product> vegitables;
	private ArrayList<Product> fruits;
	private ArrayList<Product> drinks;
	private ArrayList<Product> animals;

	
	public Storage(String name) {
		this.name = name;
	  vegitables = new ArrayList<Product>();
	  fillVegitables();
	  fruits = new ArrayList<Product>(10);
	  fillFruits();
	  drinks = new ArrayList<Product>(10);
	  fillDrinks();
	  animals = new ArrayList<Product>(10);
	  fillAnimals();
	  
	}
	
	private  void  fillVegitables() {
		this.vegitables.add(new Product("Tomato",20,0.50,"vegie"));
		this.vegitables.add(new Product("Cucumber",15,0.90,"vegie"));
		this.vegitables.add(new Product("Green-leafs",20,0.90,"vegie"));
		this.vegitables.add(new Product("Carrots",25,0.20,"vegie"));
		this.vegitables.add(new Product("Potatoes",30,0.40,"vegie"));
		this.vegitables.add(new Product("Cabage",20,1,"vegie"));
		
	}
	
	private void fillFruits() {
		this.fruits.add(new Product("Apple",20,0.15,"fruit"));
		this.fruits.add(new Product("Banana",20,1.2,"fruit"));
		this.fruits.add(new Product("Wtaremallon",20,3,"fruit"));
		this.fruits.add(new Product("Pineapple",20,3,"fruit"));
		
		
	}
	
	private void fillDrinks() {
		this.drinks.add(new Product("Beer",20,5,"drinks"));
		this.drinks.add(new Product("Water",20,4,"drinks"));
		this.drinks.add(new Product("Wine",20,10,"drinks"));
	}
	
	private void fillAnimals() {
		this.animals.add(new Product("Cow",20,100,"animal"));
		this.animals.add(new Product("Horse",20,200,"animal"));
		this.animals.add(new Product("pig",20,50,"animal"));
		this.animals.add(new Product("Chicken",20,20,"animal"));
	}
	
	
	
}

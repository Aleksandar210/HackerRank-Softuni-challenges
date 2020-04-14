package advanced_Softuni_Classes_Iterables_Comparables;

public class Chicken {
	private int countInvalidFields = 0;
	private String name;
	private int age;
	private double eggsPerDay;
	
	
	public Chicken(String name, int age) {
		setName(name);
		setAge(age);
	}
	
	private void setName(String name) {
		if(name.isEmpty() || name.equals(" ")) {
			countInvalidFields++;
			IllegalArgumentException exName = new IllegalArgumentException("Invalid name");
			throw  exName;
			
		}
		this.name = name;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	private void setAge(int age) {
		if(age<1 || age>15) {
			countInvalidFields++;
			IllegalArgumentException exAge = new IllegalArgumentException("Invalid age");
			throw  exAge;
		}else {
		this.age = age;
		}
	}
	
	public int getCountInvalidFields() {
		return this.countInvalidFields;
	}
	
	public int getAge() {
		return this.age;
	}
	
	private void calculateEggsPerDay() {
		if(getAge()<6) {
			this.eggsPerDay = 2;
		}else if(getAge()>5) {
			this.eggsPerDay=1;
		}else {
			this.eggsPerDay=0.75;
		}
	}
	public double getEggsPerDay() {
		calculateEggsPerDay();
		return this.eggsPerDay;
	}

}

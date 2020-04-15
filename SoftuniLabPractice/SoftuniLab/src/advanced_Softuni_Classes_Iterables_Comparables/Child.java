package advanced_Softuni_Classes_Iterables_Comparables;

public class Child extends Person {

	public Child(String name, int age) {
		super(name,age);
		setAge(age);
		setName(name);
		
	}
	
	@Override
	public String toString() {
		String data = String.format("%s %d years old",super.getName(),super.getAge());
		return data;
		
	}
	
	@Override
	public void setAge(int age) {
		if(age<0) {
			throw new IllegalArgumentException("Age must be positive");
		}else if(age>15) {
			throw new IllegalArgumentException("Must be younger than 15");
		}else {
			super.setAge(age);
		}
	}
	
	
	@Override
	public void setName(String name) {
		if(name.length()<3) {
			throw new IllegalArgumentException("Name must be longer than 3 symbols!");
		}
	}
}

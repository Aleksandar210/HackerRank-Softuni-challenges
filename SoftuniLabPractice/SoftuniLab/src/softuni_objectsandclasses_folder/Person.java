package softuni_objectsandclasses_folder;

public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return  name + " " + age;
	}
	
	

}

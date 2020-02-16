package softuni_objectsandclasses_folder;

public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		
	}

	@Override
	public String toString() {
		return  name + " " + age;
	}
	
	

}

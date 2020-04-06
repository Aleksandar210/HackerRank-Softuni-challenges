package advanced_Softuni_Classes_Iterables_Comparables;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private String town;
	
	public Person(String name,int age, String town) {
		setName(name);
		setAge(age);
		setTown(town);
	}
	
	public Person(String name,int age) {
		setName(name);
		setAge(age);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}


	@Override
	public int compareTo(Person o) {
		
		if(getName().length()==o.getName().length()) {
			if(getName().compareTo(o.getName())==0) {
			if(getAge()==o.getAge()) {
				if(getTown().compareTo(o.getTown())==0) {
					return 0;
				}else if(getTown().compareTo(o.getTown())<0) {
					return -1;
				}else {
					return 1;
				}
			}else {
				return getAge()-o.getAge();
			}
			}else if(getName().compareTo(o.getName())<0) {
				return -1;
			}else {
				return 1;
			}
		}else {
			return getName().length()-o.getName().length();
		}
	}
	
	

}

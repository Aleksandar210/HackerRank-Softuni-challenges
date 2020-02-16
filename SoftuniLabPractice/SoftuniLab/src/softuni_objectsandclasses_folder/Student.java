package softuni_objectsandclasses_folder;


public class Student  {
private String firstName;
private String lastName;
private int age;
private String town;
private double grade;

public Student(String name,String lastName,int age,String town) {
	this.firstName=name;
	this.lastName = lastName;
	this.age = age;
	this.town=town;
}
public Student(String firstName, String lastName, double grade) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.grade = grade;
}

public Student() {
	
}


public void setName(String name) {
	String[] names = name.split(" ");
	this.firstName = names[0];
	this.lastName = names[1];
	
}

public String getName() {
	return this.firstName+" "+this.lastName;
}

public String getTown() {
	return this.town;
}

public double getGrade() {
	return this.grade;
}

public String displayStudentInfo() {
	String display = String.format("%s %s, %d, %s, %i", this.firstName,this.lastName,this.age,this.town, this.grade);
	return display;
}


}

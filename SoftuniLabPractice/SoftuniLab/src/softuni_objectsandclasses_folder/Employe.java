package softuni_objectsandclasses_folder;



public class Employe  {
private String name;
private double salary;
private String position;
private String department;
private int age;
private String email;

public Employe() {
	
}

public Employe(String name,double salary, String position, String department, int age, String mail) {
	this.name = name;
	this.salary =salary;
	this.position = position;
	this.department = department;
	this.age = age;
	
	if(checkEmail(mail)) {
	this.email = mail;
	}
	
}

public Employe(String name,double salary, String position, String department, String other) {
	this.name = name;
	this.salary =salary;
	this.position = position;
	this.department = department;
	boolean isNumeric = other.chars().allMatch( Character::isDigit );
	if(isNumeric) {
		this.age = Integer.parseInt(other);
	}else {
		this.email = other;
	}
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary = salary;
}

public String getPosition() {
	return position;
}

public void setPosition(String position) {
	this.position = position;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}



private boolean checkEmail(String email) {
	boolean valid ;
	if(!email.contains("@") && !email.contains(".")) {
		valid = false;
	}else {
		valid =  true;
	}
	return true;
}

@Override
public String toString() {
	return   name  + " " + salary + " " + position + " " + department
			+  " " +  age +  " "+ email;
}




}

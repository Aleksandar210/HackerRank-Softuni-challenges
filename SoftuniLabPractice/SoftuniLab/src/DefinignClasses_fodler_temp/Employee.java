package DefinignClasses_fodler_temp;

public class Employee {
	private String name;
	private int age;
	private String positon;
	private String department;
	private double salary;
	
	public Employee(String name,int age,double salary,String position,String department) {
		setName(name);
		setAge(age);
		setSalary(salary);
		setPositon(positon);
		setDepartment(department);
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

	public String getPositon() {
		return positon;
	}

	public void setPositon(String positon) {
		this.positon = positon;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}

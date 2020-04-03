package DefinignClasses_folder_classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
	private static final String DEFAULT_MAIL = "n/a";
	private static final int DEFAULT_AGE = -1;
	private String name;
	private int age;
	private String positon;
	private String department;
	private double salary;
	private String email;
	
	
	
	public String getEmail() {
		return email;
	}


	

	public Employee(String name,double salary,String position,String department,String mail,int age) {
		setName(name);
		setAge(age);
		setSalary(salary);
		setPositon(positon);
		setDepartment(department);
		setEmail(mail);
		
	}
	
	
	public Employee(String name,double salary,String position,String department,String temp) {
		setName(name);
		setPositon(position);
		setDepartment(department);
		setSalary(salary);
		
		try {
			int probablyAge = Integer.parseInt(temp);
			setAge(probablyAge);
			setEmail(DEFAULT_MAIL);
		}catch(NumberFormatException e) {
			setAge(DEFAULT_AGE);
			setEmail(temp);
		}
	}
	
	public Employee(String name,double salary,String position,String department) {
		setName(name);
		setPositon(position);
		setDepartment(department);
		setSalary(salary);
		setEmail(DEFAULT_MAIL);
		setAge(DEFAULT_AGE);
		
	}
	

	
	
	public void setEmail(String email) {
		Pattern p = Pattern.compile("^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@\r\n" + 
				"[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$");
		Matcher m  = p.matcher(email);
		
		if(m.find()) {
			this.email = m.group();
		}else {
			this.email = DEFAULT_MAIL;
		}
		
	}

	
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", positon=" + positon + ", department=" + department
				+ ", salary=" + salary + ", email=" + email + "]";
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

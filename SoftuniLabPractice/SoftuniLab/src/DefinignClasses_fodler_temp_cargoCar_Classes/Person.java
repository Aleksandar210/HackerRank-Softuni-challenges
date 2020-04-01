package DefinignClasses_fodler_temp_cargoCar_Classes;

import java.util.Stack;

public class Person {
	private String firstName;
	private String secondName;
	private int yearBorn;
	private int month;
	private int day;
	private Stack<Person> parents = new Stack<Person>();
	private Stack<Person>  children =  new Stack<Person>();
	

	public Person(String firstName,String secondName, int year, int month, int day,boolean isDate,
			String[] childData) {
		setFirstName(firstName);
		setSecondName(secondName);
		setYearBorn(year);
		setMonth(month);
		setDay(day);
		
		
		if(!isDate) {
			children.add(new Person(childData[0],childData[1]));
			children.peek().parents.add(this);
		}else {
			children.add(new Person(Integer.parseInt(childData[0]),Integer.parseInt(childData[1]),Integer.parseInt(childData[2])));
			children.peek().parents.add(this);
		}
	}
	
	public Person(String firstName, Stirng secondName)
	
	public Person(int year, int month, int day,String[] childData) {
		setYearBorn(year);
		setMonth(month);
		setDay(day);
			children.add(new Person(Integer.parseInt(childData[0]),Integer.parseInt(childData[1]),Integer.parseInt(childData[2])));
			children.peek().parents.add(this);
		
		
	}
	public Person(int year, int month, int day) {
		setYearBorn(year);
		setMonth(month);
		setDay(day);
	}
	
	public Person(String firstName, String secondName) {
	setFirstName(firstName);
	setSecondName(secondName);
	}

	public String birthday() {
		String birthday = String.format("%d/%d/%d",getYearBorn(),getMonth(),getDay());
		return birthday;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public int getYearBorn() {
		return yearBorn;
	}

	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

}

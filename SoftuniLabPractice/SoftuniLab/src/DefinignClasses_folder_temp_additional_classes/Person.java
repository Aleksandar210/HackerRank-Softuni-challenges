package DefinignClasses_folder_temp_additional_classes;

import java.util.Stack;

public class Person {
	private String firstName;
	private String secondName;
	private int yearBorn;
	private int month;
	private int day;
	private Stack<Person> parents = new Stack<Person>();
	private Stack<Person>  children =  new Stack<Person>();
	

	public Person(String firstName,String secondName,boolean isDate,
			String[] childData) {
		this(firstName,secondName);
		
		
		if(!isDate) {
			children.add(new Person(childData[0],childData[1]));
			children.peek().parents.add(this);
		}else {
			children.add(new Person(Integer.parseInt(childData[0]),Integer.parseInt(childData[1]),Integer.parseInt(childData[2])));
			children.peek().parents.add(this);
		}
	}
	
	
	public Person getChild() {
		return this.children.peek();
	}
	
	public void displayParents() {
		Stack<Person> currentParents = new Stack<Person>();
		currentParents = this.parents;
		for(int i=0;i<currentParents.size();i++) {
			Person temp = currentParents.pop();
			System.out.println(temp.getBothNames()+" born: "+temp.birthday());
		}
	}
	
	public void  displayChildren() {
		Stack<Person> childs = new Stack<Person>();
		childs = this.children;
		for(Person ch:childs) {
			System.out.println(ch.getBothNames()+" born: "+ch.birthday());
		}
	}
	
	
	
	public Person(int year, int month, int day,boolean isName,String[] childData) {
		this(year,month,day);
		if(isName) {
			children.add(new Person(childData[0],childData[1]));
			children.peek().parents.add(this);
		}else {
			children.add(new Person(Integer.parseInt(childData[0]),Integer.parseInt(childData[1]),Integer.parseInt(childData[2])));
			children.peek().parents.add(this);
		}
		
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
	
	
	public Person(String firstName, String secondName,int year, int month, int day) {
		setFirstName(firstName);
		setSecondName(secondName);
		setYearBorn(year);
		setMonth(month);
		setDay(day);
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

	
	public String getBothNames() {
		return getFirstName()+getSecondName();
	}
}

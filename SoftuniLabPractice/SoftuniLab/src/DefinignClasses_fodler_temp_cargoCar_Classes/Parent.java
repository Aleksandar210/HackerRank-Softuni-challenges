package DefinignClasses_fodler_temp_cargoCar_Classes;

public class Parent {
	private String name;
	private int yearBorn;
	private int month;
	private int day;
	private Parent parent;
	private Child child;

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Parent(String name, int year, int month,int day) {
		setName(name);
		setYearBorn(year);
		setMonth(month);
		setDay(day);
	}
	
	public Parent(int year, int month,int day) {
		
	}
	
	public String birthday() {
		String birthday = String.format("%d, %d, %d",getYearBorn(),getMonth(),getDay());
		return birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}

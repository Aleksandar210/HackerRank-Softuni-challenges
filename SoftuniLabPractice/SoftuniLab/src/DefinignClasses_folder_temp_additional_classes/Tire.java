package DefinignClasses_folder_temp_additional_classes;

public class Tire {
	private static int counter = 0;
	private int tireNumber = counter;
	private int age;
	private int pressure;
	
	
	public Tire(int pressure, int age) {
		setPressure(pressure);
		setAge(age);
		counter++;
	}
	
	
	@Override
	public String toString() {
		return "Tire [tireNumber=" + tireNumber + ", age=" + age + ", pressure=" + pressure + "]";
	}


	public int getTireNumber() {
		return tireNumber;
	}
	public void setTireNumber(int tireNumber) {
		this.tireNumber = tireNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	
	

}

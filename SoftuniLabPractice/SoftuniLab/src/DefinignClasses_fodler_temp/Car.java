package DefinignClasses_fodler_temp;

public class Car {
	private String manufacturer;
	private String type;
	private int horsePower;
	
	public Car(String make, String type, int power) {
		this.manufacturer = make;
		this.type = type;
		this.horsePower =power;
	}

	@Override
	public String toString() {
		return "Car [manufacturer=" + manufacturer + ", type=" + type + ", horsePower=" + horsePower + "]";
	}
	
	
	

}

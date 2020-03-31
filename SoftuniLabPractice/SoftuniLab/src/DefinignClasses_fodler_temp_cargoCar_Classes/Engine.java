package DefinignClasses_fodler_temp_cargoCar_Classes;

public class Engine {
	private int power;
	private int speed;
	private String model;
	
	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public Engine(int power,int speed) {
		setSpeed(speed);
		setPower(power);
	}
	public Engine(String model, int power) {
		setModel(model);
		setPower(power);
	}
	
	
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	

}

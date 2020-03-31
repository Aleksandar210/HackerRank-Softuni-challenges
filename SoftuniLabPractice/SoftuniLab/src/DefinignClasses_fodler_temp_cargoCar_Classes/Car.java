package DefinignClasses_fodler_temp_cargoCar_Classes;

import java.util.LinkedList;

public class Car {
	private String model;
	private LinkedList<Tire> tires;
	private Engine engine;
	private Cargo cargo;
	
	public Car(String model,int speed,int power,int weight,String type,String[] tireData) {
		setModel(model);
		setEngine(new Engine(speed,power));
		setCargo(new Cargo(weight,type));
		tires = new LinkedList<Tire>();
		for(int i =0;i<tireData.length-1;i+=2) {
			int pressure = Integer.parseInt(tireData[i]);
			int age = Integer.parseInt(tireData[i+1]);
			tires.add(new Tire(pressure,age));
		}
	}
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void addTire(Tire currentTire) {
		this.tires.add(currentTire);
	}
	public Tire getTire(int number) {
		return this.tires.get(number);
	}
	
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	

}

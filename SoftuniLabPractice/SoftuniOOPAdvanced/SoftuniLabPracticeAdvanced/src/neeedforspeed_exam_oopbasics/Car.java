package neeedforspeed_exam_oopbasics;

public abstract class Car {
private String model;
private String brand;
private int yearOfProduction;
private int horsePower;
private int acceleration;
private int suspension;
private int durability;

protected Car(String brand,String model,int year, int horse, int accel,int susp,int dur) {
	setBrand(brand);
	setModel(model);
	setYearOfProduction(year);
	setHorsePower(horse);
	setAcceleration(accel);
	setSuspension(susp);
	setDurability(dur);
	
}



public String getModel() {
	return model;
}

protected void setModel(String model) {
	this.model = model;
}

public String getBrand() {
	return brand;
}

protected void setBrand(String brand) {
	this.brand = brand;
}

public int getYearOfProduction() {
	return yearOfProduction;
}

protected void setYearOfProduction(int yearOfProduction) {
	this.yearOfProduction = yearOfProduction;
}

public int getHorsePower() {
	return horsePower;
}

protected  void setHorsePower(int horsePower) {
	this.horsePower = horsePower;
}

public int getAcceleration() {
	return acceleration;
}

protected void setAcceleration(int acceleration) {
	this.acceleration = acceleration;
}

public int getSuspension() {
	return suspension;
}

protected void setSuspension(int suspension) {
	this.suspension = suspension;
}

public int getDurability() {
	return durability;
}

protected void setDurability(int durability) {
	this.durability = durability;
}

public abstract void tune(Object...params);

public void increaseHorse(int by) {
	this.setHorsePower(this.getHorsePower()+((100*by)-100));
}

public void decreaseHorse(int by) {
	this.setHorsePower(this.getHorsePower()-((100*by)-100));
}

public  int overallPerformance() {
	int b =  this.getSuspension()+this.getDurability();
	int a = this.getHorsePower()/this.getAcceleration();
	return a+b;
}

public  int enginePerformance() {
	return this.getHorsePower()/this.getAcceleration();
}

public  int suspensionPerformance() {
	return this.getSuspension()+this.getDurability();
}



@Override
public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("Brand: "+this.getBrand()+" Model: "+this.getModel()+" Year: "+this.getYearOfProduction());
	sb.append(System.getProperty("line.separator"));
	sb.append("HorsePower: "+this.getHorsePower()+" Acceleration: " +this.getAcceleration()+" Suspension "+this.getSuspension()
	+" Durability: "+this.getDurability());
	return sb.toString();
}


	



}

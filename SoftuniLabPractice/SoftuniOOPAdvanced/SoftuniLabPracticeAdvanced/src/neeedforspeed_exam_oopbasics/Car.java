package neeedforspeed_exam_oopbasics;

public abstract class Car {
private String model;
private String brand;
private int yearOfProduction;
private int horsePower;
private int acceleration;
private int suspension;
private int durability;

public Car(String brand,String model,int year, int horse, int accel,int susp,int dur) {
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

public void setModel(String model) {
	this.model = model;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public int getYearOfProduction() {
	return yearOfProduction;
}

public void setYearOfProduction(int yearOfProduction) {
	this.yearOfProduction = yearOfProduction;
}

public int getHorsePower() {
	return horsePower;
}

public void setHorsePower(int horsePower) {
	this.horsePower = horsePower;
}

public int getAcceleration() {
	return acceleration;
}

public void setAcceleration(int acceleration) {
	this.acceleration = acceleration;
}

public int getSuspension() {
	return suspension;
}

public void setSuspension(int suspension) {
	this.suspension = suspension;
}

public int getDurability() {
	return durability;
}

public void setDurability(int durability) {
	this.durability = durability;
}


}

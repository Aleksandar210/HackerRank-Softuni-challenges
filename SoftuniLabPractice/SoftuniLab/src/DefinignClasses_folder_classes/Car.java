package DefinignClasses_folder_classes;

public class Car {
	public static final int DEFAULT_DISTANCE = 0;
	private String manufacturer;
	private String type;
	private int horsePower;
	private double fuell;
	private double fuellCost;
	private int distanceTravelled;
	
	
	public void Drive(int distance) {
		if(fuellCost*distance<=fuell) {
			increaseDistance(distance);
			decreaseFuell(distance);
		}else {
			System.out.println("unsificent fuell");
		}
	}
	
	private void increaseDistance(int distance) {
		this.distanceTravelled+=distance;
	}
	
	private void decreaseFuell(int distance) {
		this.fuell-=distance;
	}
	
	
	public int getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(int distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	public Car(String make, String type, int power) {
		
	}
	
	public Car(String model, double fuelAmount, double fuelCostPerKm) {
		setFuell(fuelAmount);
		setType(model);
		setFuellCost(fuelCostPerKm);
		setDistanceTravelled(DEFAULT_DISTANCE);
	}
   
	
	
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public double getFuell() {
		return fuell;
	}

	public void setFuell(double fuell) {
		this.fuell = fuell;
	}

	public double getFuellCost() {
		return fuellCost;
	}

	public void setFuellCost(double fuellCost) {
		this.fuellCost = fuellCost;
	}

	@Override
	public String toString() {
		String display = String.format("Car: %s %.2f %d",getType(),getFuell(),getDistanceTravelled());
		return display;
	}
	
	
	
	
	

}

package advanced_Softuni_Classes_Iterables_Comparables;

public class Car extends Vehicle{

	public Car(String model) {
		super(model);
		this.setCurrentFuel(0);
		this.setFuelCapacity(60);
		this.setFuelConsumption(3);
		this.setKmPassed(0);
		this.setLeftOverFuel(0);
		
	}
	@Override
	public void addFuel(double fuel) {
		if(this.getCurrentFuel()>=this.getFuelCapacity()) {
			
		}else {
			double toAdd = this.getFuelCapacity()  - this.getCurrentFuel();
			this.setCurrentFuel(this.getCurrentFuel()+toAdd);
			this.setLeftOverFuel(getLeftOverFuel()+fuel-toAdd);
		}
	}
	
	@Override
	public void getTypeOfVehicle() {
		System.out.println("Car");
	}
	
	public void custom() {
		
	}
	
	

}

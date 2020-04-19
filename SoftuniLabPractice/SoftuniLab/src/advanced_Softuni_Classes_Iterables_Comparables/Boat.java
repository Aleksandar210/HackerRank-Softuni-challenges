package advanced_Softuni_Classes_Iterables_Comparables;

public class Boat extends Vehicle {

	
	public Boat(String model) {
		super(model);
		this.setCurrentFuel(0);
		this.setFuelCapacity(100);
		this.setFuelConsumption(10);
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
		System.out.println("Boat");
	}
}

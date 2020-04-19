package advanced_Softuni_Classes_Iterables_Comparables;

public class Vehicle {
	private static final double CURRENT_FUEL = 0;
	private static final double FUEL_CAPACITY = 0;
	private static final double KM_PASSED =0;
	private static final double FUEL_CONSUMPTION = 0;
	

	private double currentFuel;
	private double fuelCapacity;
	private double fuelConsumption;
	private String model;
	private double kmPassed;
	private double leftOverFuel;
	
	
	public Vehicle(String model) {
		setCurrentFuel(CURRENT_FUEL);
		setFuelCapacity(FUEL_CAPACITY);
		setKmPassed(KM_PASSED);
		setFuelConsumption(FUEL_CONSUMPTION);
		setModel(model);
		
	}
	
	public void getTypeOfVehicle() {
		
	}
	
	public void addFuel(double fuel) {
		setCurrentFuel(getCurrentFuel()+fuel);
	}
	
	public double caluclateFuelConsumption(double km) {
		return km*getFuelConsumption();
	}
	
	
	
	
	
	
	public double getCurrentFuel() {
		return currentFuel;
	}

	protected void setCurrentFuel(double currentFuel) {
		this.currentFuel = currentFuel;
	}

	public double getFuelCapacity() {
		return fuelCapacity;
	}

	protected void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	protected void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public String getModel() {
		return model;
	}

	protected void setModel(String model) {
		this.model = model;
	}

	public double getKmPassed() {
		return kmPassed;
	}

	protected void setKmPassed(double kmPassed) {
		this.kmPassed = kmPassed;
	}

	public double getLeftOverFuel() {
		return leftOverFuel;
	}

	protected void setLeftOverFuel(double leftOverFuel) {
		this.leftOverFuel = leftOverFuel;
	}
	

}

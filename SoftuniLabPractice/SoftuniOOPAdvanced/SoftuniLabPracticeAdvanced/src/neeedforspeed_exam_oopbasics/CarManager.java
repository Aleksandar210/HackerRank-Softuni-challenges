package neeedforspeed_exam_oopbasics;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager implements CarManagable {

	private Map<Integer,Car> registeredCars;
	private Map<Integer,BaseRace> currentRaces;
	private Map<Integer,Car> carsOnField;
	
	Garage currentGarage;
	
	public CarManager() {
		registeredCars = new LinkedHashMap<Integer,Car>();
		currentRaces = new LinkedHashMap<Integer,BaseRace>();
		currentGarage = new Garage();
		carsOnField = new LinkedHashMap<Integer,Car>();
	}
	
	
	@Override
	public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower,
			int acceleration, int suspension, int durability) {
		
		Car currentCar  = null;
		switch(type.toLowerCase()) {
		case "performancecar":
			currentCar = new PerformanceCar( brand,  model,  yearOfProduction,  horsepower,
					 acceleration,  suspension, durability);
			break;
		case "showcar":
			currentCar = new ShowCar( brand,  model,  yearOfProduction,  horsepower,
					 acceleration,  suspension, durability);
			break;
		}
		if(currentCar!=null) {
			this.registeredCars.putIfAbsent(id, currentCar);
			this.carsOnField.putIfAbsent(id, currentCar);
		}
		
	}

	@Override
	public String check(int id) {
		if(registeredCars.containsKey(id)) {
			return this.registeredCars.get(id).toString();
		}else {
			return "No car found!";
		}
		
	}

	@Override
	public void open(int id, String type, int length, String route, int prizePool) {
		BaseRace currentRace = null;
		switch(type.toLowerCase()) {
		case "dragrace":
			currentRace = new DragRace(length,route,prizePool);
			break;
		case "casualrace":
			currentRace = new CasualRace(length,route,prizePool);
			break;
		case "driftrace":
			currentRace = new DriftRace(length,route,prizePool);
			break;
		}
		
		if(currentRace!=null) {
			this.currentRaces.putIfAbsent(id, currentRace);
		}
		
		
	}

	@Override
	public void participate(int carId, int raceId) {
		if(this.currentRaces.containsKey(raceId) && this.carsOnField.containsKey(carId)) {
			this.currentRaces.get(raceId).addParticipant(this.registeredCars.get(carId));
			
		}else{
			
		}
		
	}

	@Override
	public String start(int id) {
		
		String returnRace =  this.currentRaces.get(id).getWinners();
		this.currentRaces.remove(id);
		return returnRace;
		
	}

	@Override
	public void park(int id) {
		if(this.carsOnField.containsKey(id)) {
			for(Map.Entry<Integer, BaseRace> entry:this.currentRaces.entrySet()) {
				if(entry.getValue().getParticipants().contains(this.carsOnField.get(id))) {
					return;
				}
			}
			
			
			currentGarage.parkCar(this.carsOnField.get(id), id);
			this.carsOnField.remove(id);
		}
		
		
	}

	@Override
	public void unpark(int id) {
		this.carsOnField.put(id, this.currentGarage.unparkCar(id)); 
		
	}

	@Override
	public void tune(int tuneIndex, String addOn) {
		Object[] currentObject = new Object[2];
		currentObject[0] = tuneIndex;
		currentObject[1] = addOn;
		this.currentGarage.tune(currentObject);
		
		
	}

}

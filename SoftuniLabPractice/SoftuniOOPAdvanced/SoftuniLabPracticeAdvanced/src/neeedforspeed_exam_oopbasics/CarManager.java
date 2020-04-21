package neeedforspeed_exam_oopbasics;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager implements CarManagable {

	private Map<Integer,Car> registeredCars;
	private Map<Integer,BaseRace> currentRaces;
	
	public CarManager() {
		registeredCars = new LinkedHashMap<Integer,Car>();
		currentRaces = new LinkedHashMap<Integer,BaseRace>();
	}
	
	
	@Override
	public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower,
			int acceleration, int suspension, int durability) {
		
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public String start(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void park(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unpark(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tune(int tuneIndex, String addOn) {
		// TODO Auto-generated method stub
		
	}

}

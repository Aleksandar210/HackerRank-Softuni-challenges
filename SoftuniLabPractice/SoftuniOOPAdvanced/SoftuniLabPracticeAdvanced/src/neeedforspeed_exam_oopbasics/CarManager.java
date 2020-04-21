package neeedforspeed_exam_oopbasics;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager implements CarManagable {

	private Map<Integer,Car> registeredCars;
	
	public CarManager() {
		registeredCars = new LinkedHashMap<Integer,Car>();
	}
	
	
	@Override
	public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower,
			int acceleration, int suspension, int durability) {
		
		
	}

	@Override
	public String check(int id) {
		
		
	}

	@Override
	public void open(int id, String type, int length, String route, int prizePool) {
		// TODO Auto-generated method stub
		
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

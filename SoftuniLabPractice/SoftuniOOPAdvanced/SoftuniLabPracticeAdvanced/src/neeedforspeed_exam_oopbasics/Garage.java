package neeedforspeed_exam_oopbasics;


import java.util.LinkedHashMap;
import java.util.Map;

public class Garage {
	
	Map<Integer,Car> parkedCars;
	
	public Garage() {
		parkedCars = new LinkedHashMap<Integer,Car>();
	}
	
	public void parkCar(Car current, int id) {
		this.parkedCars.put(id, current);
	}
	
	public Car unparkCar(int id) {
		
		return this.parkedCars.remove(id);
		
	}
	
	public void tune(Object...params) {
		for(Map.Entry<Integer, Car>entry:this.parkedCars.entrySet()) {
			entry.getValue().tune(params);
		}
	}

}

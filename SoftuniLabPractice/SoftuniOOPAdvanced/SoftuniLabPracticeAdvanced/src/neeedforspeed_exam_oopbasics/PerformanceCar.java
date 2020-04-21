package neeedforspeed_exam_oopbasics;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
	List<String> addOns;
	public PerformanceCar(String brand, String model, int year, int horse, int accel, int susp, int dur) {
		super(brand, model, year, horse, accel, susp, dur);
		addOns = new ArrayList<String>();
	}
	
	
	@Override
	public void tune(Object... params) {
	this.addOns.add(String.valueOf(params[0]));
	}
	
	
	
	
	

}

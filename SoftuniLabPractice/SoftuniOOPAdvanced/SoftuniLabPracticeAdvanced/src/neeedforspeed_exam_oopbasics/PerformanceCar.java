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
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(System.getProperty("line.separator"));
		String currentAddOns = String.join(" ", this.addOns);
		sb.append("Addons: "+currentAddOns);
		 return sb.toString();
		
	}
	
	
	

}

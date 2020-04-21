package neeedforspeed_exam_oopbasics;

public class ShowCar extends Car {
	private int stars;
	public ShowCar(String brand, String model, int year, int horse, int accel, int susp, int dur) {
		super(brand, model, year, horse, accel, susp, dur);
		stars = 0;
	}
	@Override
	public void tune(Object... params) {
	
		
	}
	
	

}

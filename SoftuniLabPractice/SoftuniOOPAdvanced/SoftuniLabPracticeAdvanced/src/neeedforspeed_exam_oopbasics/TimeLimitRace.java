package neeedforspeed_exam_oopbasics;

public class TimeLimitRace extends BaseRace {
	private Car currentRacer;
	private int goldTime;
	protected TimeLimitRace(int length, String route, int prizePool,int goldTime) {
		super(length, route, prizePool);
		this.goldTime = goldTime;
		
	}
	
	private String goldTime() {
		int time = this.getLength()*(currentRacer.getHorsePower()/100)*currentRacer.getAcceleration();
		if(time<=goldTime) {
			return"Gold";
		}else if(time<goldTime+15) {
			return "Silver";
		}else {
			return 
					"Bronze";
		}
	}
	@Override
	public String getWinners() {
		
		return this.goldTime()+" "+currentRacer;
		
	}
	
	
	
	

}

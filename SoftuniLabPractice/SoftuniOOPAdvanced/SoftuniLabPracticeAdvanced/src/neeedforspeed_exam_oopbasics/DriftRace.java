package neeedforspeed_exam_oopbasics;


import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class DriftRace extends BaseRace {
	
	private Map<Integer,Car> winners;
	protected DriftRace(int length,String route,int prizePool) {
		super(length,route,prizePool);
		this.winners = new TreeMap<Integer,Car>(Collections.reverseOrder());
	}
	
	public  int enginePerformance(Car current) {
		return current.getHorsePower()/current.getAcceleration();
	}
	
	@Override
	public String getWinners() {
		this.getParticipants().stream().map(e->{
			this.winners.put(enginePerformance(e), e);
			return e;
		});
		int i=0;
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer, Car> entry:this.winners.entrySet()) {
			sb.append((i+1)+": "+entry.getValue());
			i+=1;
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
		
	}

}

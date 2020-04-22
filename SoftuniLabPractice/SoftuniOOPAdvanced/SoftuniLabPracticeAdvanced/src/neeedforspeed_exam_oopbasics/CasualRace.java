package neeedforspeed_exam_oopbasics;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CasualRace extends BaseRace {
	private Map<Integer,Car> winners;
	protected CasualRace(int length, String route, int prizePool) {
		super(length, route, prizePool);
		this.winners = new TreeMap<Integer,Car>(Collections.reverseOrder());
	}
	
	private  int overallPerformance(Car current) {
		int b =  current.getSuspension()+current.getDurability();
		int a = current.getHorsePower()/current.getAcceleration();
		return a+b;
	}

	


	@Override
	public String getWinners() {
		this.getParticipants().stream().map(e->{
			this.winners.put(overallPerformance(e), e);
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

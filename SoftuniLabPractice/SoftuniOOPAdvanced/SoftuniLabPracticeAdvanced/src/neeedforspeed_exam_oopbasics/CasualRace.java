package neeedforspeed_exam_oopbasics;

import java.util.Map;
import java.util.TreeMap;

public class CasualRace extends BaseRace {
	private Map<Integer,Car> winners;
	protected CasualRace(int length, String route, int prizePool) {
		super(length, route, prizePool);
		this.winners = new TreeMap<Integer,Car>();
	}

	@Override
	public void getWinners() {
		this.getParticipants().stream().map(e->{
			this.winners.put(e.overallPerformance(), e);
			return e;
		});
		int i=0;
		for(Map.Entry<Integer, Car> entry:this.winners.entrySet()) {
			System.out.println((i+1)+": "+entry.getValue());
		}
		
	}

	
	

}

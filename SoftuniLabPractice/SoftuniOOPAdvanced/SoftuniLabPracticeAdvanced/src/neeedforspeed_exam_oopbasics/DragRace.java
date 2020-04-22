package neeedforspeed_exam_oopbasics;

import java.util.Map;
import java.util.TreeMap;

public class DragRace extends BaseRace {
private Map<Integer,Car> winners;
	protected DragRace(int length, String route, int prizePool) {
		super(length, route, prizePool);
		// TODO Auto-generated constructor stub
		this.winners = new TreeMap<Integer,Car>();
	}
	
	
	private int suspensionPerformance(Car currentCar) {
		return currentCar.getSuspension()+currentCar.getDurability();
	}

	
	@Override
	public String getWinners() {
		this.getParticipants().stream().map(e->{
			this.winners.put(suspensionPerformance(e), e);
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

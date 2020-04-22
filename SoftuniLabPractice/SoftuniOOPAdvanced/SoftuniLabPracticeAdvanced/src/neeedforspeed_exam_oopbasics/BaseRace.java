package neeedforspeed_exam_oopbasics;


import java.util.Collection;
import java.util.LinkedList;

public abstract class BaseRace {
	private int length;
	private String route;
	private int prizePool;
	private Collection<Car> participants;
	
	protected BaseRace(int length,String route, int prizePool) {
		setLength(length);
		setRoute(route);
		setPrizePool(prizePool);
		this.participants = new LinkedList<Car>();
	}

	public int getLength() {
		return length;
	}

	protected void setLength(int length) {
		this.length = length;
	}

	public String getRoute() {
		return route;
	}

	protected void setRoute(String route) {
		this.route = route;
	}

	public int getPrizePool() {
		return prizePool;
	}

	protected void setPrizePool(int prizePool) {
		this.prizePool = prizePool;
	}
	
	public void addParticipant(Car part) {
		this.participants.add(part);
	}
	
	public Collection<Car> getParticipants() {
		return this.participants;
	}
	
	public abstract String getWinners() ;
	
	
}

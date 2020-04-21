package neeedforspeed_exam_oopbasics;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseRace {
	private int length;
	private String route;
	private int prizePool;
	private Collection<Car> participants;
	
	protected BaseRace(int length,String route, int prizePool) {
		setLength(length);
		setRoute(route);
		setPrizePool(prizePool);
		this.participants = new ArrayList<Car>();
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
}

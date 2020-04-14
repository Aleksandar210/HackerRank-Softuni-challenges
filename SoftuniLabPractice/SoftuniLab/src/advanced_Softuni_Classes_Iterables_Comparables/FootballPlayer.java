package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FootballPlayer {
	private String name;
	private int[] stats;
	private int playerRating;
	
	//ns is nameAndStats
	public FootballPlayer(String...ns) {
		setName(ns[2]);
		setStats(ns);
		
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
		
	}
	
	private void setStats(String[] stats) {
		int currentStat;
		int index =0;
		List<String> listStats = new ArrayList<String>(Arrays.asList(stats));
		for(int i =0;i<3;i++) {
			listStats.remove(i);
		}
		
		listStats.forEach(e->{
			this.stats[listStats.indexOf(e)] = Integer.parseInt(e);
			this.playerRating+=this.stats[listStats.indexOf(e)];
		});
		
	}
	
	public int getPlayerRating() {
		return this.playerRating/this.stats.length;
	}
	
	
	
	

}

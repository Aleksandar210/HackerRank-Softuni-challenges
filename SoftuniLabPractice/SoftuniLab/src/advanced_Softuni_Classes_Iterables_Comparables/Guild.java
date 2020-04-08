package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Guild implements Iterable<Player>{
	private static final int DEF_INDEX =0;
private Player[] players;
private String name;
private Map<String,Integer> searchByNames;


public Guild(String name, int capacity) {
	setName(name);
	players = new Player[capacity];
	searchByNames = new HashMap<String,Integer>();
}

public void addPlayer(Player currentPlayer) {
	
}

public int getSize() {
	return this.players.length;
}






	@Override
	public Iterator iterator() {
	
		
	}
	
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
	return this.name;	
	}
	
}

package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;

public class Guild implements Iterable<Player>{
	private static final int DEF_SIZE =0;
private Player[] players;
private String name;
private Map<String,Integer> searchByNames;
private int size;


public Guild(String name, int capacity) {
	setName(name);
	players = new Player[capacity];
	searchByNames = new HashMap<String,Integer>();
}

public void addPlayer(Player currentPlayer) {
	if(getSize()==getCapacity()) {
		System.out.println("No more room");
	}else {
	this.players[getSize()] = currentPlayer;
	setSize(getSize()+1);
	}
}

public void removePlayer(String name) {
	
}

public int getCapacity() {
	return this.players.length;
}

public void setSize(int a) {
	this.size=a;
}

public int getSize() {
	return this.size;
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

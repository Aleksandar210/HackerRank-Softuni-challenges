package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Guild implements Iterable<Player>{
	private static final int DEF_SIZE =0;
private Player[] players;
private String name;
private Map<String,Integer> searchByNames;
private Set<String> clazzezInGuild = new HashSet<String>();
private int size;


public Guild(String name, int capacity) {
	setName(name);
	players = new Player[capacity];
	searchByNames = new HashMap<String,Integer>();
}

public void addPlayer(Player currentPlayer) {
	currentPlayer.setRank("Trial");
	this.clazzezInGuild.add(currentPlayer.getClazz());
	if(getSize()==getCapacity()) {
		System.out.println("No more room");
	}else {
	this.players[getSize()] = currentPlayer;
	setSize(getSize()+1);
	}
}

public void removePlayer(String name) {
	Player[] temp = new Player[getCapacity()];
	searchByNames.remove(name);
	int counter =0;
	for(Map.Entry<String, Integer> entry:searchByNames.entrySet()) {
		temp[counter] =this.players[entry.getValue()];
		counter++;
	}
	
	this.players = temp;
}


public void promotePlayer(String playerName) {
	this.players[searchByNames.get(playerName)].setRank("MEMBER");
	
}

public void demotePlayer(String playerName) {
	this.players[searchByNames.get(playerName)].setRank("TRIAL");
}

public void kickPlayerByClass(String clazz) {
	if(this.clazzezInGuild.contains(clazz)) {
		List<Player> currentPlayers = new ArrayList<Player>();
		currentPlayers = Arrays.stream(this.players)
				.filter(e ->  !e.getClazz().equals(clazz))
				.collect(Collectors.toList());
		Player[] temp = currentPlayers.toArray(new Player[currentPlayers.size()]);
		this.players = temp;
	}else {
		
	}
}

public int count() {
	return getCapacity();
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

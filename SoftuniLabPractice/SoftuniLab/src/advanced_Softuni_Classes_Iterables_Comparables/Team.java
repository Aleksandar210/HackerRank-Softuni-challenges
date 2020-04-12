package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Team {
private String name;
private List<Person> first;
private List<Person> reserve;
private Map<String,Integer> older;
private Map<String,Integer> younger;

public Team(String name) {
	setFirst();
	setReserve();
}



private void setReserve() {
	this.reserve = new LinkedList<Person>();
	this.older = new LinkedHashMap<String,Integer>();
}

private void setFirst() {
 this.first = new LinkedList<Person>();
 younger = new LinkedHashMap<String,Integer>();
}

public List<Person> getFirst(){
	return Collections.unmodifiableList(this.first);
}

public List<Person> getReserve(){
	return Collections.unmodifiableList(this.reserve);
}

private void addFirst(Person current) {
	this.first.add(current);
}

private void addReserve(Person current) {
	this.reserve.add(current);
	
}

public void addplayer(Person currentPlayer) {
	if(currentPlayer.getAge()<40) {
		addFirst(currentPlayer);
	}else {
		addReserve(currentPlayer);
	}
}

public String getName() {
	String returnThis = String.format("first squad has %d players %n reserve has %d players",
			this.first.size(),this.reserve.size());
	return returnThis;
	
}

@Override
public String toString() {
	return "Team []";
}



@SuppressWarnings("unlikely-arg-type")
public Person removeFirst(String name) {
	Person removed = this.first.get(younger.remove(name));
	this.first.remove(younger.remove(name));
	
	return removed;
     
}
@SuppressWarnings("unlikely-arg-type")
public void removeReserve(String name) {
	this.reserve.remove(this.older.remove(name));
}





}

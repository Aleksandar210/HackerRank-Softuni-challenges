package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Cage implements Iterable<Rabbit> {
	String name;
	int capacity;
private Set<String> species;
private Map<String,Integer> searchByName;
private List<Rabbit> rabbits;

public Cage(String name, int capacity) {
	setName(name);
	setCapacity(capacity);
	setRabbits(new ArrayList<Rabbit>(getCapacity()));
	setSearchByName(new HashMap<String,Integer>());
	setSpecies(new HashSet<String>());
	
}

public void sellBySpecies(String specie) {
	List<Rabbit> tempRabbitList = new ArrayList<Rabbit>();
	this.rabbits = getRabbits().stream()
			.map(e ->{
				if(e.getSpecies().equalsIgnoreCase(specie)) {
					getSearchByName().remove(e.getName());
					tempRabbitList.add(e);
				}
				return e;
					})
			
			.collect(Collectors.toList());
	Collections.sort(getRabbits(),(a,b)->a.getSpecies().compareTo(b.getSpecies()));
	getRabbits().removeAll(tempRabbitList);
	
}

public void addRabbit(Rabbit rabbit) {
	if(getRabbits().size()<getCapacity()) {
		getRabbits().add(rabbit);
		
	}
	getRabbits().sort((a,b)->a.getSpecies().compareTo(b.getSpecies()));
}

public int count() {
	return getRabbits().size();
}

public void report() {
	
	System.out.println("Cage contains: ");
	getRabbits().forEach(e->System.out.println(e));
}


public void sellRabbit(String name) {
	int index = searchByName.get(name);
	searchByName.remove(name);
	getRabbits().remove(index);
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getCapacity() {
	return capacity;
}

public void setCapacity(int capacity) {
	this.capacity = capacity;
}

public Set<String> getSpecies() {
	return species;
}

public void setSpecies(Set<String> species) {
	this.species = species;
}

public Map<String, Integer> getSearchByName() {
	return searchByName;
}

public void setSearchByName(Map<String, Integer> searchByName) {
	this.searchByName = searchByName;
}

public List<Rabbit> getRabbits() {
	return rabbits;
}

public void setRabbits(List<Rabbit> rabbits) {
	this.rabbits = rabbits;
}

@Override
public Iterator<Rabbit> iterator() {
	cageIterator ci = new cageIterator();
	return ci;
}


private class cageIterator implements Iterator<Rabbit>{
int  index =0;
	@Override
	public boolean hasNext() {
		if(index<getCapacity()) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Rabbit next() {
		return getRabbits().get(index++);
		
	}
	
}

}

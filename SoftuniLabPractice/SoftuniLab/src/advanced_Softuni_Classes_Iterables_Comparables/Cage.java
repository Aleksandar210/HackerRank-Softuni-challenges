package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cage {
	String name;
	int capacity;
private Set<String> species;
private Map<String,Rabbit> searchByName;
private List<Rabbit> rabbits;

public Cage(String name, int capacity) {
	setName(name);
	setCapacity(capacity);
	setRabbits(new ArrayList<Rabbit>(getCapacity()));
	
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

public Map<String, Rabbit> getSearchByName() {
	return searchByName;
}

public void setSearchByName(Map<String, Rabbit> searchByName) {
	this.searchByName = searchByName;
}

public List<Rabbit> getRabbits() {
	return rabbits;
}

public void setRabbits(List<Rabbit> rabbits) {
	this.rabbits = rabbits;
}
}

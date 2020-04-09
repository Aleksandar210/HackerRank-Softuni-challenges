package advanced_Softuni_Classes_Iterables_Comparables;

public class Rabbit {
	private static final boolean DEF_AV =true;
String name;
String species;
boolean available;



public Rabbit(String name,String species) {
	setName(name);
	setSpecies(species);
	setAvailable(DEF_AV);
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getSpecies() {
	return species;
}



public void setSpecies(String species) {
	this.species = species;
}



public boolean isAvailable() {
	return available;
}



public void setAvailable(boolean available) {
	this.available = available;
}



@Override
public String toString() {
	String info = String.format("%s %s",getSpecies(),getName());
	return info;
}


}

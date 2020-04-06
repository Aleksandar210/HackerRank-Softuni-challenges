package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Town implements Iterable<Person> {
	private String name;
	private List<Person> people;
	
	public Town(String name) {
		this.name = name; 
		people = new LinkedList<Person>();
		
	}
	
	public List<Person> getPeople(){
		return this.people;
	}
	public void add (Person person) {
		this.people.add(person);
	}
	@Override
	public Iterator<Person> iterator() {
		TownIterate townIter = new TownIterate();
		return townIter;
	}
	
	private class TownIterate implements Iterator<Person>{
		int index =0;

		@Override
		public boolean hasNext() {
			if(index<people.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Person next() {
			
			return people.get(index++);
		}
	}
	
	
	

}

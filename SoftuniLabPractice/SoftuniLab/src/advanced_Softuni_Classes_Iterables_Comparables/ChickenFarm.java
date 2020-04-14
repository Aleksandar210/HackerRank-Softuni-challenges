package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ChickenFarm {
	private Map<String,Integer> chickenByNames;
	private List<Chicken> chickens;
	private int size;
	private int index;
	
	
	
	public ChickenFarm(int numberChickens) {
		index =0;
		setSize(size);
		chickens = new LinkedList<Chicken>();
		chickenByNames = new HashMap<String,Integer>();
		
	}
	
	private void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void addChicken(Chicken currentChicken) {
		if(index<getSize()) {
			chickens.add(currentChicken);
			chickenByNames.put(	currentChicken.getName(), index);
			
		}else {
			System.out.println("No space");
		}
	}
	
	public void removeChicken(String name) {
		if(chickenByNames.containsKey(name)) {
			int indexToRemove = chickenByNames.remove(name);
			chickens.remove(indexToRemove);
			
		}else {
			System.out.println("No such chicken found");
		}
	}
	
	

}

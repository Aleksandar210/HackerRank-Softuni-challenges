package DefinignClasses_fodler_temp_cargoCar_Classes;

public class Cargo {
	private String type;
	private int weight;
	
	public Cargo(int weight, String type) {
		setWeight(weight);
		setType(type);
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	

}

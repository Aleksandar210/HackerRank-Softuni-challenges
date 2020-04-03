package DefinignClasses_folder_temp_additional_classes;

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

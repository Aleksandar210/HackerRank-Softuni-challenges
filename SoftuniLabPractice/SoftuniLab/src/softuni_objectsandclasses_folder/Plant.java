package softuni_objectsandclasses_folder;

public class Plant {
	private int position;
	private int pesticide;
	
	
	public Plant(int position, int pesticide) {
		this.position = position;
		this.pesticide=pesticide;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public int getPesticide() {
		return this.pesticide;
	}

}

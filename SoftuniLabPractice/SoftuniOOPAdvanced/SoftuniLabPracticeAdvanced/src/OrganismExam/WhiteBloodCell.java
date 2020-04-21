package OrganismExam;

public class WhiteBloodCell extends Cell {

	public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
		super(id,health,positionRow,positionCol,size);
		
	}
	
	@Override
	public int getEnergy() {
		return (this.getHealth()+this.getAdditional())*2;
	}
	
	
	@Override
	public String toString() {
		String print = String.format("WBC:%s HEALTH: %d ENERGY: %d SIZE: %d",this.getId(),this.getHealth(),this.getEnergy(),this.getAdditional());
		return print;
	}
}

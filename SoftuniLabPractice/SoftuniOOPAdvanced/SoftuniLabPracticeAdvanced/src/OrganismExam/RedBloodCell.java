package OrganismExam;

public class RedBloodCell extends BloodCell {
	
	public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
		super(id,health,positionRow,positionCol,velocity);
		
		
	}
	
	@Override
	public int getEnergy() {
		return this.getHealth()+this.getAdditional();
	}
	
	
	@Override
	public String toString() {
		String print = String.format("RBC:%s HEALTH: %d ENERGY: %d Velocity: %d",this.getId(),this.getHealth(),this.getEnergy(),this.getAdditional());
		return print;
	}
	

}

package OrganismExam;

public class RedBloodCell extends BloodCell {
	
	public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
		super(id,health,positionRow,positionCol,velocity);
		
		
	}
	
	@Override
	public int getEnergy() {
		return this.getHealth()+this.getAdditional();
	}
	
	

}

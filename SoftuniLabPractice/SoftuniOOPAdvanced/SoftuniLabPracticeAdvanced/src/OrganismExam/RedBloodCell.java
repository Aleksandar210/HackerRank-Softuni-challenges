package OrganismExam;

public class RedBloodCell extends BloodCell {
	private int velocity;
	public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
		super(id,health,positionRow,positionCol);
		
	}
	
	private void setVelocity(int vel) {
		this.velocity = vel;
	}

}

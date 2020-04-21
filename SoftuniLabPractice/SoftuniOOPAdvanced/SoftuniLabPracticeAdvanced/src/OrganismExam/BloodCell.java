package OrganismExam;

public abstract class BloodCell extends Cell {
	
public BloodCell(String id, int health, int positionRow, int positionCol) {
		
	}

	protected void setId(String id) {
		this.id  = id;
	}
	
	protected String getId() {
		return this.id;
	}
	
	protected void setHelath(int health) {
		this.health = health;
		
	}
	
	protected int getHealth() {
		return this.health;
	}
	
	protected void setRowPos(int pos) {
		
		this.positionRow = pos;
	}
	
	protected void setColPos(int pos) {
		this.positionCol=pos;
	}
	
	

}

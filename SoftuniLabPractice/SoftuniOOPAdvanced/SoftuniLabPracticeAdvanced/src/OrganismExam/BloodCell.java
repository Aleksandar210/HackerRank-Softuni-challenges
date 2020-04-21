package OrganismExam;

public abstract class BloodCell extends Cell {
	
public BloodCell(String id, int health, int positionRow, int positionCol,int additional) {
		super(id,health,positionRow,positionCol,additional);
	}

@Override
public void attack(Cell enemy) {
	this.setHealth(this.getHealth()+enemy.getHealth());
	enemy.setHealth(0);
}
	
	
	

}

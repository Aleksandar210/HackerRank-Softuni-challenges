package OrganismExam;

public abstract class Cell {
	protected  String id;
	protected Integer health;
	protected Integer positionRow;
	protected Integer positionCol;
	protected int additionalProperty;
	
	protected Cell(String id, int health, int positionRow,int positionCol,int addit) {
		setId(id);
		setHealth(health);
		setRowPos(positionRow);
		setColPos(positionCol);
		setAdditional(addit);
	}
	
	private void setId(String id) {
		this.id  = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	private void setHealth(int health) {
		this.health = health;
		
	}
	
	public int getHealth() {
		return this.health;
	}
	
	private void setRowPos(int pos) {
		
		this.positionRow = pos;
	}
	
	private void setColPos(int pos) {
		this.positionCol=pos;
	}
	
	private void setAdditional(int add) {
		this.additionalProperty = add;
	}
	
	public int getAdditional() {
	return this.additionalProperty;	
	}
	
	
	public int getEnergy() {
		return this.getHealth()+getAdditional();
	}
	

}

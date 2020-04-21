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
	
	@Override
	public String toString() {
		return "Cell [id=" + id + ", health=" + health + ", positionRow=" + positionRow + ", positionCol=" + positionCol
				+ ", additionalProperty=" + additionalProperty + "]";
	}

	private void setId(String id) {
		this.id  = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setHealth(int health) {
		this.health = health;
		
	}
	
	public void Attacked(int energy) {
		this.setHealth(this.getHealth()-energy);
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
	
	public int getRowPos() {
		return this.positionRow;
	}
	
	public int getColPos() {
		return this.positionCol;
	}
	
	public int getAdditional() {
	return this.additionalProperty;	
	}
	
	
	public int getEnergy() {
		return this.getHealth()+getAdditional();
	}
	
	public int[] getCoordinatedCell() {
		int[] coordinates = new int[2];
		coordinates[0] = this.getRowPos();
		coordinates[1] = this.getColPos();
		return coordinates;
	}
	
	public void attack(Cell enemy) {
		enemy.Attacked(this.getEnergy());
		
	}
	
	
	

}

package OrganismExam;

public class WhiteBloodCell extends Cell {

	public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
		super(id,health,positionRow,positionCol,size);
		
	}
	
	@Override
	public int getEnergy() {
		return (this.getHealth()+this.getAdditional())*2;
	}
}

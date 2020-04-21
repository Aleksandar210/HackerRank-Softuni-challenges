package OrganismExam;

public class Virus extends Microbe {

	protected Virus(String id, int health, int positionRow, int positionCol, int addit) {
		super(id, health, positionRow, positionCol, addit);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getEnergy() {
		return this.getHealth()+this.getEnergy();
	}

}

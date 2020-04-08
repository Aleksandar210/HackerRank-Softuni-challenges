package advanced_Softuni_Classes_Iterables_Comparables;

public class Player {
	private static final  int HEALTH = 100;
	private static final String DESCRIPTION = "N/A";
	private String name;
	private String rank;
	private String clazz;
	private int health;
	private String description;
	
	public Player(String name,String clazz) {
		setName(name);
		setHealth(HEALTH);
		setClazz(clazz);
	}

	@Override
	public String toString() {
		String playerInfo = String.format("%s%n%s%n%s%s",getName(),getClazz(),getRank(),getDescription());
		return playerInfo;
	}
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

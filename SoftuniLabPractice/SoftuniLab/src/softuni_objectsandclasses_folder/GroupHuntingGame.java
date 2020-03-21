package softuni_objectsandclasses_folder;

public class GroupHuntingGame {
private String groupName;	
private int playerCount;
private double foodCount;
private double waterCount;
private double energy;
private boolean survived;
 
public GroupHuntingGame(String name, int count,double food, double water,double energy) {
	this.groupName=name;
	this.playerCount=count;
	this.foodCount=food;
	this.waterCount=water;
	this.energy=energy;
	survived=false;		//default value
}

public double getEnergy() {
	return energy;
}

public void setEnergy(double energy) {
	this.energy = energy;
}

public String getGroupName() {
	return groupName;
}

public void setGroupName(String groupName) {
	this.groupName = groupName;
}

public int getPlayerCount() {
	return playerCount;
}

public void setPlayerCount(int playerCount) {
	this.playerCount = playerCount;
}

public double getFoodCount() {
	return foodCount;
}

public void setFoodCount(double foodCount) {
	this.foodCount = foodCount;
}

public void decreaseFoodSupply(int decreaseBy) {
	this.foodCount-=decreaseBy;
}

public double getWaterCount() {
	return waterCount;
}

public void setWaterCount(double waterCount) {
	this.waterCount = waterCount;
}

public void increaseEnergy(double increaseBy) {
	this.energy+=increaseBy;
}

public void decreaseEnergy(double increaseBy) {
	this.energy-=increaseBy;
}

public void checkGroupSurvival() {
	if(this.energy>=0) {
		survived=true;
	}
}

public void displayGroupData() {
	if(survived) {
		System.out.printf("%s has survived with remaining -%f food and %f water",this.groupName,this.foodCount,this.waterCount);
	}else {
		System.out.println("Group didnt survive");
	}
}


}

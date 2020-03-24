package softuni_objectsandclasses_folder;

public class Dragon {
private String name;
private int health;
private int damage;
private int armour;

public Dragon(String name ,int health,int damage,int armour) {
	this.name = name;
	this.health = health;
	this.damage = damage;
	this.armour = armour;
	
}


@Override
public String toString() {
	return "Dragon name=" + name + ", health=" + health + ", damage=" + damage + ", armour=" + armour + "";
}


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getHealth() {
	return health;
}

public void setHealth(int health) {
	this.health = health;
}

public int getDamage() {
	return damage;
}

public void setDamage(int damage) {
	this.damage = damage;
}

public int getArmour() {
	return armour;
}

public void setArmour(int armour) {
	this.armour = armour;
}

}

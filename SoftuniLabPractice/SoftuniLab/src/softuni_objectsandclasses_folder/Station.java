package softuni_objectsandclasses_folder;

public class Station {
private int gas;
private int distance;

public Station(int gas,int distance) {
	this.gas=gas;
	this.distance=distance;
}

public int get_Gas() {
	return this.gas;
}

public int get_Distance() {
	return this.distance;
}
}

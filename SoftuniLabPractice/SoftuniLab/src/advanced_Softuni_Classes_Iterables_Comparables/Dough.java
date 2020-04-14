package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.LinkedList;
import java.util.List;

public class Dough {
private double weight;
private double white;
private double wholeGrain;
private double crispy;
private double chewy;
private double homemade;
private List<Double> currentProperties;

public Dough(String...data) {
	setDough(data);
	
	
	
}

private void setDough(String[]data) {
	currentProperties = new LinkedList<Double>();
	for(String currentData:data) {
		
		switch(currentData.toLowerCase()) {
		case "wholegrain":
			setWholeGrain(1.0);
			currentProperties.add(getWholeGrain());
			break;
		case "white":
			setWhite(1.5);
			currentProperties.add(getWhite());
			break;
		case "chewy":
			setChewy(1.1);
			currentProperties.add(getChewy());
			break;
		case "crispy":
			setCrispy(0.9);
			currentProperties.add(getCrispy());
				break;
		case "homemade":
			
			setHomemade(1.0);
			currentProperties.add(getHomemeade());
			break;
			default:
				if(currentData.equals("dough")) {
					
				}else if(Character.isDigit(currentData.charAt(0))) {
					setWeight(Double.parseDouble(currentData));
				}
				break;
		}
		
	}
}

public double calculateDoughCalories() {
	double calories = 2*getWeight();
	calories *= this.currentProperties.stream()
			.reduce((a,b)-> a*b)
			.get();
	return calories;
}

public double getWeight() {
	return weight;
}

private void setWeight(double weight) {
	this.weight = weight;
}

public double getWhite() {
	return white;
}

private void setWhite(double white) {
	this.white = white;
}

public double getWholeGrain() {
	return wholeGrain;
}

private void setWholeGrain(double wholeGrain) {
	this.wholeGrain = wholeGrain;
}

public double getCrispy() {
	return crispy;
}

private void setCrispy(double crispy) {
	this.crispy = crispy;
}

public double getChewy() {
	return chewy;
}

private  void setChewy(double chewy) {
	this.chewy = chewy;
}

public double getHomemeade() {
	return homemade;
}

private void setHomemade(double homemeade) {
	this.homemade = homemeade;
}
}

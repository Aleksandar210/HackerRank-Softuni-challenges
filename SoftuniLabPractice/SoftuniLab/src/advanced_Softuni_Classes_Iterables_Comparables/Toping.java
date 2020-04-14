package advanced_Softuni_Classes_Iterables_Comparables;

public class Toping {
private double modifier;
private String type;
private double weight;

	private double calories;
	
	
	public Toping(String...top) {
		setToppings(top);
		
		
	}
	
	private void setToppings(String[] data) {
		double currentCalories=1;
		
		for(String currentData:data) {
		switch(currentData.toLowerCase()) {
		case "veggies":
			currentCalories*=0.8;
			setModifier(0.8);
			setType(currentData);
			
			break;
		case "meat":
			setModifier(1.2);
			currentCalories*=1.2;
			setType(currentData);
			break;
		case "cheese":
			setModifier(1.1);
			currentCalories*=1.1;
			setType(currentData);
			break;
		case"sauce":
			setModifier(0.2);
			currentCalories*=0.2;
			setType(currentData);
			break;
			default:
				if(currentData.equals("topping")) {
					
				}else if(Character.isDigit(currentData.charAt(0))) {
					
						setWeight(Double.parseDouble(currentData));
						currentCalories*=(2*getWeight());
					
				}else {
					throw new IllegalArgumentException("Cannot place "+currentData
							+"on the pizza");
					
				}
				break;
		}
		}
		setCaloriesToppings(currentCalories);
		
		
	}
	
	public double getCaloriesToppings() {
		
		return this.calories;
	}
	
	private void setCaloriesToppings(double temp) {
		this.calories=temp;
	}
	
	private void setModifier(double current) {
		this.modifier=current;
	}
	public double getModifier() {
		return this.modifier;
	}
	
	private void setType(String current) {
		this.type = current;
	}
	
	private void setWeight(double current) {
		if(current>50) {
			throw new IllegalArgumentException("Range must be between[0-50]");
		}else if(current<=0) {
			this.weight=0;
		}
		this.weight = current;
	}
	public double getWeight() {
		return this.weight;
	}

	

}

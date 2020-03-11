package FarmerSalesman;

public class Product {
	private String name;
	 private int quantity;
	 private double price;
	 private String type;
	 
	 
	 
	 public Product(String name, int quantity, double price, String type) {
		 this.name = name;
		 this.quantity =quantity;
		 this.price = price;
		 this.type = type;
	 }
	 
	 public String getType() {
		 return this.type;
	 }
	 

	public String getName() {
		return name;
	}

	

	public int getQuantity() {
		return quantity;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	 
	 
	 

}

package advanced_Softuni_Classes_Iterables_Comparables;

public class Box {
	private double length;
	private double width;
	private double height;
	
	
	public Box(double length, double width, double height) {
		setLength(length);
		setWidth(width);
		setHeight(height);
	}
	
	public double getVolume() {
		
		return this.length*this.height*this.width;
	}
	
	public double getLateralSurface() {
		return (this.length*this.height) + (this.width*this.height);
	}
	
	public double getSurface() {
		return getLateralSurface() + (this.length*this.width);
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Box [getVolume()=" + getVolume() + ", getLateralSurface()=" + getLateralSurface() + ", getSurface()="
				+ getSurface() + "]";
	}

	private void setLength(double length) {
		this.length = length;
	}
	
	private void setWidth(double width) {
		this.width = width;
	}
	
	private void setHeight(double height) {
		this.height = height;
	}
	

}

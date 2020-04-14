package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.Scanner;

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
		if(length<=0) {
			throw new IllegalArgumentException("Length cannot be negatie or 0");
		}else {
		this.length = length;
		}
	}
	
	private void setWidth(double width) {
		if(width<=0) {
			throw new IllegalArgumentException("Width cannot be negative or zero");
		}else {
		this.width = width;
		}
	}
	
	private void setHeight(double height) {
		if(height<=0) {
			throw new IllegalArgumentException("Height cannot be negative or 0");
		}else {
		this.height = height;
		}
	}
	

}

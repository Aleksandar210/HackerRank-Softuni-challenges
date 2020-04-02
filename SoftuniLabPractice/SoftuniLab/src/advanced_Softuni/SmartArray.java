package advanced_Softuni;

import java.util.Arrays;
import java.util.function.Consumer;

public class SmartArray {
	private static int count = 0;			//used for contains method to solve scope problem
											//don't change the count variable at all;			
	
	private static int INITIAL_SIZE = 4;
	private int size;
	private int capacity;
	private int data[];
	
	public SmartArray() {
		setCapacity(INITIAL_SIZE);
		setSize(0);
		this.data = new int[getCapacity()];
		
	}
	
	public void add(int atIndex,int elementToAdd) {
		 if(atIndex==getSize()) {
			add(atIndex);
		}else if(atIndex==0) {
			int[] tempArray = new int[getCapacity()]; 
			System.arraycopy(this.data, 0, tempArray, 1, getSize());
			tempArray[0] = elementToAdd;
			setSize(getSize()+1);
			this.data = tempArray;	
		}else {
			int[] temp = new int[getCapacity()];
			int holdCurrent;
			System.arraycopy(this.data, 0, temp, 0, atIndex+1);
			holdCurrent = this.data[atIndex+1];
			temp[atIndex] =elementToAdd;
			System.arraycopy(this.data, atIndex, temp, atIndex+1,getSize()-atIndex);
			setSize(getSize()+1);
			
		}
	}
	
	public void foreach(Consumer<Integer> consumer) {
		for(int i =0;i<getSize();i++) {
			consumer.accept(this.data[i]);
		}
	}
	
	public int get(int index) {
		if(index>getSize() || index<getSize()) {
			throw new IndexOutOfBoundsException("Index beyond the size");
		}else {
			return this.data[index];
		}
	}
	
	@SuppressWarnings("static-access")
	public boolean contains(int element) {
		boolean containsElement = false;
		
		int[] arrayToCheck = new int[getSize()];
		System.arraycopy(this.data, 0, arrayToCheck, 0, getSize());
		arrayToCheck = Arrays.stream(arrayToCheck).filter(e -> e==element)
				.map(e ->{count++; return e;}).toArray();
		if(count>0) {
			containsElement=true;
			this.count=0;
		}
		return containsElement;
	}
	
	
	
	public void add(int element) {
		if(getSize()>getCapacity()) {
			throw new IndexOutOfBoundsException("Index is beyond the size");
		}else if(getSize()==getCapacity()) {
			setCapacity(getCapacity()*2);
		}
		this.data[getSize()] = element;
		setSize(getSize()+1);
	}
	
	public int remove(int index) {
		int removedElement;
		int[] arrayToReturn;
		if(index>=getSize()|| index<getSize()) {
			throw new IndexOutOfBoundsException("Index beyond size!");
		}else {
			removedElement = this.data[index];
		}
		if(index==0) {
			arrayToReturn = new int[this.data.length-1];
			System.arraycopy(this.data,1, arrayToReturn, 0, getSize()-1);
			this.data = arrayToReturn;
			if(getSize()<=getCapacity()/4) {
				setCapacity(getCapacity()/2);	
				}
				
			return removedElement;
		}else if(index==getSize()-1) {
			arrayToReturn = new int[this.data.length-2];
			System.arraycopy(this.data, 0, arrayToReturn, 0, getSize()-2);
			this.data = arrayToReturn;
			if(getSize()<=getCapacity()/4) {
				setCapacity(getCapacity()/2);	
				}
				
			return removedElement;
			
		}else {
			arrayToReturn = new int[this.data.length-1];
			
			System.arraycopy(this.data, 0, arrayToReturn, 0, index);
			System.arraycopy(this.data, index+1, arrayToReturn, index, (getSize()-1)-index);
			this.data = arrayToReturn;
			
			if(getSize()<=getCapacity()/4) {
			setCapacity(getCapacity()/2);	
			}
			
			return removedElement;
		}
		
		
		
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	

}

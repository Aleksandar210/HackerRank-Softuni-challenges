package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.Iterator;
import java.util.function.Consumer;

public class CustomIterableStack implements Iterable<Integer> {
	private static final int INDEX_DEFAULT =0;
	private static final int CAPACITY_DEFAULT = 4;
	private static final int SIZE_DEFAULT = 0;

private int size;
private int capacity;
private int[] data;


public CustomIterableStack() {
	
	setSize(SIZE_DEFAULT);
	setCapacity(CAPACITY_DEFAULT);
	setData(new int[getCapacity()]);
	
}

public void push(int element) {
	getData()[getSize()] = element;
	setSize(getSize()+1);
	setCapacity(getCapacity()+1);
}

public int pop() {
	int[] tempArray = new int[getCapacity()-1];
	System.arraycopy(getData(), 1, tempArray, 0, getSize()-1);
	int returnPoped = getData()[0];
	setData(tempArray);
	setSize(getSize()-1);
	setCapacity(getCapacity()-1);
	return returnPoped;
}




@Override
public Iterator<Integer> iterator() {
	StackIterator stackIter = new StackIterator(getData(),getSize());
	return stackIter;
	
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

public int[] getData() {
	return data;
}

public void setData(int[] data) {
	this.data = data;
}











private final class StackIterator implements Iterator<Integer>{
	private static final int INDEX_DEFAULT =0;
	private int indexOfElement;
	private int[] currentCollection;
	private int currentSize;
	
	public StackIterator(int[] data,int size) {
		this.indexOfElement = INDEX_DEFAULT;
		this.currentCollection= new int[size];
		System.arraycopy(data, 0, currentCollection, 0, size);
		this.currentSize = size;
	}
	
	
	@Override
	public boolean hasNext() {
		if(this.indexOfElement<currentSize) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Integer next() {
		this.indexOfElement++;
		if(indexOfElement<this.currentSize) {
			
			return this.currentCollection[this.indexOfElement];
		}else {
			return null;
		}
		
	}
	

	
	
	}
	
}



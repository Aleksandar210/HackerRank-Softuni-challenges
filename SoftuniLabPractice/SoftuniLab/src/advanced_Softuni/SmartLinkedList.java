package advanced_Softuni;

import java.util.function.Consumer;

public class SmartLinkedList {
	private static final int INITIAL_CAPACITY = 4;
	private static final int INITIAL_SIZE = 0;
	private int capacity;
	private int size;
	private int[] data;
	
	public SmartLinkedList() {
		setCapacity(INITIAL_CAPACITY);
		setSize(INITIAL_SIZE);
		setData(new int[capacity]);
		
	}
	
	public void addFirst(int element) {
		if(getSize()==getCapacity()) {
			setCapacity(getCapacity()+4);
		}
		int[] temp = new int[getCapacity()];
		System.arraycopy(getData(), 0, temp, 1, getSize()-1);
		temp[0] = element;
		setData(temp);
		setSize(getSize()+1);
	}
	
	public void addLast(int element) {
		if(getSize()==getCapacity()) {
			setCapacity(getCapacity()+4);
		}
		getData()[getSize()] = element;
		setSize(getSize()+1);
		
	}
	public void foreach(Consumer<Integer> consumer) {
		consumer = e->System.out.println(e);
		for(int i =0;i<getSize();i++) {
			consumer.accept(i);
		}
	}
	
	public int removeFirst() {
		int[] temp = new int[getCapacity()];
		int removedElement;
		System.arraycopy(getData(), 1, temp, 0, getSize()-1);
		setData(temp);
		removedElement = getData()[0];
		setSize(getSize()-1);
		return removedElement;
		
	}
	
	public int removeLast() {
		int[] temp = new int[getCapacity()];
		int removedElement = getData()[getSize()-1];
		System.arraycopy(getData(), 0, temp, 0, getSize()-2);
		setData(temp);
		setSize(getSize()-1);
		return removedElement;
	}
	
	public int[] toArray() {
		return getData();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private int[] getData() {
		return data;
	}

	private void setData(int[] data) {
		this.data = data;
	}

}

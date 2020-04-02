package advanced_Softuni;

import java.util.function.Consumer;

public class SmartStack {
	private static final int INITIAL_CAPACITY = 0;
	
private int size = 0;		//0 default value because its empty
private int data[];
private int capacity;

public SmartStack() {
	this.capacity = INITIAL_CAPACITY;
	data = new int[capacity];
}


public void push(int element) {
	if(getSize()==getCapacity()) {
		setCapacity(getCapacity()*2);
	}
	if(getSize()>0) {
		int[] newArray = new int[getCapacity()];
		System.arraycopy(this.data, 0, newArray, 1, getSize()-1);
		newArray[0]=element;
		this.data = newArray;		
	}else {
		this.data[getSize()] = element;
	}
	
	
}

public void foreach(Consumer<Integer> consumer) {
	for(int i =0;i<getSize();i++) {
		consumer = e->System.out.println(e);
		consumer.accept(this.data[i]);
		
	}
}

public int pop() {
	int[] newArray = new int[getCapacity()];
	System.arraycopy(this.data, 1, newArray, 0, getSize()-1);
	int removedElement = this.data[0];
	this.data = newArray;
	setSize(getSize()-1);
	
	if(getSize()<=getCapacity()/4) {
		setCapacity(getCapacity()/2);
	}
	return removedElement;
}


public int peek() {
	
return this.data[0];


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

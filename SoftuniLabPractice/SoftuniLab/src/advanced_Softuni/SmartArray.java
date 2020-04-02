package advanced_Softuni;

public class SmartArray {
	private static int INITIAL_SIZE = 4;
	private int size;
	private int capacity;
	private int data[];
	
	public SmartArray() {
		setCapacity(INITIAL_SIZE);
		setSize(0);
		this.data = new int[getCapacity()];
		
		
		
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
		if(index>=getSize()) {
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

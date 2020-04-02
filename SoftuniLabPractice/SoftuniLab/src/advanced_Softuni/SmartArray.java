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
	
	public void remove(int element) {
		
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

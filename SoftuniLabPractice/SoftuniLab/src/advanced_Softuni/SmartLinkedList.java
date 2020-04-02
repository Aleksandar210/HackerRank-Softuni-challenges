package advanced_Softuni;

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

package advanced_Softuni;

public class CustomDoublyLinkedList {
	private static final int INIT_CAPACITY = 4;
	private static final int INIT_SIZE = 0;
	private int capacity;
	private int size;
	private ListNode[] data;
	
	public CustomDoublyLinkedList() {
		setCapacity(INIT_CAPACITY);
		setSize(INIT_SIZE);
		setData(new ListNode[getCapacity()]);
	}
	
	public void addFirst(int element) {
		if(getSize()==getCapacity()) {
			setCapacity(getCapacity()+4);
		}
		if(getSize()==0) {
			getData()[getSize()] = new ListNode(element);
			getData()[getSize()].setPrevious(null);
		}else {
			getData()[0] = new ListNode(element);
			getData()[0].setNext(getData()[getSize()-1]);
			getData()[getSize()-1].setPrevious(getData()[getSize()]);
		}
		setSize(getSize()+1);
	}
	
	public void addLast(int element) {
		if(getSize()==getCapacity()) {
			setCapacity(getCapacity()+4);
		}
		if(getSize()==0) {
			getData()[getSize()] = new ListNode(element);
			getData()[getSize()].setPrevious(null);
		}else {
			getData()[getSize()] = new ListNode(element);
			getData()[getSize()].setPrevious(getData()[getSize()-1]);
			getData()[getSize()-1].setNext(getData()[getSize()]);
		}
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

	public ListNode[] getData() {
		return data;
	}

	public void setData(ListNode[] data) {
		this.data = data;
	}
	

}

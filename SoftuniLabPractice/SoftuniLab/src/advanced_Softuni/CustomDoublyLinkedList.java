package advanced_Softuni;

import java.util.function.Consumer;

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
	
	public void foreach(Consumer<Integer> consumer) {
		consumer = e -> System.out.println(e);
		for(int i =0;i<getSize();i++) {
			consumer.accept(getData()[i].getCurrentItem());
		}
	}
	
	
	public int removeFirst() {
		ListNode removedElement = getData()[0];
		ListNode[] temp = new ListNode[getCapacity()];
		System.arraycopy(getData(), 1, temp, 0, getSize()-1);
		temp[0].setPrevious(null);
		setData(temp);
		setSize(getSize()-1);
		return removedElement.getCurrentItem();
	}

	public int getCapacity() {
		return capacity;
	}
	
	public int removeLast() {
		int removedElement = getData()[getSize()-1].getCurrentItem();
		ListNode[] temp = new ListNode[getCapacity()];
		System.arraycopy(getData(), 0, temp, 0, getSize()-2);
		setSize(getSize()-1);
		return removedElement;
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

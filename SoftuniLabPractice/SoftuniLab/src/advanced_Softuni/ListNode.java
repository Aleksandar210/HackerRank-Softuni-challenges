package advanced_Softuni;

public class ListNode {
	private int currentItem;
	private ListNode previous;
	private ListNode next;
	
	public ListNode(int item) {
		setCurrentItem(item);
		
	}
	
	
	
	

	@Override
	public String toString() {
		String currReturn = String.valueOf(getCurrentItem()); 
		return  currReturn;
	}
	
	





	public int getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(int currentItem) {
		this.currentItem = currentItem;
	}

	public ListNode getPrevious() {
		return previous;
	}

	public void setPrevious(ListNode previous) {
		this.previous = previous;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

}

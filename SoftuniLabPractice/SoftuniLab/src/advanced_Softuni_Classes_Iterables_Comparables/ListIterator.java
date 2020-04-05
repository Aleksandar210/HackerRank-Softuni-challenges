package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListIterator implements Iterable<String> {

	private List<String> list;
	private ListIter currentListIter;
	
	public ListIterator(String[] arr) {
		this.list = new LinkedList<String>(Arrays.asList(arr));
	}
	
	public boolean hasNext() {
		return this.iterator().hasNext();
	}
	
	public void print() {
		currentListIter.print();
		
	}
	
	public String next() {
		return this.iterator().next();
	}
	
	
	@Override
	public Iterator<String> iterator() {
		 ListIter currentIterator = new ListIter(this.list);
		 currentListIter = currentIterator;
		return currentIterator;
	}
	
	private class ListIter implements Iterator<String>{
		private static final int INDEX_DEFAULT =0;
		private int index=INDEX_DEFAULT;
		private List<String> currentList;
		public ListIter(List<String> list) {
			this.currentList=list;
		}
		
		
		@Override
		public boolean hasNext() {
			
			if(this.index<this.currentList.size()) {
				return true;
			}else {
				return false;
			}
		}

		@Override
		public String next() {
			
			return this.currentList.get(index++);
		}
		
		public void print() {
			System.out.println(this.currentList.get(index));
		}
		
	}

}

package classes_used_generics_tasks;

import java.util.Collections;
import java.util.List;

public class ListUtils<E extends Comparable<E>> {
	private E min;
	private E max;
	private List<E> elements;
	
	public ListUtils(List<E> listGiven) {
		elements = listGiven;
	}
	
	
	
	public E getMin() {
		if(this.min==null) {
			return null;
		}else {
			int indexOfMin = elements.indexOf(Collections.min(elements));
			this.min = elements.get(indexOfMin);
			return this.min;
		}
	}
	
	public E getMax() {
		if(this.max==null) {
			return null;
		}else {
			int indexOfMax = elements.indexOf(Collections.max(elements));
			this.max = elements.get(indexOfMax);
			return this.max;
		}
	}
	
	

}

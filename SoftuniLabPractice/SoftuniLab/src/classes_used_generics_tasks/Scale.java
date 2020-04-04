package classes_used_generics_tasks;

public class Scale<E extends Comparable<E>> {
	private static final boolean areEqualDefault = false;
	private E min;
	private E max;
	private boolean areEqual = areEqualDefault;
	
	public Scale(E first, E second) {
		assignCompare(first,second);
	}
	
	private void assignCompare(E first, E second) {
		if(first.compareTo(second)==0) {
			areEqual = true;
		}else if(first.compareTo(second)<0) {
			this.min = first;
			this.max=second;
		}else {
			this.min = second;
			this.max=first;
		}
	}
	
	public E getMin() {
		if(areEqual) {
			return null;
		}
		return this.min;
	}
	
	
	public E getMax() {
		if(areEqual) {
			return null;
		}
		return this.max;
	}

}

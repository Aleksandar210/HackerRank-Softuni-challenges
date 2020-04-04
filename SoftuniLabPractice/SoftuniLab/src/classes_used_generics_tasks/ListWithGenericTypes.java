package classes_used_generics_tasks;

import java.util.List;

public class ListWithGenericTypes {
	
	
	public ListWithGenericTypes() {
		
	}
	
	public static <E> void swapElements(List<E> list,int index, int index2) {
		E element = list.get(index);
		list.set(index, list.get(index2));
		list.set(index2, element);
	}

}

package classes_used_generics_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Box<E> {
private E element;

public Box(E element) {
	this.element = element;
}

public E getElement() {
	return this.element;
}

public static <E extends Comparable<E>> int countElemsGreaterThan(List<E> list,E element) {
	int count=0;
	List<E> newList = new ArrayList<E>(list);
	newList.stream().filter(e -> e.compareTo(element)>1).collect(Collectors.toList());
	return count = newList.size();
}

@Override
public String toString() {
	String printThis  = this.element.getClass().getSimpleName()+" "+this.element;
	return printThis;
}
}

package classes_used_generics_tasks;

public class Box<E> {
private E element;

public Box(E element) {
	this.element = element;
}

public E getElement() {
	return this.element;
}

@Override
public String toString() {
	String printThis  = this.element.getClass().getSimpleName()+" "+this.element;
	return printThis;
}
}

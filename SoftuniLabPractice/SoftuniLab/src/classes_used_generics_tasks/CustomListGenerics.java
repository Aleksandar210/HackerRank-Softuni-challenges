package classes_used_generics_tasks;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
public class CustomListGenerics<E extends Comparable<E>> implements List<E> {
private List<E> list;


public CustomListGenerics(List<E> list) {
	this.list = list;
}

	@Override
	public boolean add(E e) {
		list.add(e);
		return false;
	}

	@Override
	public void add(int index, E element) {
		
		list.set(index, element);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return list.addAll(c);
		
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		
		return list.addAll(index, c);
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public boolean contains(Object o) {
		return list.contains(o);
		
	}

	

	@Override
	public E get(int index) {
		
		return list.get(index);
	}

	@Override
	public int indexOf(Object o) {
		
		return list.indexOf(o);
	}

	
	@Override
	public E remove(int index) {
		
		return list.remove(index);
	}
	
	public void swap(int index, int index2) {
	E element = list.get(index);
	list.set(index, list.get(index2));
	list.set(index2, element);
	
	
	}
	
	
	

	

}

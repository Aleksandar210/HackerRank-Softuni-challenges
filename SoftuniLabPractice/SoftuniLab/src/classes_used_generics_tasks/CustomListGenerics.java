package classes_used_generics_tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
public class CustomListGenerics<E extends Comparable<E>>  {
private List<E> list;


public CustomListGenerics(List<E> list) {
	this.list = list;
}

	
	public boolean add(E e) {
		list.add(e);
		return false;
	}

	
	public void add(int index, E element) {
		
		list.set(index, element);
	}

	
	public boolean addAll(Collection<? extends E> c) {
		return list.addAll(c);
		
	}

	
	public boolean addAll(int index, Collection<? extends E> c) {
		
		return list.addAll(index, c);
	}

	
	public void clear() {
		list.clear();
	}

	
	public boolean contains(Object o) {
		return list.contains(o);
		
	}

	

	
	public E get(int index) {
		
		return list.get(index);
	}

	
	public int indexOf(Object o) {
		
		return list.indexOf(o);
	}

	
	
	public E remove(int index) {
		
		return list.remove(index);
	}
	
	public void swap(int index, int index2) {
	E element = list.get(index);
	list.set(index, list.get(index2));
	list.set(index2, element);
	
	
	}
	
	public int countGreatherThan(E element) {
		List<E> currentStreamList = new ArrayList<E>(this.list);
		this.list.stream().filter(e -> e.compareTo(element)>1).collect(Collectors.toList());
		return currentStreamList.size();
	}
	
	public E getMin() {
		return Collections.min(this.list);
	}
	
	public E getMax() {
		return Collections.max(this.list);
	}
	
	public  void sort() {
		
		Collections.sort(this.list);
	}

	
	

	

}

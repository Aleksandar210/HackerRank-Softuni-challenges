package classes_used_generics_tasks;


import java.util.LinkedList;

public class JarCollections<E> {
	private LinkedList<E> jars;
	
	public JarCollections() {
		setJars(new LinkedList<E>());
	}
	
	public void add(E element) {
		getJars().add(element);
	}
	
	public E getFirstElement() {
		return getJars().getFirst();
	}
	
	public void showCurrentJarContents() {
		getJars().forEach(e ->System.out.print(e+" "));
	}
	
	
	public LinkedList<E> getJars() {
		return this.jars;
	}
	
	

	public void setJars(LinkedList<E> jars) {
		this.jars = jars;
	}
	
	

}

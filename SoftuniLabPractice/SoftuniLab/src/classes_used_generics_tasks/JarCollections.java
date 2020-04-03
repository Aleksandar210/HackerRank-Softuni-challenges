package classes_used_generics_tasks;


import java.util.LinkedList;

public class JarCollections<E> {
	private LinkedList<LinkedList<Class<E>>> jars;
	
	public JarCollections() {
		jars = new LinkedList<>();
	}
	
	public void add(E element) {
		
	}
	
	public void addToLastCreatedCollection(E element) {
		
	}
	
	public void showCurrentJars() {
		getJars().forEach(e ->System.out.println(e));
	}
	
	public void createJarCollection() {
		getJars().add(new LinkedList<Class<E>>());
	}

	public LinkedList<LinkedList<Class<E>>> getJars() {
		return jars;
	}

	public void setJars(LinkedList<LinkedList<Class<E>>> jars) {
		this.jars = jars;
	}
	
	

}

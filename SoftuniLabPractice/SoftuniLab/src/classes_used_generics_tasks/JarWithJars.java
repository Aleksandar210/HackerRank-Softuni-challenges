package classes_used_generics_tasks;

import java.util.List;
import java.util.LinkedHashMap;

public class JarWithJars<E extends Comparable<E>> {
	private static int jarCounter = 0;
	private LinkedHashMap<Integer,JarCollections<E>> jars;
	
	public JarWithJars() {
		
		this.jars = new LinkedHashMap<>();
	}
	
	
	
	@SuppressWarnings("static-access")
	public void createNewJarCollection() {
		JarCollections<E> currentJarCollection = new JarCollections<E>();
		this.jarCounter+=1;
		getJars().put(jarCounter,currentJarCollection);
	}
	
	public List<E> getAccessToCollection(){
		
	}

	public LinkedHashMap<Integer, JarCollections<E>> getJars() {
		return jars;
	}

	public void setJars(LinkedHashMap<Integer, JarCollections<E>> jars) {
		this.jars = jars;
	}

}

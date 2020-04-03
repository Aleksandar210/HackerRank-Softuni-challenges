package classes_used_generics_tasks;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
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
		if(jars.isEmpty()) {
			
			return  null;
		}
		int counter = 0;
		for(Map.Entry<Integer, JarCollections<E>>entry:jars.entrySet()) {
			System.out.print(entry.getKey()+ " ");
			entry.getValue().showCurrentJarContents();
			System.out.println();
			counter++;
		}
		int select;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Select Collection: ");
			select = Integer.parseInt(scan.nextLine());
		}while(select<1 || select>counter);
		scan.close();
		return jars.get(select).getJars();
	}
	
	public JarCollections<E> getAccesToClassJarCollections(){
         if(jars.isEmpty()) {
			
			return  null;
		}
		int counter = 0;
		for(Map.Entry<Integer, JarCollections<E>>entry:jars.entrySet()) {
			System.out.print(entry.getKey()+ " ");
			entry.getValue().showCurrentJarContents();
			System.out.println();
			counter++;
		}
		int select;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Select Collection: ");
			select = Integer.parseInt(scan.nextLine());
		}while(select<1 || select>counter);
		scan.close();
		return this.jars.get(select);
	}

	public LinkedHashMap<Integer, JarCollections<E>> getJars() {
		return jars;
	}

	public void setJars(LinkedHashMap<Integer, JarCollections<E>> jars) {
		this.jars = jars;
	}

}

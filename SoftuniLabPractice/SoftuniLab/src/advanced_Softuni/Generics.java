package advanced_Softuni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes_used_generics_tasks.JarWithJars;
import classes_used_generics_tasks.ListUtils;

public class Generics {
	public static void main(String[] args) {
		//jarTask();
	}
	
	
	
	static void jarTask() {
		//specify Type  Jar<> jar = new Jar<>();
	}
	
	//this is experimental
	static void JarWithjarsTask() {
		JarWithJars<Integer> jarCollections = new JarWithJars<Integer>();
		jarCollections.createNewJarCollection();
		List<Integer> currentCollection =  jarCollections.getAccessToCollection();
		currentCollection.add(34);
		currentCollection.add(133);
		jarCollections.getAccesToClassJarCollections().showCurrentJarContents();
		
			
	}
	
	static void ListUtilsScales() {
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, 1,2,3,4,5,6);
		ListUtils<Integer> util = new ListUtils<Integer>(list);
		System.out.println(util.getMax());
		System.out.println(util.getMin());
	}

}

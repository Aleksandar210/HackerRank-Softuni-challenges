package advanced_Softuni;

import java.util.List;

import classes_used_generics_tasks.JarWithJars;

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

}

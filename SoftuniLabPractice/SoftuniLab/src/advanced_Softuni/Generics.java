package advanced_Softuni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes_used_generics_tasks.ArrayCreator;
import classes_used_generics_tasks.Box;
import classes_used_generics_tasks.JarWithJars;
import classes_used_generics_tasks.ListUtils;

public class Generics {
	public static void main(String[] args) {
		//jarTask();
		arrCreator();
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
	
	static void arrCreator() {
		ArrayCreator arrCr = new ArrayCreator();
		System.out.println(arrCr.create(Integer.class, 5, 0).length);
		
			
		
	}
	
	 static void BoxTask() {
		 int numberElements = getInt();
		 List<Box<String>> boxes = new ArrayList<Box<String>>(numberElements);
		 
		 while(numberElements-- >0) {
			 boxes.add(new Box<String>(getString()));
		 }
		 
		 for(int i =0;i<boxes.size();i++) {
			 System.out.println(boxes.get(i));
		 }
	 }
	 
	 static int getInt() {
		 try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			 return Integer.parseInt(br.readLine());
			 
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return -1;
	 }
	 
	 static String getString() {
		 try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			 return br.readLine();
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	 }

}

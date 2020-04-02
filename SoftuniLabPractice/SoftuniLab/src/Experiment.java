
import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Map.Entry;


public class Experiment {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
			
		int[] array1 =new int[5];
		for(int i =0;i<5;i++) {
			array1[i]=i+1;
		}
		
		
	add(3,777,array1);
		
	}
	
	static void add(int atIndex, int elementToAdd,int[] array1) {
		int[] temp = new int[array1.length+1];
		int getTempIndex =  array1[atIndex+1];
		System.arraycopy(array1, 0, temp, 0, atIndex+1);
		temp[atIndex] = elementToAdd;
		System.arraycopy(array1, atIndex, temp, atIndex+1,array1.length-atIndex);
		for(int i =0;i<temp.length;i++) {
			System.out.println(temp[i]);
		}
		
	}
	
	
	
	//works fine
	static int[] removeElement(int index,int[] arrayToRemove) {
		int[] arrayToReturn;
		if(index==0) {
			arrayToReturn = new int[arrayToRemove.length-1];
			System.arraycopy(arrayToRemove,1, arrayToReturn, 0, arrayToRemove.length-1);
		}else if(index==arrayToRemove.length-1) {
			arrayToReturn = new int[arrayToRemove.length-2];
			System.arraycopy(arrayToRemove, 0, arrayToReturn, 0, arrayToRemove.length-2);
			return arrayToReturn;
		}else {
			arrayToReturn = new int[arrayToRemove.length-1];
			
			System.arraycopy(arrayToRemove, 0, arrayToReturn, 0, index);
			System.arraycopy(arrayToRemove, index+1, arrayToReturn, index, (arrayToRemove.length-1)-index);
			return arrayToReturn;
		}
		return null;
		
	}
	
	
	
	
	
}

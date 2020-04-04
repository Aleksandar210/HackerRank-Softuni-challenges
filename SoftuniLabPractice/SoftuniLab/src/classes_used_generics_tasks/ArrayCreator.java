package classes_used_generics_tasks;

import java.lang.reflect.Array;

public class ArrayCreator {

	public ArrayCreator() {
		
	}
	
	public<E> E[] create(Class<E> cl,int length,E defValue) {
		E[] arr = (E[]) Array.newInstance(cl, length);
		for(int i =0;i<length;i++) {
			arr[i] = defValue;
		}
		return arr;
		
	}
	
}

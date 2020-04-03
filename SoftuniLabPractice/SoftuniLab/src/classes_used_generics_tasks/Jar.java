package classes_used_generics_tasks;

public class Jar<E> {
	public static final int INITIAL_SIZE = 0;
	private static final int INITIAL_CAPACITY = 0;
	private int size = INITIAL_SIZE;
	private int capacity = INITIAL_CAPACITY;
  private E lastElementInJar;
  private Object[] elementsInJar;
  
  public Jar() {
	  setElementsInJar(new Object[getCapacity()]);
  }
  
  //work around with pre entered value(parameter) on add
  
  public E removeLastAdded() {
	  if(getSize()==0) {
		  return null;
	  }
	  Object[] temp = new Object[getCapacity()];
	  System.arraycopy(getElementsInJar(), 1, temp, 0, getSize()-1);
	  setElementsInJar(temp);
	  setSize(getSize()-1);
	  if(getSize()<=getCapacity()/4) {
		  setCapacity(getCapacity()/2);
	  }
	  return lastElementInJar;
	  
  }
  
  
  
  public void addElementInJar(E element) {
	  if(getSize()==getCapacity()) {
		  setCapacity(getCapacity()+4);
	  }
	  lastElementInJar = element; 
	  setSize(getSize()+1);
	  if(getSize()==0) {
		  getElementsInJar()[0] = element;
	  }else {
		  getElementsInJar()[getSize()]=getElementsInJar()[getSize()-1];
			getElementsInJar()[getSize()-1] = element;
		  
	  }
  }
  
  public void clearJar() {
	  setSize(INITIAL_SIZE);
	  setCapacity(INITIAL_CAPACITY);
	  this.elementsInJar = new Object[getCapacity()];
  }

public int getSize() {
	return size;
}

public void setSize(int size) {
	this.size = size;
}

public int getCapacity() {
	return capacity;
}

public void setCapacity(int capacity) {
	this.capacity = capacity;
}

public E getLastElementInJar() {
	return lastElementInJar;
}

public void setLastElementInJar(E elementInJar) {
	this.lastElementInJar = elementInJar;
}

public Object[] getElementsInJar() {
	return elementsInJar;
}

public void setElementsInJar(Object[] elementsInJar) {
	this.elementsInJar = elementsInJar;
}

}

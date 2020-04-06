package advanced_Softuni_Classes_Iterables_Comparables;
import java.util.Iterator;


public class Lake implements Iterable<Integer> {
private int[] numbers;


public Lake(int...numbers) {
	this.numbers = new int[numbers.length];
	this.numbers = numbers;
}

public void addNumber(int number) {
	int[]temp = new int[this.numbers.length+1];
	temp[temp.length-1]=number;
	this.numbers=temp;
}





@Override
public Iterator<Integer> iterator() {
	 
	Frog frog = new Frog();
	return frog;
}

private class Frog implements Iterator<Integer>{

	private int index = 0;
	
	@Override
	public boolean hasNext() {
		if(index<numbers.length) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Integer next() {
		return numbers[index++];
	}
	
}


}

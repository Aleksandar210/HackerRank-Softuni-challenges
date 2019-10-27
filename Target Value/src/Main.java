import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static Scanner scan =  new Scanner(System.in);
	
public static void main(String args[]) {
	ArrayList<Integer> initialInput = enterInitialInput();
	int size = initialInput.get(0);
	int targetValue = initialInput.get(1);
	ArrayList<Integer> elements = enterSecondaryInput(size);
	
	
	
	
	int indexChecked =0;
	int pairs =0;
	while(indexChecked<size) {
	for(int i =1;i<elements.size()-1;i++) {
		
		if(elements.get(i)-elements.get(indexChecked)==targetValue) {
			pairs++;
			
		}
	}
		indexChecked++;
	}
	
	System.out.println(pairs);

}




static ArrayList<Integer> enterInitialInput() {		//enter size and target value
	System.out.print("Enter size and target Value: ");
	int size = Integer.parseInt(scan.nextLine());
	int targetValue = Integer.parseInt(scan.nextLine());
	
	ArrayList<Integer> input = new ArrayList<Integer>();		//put them in a ArrayList
	input.add(size); 
	input.add(targetValue);
	
	return input;
}



static ArrayList<Integer> enterSecondaryInput(int size) {
	ArrayList<Integer> elements = new ArrayList<Integer>();		//List for the elements
	
	for(int i = 0; i < size; i++) {								
		elements.add(Integer.parseInt(scan.nextLine()));
	}
	
	return elements;
}





}

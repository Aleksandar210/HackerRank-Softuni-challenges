
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Experiment {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
	list.parallelStream().filter(a -> a>1);
	
	for(int num:list) {
		System.out.println(num);
	}
	
	
	}
}

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
			
		ArrayDeque<Integer> stat = new ArrayDeque<Integer>();
		String temp = "{(())))";
		System.out.println(temp.length());
 }
	
	static void reorderQueue(int from,ArrayDeque<Integer> que) {
		for(int i =0;i<from;i++) {
		int removed=  que.remove();	
		que.addLast(removed);
		
		}
	}
	
	
	
}

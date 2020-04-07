package advanced_Softuni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdvancedExam {
	static Scanner scan = new Scanner(System.in);
public static void main(String[] args) {
	lootBoxes();
	
}

static void lootBoxes() {

	
	List<Integer> boxOne = new LinkedList<Integer>();
	boxOne = Arrays.stream(scan.nextLine().split("\\s+")).map(e -> Integer.parseInt(e))
			.collect(Collectors.toList());
	List<Integer> boxTwo = new LinkedList<Integer>();
	boxTwo=Arrays.stream(scan.nextLine().split("\\s+"))
			.map( e ->Integer.parseInt(e))
			.collect(Collectors.toList());
	List<Integer> claimedItems = new LinkedList<Integer>();
	
	while((!boxOne.isEmpty()) || !(boxTwo.isEmpty())) {
		int sum = boxOne.get(0)+boxTwo.get(boxTwo.size()-1);
		if(sum%2==0) {
			claimedItems.add(sum);
			
		}else {
			boxOne.add(boxTwo.remove(boxTwo.size()-1));
		}
		
	}
	
	
	if(boxOne.isEmpty()) {
		System.out.println("First lootbox is Empty");
	}else if (boxTwo.isEmpty()) {
		System.out.println("Second lootbox is empty");
	}else if(boxOne.isEmpty()&& boxTwo.isEmpty()) {
		System.out.println("Both secondloot are empty");
	}
	
	System.out.println("Your loot:");
	Optional<Integer> typeLoot = claimedItems.stream().reduce((a,b)->a+b);
	if(typeLoot.get()>100) {
		System.out.println(typeLoot.get()+" EPIC");
	}else {
		System.out.println(typeLoot.get()+" POOR");
	}
}
}



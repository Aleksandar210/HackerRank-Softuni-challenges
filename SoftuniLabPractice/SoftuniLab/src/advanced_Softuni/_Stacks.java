package advanced_Softuni;


import java.awt.List;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

import softuni_objectsandclasses_folder.Plant;
import softuni_objectsandclasses_folder.Station;

public class _Stacks {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//stackCommandsTask();
		//reverseStack();
		//stackOperations();
		//queueOperations();
		//queueSequence();
		//truckTour(); //?
		//balancedParan();
		//recursiveFibonachi();
		//stackFibonachi(); //?
		//basicTextEditor();
		//poisonousPlants();
	}
	
	
	//poisonousPlants
	static void poisonousPlants() {
		ArrayDeque<Plant> plants  = new ArrayDeque<Plant>();
		String[] enterPlants =scan.nextLine().split("\\s");
		
		for(int i =0;i<enterPlants.length;i++) {
			Plant plant = new Plant(i,Integer.parseInt(enterPlants[i]));
			plants.add(plant);
		}
		
		Plant removedPlant;
		for(int i =0;i<enterPlants.length;i++) {
			removedPlant=plants.remove();
			if(plants.peek().getPesticide()>removedPlant.getPesticide()) {
				plants.remove();
				plants.push(removedPlant);
			}else {
				plants.addLast(removedPlant);
			}
		}
	}
	
	
	//---------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
//--------------------------------------------------------------------------------
	static void basicTextEditor() {
		ArrayDeque<Character> text = new ArrayDeque<Character>();
		ArrayDeque<Character> backUp = new ArrayDeque<Character>();
		int numberOperations = Integer.parseInt(scan.nextLine());
		while(numberOperations>0) {
			String enterCommand = scan.nextLine();
			String[] commands = enterCommand.split("\\s");
			switch(Integer.parseInt(commands[0])) {
			case 1:
				backUp=text;
				char[] c = commands[1].toCharArray();
				appendText(c,text);
				break;
				
				
			case 2:
				backUp=text;
				for(int i =0;i<Integer.parseInt(commands[1]);i++) {
					text.pop();
				}
				break;
				
				
			case 3:
				LinkedList<Character> list = new LinkedList<Character>(text);
				list.get(Integer.valueOf(Integer.parseInt(commands[1])));
				break;
				
				
			case 4:
				
			break;
			}
		}
	}
	
	static void appendText(char[] c, ArrayDeque<Character> text) {
		for(int i =0;i<c.length;i++) {
			text.push(c[i]);
		}
	}
	
//--------------------------------------------------------------------------------
	
	
	
	
	//stack Fibonachi
//--------------------------------------------------------------------------------
	static void stackFibonachi() {
	Stack<Integer> stack = new Stack<Integer>();
	int number = Integer.parseInt(scan.nextLine());
	
	
	for(int i =0;i<=number;i++) {
		if(i>0) {
		stack.push(stack.peek()+i);
		}
	}
	System.out.println(stack);
	}
	
	
//--------------------------------------------------------------------------------
	
	
	
	//recursiveFibonachi
//--------------------------------------------------------------------------------
	static void recursiveFibonachi() {
		Stack<Integer> stack = new Stack<Integer>();
		
		int n;
		do {
			n = Integer.parseInt(scan.nextLine());
		}while(n<1 || n>49);
		
		for(int i =n;i>=1;i--) {
			stack.push(getFibonachiResult(n));
		}
		
		System.out.println(stack.pop());
	}
	
	static int getFibonachiResult(int n) {
		return (n-1)+(n-2);
	}
	
//--------------------------------------------------------------------------------
	
	
	
	
	//balanced Paranthesis
//--------------------------------------------------------------------------------
	static void balancedParan() {
		ArrayDeque<String> paranth = new ArrayDeque<String>();
		String enterParan= scan.nextLine();
		for(int i =0;i<enterParan.length()-1;i++) {
			paranth.add(enterParan.substring(i,i+1));
		}
		
		boolean allGood = true;
		String first;
		String last;
		for(int i =0;i<paranth.size()/2;i++) {
			first = paranth.remove();
			last = paranth.removeLast();
			if(first.equalsIgnoreCase(last)) {
				allGood=false;
				break;
			}
		}
		
		
			System.out.println(allGood);
		
	}
	
//--------------------------------------------------------------------------------
	
	
	
	//truckTour task
//--------------------------------------------------------------------------------	
	static void truckTour() {
		int numberPumps = Integer.parseInt(scan.nextLine());
		ArrayDeque<Station> stations = new ArrayDeque<Station>(numberPumps);
		
		
		for(int i =0;i<numberPumps;i++) {
			String[] enterPumps = scan.nextLine().split("\\s");
			Station stat = new Station(Integer.parseInt(enterPumps[0]),Integer.parseInt(enterPumps[1]));
			stations.add(stat);
		}
		

		doTour(0,stations);
	}
	
	

	
	
	static void reorderQueue(ArrayDeque<Station> stations, int indexOfStart) {
		Station currentRemovedStation;
	
		for(int i =0;i<indexOfStart;i++) {
			currentRemovedStation = stations.remove();	
			stations.addLast(currentRemovedStation);
			
	      }
	}
	
	

	
	
	static void doTour(int indexOfStation,ArrayDeque<Station> stations) {
		Station stationStart=stations.peek();
		reorderQueue(stations,indexOfStation);
		int start = 0;
		int tank = stationStart.get_Gas();
		int currentPosition=0;
		while(start<=stations.size()) {
			
			if(currentPosition==stations.size()-1) {
				System.out.println(indexOfStation);
			}
			
			if(tank>=stations.peek().get_Distance()) {
				tank-=stations.peek().get_Distance();
				tank+=stations.peek().get_Gas();
				currentPosition++;
			}else {
				doTour(indexOfStation+1,stations);
			}
		}
		
	}
//--------------------------------------------------------------------------------	
	
	
	
	
	
	
	//Sequence
//--------------------------------------------------------------------------------
	static void quueSequence() {
		Queue<Integer> que =new ArrayDeque<Integer>();
		int N = Integer.parseInt(scan.nextLine());
		int sequenceTo3=1;
		for(int i =1;i<=50;i++) {
			switch(sequenceTo3) {
			case 1:
				que.add(N+1);
				sequenceTo3++;
				break;
			case 2:
				que.add(2*N+1);
				sequenceTo3++;
				break;
				
			case 3:
				que.add(N+2);
				sequenceTo3=1;
				N+=1;
				break;
			}
		}
		
		System.out.println(que);
	}
//--------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
//Queue operations	
//--------------------------------------------------------------------------------
	static void queueOperations() {
		String initialInput = scan.nextLine();
		String[] initInputCollect = initialInput.split(" ");
		String[] enterValues = scan.nextLine().split(" ");
		Integer[] intValues = new Integer[enterValues.length];
		putInArray(enterValues,intValues);
		
		Queue<Integer> stack = new LinkedList<Integer>();
		queueOperations(stack,initInputCollect,intValues);
		
		
	}
	
	static void queueOperations(Queue<Integer> que, String[] commands, Integer[] values) {
		int minElement = Integer.MAX_VALUE;
		//add n elements
		if(values.length<Integer.parseInt(commands[0])) {
			for(int i =0;i<values.length;i++) {
				que.add(values[i]);
				if(values[i]<minElement) {
					minElement = values[i];
				}
			}
		}else {
		for(int i =0;i<Integer.parseInt(commands[0]);i++) {
			que.add(values[i]);
			if(values[i]<minElement) {
				minElement = values[i];
			}
		}
		}
		//------------------------------------------------
		
		//removing n  elements from stack
		while(Integer.parseInt(commands[1])>0) {
			if(que.size()<=0) {
				break;
			}else {
				que.remove();
			}
		}
		//-----------------------------------------------
		
		//search for element if not there print min element in stack
		if(que.contains(Integer.parseInt(commands[2]))) {
			System.out.println("Value is in stack!");
		}else {
			System.out.println("Min Eelement: "+ minElement );
		}
	}
	
	
	
	
	
	
//--------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	//stack operations
//--------------------------------------------------------------------------------
		static void stackOperations() {
			String initialInput = scan.nextLine();
			String[] initInputCollect = initialInput.split(" ");
			String[] enterValues = scan.nextLine().split(" ");
			Integer[] intValues = new Integer[enterValues.length];
			putInArray(enterValues,intValues);
			
			Stack<Integer> stack = new Stack<Integer>();
			stackOperations(stack,initInputCollect,intValues);
			
			
		}
	
	
	static void stackOperations(Stack<Integer> stack, String[] commands, Integer[] values) {
		int minElement = Integer.MAX_VALUE;
		//add n elements
		if(values.length<Integer.parseInt(commands[0])) {
			for(int i =0;i<values.length;i++) {
				stack.push(values[i]);
				if(values[i]<minElement) {
					minElement = values[i];
				}
			}
		}else {
		for(int i =0;i<Integer.parseInt(commands[0]);i++) {
			stack.push(values[i]);
			if(values[i]<minElement) {
				minElement = values[i];
			}
		}
		}
		//------------------------------------------------
		
		//removing n  elements from stack
		while(Integer.parseInt(commands[1])>0) {
			if(stack.size()<=0) {
				break;
			}else {
				stack.pop();
			}
		}
		//-----------------------------------------------
		
		//search for element if not there print min element in stack
		if(stack.contains(Integer.parseInt(commands[2]))) {
			System.out.println("Value is in stack!");
		}else {
			System.out.println("Min Eelement: "+ minElement );
		}
	}
	
	
	
	
	
	
//--------------------------------------------------------------------------------
		
	
	
	
	
	
	
	
	
	//reverse
	//--------------------------------------------------------------------------------
	
	static void reverseStack() {
		String enterNumbers = scan.nextLine();
		Integer[] numbers = new Integer[enterNumbers.split(" ").length];
		putInArray(enterNumbers.split(" "),numbers);
		Stack<Integer> stack = new Stack<Integer>();
		stack.addAll(Arrays.asList(numbers));
		
		while(stack.size()>0) {
			System.out.print(stack.pop()+" ");
		}
		
	}
	
	
	static void putInArray(String[] arr1,Integer[] arr2) {
		for(int i =0;i<arr1.length;i++) {
			try {
				arr2[i]=Integer.parseInt(arr1[i]);	
			}catch(NumberFormatException exception){
				continue;
			}
			
		}
	}
	
	
	//--------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	//Stack task
	//--------------------------------------------------------------------------------------
	static void stackCommandsTask() {
		 Stack<Integer> stack = new Stack<Integer>();		//the stack we will be using
		 Stack<Integer> stackMaxValues = new Stack<Integer>();	//will store only above max
		int numberCommands = Integer.parseInt(scan.nextLine());
		String giveCommand;
		for(int i =0;i<numberCommands;i++) {
			giveCommand = scan.nextLine();
			executeCommand(giveCommand,stack,stackMaxValues);
		}
	}
	
	static void executeCommand(String command,Stack<Integer>stack,Stack<Integer>stackMax) {
			
		String[] commands = new String[2];
		commands = command.split(" ");
		int max=Integer.MIN_VALUE;
		switch(Integer.parseInt(commands[0])) {
		case 1:
			
			stack.push(Integer.parseInt(commands[1]));
			if(Integer.parseInt(commands[1])>max) {
				stackMax.push(Integer.parseInt(commands[1]));
			}
			break;
		case 2:
			int popped = stack.pop();
			if(stackMax.peek()==popped) {
				stackMax.pop();
			}
			break;
		case 3:
			Optional<Integer> opt = Optional.ofNullable(getMaxValueStack(stackMax));
			if(opt.isPresent()) {
				System.out.println(opt);
			}else {
				System.out.println("Stack Empty!");
			}
			break;
		}
	}
	
	static int getMaxValueStack(Stack<Integer>stack) {
		int max=Integer.MIN_VALUE;
		for(Integer stackValue:stack) {
			if(stackValue>max) {
				max=stackValue;
			}
		}
		
		return max;
	}
//--------------------------------------------------------------------------------------
	
	
	
	
	
	
}

package advanced_Softuni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;

public class _Stacks {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		//stackCommandsTask();
		//reverseStack();
	}
	
	
	//stack operations
//--------------------------------------------------------------------------------
		static void stackOperations() {
			String initialInput = scan.nextLine();
			String[] initInputCollect = initialInput.split(" ");
			String[] enterValues = scan.nextLine().split(" ");
			Integer[] intValues = new Integer[enterValues.length];
			putInArray(enterValues,intValues);
			
			Stack<Integer> stack = new Stack<Integer>();
			
			
			
		}
	
	
	static void stackOperations(Stack<Integer> stack, String[] commands, Integer[] values) {
		
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

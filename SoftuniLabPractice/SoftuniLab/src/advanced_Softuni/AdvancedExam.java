package advanced_Softuni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import advanced_Softuni_Classes_Iterables_Comparables.Guild;

public class AdvancedExam {
	static Scanner scan = new Scanner(System.in);
	static int rowPosPlayer;		//used for matrixGame
	static int colPosPlayer;		//used  for matrixGame
	static int rowWormPos;
	static int colWormPos;
	
public static void main(String[] args) {
	//lootBoxes();
	//matrixGame();
	//guildTask();
	//datingApp();
	worm();
}

static void worm() {
	String initialString = scan.nextLine();
	StringBuilder sb = new StringBuilder();
	sb.append(initialString);
	int initLength =  sb.length();
	
	int number = Integer.parseInt(scan.nextLine());
	String[][] book = new String[number][number]; 
	int row =0;
	String enterRowData;
	while(number-- >0) {
		enterRowData = scan.nextLine();
		book[row] = enterRowData.split("");
		if(enterRowData.contains("P")) {
			rowWormPos = row;
			colWormPos = enterRowData.indexOf("P");
			book[row] = enterRowData.split("");
		}
		
	}
	
	String enterCommand;
	int numberCommand =0;
	do {
		enterCommand = scan.nextLine();
		if("end".equalsIgnoreCase(enterCommand)) {
			break;
		}else {
			executeCommandWorm(enterCommand,book,sb,numberCommand,initLength);
			numberCommand++;
		}
	}while(!"end".equalsIgnoreCase(enterCommand));
	
	
	
	
}
static void executeCommandWorm(String command, String[][]book,StringBuilder sb, int numberCommand,int initLength) {
	String lastWord;
	if(numberCommand==0) {
		lastWord = sb.toString();
	}

	switch(command.toLowerCase()) {
	
	case "up":
		if(rowWormPos-1<0) {
			if(sb.length()>0 && numberCommand==0) {
				sb.delete(0,sb.length());
				lastWord="";
				
			}else if(sb.length()>0 && sb.length()!=initLength) {
				sb.deleteCharAt(sb.length()-1);
			}
		}else {
			book[rowWormPos][colWormPos] ="-";
			rowWormPos-=1;
			colWormPos-=1;
			if(book[rowWormPos][colWormPos].equals("-")) {
				
			}else {
				sb.append(book[rowWormPos][colWormPos]);
				
			}
			book[rowWormPos][colWormPos] ="P";
		}
	break;
	
	case"down":
		if(rowWormPos+1>book.length-1) {
			if(sb.length()>0 && numberCommand==0) {
				sb.delete(0,sb.length());
				lastWord="";
				
			}else if(sb.length()>0 && sb.length()!=initLength) {
				sb.deleteCharAt(sb.length()-1);
			}
		}else {
			book[rowWormPos][colWormPos] ="-";
			rowWormPos+=1;
			colWormPos+=1;
			if(book[rowWormPos][colWormPos].equals("-")) {
				
			}else {
				sb.append(book[rowWormPos][colWormPos]);
				
			}
			book[rowWormPos][colWormPos] ="P";
		}
		
		break;
		
	case "left":
		
		if(colWormPos-1<0) {
			if(sb.length()>0 && numberCommand==0) {
				sb.delete(0,sb.length());
				lastWord="";
				
			}else if(sb.length()>0 && sb.length()!=initLength) {
				sb.deleteCharAt(sb.length()-1);
			}
		}else {
			book[rowWormPos][colWormPos] ="-";
			
			colWormPos-=1;
			if(book[rowWormPos][colWormPos].equals("-")) {
				
			}else {
				sb.append(book[rowWormPos][colWormPos]);
				
			}
			book[rowWormPos][colWormPos] ="P";
		}
		
		
		break;
		
	case"right":
		
		if(colWormPos+1>book[rowWormPos].length-1) {
			if(sb.length()>0 && numberCommand==0) {
				sb.delete(0,sb.length());
				lastWord="";
				
			}else if(sb.length()>0 && sb.length()!=initLength) {
				sb.deleteCharAt(sb.length()-1);
			}
		}else {
			book[rowWormPos][colWormPos] ="-";
			
			colWormPos+=1;
			if(book[rowWormPos][colWormPos].equals("-")) {
				
			}else {
				sb.append(book[rowWormPos][colWormPos]);
				
			}
			book[rowWormPos][colWormPos] ="P";
		}
		
		break;
	}
}


static void datingApp() {
	List<Integer> males = Arrays.stream(scan.nextLine().split("\\s+"))
	.map(e ->Integer.parseInt(e))
	.collect(Collectors.toList());
	List<Integer> females = Arrays.stream(scan.nextLine().split("\\s+"))
			.map(e ->Integer.parseInt(e))
			.collect(Collectors.toList());
	int matches =0;
	while(males.size()>0 || females.size()>0) {
		if(25%males.get(0)==0) {
			males.remove(0);
			males.remove(0);
			if(25%females.get(females.size()-1)==0) {
				females.remove(females.size()-1);
				females.remove(females.size()-1);
			}
		}
		
		if(males.get(0)==females.get(females.size()-1)) {
			males.remove(0);
			females.remove(females.size()-1);
			matches++;
		}else {
			if(males.get(0)-2<0) {
				males.remove(0);
			}
			females.remove(females.size()-1);
		}
	}
	
	System.out.println("Matches: "+  matches);
	if(males.size()>0) {
	System.out.print("Males left: ");
	males.forEach(e ->System.out.print(e+" "));
	}else {
		System.out.println("Males: none");
	}
	
	if(females.size()>0) {
		System.out.print("Females left: ");
		females.forEach(e ->System.out.println(e+ " "));
	}else {
		System.out.println("Females: none");
	}
}


static void guildTask() {
	Guild win = new Guild("WIN",5);
	//win.addPlayer(currentPlayer);
	//win.removePlayer(name);
	//win.promotePlayer(playerName);
	//win.demotePlayer(playerName);
	//win.kickPlayerByClass(clazz);
	
}


static void matrixGame() {
	boolean hasWon = false;
	 
int size = Integer.parseInt(scan.nextLine());
int commandsCount = Integer.parseInt(scan.nextLine());
String[][] field = new String[size][size];
String enterRow;
int count = 0;
do {
	enterRow = scan.nextLine();
	if(enterRow.contains("f")) {
		colPosPlayer = enterRow.indexOf("f");
		rowPosPlayer = count;
		
	}
	field[count] = enterRow.split("");
	count++;
	size--;
	
}while(size>0);



while(commandsCount-- >0) {
	String enterCommand = scan.nextLine();
	hasWon=executeCommand(enterCommand,field);
}
if(hasWon) {
	System.out.println("Player Won!");
}else{
	System.out.println("Player has Lost!");
}
for(int i =0;i<field.length;i++) {
	for(int j =0;j<field[i].length;i++) {
		System.out.print(field[i][j]+" ");
	}
	System.out.println();
}

	
}

static boolean executeCommand(String command, String[][] field) {
	switch(command.toLowerCase()) {
	case "up":
		field[rowPosPlayer][colPosPlayer]="-";
		rowPosPlayer-=1;
		if(rowPosPlayer<0) {
			rowPosPlayer = field.length-1;
		}
		if(field[rowPosPlayer][colPosPlayer].equals("B")) {
			executeCommand(command,field);
		}else if(field[rowPosPlayer][colPosPlayer].equals("T")) {
			rowPosPlayer+=1;
		}else if(field[rowPosPlayer][colPosPlayer].equals("F")) {
			return true;
		}
		
		field[rowPosPlayer][colPosPlayer]="f";
		
		break;
		
	case "down":
		
		field[rowPosPlayer][colPosPlayer]="-";
		rowPosPlayer+=1;
		if(rowPosPlayer>field.length-1) {
			rowPosPlayer = 0;
		}
		if(field[rowPosPlayer][colPosPlayer].equals("B")) {
			executeCommand(command,field);
		}else if(field[rowPosPlayer][colPosPlayer].equals("T")) {
			rowPosPlayer-=1;
		}else if(field[rowPosPlayer][colPosPlayer].equals("F")) {
			return true;
		}
		
		field[rowPosPlayer][colPosPlayer]="f";
		
		
		break;
		
	case "left":
		field[rowPosPlayer][colPosPlayer] = "-";
		colPosPlayer-=1;
		if(colPosPlayer<0) {
			colPosPlayer = field[rowPosPlayer].length-1;
		}
		
		if(field[rowPosPlayer][colPosPlayer].equals("B")) {
			executeCommand(command,field);
		}else if(field[rowPosPlayer][colPosPlayer].equals("T")) {
			colPosPlayer+=1;
		}else if(field[rowPosPlayer][colPosPlayer].equals("F")) {
			return true;
		}
		
		field[rowPosPlayer][colPosPlayer]="f";
		break;
		
		
	case "right":
		field[rowPosPlayer][colPosPlayer] = "-";
		colPosPlayer=+1;
		if(colPosPlayer>field[rowPosPlayer].length-1) {
			colPosPlayer = field[rowPosPlayer].length-1;
		}
		
		if(field[rowPosPlayer][colPosPlayer].equals("B")) {
			executeCommand(command,field);
		}else if(field[rowPosPlayer][colPosPlayer].equals("T")) {
			colPosPlayer-=1;
		}else if(field[rowPosPlayer][colPosPlayer].equals("F")) {
			return true;
		}
		
		field[rowPosPlayer][colPosPlayer]="f";
		break;
	}
	
	return false;
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



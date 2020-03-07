package softuni_objectsandclasses_folder;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessing {
	static Scanner scan =new Scanner(System.in);
public static void main(String[] args) {
	//repeatLengthTimes();
	//getFileExtention();
	//searchByInString();
	//removeOccurenceOfSearch();
	//censorWords();
	//getCategoryChars();
	//reverseString();
	//validNames();
	//sumCharacterCodes();
	//extractFile();
	//lettersAndNumbers();
	//winnignTicket()
}

static void morseCode() {
	String enter = scan.nextLine();
	enter = enter.replace("|", " ");
	String[] words = enter.split(" ");
	StringBuilder sb = new StringBuilder(words.length);
	
	for(String code : words) {
		switch(code) {
		case ".-":
			sb.append("a");
		break;
		case "-...":
			sb.append("b");
			break;
		}
	}
	//and so one adn then to string and print
	
}

static void winningTicket() {
 String enter = scan.nextLine();
 String[] tickets = enter.split(",");
 StringBuilder sb = getWinningTicketsOnly(tickets);
 System.out.println(sb.toString());
 
}

static StringBuilder getWinningTicketsOnly(String[] tickets) {
	StringBuilder sb = new StringBuilder(tickets.length);
	
	String s;
	String p;
	int countRight;
	int countLeft;
	
	for(int i =0;i<tickets.length;i++) {
		
		if(tickets[i].length()==20) {
			s = tickets[i].substring(0,10);
			p = tickets[i].substring(10,20);
			switch(checkCurrentChar(tickets[i])) {
			case '$':
				countRight =  s.length() -s.replaceAll("$","").length();
				countLeft =  s.length() -s.replaceAll("$","").length();
				if(checkTicket(countRight,countLeft)==true) {
					sb.append(tickets[i]);
				}
				
				break;
			case '^':
				countRight =  s.length() -s.replaceAll("^","").length();
				countLeft =  s.length() -s.replaceAll("$","").length();
				if(checkTicket(countRight,countLeft)==true) {
					sb.append(tickets[i]);
				}
				break;
			case '@':
				countRight =  s.length() -s.replaceAll("@","").length();
				countLeft =  s.length() -s.replaceAll("@","").length();
				if(checkTicket(countRight,countLeft)==true) {
					sb.append(tickets[i]);
				}
				break;
			case '#':
				countRight =  s.length() -s.replaceAll("#","").length();
				countLeft =  s.length() -s.replaceAll("#","").length();
				if(checkTicket(countRight,countLeft)==true) {
					sb.append(tickets[i]);
				}
				break;
				default:
					System.out.println("No match");
					break;
						
			}
		}
	}
	return sb;
}

static char checkCurrentChar(String ticket) {
	ticket = ticket.replaceAll("\\d","");
	ticket= ticket.replaceAll("[0-9]","");
	char c = ticket.charAt(0);
	return c;
}

static boolean checkTicket(int a, int b) {
	boolean win = false;
	if(a==b && a==6) {
		win = true;
	}else if(a==b && a==10) {
		win =true;
	}
	return win;
}

static void productOfStrings() {
	String first = scan.nextLine();
	String second = scan.nextLine();
	
}

static void stringExplosion() {
	String enter  = scan.nextLine();
	
}

static void lettersAndNumbers() {
	String etner = scan.nextLine();
	String[] lettersAndNumbers = etner.split(" ");
	char c;
	int totallSum=0;
	for(String letter :lettersAndNumbers) {
		totallSum+=lettersAndNumbersCalcs(letter);
	}
	
	System.out.println(totallSum);
}

static int lettersAndNumbersCalcs(String word) {
	int totallSum =0;
	int currentDigit = 0;
	
	if(Character.isUpperCase(word.charAt(0))) {
		currentDigit = word.charAt(1);
		totallSum+=currentDigit/alphabetPositions(word.charAt(0));
	}else {
		currentDigit = word.charAt(1);
		totallSum+=currentDigit*alphabetPositions(word.charAt(0));
	}
	
	
	if(Character.isUpperCase(word.charAt(word.length()-1))) {
		currentDigit = word.charAt(1);
		totallSum+=currentDigit-alphabetPositions(word.charAt(0));
	}else {
		currentDigit = word.charAt(1);
		totallSum+=currentDigit+alphabetPositions(word.charAt(0));
	}
	
	return totallSum;
	
}

static int alphabetPositions(char c) {
	String letters = "ABCDEFGHIKLMNOPQRSTVXYZ".toLowerCase();
	int pos=0;
	if(letters.contains(String.valueOf(c))) {
		pos = letters.indexOf(String.valueOf(c))+1;
	}
	
	return pos;
	
}

static void extractFile() {
	String enterFilePath = scan.nextLine();
	String[] temp = enterFilePath.split("\\");
	String[] fileNameAndPath = temp[temp.length-1].split(".");
	System.out.println(fileNameAndPath[0]+"\n"+fileNameAndPath[1]);
	
 
	
}

static void sumCharacterCodes() {
	String enter = scan.nextLine();
	String[] words = enter.split(" ");
	
	int totalSum = 0;
	if(words[0].length()>words[1].length()) {
		System.out.println(sumWordsCodes(words,1));
	}else if(words[0].length()<words[1].length()) {
		System.out.println(sumWordsCodes(words,2));
	}else {
		System.out.println(sumWordsCodes(words,3));
	}
}

static int sumWordsCodes(String[] words, int type) {
	int total=0;
	char c;
	int codeOfWordOne;
	int codeOfWordTwo; 
	switch(type) {
	case 1:
	for(int i=0;i<words[1].length();i++) {
		c =  words[1].charAt(i);
		codeOfWordOne = c;
		c = words[0].charAt(i);
		codeOfWordTwo = c;
		total+=codeOfWordOne*codeOfWordTwo;
	}
	
	for(int i =words[1].length()-1;i<words[0].length();i++) {
		c = words[0].charAt(i);
		codeOfWordOne = c; 
		total+=codeOfWordOne;
	}
	break;
	case 2:
		for(int i=0;i<words[0].length();i++) {
			c =  words[1].charAt(i);
			codeOfWordOne = c;
			c = words[0].charAt(i);
			codeOfWordTwo = c;
			total+=codeOfWordOne*codeOfWordTwo;
		}
		
		for(int i =words[0].length()-1;i<words[1].length();i++) {
			c = words[1].charAt(i);
			codeOfWordOne = c; 
			total+=codeOfWordOne;
		}
		break;
		default:
			for(int i =0;i<words[0].length();i++) {
				codeOfWordOne = words[0].charAt(i);
				codeOfWordTwo = words[1].charAt(i);
				total+=codeOfWordOne*codeOfWordTwo;
			}
			break;
			
	}
	
	return total;
	
}



static void reverseString() {
	String enter = scan.nextLine();
	StringBuilder builder = new StringBuilder(enter);
	
	System.out.println(enter+" "+builder.reverse().toString());
	
}


static void validUsername() {
	String enter = scan.nextLine();
	StringBuilder sb = new StringBuilder(extractOnlyValidUsernames(enter));
	String validNames = sb.toString();
	String[] displayValidNames = validNames.split(" ");
	for(String name: displayValidNames) {
		System.out.println(name);
	}
	
	
}

static StringBuilder extractOnlyValidUsernames(String temp) {
	StringBuilder sb =new StringBuilder(temp);
	String[] usernames = temp.split(", ");
	for(String word : usernames) {
		if(word.length()>3 && word.length()<16) {
			Pattern special = Pattern.compile ("[!@#$%&*()+=|<>?{}\\[\\]~]");
			  Matcher hasSpecial = special.matcher(word);
			  if(hasSpecial.find()) {
				  
			  }else {
				  sb.append(word);
			  }
		}
	}
	
		return sb;
	
}

static void repeatLengthTimes() {
	String enter = scan.nextLine();
	String[] extractedData = enter.split(" ");
	ArrayList<String> words = new ArrayList<String>(extractedData.length);
	for(int i =0;i<extractedData.length;i++) {
		addWordsLengthTimes(extractedData[i],words);
	}
	String allWordsCombined = String.join("", words);
	System.out.println(allWordsCombined);
}
static void addWordsLengthTimes(String word,ArrayList<String> list) {
	for(int i =0;i<word.length();i++) {
		list.add(word);
	}
}




static void getFileExtention() {
	String enterFileName = scan.nextLine();
	int getDotIndex = enterFileName.indexOf(".");
	String getExtention = enterFileName.substring(getDotIndex+1,enterFileName.length());
	System.out.println(getExtention);
}





static void searchByInString() {
	String enter = scan.nextLine();
	String search = scan.nextLine();
	
	int from = enter.indexOf(search,0);
	while(from!=-1) {
		System.out.println(from);
		from  = enter.indexOf(search,from+1);
	}
}


static void removeOccurenceOfSearch() {
	String enterWordToRemove = scan.nextLine();
	String word = scan.nextLine();
	
	word = word.replaceAll(enterWordToRemove,"");
	System.out.println(word);
}




static void censorWords() {
	String enterSentance  = scan.nextLine();
	
	enterSentance = enterSentance.replace("Linux", repeatString("*","Linux".length()));
	enterSentance = enterSentance.replace("Windows", repeatString("*","Windows".length()));
	System.out.println(enterSentance);
}

static String repeatString(String word, int times) {
	
	String[] repeatedWord = new String[times];
	for(int i =0;i<repeatedWord.length;i++) {
		repeatedWord[i]=word;
	}
	
	return String.join("", repeatedWord);
}


static void getCategoryChars() {
	String enter = scan.nextLine();
	StringBuilder characters = new StringBuilder();
	StringBuilder digits = new StringBuilder();
	StringBuilder symbols = new StringBuilder();
	
	for(int i =0;i<enter.length();i++) {
		char c = enter.charAt(i);
		if(Character.isAlphabetic(c)) {
			characters.append(c);
		}else if(Character.isDigit(c)) {
			digits.append(c);
		}else {
			symbols.append(c);
		}
	}
	
	System.out.printf("Characters -  %s%nDigits - %s%nSymbols - %s",characters.toString(),digits.toString(),symbols.toString());
	
}

}

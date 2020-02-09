import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class SoftuniMethods {
	static Scanner scan  = new Scanner(System.in);
	public static void main(String[] args) {
		//printSign();
		//displayGrades();
		//printTriangle();
		
		//int[] numbersToCalculate = new int[2];
		//calculations(numbersToCalculate);
		//orederCalculator
		//System.out.println(rectangleAreCalculate());
		
		//int number = Integer.parseInt(scan.nextLine());
		//String word = scan.nextLine();
		//System.out.println(repeatString(number,word));
		
		
		//int number = Integer.parseInt(scan.nextLine());
		//int power = Integer.parseInt(scan.nextLine());
		//raisePower(number,power);
		
		//Numbers
		//int number = Integer.parseInt(scan.nextLine());
		//int number1= integer.parseInt(scan.nextLine());
		//int result = displayBiggestNumber( number, number1);
		//System.out.println(result);
		
		//Chars
		//char letter1 = scan.next().charAt(0);
		//char letter2 = scan.next().charAt(0);
		//displayBiggestNumber(letter1, letter2);
		
		
	
	}
	
	static void printSign() {
		System.out.print("Enter number: ");
		int number = Integer.parseInt(scan.nextLine());
		
		if(number<0) {
			System.out.println("negative");
		}else if(number>0) {
			System.out.println("Positive");
		}else {
			System.out.println("zero");
		}
		
	}
	static void displayGrades() {
		
		double grade;
		
		do {
			System.out.print("Enter grade in numbers: ");
			grade = Double.parseDouble(scan.nextLine());
			
			if(grade<2 || grade>6) {
				System.out.println("invalid, try agian.");
			}
			
		}while(grade<2 || grade>6);
		
		if(grade>2.99) {
			System.out.println("poor");
		}else if(grade>3.49) {
			System.out.println("Good");
		}else if(grade>4.49) {
			System.out.println("Very Good");
		}else if(grade>5.49) {
			System.out.println("Excelent");
		}else {
			System.out.println("Fail");
		}
		
	}
	
	static void printTriangle() {
		System.out.print("enter number:");
		int number = Integer.parseInt(scan.nextLine());
		printSidesOfTriangle(number);
		printCenterOfTriangle(number);
		printSidesOfTriangle(number);
		
		
	}
	static void printSidesOfTriangle(int number) {
		for(int i=number;i>0;i--) {
			printNumbersOfSides(i);
		}
	}
	
	static void printCenterOfTriangle(int number) {
		for(int i =1;i<=number;i++) {
			System.out.print(i);
			
		}
	}
	static void printNumbersOfSides(int n) {
		for(int i =1;i<n;i++) {
			System.out.print(i);
		}
	}
	
	static void calculateNumbers(int[] numbers) {
		System.out.println("enter numbers.");
		System.out.print("enter number: ");
		numbers[0] = Integer.parseInt(scan.nextLine());
		System.out.print("enter number: ");
		numbers[1] = Integer.parseInt(scan.nextLine());
		
		String command;
		do {
		System.out.print("add command: ");
		command =scan.nextLine();
		if(verifyCommand(command)==false) {
			System.out.println("Invalid command.");
		}
		}while(verifyCommand(command)==false);
		doCalculations(command, numbers);
		
	}
	static boolean verifyCommand(String command) {
		boolean correctCommand = false;
		String[] commandsAvailable = new String[] {"substract","divide", "add","multiply"};
		
		for(int i =0;i<commandsAvailable.length;i++) {
			if(command.toLowerCase().equals(commandsAvailable[i])) {
				correctCommand = true;
			}
		}
		
		return correctCommand;
	}
	static void doCalculations(String command, int[] numbers) {
		switch(command.toLowerCase()) {
		case "divide": System.out.println(numbers[0]/numbers[1]);
		break;
		case "add": System.out.println(numbers[0]+numbers[1]);
		break;
		case "multiply":System.out.println(numbers[0]* numbers[1]);
		break;
		case "substract": System.out.println(numbers[0]-numbers[1]);
		break;
		
		}
	}
	
	static void orderCalculator() {
		String[] products = new String[] {"coffee","water","coke","snacks"};
		
		String enterProduct="";
		do {
			System.out.print("Enter product: ");
			enterProduct = scan.nextLine();
			if(validOrderProdut(enterProduct, products)==false) {
				System.out.println("Enter a valid produt!");
			}
			
		}while(validOrderProdut(enterProduct, products)==false);
		
		System.out.print("Enter quantity: ");
		int quantity = Integer.parseInt(scan.nextLine());
		if(quantity==0 || quantity<0) {
			System.out.println("0.00- Order canceled");
		}else {
			switch(enterProduct.toLowerCase()) {
			case "coffee": displayReceipt(quantity,1.50);
			break;
			case "water": displayReceipt(quantity, 1.00);
			break;
			case "coke":displayReceipt(quantity,1.40);
			break;
			case "snacks": displayReceipt(quantity,2.00);
			}
		}
		
		
	}
	static boolean validOrderProdut(String product, String[] products) {
		for(int i =0;i<products.length;i++) {
			if(product.toLowerCase().equals(products[i])) {
				return true;
			}
		}
		
		return false;
	}
	static void displayReceipt(int quantity, double price) {
		double receipt = 0;
		
		for(int i =0;i<quantity;i++) {
			receipt+=price;
		}
		
		System.out.println(receipt);
		
	}
	
	static double rectangleAreCalculate() {
		System.out.print("width: ");
		double width = Double.parseDouble(scan.nextLine());
		System.out.print("height: ");
		double height = Double.parseDouble(scan.nextLine());
		
		double result = width* height;
		return result;
		
	}
	static String repeatString(int number, String word) {
		String[] wordNumberTimes = new String[number];
		String repeatedWord="";
		for(int i =0;i<wordNumberTimes.length;i++) {
			wordNumberTimes[i] = word;
			
		}
		repeatedWord = String.join(repeatedWord, wordNumberTimes);
		
		return repeatedWord;
		
	}
	
	static void raisePower(int number, int power) {
		int numberResult = 1;
		for(int i =0;i<power;i++) {
			numberResult*=number;
		}
		
		System.out.println(numberResult);
	}

	static int displayBiggestNumber(int number1, int number2) {
		if(number1< number2) {
			return number2;
		}
		
		return number1;
	}
	static char displayBiggestNumber(char letter1, char letter2) {
		int numb1 = letter1;
		int numb2 = letter2;
		if(numb1>numb2) {
			return letter1;
		}
		
		return letter2;
	}
	static String displayBiggestNumber(String one, String two) {
		if(one.length()>two.length()) {
			return one;
		}else {
			return two;
		}
	}
	
	static void multiplyEvenOdds(int number) {
		String s = String.valueOf(number);
		int evens=0;
		int odds=0;
		for (int i = 0; i < s.length(); i++){
		    char c = s.charAt(i);        
		    int digit = c;
		    if(digit%2==0) {
		    	evens+=digit;
		    }else {
		    	odds+=digit;
		    }
		}
		
		System.out.println(evens*odds);
	}
	
	static int mathOperations(int[] numbers, String operator) {
		int result = 0;
		switch(operator) {
		case "+": result=numbers[0]+numbers[1];
		break;
		case"-": result = numbers[0]-numbers[1];
		break;
		case "*": result = numbers[0]*numbers[1];
		break;
		case "/" : result = numbers[0]/numbers[1];
		break;

			
		}
		
		return result;
	}
	
	static void getSmallestOfThree(int[] numbers) {
		int max = numbers[0];
		for(int i =1;i<=numbers.length;i++) {
			if(max<numbers[i]){
				max=numbers[i];
			}
		}
		System.out.println(max);
	}
	
	static void vowelCount(String word) {
		int vowelCount=0;
		for (int i = 0; i < word.length(); i++){
		    char c = word.charAt(i); 
		    if(checkVowel(c)==true) {
		    	vowelCount++;
		    }
		}   
		System.out.println(vowelCount);
	}
	
	static boolean checkVowel(char letter) {
		boolean correct =false;
		char[] vowels = new char[] {'A','E','L','O','U'};
		for(int i =0;i<vowels.length;i++) {
			if(Character.toLowerCase(letter) == Character.toLowerCase(vowels[i])) {
				correct = true;
			}
		}
		
		return correct;
	}
	static void charactersInRange(char start, char finish) {
		for(int i =start+1; i<=finish-1;i++) {
			char temp = (char)i;
			System.out.print(temp+" ");
		}
	}
	
	static void enterPasword() {
		String password;
		do {
			System.out.print("enter password: ");
			password = scan.nextLine();
		}while(passwordValidation(password)==false || (password.length()<6||password.length()>10)||countDigits(password)<2);
		
		System.out.println("Loged in.");
	}
	
	static boolean  passwordValidation(String password) {
		boolean valid = false;
		Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		Matcher hasSpecial = special.matcher(password);
		if(hasSpecial.matches()==true) {
			return valid;
		}else {
			valid = true;
			return valid;
		}
	}
	
	static  int countDigits(String s) {
		int count = 0;
		for (int i = 0, len = s.length(); i < len; i++) {
		    if (Character.isDigit(s.charAt(i))) {
		        count++;
		    }
		}
		return count;
	}
	
	static void datatypeCalculate(String type, String enteredValue) {
		switch(type.toLowerCase()) {
		case "int":
			int number = Integer.parseInt(enteredValue);
			number*=2;
		System.out.println(number);
		break;
		case "real": 
			double numberReal = Double.parseDouble(enteredValue);
		System.out.printf("%.2f",numberReal*1.5);
		break;
		case "stirng":
			System.out.println("$"+enteredValue+"$");
			break;
		
		}
	}
	
	static void findClosestToCenter(int[]coordinates) {
		int[]rightTop = new int[2];
		rightTop[0] = coordinates[2];
		rightTop[1] = coordinates[3];
		
		int[] rightBottom = new int[2];
		rightBottom[0] = coordinates[2];
		rightBottom[1] = coordinates[1];
		
		int[] leftTop = new int[2];
		leftTop[0] = coordinates[0];
		leftTop[1] = coordinates[3];
		
		int[] leftBottom = new int[2];
		leftTop[0] = coordinates[0];
		leftTop[1] = coordinates[1];
		
		double close =  displayLowestNumber(rightTop,rightBottom,leftTop,leftBottom);
		System.out.println(close);
		
	}
	
	static double displayLowestNumber(int[]rightTop, int[]rightBottom, int[]leftTop,int[]leftBottom) {
		double[] coordinatesInDistance = new double[4];
		coordinatesInDistance[0] = Math.pow(rightTop[0],2)+Math.pow(rightTop[1],2);
		coordinatesInDistance[0]= Math.sqrt(coordinatesInDistance[0]);
		
		coordinatesInDistance[1] = Math.pow(rightBottom[0],2)+Math.pow(rightBottom[1],2);
		coordinatesInDistance[1]= Math.sqrt(coordinatesInDistance[1]);
		
		coordinatesInDistance[2] = Math.pow(leftTop[0],2)+Math.pow(leftTop[1],2);
		coordinatesInDistance[2]= Math.sqrt(coordinatesInDistance[2]);
		
		coordinatesInDistance[3] = Math.pow(rightBottom[0],2)+Math.pow(leftBottom[1],2);
		coordinatesInDistance[3]= Math.sqrt(coordinatesInDistance[0]);
		
		
		double max = coordinatesInDistance[0];
		for(int i =1;i<=coordinatesInDistance.length;i++) {
			if(max>coordinatesInDistance[i]) {
				max = coordinatesInDistance[i];
			}
			
		}
		return max;
		
	}
	
	static void tribonachi() {
		int number = Integer.parseInt(scan.nextLine());
		
		for(int i=1;i<=number;i++) {
			System.out.print((i-(i-1))+" "+(i-(i-2))+" "+(i-(i-3))+" ");
			
		}
	}
	
	static void deideAndDisplayStatus(int count) {
		if(count==1 || count==3) {
			System.out.println("negative");
		}else {
			System.out.println("Positive");
		}
	}
	
	static int numberStatus(int[] numbers) {
		int countNegatives=0;
		for(int i =0;i<numbers.length;i++) {
			if(numbers[i]<0) {
				countNegatives++;
			}
		}
		return countNegatives;
	}
	
	static void calculationsWithThreeDigits(int[] numbers) {
		System.out.println(multiply(sum(numbers[0],numbers[1]),numbers[2]));
	}
	
	static int sum(int number1, int number2) {
		return number1+number2;
	}
	static int multiply(int numberResult, int thirdNumber) {
		return numberResult* thirdNumber;
	}
	
	static void matrixDisplay(int number) {
		int[][] matrix = new int[number][number];
		for(int i =0;i<number;i++) {
			for(int j=0;j<number;j++) {
				System.out.print(number+" ");
			}
			System.out.println();
		}
	}
	
	static void factoriel(int[] numbers) {
		numbers[0] = calcFactoriel(numbers[0]);
		numbers[1] = calcFactoriel(numbers[1]);
		
		System.out.printf("%.2f",numbers[0]/numbers[1]);
	}
	
	static int calcFactoriel(int number) {
		int result=1;
		for(int i =1;i<=number;i++) {
			result*=i;
		}
		return result;
	}
	static void palindrome(String[] numbers) {
		for(int i =0;i<numbers.length;i++) {
			if(isPalindrome(numbers[i])==true) {
			System.out.println(numbers[i]+" -  "+"true");
			}else {
				System.out.println(numbers[i]+" -  "+"false");
			}
		}
	}
	
	static boolean isPalindrome(String s) {
		boolean isPalindrome = false;
		String backwardNumber = "";
		for (int i = s.length()-1; i>=0; i++){
		    char c = s.charAt(i);        
		    backwardNumber+=String.valueOf(c);
		}
		
		if(backwardNumber.equals(s)) {
			return true;
		}else {
			return isPalindrome;
		}
	}
	
	
}

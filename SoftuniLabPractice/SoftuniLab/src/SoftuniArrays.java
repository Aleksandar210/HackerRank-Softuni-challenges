import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SoftuniArrays {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		 //reverseStrings();
		 //evenAndOddSubstraction()
		//identicalArrays();
		//train();
		//ommonElemetns();
		//zigZagZoe();
		//perfectNumberInArray();
		//
		
		
	}
static void reverseStrings() {
	String enter = scan.nextLine();
	String[] letters  = enter.split(" ");
	for(int i =0;i<letters.length/2;i++) {
		String left =letters[i];
		String right = letters[letters.length - i- 1];
		letters[i] = right;
		letters[letters.length/2-i-1] = left;
	}
	
	for(int i =0;i<letters.length;i++) {
		System.out.println(letters[i]);
	}
}

static void evenAndOddSubstraction() {
	

	String enterNumbers =scan.nextLine();
	String[] temp = enterNumbers.split(" ");
	int numbers[] = new int[temp.length];
	int oddSum=0;
	int evenSum =0;
	
	for(int i=0;i<numbers.length;i++) {
		numbers[i] = Integer.parseInt(temp[i]);
		if(numbers[i]%2==0) {
			evenSum+=numbers[i];
		}else {
			oddSum+=numbers[i];
		}
	}
	
	System.out.println((evenSum-oddSum));
}




static void identicalArrays() {
	int[] firstArray = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e ->Integer.parseInt(e))
			.toArray();
	int[] secondArray = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e ->Integer.parseInt(e))
			.toArray();
	
	String differenceAt = "";
	if(arraySum(0,firstArray, secondArray)==arraySum(1,firstArray,secondArray)) {
		
		System.out.println("Arrys are identical Sum: "+arraySum(0,firstArray,secondArray));
	}else {
		String printThis = findDifferentIndexes(firstArray,secondArray);
		System.out.println("difference and indexes: "+printThis);
	}
}
static int arraySum(int number, int[] array1, int[] array2) {
	int sum = 0;
	if(number==0) {
		for(int i =0;i<array1.length;i++) {
			sum+=array1[i];
		}
		
	  }else {
			for(int j=0;j<array2.length;j++) {
				sum+=array2[j];
			}
		}
	return sum;
	
}
static String findDifferentIndexes(int[] array1, int[] array2) {
	String returnThis="";
	if(array1.length==array2.length) {
	for(int i =0;i<array1.length;i++) {
		if(array1[i]!= array2[i]) {
			returnThis+=String.valueOf(array1[i]);
		}
	}
	}else {
		return returnThis = "Arrays are not the same length";
	}
	return returnThis;
	
}






static void condenceArray() {
	int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
	int resultValue = condenced(numbers,numbers.length);
	System.out.println(resultValue);
			
}
static int condenced(int[] array, int count){
	int[] condencedNewArray;
	String newValues = "";
	int lengthIndex = 0;
	for(int i =0;i<array.length-1;i++) {
		newValues = String.valueOf(array[i]+array[i+1]);
		newValues+=" ";
		lengthIndex++;
	}
	condencedNewArray = Arrays.stream(newValues.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
	
	int returnedValue = 0;
	int length= condencedNewArray.length;
	if(count>1) {
		condenced(condencedNewArray,length);
	}else {
		returnedValue=condencedNewArray[0];
	}
	return returnedValue;
}

static void train() {
	int numberWagons = Integer.parseInt(scan.nextLine());
	int[] numberPeople = new int[numberWagons];
	int sum=0;
	for(int i =0;i<numberPeople.length;i++) {
		numberPeople[i] = Integer.parseInt(scan.nextLine());
		sum = numberPeople[i];
	}
	
	System.out.println(sum);
	
}
static void commonElements() {
	String enterFirstArray = scan.nextLine();
	String[] first = enterFirstArray.split(" ");
	
	String enterSecondArray = scan.nextLine();
	String[] second = enterSecondArray.split(" ");
	
	String commonElements ="";
	
	for(int i =0;i<first.length;i++) {
		for(int j=0;j<second.length;j++) {
			if(first[i].equals(second[j])) {
				commonElements+=first[i];
				commonElements+=" ";
			}
		}
	}
	System.out.println(commonElements);
}

static void zigZagZoe(){
	int number = Integer.parseInt(scan.nextLine());
	
	int[] firstArray;
	int[] secondArray;
	if(number==1 ) {
		String enter = scan.nextLine();
		String[] numbers = enter.split(" ");
		firstArray = new int[1];
		firstArray[0] = Integer.parseInt(numbers[0]);
		
		secondArray = new int[1];
		secondArray[0] = Integer.parseInt(numbers[1]);
		
		
	}else {
		firstArray = new int[number];
		secondArray = new int[number];
		for(int i =1;i<=number;i++) {
			String enter = scan.nextLine();
			String[] temp = enter.split(" ");
			if(i%2==0) {
				secondArray[i-1] = Integer.parseInt(temp[1]);
			}else {
				firstArray[i-1] = Integer.parseInt(temp[0]);
			}
		}
	}
	
	for(int i =0;i<firstArray.length;i++) {
		System.out.print(firstArray[i]+" ");
		
	}
	System.out.println();
	for(int i =0;i<secondArray.length;i++) {
		System.out.print(secondArray[i]+" ");
	}
	
}

static void rotation() {
	int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
	int  numberRotation = Integer.parseInt(scan.nextLine());
	
	
	for(int i =0;i<numberRotation;i++) {
		
		for(int j = numbers[numbers.length-1];j>=0;j--) {
			numbers[i]= numbers[j];
			
		}
		
	}
	for(int i =0;i<numbers.length;i++) {
		System.out.print(numbers[i]+" ");
	}
}


static void topIntegers() {
	int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
	
	int current = 0;
	
	outter:
	for(int i =0;i<numbers.length-1;i++) {
		current = i;
		
		for(int j=current+1;j<=numbers.length;j++) {
			if(numbers[i]<numbers[j]) {
				 continue outter;
			}
		}
	}
	System.out.println(numbers[current]);
}

static void perfectNumerInArray() {
	int numbers[] =  Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
	
	int leftSum=0;
	int rightSum=0;
	int result=-1;
	for(int i =0;i<numbers.length;i++) {
		if(i-1==-1) {
			leftSum=0;
			for(int j=i+1;j<=numbers.length;j++) {
				rightSum+=numbers[j];
			}
			
			if(leftSum==rightSum) {
				result=numbers[i];
				break;
			}
		}else if( i+1 > numbers.length){
			rightSum=0;
			for(int h =0;h<=i;h++) {
				rightSum+=numbers[h];
			}
			if(leftSum==rightSum) {
				result = numbers[i];
				break;
			}
			
			}else {
				for(int z=0;z<i;z++) {
					leftSum=numbers[z];
				}
				
				for(int k=i+i;k<numbers.length;k++) {
					rightSum+=numbers[k];
			}
				if(leftSum==rightSum) {
					result=numbers[i];
				}
		}
		
			
	}
	
	if(result!=-1) {
		System.out.println(result);
	}else {
		System.out.println("no such number");
	}

}

static void sequence() {
	String enter = scan.nextLine();
	String[] enteredNumbers = enter.split(" ");
	
	
	
	String equalSequences ="";
	for(int i =0;i<enteredNumbers.length-1;i++) {
		if(enteredNumbers[i].equals(enteredNumbers[i+1])) {
			equalSequences+=enteredNumbers[i];
		}else {
			equalSequences+=" ";
		}
	}
	
	int[] sequences = Arrays.stream(equalSequences.split(" ")).mapToInt(e ->Integer.parseInt(e)).toArray();
	
	//finding the longest one
	int max = sequences[0];
	for(int i =0;i<sequences.length;i++) {
		if(sequences[i]>max) {
			max=sequences[i];
		}
	}
	
	System.out.println(max);
	
}

static void magicSum() {
	int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
	int targetValue = Integer.parseInt(scan.nextLine());
	
	for(int i =0;i<numbers.length-1;i++) {
		for(int j=i+1;j<numbers.length;j++) {
			if(numbers[i]+numbers[j]==targetValue) {
				System.out.println(numbers[i]+" "+numbers[j]);
			}
		}
	}
	
	
}


//----------------------------------------------------
static void kaminoFactory() {
	int length = Integer.parseInt(scan.nextLine());
	
	
	String enteredDna;
	String insertData ="";
	boolean stop = false;
	while(stop==false) {
		do {
			System.out.print("Enter DNA: ");
			enteredDna  = scan.nextLine();
			insertData+=enteredDna;
			insertData+=" ";
			if(countDigits(enteredDna)!=5) {
				System.out.println("Digits of DNA have to be 5 of length!");
			}
			
			if(enteredDna.equals("Clone them!")) {
				stop=true;
			}
		}while(countDigits(enteredDna)!=5);
	}
	
	
	
}

static int countDigits(String enteredDna) {
	
	int count = 0;
	for (int i = 0, len = enteredDna.length(); i < len; i++) {
	    if (Character.isDigit(enteredDna.charAt(i))) {
	        count++;
	    }
	}
	return count;
}

static int displayBestDnaSequence(String allEntered) {
	String[] getAllSequences = allEntered.split(" ");
	int[] dnaSequences = new int[getAllSequences.length];
	
	//for(int i =0;i< getAllSequences.length;i++) {
		//String temp = getAllSequences[i];
		//dnaSequenes[i] = Integer.parseInt(temp.split("!"));
	//}
	
	return 5;
	
}
//static int[] getUniqueDna(int[] dnaSequences) {
	//String indexesOfUniqueDna="";
	//int count;
	
	
//}

//----------------------------------------------

static void encryptWords() {
	int number = Integer.parseInt(scan.nextLine());
	
	int count=0;
	String enterName;
	String[] names = new String[number];
	do {
	enterName = scan.nextLine();
	names[count] = enterName;
	count++;
	}while(count<number);
	
	int[] sumsOfNames = new int[number];
	int currentCodeVowels=0;
	int currentCodeNotVowels=0;
	int currentCode;
	for (int i = 0; i < names.length; i++){
	    for(int j=0;j<names[i].length();j++) {
	    	char c = names[i].charAt(j);
	    	String currentCharacter = String.valueOf(c);
	    	switch(currentCharacter.toLowerCase()) {
	    	case "a": case "e": case "i": case "o": case "u":
	    	 currentCode = c;
	    		currentCode+=names.length;
	    		currentCodeVowels+=currentCode;
	    		break;
	    		default:
	    			currentCode=c;
	    			currentCode/=names.length;
	    			currentCodeNotVowels+=currentCode;
	    			break;
	    	}
	    	
	    }
	    sumsOfNames[i] = currentCodeVowels+currentCodeNotVowels;
	}
	
	for(int j =0;j<3;j++) {
	for(int i =0;i<sumsOfNames.length-1;i++) {
		int thirdSumVariable=0;
		if(sumsOfNames[i]>sumsOfNames[i+1]) {
			thirdSumVariable = sumsOfNames[i];
			sumsOfNames[i] = sumsOfNames[i+1];
			sumsOfNames[i+1] = thirdSumVariable;
		}
	}
	}
	
	
	for(int i =0;i<names.length;i++) {
		System.out.println(names[i]+"= "+sumsOfNames[i]);
	}
	
}


static void pascalTriangle() {
	int numberRows = Integer.parseInt(scan.nextLine());
	for(int i =0;i<numberRows;i++) {
		for(int j =0; j<i;j++) {
			System.out.println(binomialCoeff(i,j)+" ");
		}
	}
	
}


static int binomialCoeff(int n, int k) 
{ 
    int res = 1; 
      
    if (k > n - k) 
    k = n - k; 
          
    for (int i = 0; i < k; ++i) 
    { 
        res *= (n - i); 
        res /= (i + 1); 
    } 
    return res; 
} 


static void fibonachiN() {
	int numbers = Integer.parseInt(scan.nextLine());
	int[] fibonachiNumbers = new int[numbers];
	fibonachiNumbers[0] = 1;
	for(int i =0;i<numbers;i++) {
		fibonachiNumbers[i+1] = fibonachiNumbers[0]+(i+1);
	}
	
	System.out.println(fibonachiNumbers[fibonachiNumbers.length-1]);
}

static void subsequence() {
	int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(scan.nextLine())).toArray();
	
	int p =numbers.length-1;
	
	int[] subsequence = new int[p];
	int count=0;
	for(int i =0;i<numbers.length;i++) {
		if(numbers[i]<=p) {
			subsequence[count] = numbers[i];
			count++;
		}
	}
	
	for(int i =0;i<subsequence.length-1;i++) {
		int temp = 0;
		if(subsequence[i]>subsequence[i+1]) {
			temp = subsequence[i];
			subsequence[i] = subsequence[i+1];
			subsequence[i+1] = temp;
		}
	}
	
	for(int i =0;i<subsequence.length;i++) {
		System.out.print(subsequence[i]+" ");
	}
	
}

}

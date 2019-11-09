import  java.util.Scanner;

public class SherlockArray {
	static Scanner  scan = new Scanner(System.in);
	public static void main(String args[]) {
		System.out.print("how much elemetn in array: ");
		int numElem = Integer.parseInt(scan.nextLine());
		int elm = numElem;	//so that I dont have to enter twice
		
	}
	
	
	static int[] createArr(int numElem) {
		
		int[] Array =  new int[numElem];
		
		for(int i=0;i<numElem;i++) {
			Array[i] = Integer.parseInt(scan.nextLine());
		}
		
		return Array;	
	}
	
	
	//perfectElement is the element which left and right sum are equal
	static void perfectElement(int[] arr, int elm ) {
		String[] results = new String[elm];
		int rightSum = 0;
		int leftSum = 0;
		
		int indexCount =0;
		int indexCount1 = 0;
		
		int number = 0;
    	int numCount=0;	
    	
    	while(number<elm) {
    	if(number==0) {
			for(int i=1;i<arr.length;i++) {
    			rightSum+=arr[i];
    		}
			if(rightSum==0) {
				results[0] = "first Element is perfect";
			}else {
				results[0] = "first element is not perfect";
			}
    	
		
	}else if(number != 0) {
		
		for(int z = 0;z<arr.length;z++) {
    		indexCount++;
    		if(indexCount==number) {
    			numCount = indexCount;
    		}
    	}
    	
    	for(int i=0;i<=number;i++) {	//get full left with number
    		
    		indexCount1++;
    	}
    	
    	int rightPart = indexCount- indexCount1;
  
    	
    	for(int h=0;h<number;h++) {	//leftSum 
    		
    		leftSum+=arr[h];
    	}
    	
    	for(int l=0 , g =numCount+=1;l<rightPart;l++,g++) {	 // right sum
    		rightSum+=arr[g];
    		
    		
    	}
    	if(leftSum==rightSum) {
    		results[number] = "perfectNumber";
    	}else {
    		results[number] = "not a perfectNumber";
    	}
	}else if(number ==arr.length-1) {
		for(int i=0;i<number;i++) {
			leftSum+=arr[i];
		}
		if(leftSum==0) {
			results[arr.length-1] = "perfectNumber";
			}else {
				results[arr.length-1]="not a prfectNumber";
		}
		
	}
number++;
}
    	for(int show = 0;sho<results.length;show++) {
    		System.out.println( results[show]);
    	}
}
}

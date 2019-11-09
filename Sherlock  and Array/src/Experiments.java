import java.util.Scanner;
public class Experiments {

	
	


	
		static Scanner scan = new Scanner(System.in);
		
		public static void main(String args[]) {
				int indexCount =0;
				int indexCount1 = 0;
				
		    	int rightSum =0;
		    	int leftSum =0;
		    	int[] arr = {1,4,3,4,7,8};
		    	int number = 3;	//the number which we are iterating with
		    	int numCount=0;	// collect the number
		    	
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
		    	System.out.println(rightSum);		
		  
	 }
		    		
		    		
	}
		
		

		
		
		

		

		

	
	
	


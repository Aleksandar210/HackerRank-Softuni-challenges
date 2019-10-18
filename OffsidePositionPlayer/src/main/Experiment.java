package main;
import java.util.Scanner;
import java.util.Arrays;

public class Experiment {
	static Scanner scan = new Scanner(System.in);
	public static void main(String args[])
	{
	/*	int[] array1 = new int[5];
		System.out.println( getElement(arr(array1)));
		
		
	}
	
	
	static int[] arr(int[] arrk)
	{
		for(int i =0; i<arrk.length;i++)
		{
			arrk[i] = Integer.parseInt(scan.nextLine());
		}
		return arrk;
		
	}
	static int getElement(int[] array)
	{
		
		return array[2];
		
		
	}
	*/
		
		/* int[] arr1 =  {1,3,4,6,5};
		Arrays.sort(arr1);
		int[] without1 = new int[arr1.length-1];
		for(int i =0; i<arr1.length-1;i++)
		{
			without1[i] = arr1[i];
		}
		
		for(int j =0; j<without1.length;j++)
		{
			System.out.println(without1[j]);
		}
				
		*/
	
		int numb =0;
		boolean offside = false;
		int[] arr1Blue = {10,9,76,43};
		int furthestRed = 90;
		int[] arr2 = {11,33,46,55};
		
	while (offside ==false)
	{
		if(arr1Blue[numb]<furthestRed)
		{
			
		
		
		int firstInside = arr1Blue[numb];
		for(int i=0;i<arr2.length;i++)
		{
			if(arr2[i]<firstInside)
			{
				System.out.println("Offside player: "+ arr1Blue[numb] + " playerBehind him: "+arr2[i]);
				offside=true;
				break;
			}
		}
		
		numb++;
		}
		
	}
	System.out.println("it broke out");
	
	}
}


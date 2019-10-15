import java.util.Scanner;

public class Main {
	static Scanner scan= new Scanner(System.in);	/*creating an object Scanner outside the main method
											 in case I need to use it in other methods of this class */
	public static void  main(String args[])
	{
		System.out.print("product's purchase value: ");			//asking the user to enter the value!
		int purchaseValue = Integer.parseInt(scan.nextLine());	//entering value(product price)
		
		System.out.print("Type of discount card (bronze,silver,gold):  ");			//asking what cars is the user using
		String cardType = scan.nextLine();	                   //entering a string value for the card
		
		System.out.print("enter turn over: ");
		int turnOver = Integer.parseInt(scan.nextLine());
		
		
		PayDesk paymentDetails = new PayDesk();
		
 /*double rate =  paymentDetails.discountRate(purchaseValue, cardType, turnOver )
  * ;   //the discount rate 
  */
		
		 purchaseInfo(paymentDetails.discountRate(purchaseValue, cardType, turnOver ),purchaseValue);
		
		}
	static void purchaseInfo(double rate,int purchaseValue)
	{
		double purchaseVal =purchaseValue;
		double discount = purchaseValue*rate;
		double oldRate =rate*100;
		double total = purchaseVal - discount;
		System.out.printf("purchase value:$%.2f %n discount rate:%.2f %n discount:$%.2f %n",purchaseVal,oldRate,discount);
		System.out.printf("Total:$ %.2f", total);
	}
	
	

}

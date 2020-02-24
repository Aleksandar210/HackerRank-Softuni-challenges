import java.util.Scanner;

public class PayDesk {
	public static void main(String[] args) {
		Card card = enterDataForCard();
		displayTotal(card);
	}
	static Card enterDataForCard() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter purchase value: ");
		double purchaseValue = Double.parseDouble(scan.nextLine());
		System.out.print("Enter turn over");
		int turnover = Integer.parseInt(scan.nextLine());
		System.out.print("Card type: ");
		String type = scan.nextLine();
		Card card = new Card(type,purchaseValue,turnover);
		
		return card;
	}
	
	static void displayTotal(Card card) {
		System.out.printf("card type- %s, %n purcahse value - %.2f %n discount - %d, Total - %d",card.getType(),card.getPurchaseValue(),card.getDiscount(),card.getTotal());
		
	}

}

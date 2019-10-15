
public class PayDesk
{

public double discountRate(int purchaseValue, String cardType , int turnOver)
{
	double discountRate = 0;	     //this variable is to set the dicountRate according to the value of the product
	int discountRateGold = 0;	//this variable is to see how many times to ad 1%to discountRate (for each 100)
	
	
	if("bronze".equalsIgnoreCase(cardType))
	{
		if(turnOver<100)
		{
			discountRate = 0;
		}else if(turnOver>99 && turnOver<301)
		{
			discountRate = 0.01;
		}else if (turnOver>300)
		{
			discountRate = 0.025;
		}
		
	}else if("silver".equalsIgnoreCase(cardType))
	{
		discountRate = 0.02;
		
		if(turnOver>300)
		{
			discountRate = 0.035;
		}
	}else if("gold".equalsIgnoreCase(cardType))
	{
		discountRate = 0.02;
		
		discountRateGold = turnOver/100;
		if(discountRateGold >0)
		{
			discountRate+=discountRateGold;
		}
		
		
	}
	
	return discountRate;
	
	
	
	
}
		
}



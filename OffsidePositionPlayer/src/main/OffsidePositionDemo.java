package main;
import java.util.Random;

public class OffsidePositionDemo {
	public static Random generateCoordinates = new Random();
	
	
	// |The field|
	 
    /*  1234567891011121314..25 <--TOP
     *      goalkeeper{50}
     *                         50	
	                           49    SIDE
	                           48 
	   somePLayer              47
                               .	
	         somePlayer        .
	                           .
	                           1
	                         
	 */
	public static void main(String args[])
	{
		
		//NOTE: e assume that the goal keeper s position is 50.
		
		isPlayerOffside(redTeamDefender(),blueTeamPlayer());
		
		
	}
	
	
	
	public static void isPlayerOffside(int[] redPlayer,int[] bluePlayer)
	{
		
	
		for(int i=0;i<50;i++)
		{
			
			//BLUE PLAYER COORDINATES
			 int sidePositionBlue = generateCoordinates.nextInt(49);  //we assume that 50 is the goalkeeper position
			 int topPositionBlue  = generateCoordinates.nextInt(25);
			 
			 //RED PLAYER COORDINATES
			 int sidePositionRed = generateCoordinates.nextInt(49);  
			 int topPositionRed  = generateCoordinates.nextInt(25);
			 
			 
			 //adding coordinates to the defender
			 redPlayer[0]=sidePositionRed;
			 redPlayer[1]=topPositionRed;
			 
			 //adding coordinates to ballpLAYER(BLUE TEAM)
			 bluePlayer[0]=sidePositionBlue;
			 bluePlayer[1]= topPositionBlue;
			 if(bluePlayer[0]>redPlayer[0])
			 {
				 break;
			 }
			 
			 
		}
		System.out.println("Blue player is in OFFSIDE POSITION!");
		System.out.println();
		System.out.println("Blue player coordinates: "+ " SIDE: "+bluePlayer[0]+" TOP "+bluePlayer[1]);
		System.out.println("Red player coordinates: "+ " SIDE: "+redPlayer[0]+" TOP "+redPlayer[1]);
		   
	}
	
	
	
	
	
	

	
	
	
	//-------------------------------------------------------------------
	
	
	//function to generate the coordiinates of the player with the ball (blue team player)
	
	public static int[] blueTeamPlayer()
	{
		
		
		// the top side is half the length of the field from top to bottom!
		
		int bluePlayerSide = 0;
		int bluePlayerTop = 0;
		
		//storing both coordinates top and side
		int[] bothBlueCoordinates = {bluePlayerSide, bluePlayerTop};
		return bothBlueCoordinates;
	}
	
	//-------------------------------------------------
	
	public static int[] redTeamDefender()
	{
		int redPlayerSide = 0;
		int redPlayerTop = 0;
		
		//storing both coordinates top and side
		int[] bothRedCoordinates = {redPlayerSide , redPlayerTop};
		
		return bothRedCoordinates;
	}

}
 
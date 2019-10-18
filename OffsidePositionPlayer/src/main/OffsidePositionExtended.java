package main;

import java.util.Arrays;
import java.util.Scanner;


public class OffsidePositionExtended {
	static Scanner scan = new Scanner(System.in);
	
	static final int numberPlayers = 11;			//setting the max number of players in a team
	
	public static void main(String arg[])
	{	
		
		FieldAttributes playerCoordinates = new FieldAttributes();	//object for entering player Data
		FieldAttributes furthestPlayer = new FieldAttributes();		//object for furthest Players (2 pair)
		FieldAttributes insidePlayers = new FieldAttributes();		// get players in between(object)
		
		int blueTeamPlayers[] = new int[numberPlayers];		//array with blue team coordinates aside
		int redTeamPlayers[] = new int[numberPlayers];	    //array with red team coordinates aside
		
		
	playerCoordinates.enterPlayerCoordinatesRed(redTeamPlayers);	//return an array with coordinates
	playerCoordinates.enterPlayerCoordinatesBlue(blueTeamPlayers);	//return an array with coordinate
	furthestPlayer.playerFurthestRed(coordinates);				//returns int(biggest element in arr)
	furthestPlayer.playerFurthestBlue(coordinates);				//same as above
	insidePlayers.insidePlayersBlue(coordinates);				//get players in between from furthest
	insidePlayers.insidePlayersRed(coordinates);					//same as above
	
		}
	static void checkPositions
	(int blueFurthest, int redFurthest , int[] bluePlayersInside, int[] redPlayersInside)
	{
		// important part here!
		
		
		
	}
	
	
	
	

}

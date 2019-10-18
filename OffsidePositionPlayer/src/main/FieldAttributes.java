package main;
import java.util.Arrays;
import java.util.Scanner;


public class FieldAttributes
{
	
	
	static final int numberPlayers = 11;

	Scanner scan = new Scanner(System.in);

public int[] enterPlayerCoordinatesBlue(int[] blueTeamPlayers)
{
	
	for(int i = 0; i<blueTeamPlayers.length; i++)		//entering the blue team coordinates
	{

		blueTeamPlayers[i] = Integer.parseInt(scan.nextLine());
		
	}
		

	return  blueTeamPlayers;

	
}

public int[] enterPlayerCoordinatesRed(int[] redTeamPlayer)
{
	for(int j=0;j<redTeamPlayer.length;j++)			//entering red team coordinates
	{

		redTeamPlayer[j] =Integer.parseInt(scan.nextLine());
	}
	
	return redTeamPlayer;
	
	
}


public int playerFurthestRed( int[] redTeam)
{
	Arrays.sort(redTeam);
	
	int redPlayerFurthest  =  redTeam[numberPlayers-1]; 	//get the player with the largest coordinate value
	return redPlayerFurthest;
	
}

public int playerFurthestBlue(int[] blueTeam)
{
	Arrays.sort(blueTeam);
	int bluePlayerFurthest = blueTeam[numberPlayers-1];
	return bluePlayerFurthest;
}




public int[] insidePlayersBlue(int[] blueTeamPlayers)		//function to get the players without the furthest
{
	int[] insidePlayersBlue = new int[numberPlayers-1];
	Arrays.sort(blueTeamPlayers);
	for(int i=0;i<blueTeamPlayers.length-1;i++)
	{
		insidePlayersBlue[i] = blueTeamPlayers[i];
	}
	
	return insidePlayersBlue;
}

public int[] insidePlayersRed(int [] redTeamPlayers)		//same as above
{
	int[] insidePlayersRed = new int[numberPlayers-1];
	Arrays.sort(redTeamPlayers);
	for(int i =0; i<redTeamPlayers.length-1;i++)
	{
		insidePlayersRed[i] = redTeamPlayers[i];
		
	}
	return insidePlayersRed;
	
}



}

	







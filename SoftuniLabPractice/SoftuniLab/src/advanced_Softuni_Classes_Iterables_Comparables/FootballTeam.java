package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FootballTeam {
	private Map<String,FootballPlayer> players;
	private String name;
	private int teamRating;
	
	
	public FootballTeam(String name) {
		setName(name);
		this.players = new LinkedHashMap<>();
		
	}
	
	public void addPlayer(String[] addedCommand) {
		Scanner scan = new Scanner(System.in);
	FootballPlayer currentPlayer = null;
	try {
		currentPlayer = new FootballPlayer(addedCommand);
	}catch(IllegalArgumentException ex) {
		System.out.println(ex.getMessage());
		addPlayer(reEnterPlayer(scan,addedCommand));
	}
	
	scan.close();
	this.players.put(currentPlayer.getName(),currentPlayer);
	this.teamRating+=currentPlayer.getPlayerRating()/this.players.size();
	}
	
	private String[] reEnterPlayer(Scanner scan,String[] data) {
		StringBuilder sb = new StringBuilder(data.length);
		sb.append(data[0]+";").append(data[1]+";").append(data[2]+";");
		System.out.println("Enter stats only: ");
		String enter = scan.nextLine();
		Arrays.stream(enter.split(";")).map(e -> sb.append(e));
		
		return sb.toString().split(";");
		
	}
	
	public void removePlayer(String name) {
		if(players.containsKey(name)) {
			this.teamRating-=players.get(name).getPlayerRating();
			players.remove(name);
			this.teamRating/=players.size();
		}else {
			System.out.println("No Player found");
		}
	}
	
	public int getTeamRating() {
		return this.teamRating;
	}
	private void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	

}

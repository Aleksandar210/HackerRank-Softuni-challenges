package OOP_Advanced_Classes.Encapsulation;

import java.util.HashMap;

public class FootballTeam {
    private String name;
    private HashMap<String,FootballPlayer> currentPlayers;
    private double teamRating;

    public FootballTeam(String name){
    this.currentPlayers = new HashMap<>();
    }

    public String getName(){return this.name;}
    private void setName(String name){
        if(name!=null && !name.trim().isEmpty()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }

    public void addPlayer(FootballPlayer player){
        if(this.currentPlayers.containsKey(player.getName())){
            throw new IllegalArgumentException(String.format("Player %s already in team",player.getName()));
        }else{
            this.currentPlayers.put(player.getName(),player);
            this.teamRating+=player.overallStatLevel();
        }

    }

    public void removePlayer(String name){
        if(this.currentPlayers.containsKey(name)){
            this.teamRating-=this.currentPlayers.get(name).overallStatLevel();
            this.currentPlayers.remove(name);
        }else{
            throw new IllegalArgumentException(String.format("Player %s is not in %s",name,this.getName()));
        }

    }

    public double getRating(){return this.teamRating/this.currentPlayers.size();}

}



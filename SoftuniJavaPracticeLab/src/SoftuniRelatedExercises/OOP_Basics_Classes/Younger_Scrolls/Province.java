package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

import java.util.HashMap;
import java.util.HashSet;

public class Province {
    private String name;
    private HashSet<String> availableHeroTypes;
    private HashMap<String,Guild> guilds;

    public Province(String name){
        this.setName(name);
        this.availableHeroTypes = new HashSet<String>();
        this.availableHeroTypes.add("DUNMER");
        this.availableHeroTypes.add("NORD");
        this.availableHeroTypes.add("BRETON");
        this.availableHeroTypes.add("ORSIMER");
        this.availableHeroTypes.add("KHAJIIT");
        this.availableHeroTypes.add("REDGUARD");
        this.guilds = new HashMap<String,Guild>();
    }

    private void setName(String name){
    if(name!=null&& name.trim().isEmpty()){
        this.name = name;
    }else{
        throw new IllegalArgumentException("Illegal name state.");
    }
    }

    public String getName(){
        return this.name;
    }

    public String addGuild(Guild guild){
    if(!this.guilds.containsKey(guild.getName())){
        this.guilds.put(guild.getName(),guild);
        return String.format("Added guild: [ %s ]",guild.getName());
    }else{
        return "";
    }
    }

    public String removeGuild(Guild guild){
        String returnMessageGuild;
    if(this.guilds.containsKey(guild.getName())){
        returnMessageGuild = String.format("Removed guild %s with size %d",guild.getName(),guild.getGuildSize());
        this.guilds.remove(guild.getName());
        return returnMessageGuild;
    }else{
        return String.format("No guild with the name %s exists in %S province",guild.getName(),this.getName());
    }
    }
}

package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Guild {

    //resources
    private StringBuilder sb;
    private String name;
    private String guildSpecialization;
    private HashMap<String,Integer> specializationCount;
    private HashMap<String,Hero> heroes;
    double guildPower;

    public Guild(String name){
    this.setName(name);
    this.heroes = new HashMap<String,Hero>();
    this.specializationCount = new HashMap<>();
    this.specializationCount.put("Willpower",0);
    this.specializationCount.put("Endurance",0);
    this.specializationCount.put("Strength",0);
    this.guildPower = 0;
    }

    public String getName(){
        return this.name;
    }

    private void setName(String name){
        if(name!=null && name.trim().isEmpty()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Illegal name state.");
        }
    }

    private void updateGuildPower(Hero hero){      //for adding
    BigDecimal currentGuildPower = new BigDecimal(this.guildPower).setScale(2);
    BigDecimal currentHeroAddedPower =new BigDecimal(hero.getTotalPoints()).setScale(2);
    this.guildPower = currentGuildPower.add(currentHeroAddedPower).doubleValue();
    }

    private void updateGuildPower(String heroName){        //for removing
        BigDecimal currentGuildPower = new BigDecimal(this.guildPower).setScale(2);
        BigDecimal currentHeroAddedPower =new BigDecimal(this.heroes.get(heroName).getTotalPoints())
                .setScale(2);
        this.guildPower = currentGuildPower.subtract(currentHeroAddedPower).doubleValue();
    }

    private void updateSpecialization(Hero hero){
        this.specializationCount.put(hero.getSpecialization(),this.specializationCount
                .get(hero.getSpecialization())+1);
    }

    private void updateSpecialization(String heroName){
        this.specializationCount.put(this.heroes.get(heroName).getSpecialization(),this.specializationCount
                .get(this.heroes.get(heroName).getSpecialization())-1);
    }


    public String addHero(Hero hero){
        if(this.heroes.containsKey(hero.getName())){
            if(hero.getTotalPoints()<=this.heroes.get(hero.getName()).getTotalPoints()){
                return String.format("Hero [ %s ] cannot be replaced by a weaker one",hero.getName());
            }else{
                this.updateGuildPower(hero.getName());      //remove if necessary
                this.heroes.put(hero.getName(),hero);
                this.updateGuildPower(hero);
                this.updateGuildPower(hero);
                return String.format("Updated hero: [ %s ]",hero.getName());
            }
        }else{
            this.heroes.put(hero.getName(),hero);
            this.updateGuildPower(hero);
            this.updateSpecialization(hero);
            return String.format("Added hero: [ %s ]",hero.getName());
        }
    }

    public String removeHero(String heroName){
    if(this.heroes.containsKey(heroName)){
        this.updateGuildPower(heroName);
        this.updateSpecialization(heroName);
        this.heroes.remove(heroName);
        return String.format("Removed Hero [ %s ]",heroName);
    }else{
        return "";
    }
    }

    public Hero getHeroByName(String heroName){
        if(this.heroes.containsKey(heroName)){
            return this.heroes.get(heroName);
        }else{
            return null;
        }
    }

    public double getGuildPower() {return this.guildPower;}

    public long getGuildSize() {return this.heroes.size();}

    private Map getSortedMapOfHeroes(){
        return null;
    }

    @Override
    public String toString(){
        this.sb = new StringBuilder();
        this.sb.append(String.format("Guild: [%s]",this.getName())+System.lineSeparator());
        if(this.heroes.isEmpty()){
            this.sb.append("###Heroes: None"+System.lineSeparator());
        }else{
            this.sb.append("###Heroes:"+System.lineSeparator());
            this.heroes.forEach((k,v)->this.sb.append(v+System.lineSeparator()));
        }
        return this.sb.toString();
    }



}

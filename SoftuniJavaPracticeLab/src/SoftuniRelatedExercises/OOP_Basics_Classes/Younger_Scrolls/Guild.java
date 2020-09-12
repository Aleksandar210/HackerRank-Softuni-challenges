package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

import java.util.HashMap;
import java.util.List;

public class Guild {
    private String name;
    private HashMap<String,Hero> heroes;

    public Guild(String name){
    this.setName(name);
    this.heroes = new HashMap<String,Hero>();
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

    public String addHero(Hero hero){
        if(this.heroes.containsKey(hero.getName())){
            if(hero.getTotalPoints()<=this.heroes.get(hero.getName()).getTotalPoints()){
                return String.format("Hero [ %s ] cannot be replaced by a weaker one",hero.getName());
            }else{
                this.heroes.put(hero.getName(),hero);
                return String.format("Updated hero: [ %s ]",hero.getName());
            }
        }else{
            this.heroes.put(hero.getName(),hero);
            return String.format("Added hero: [ %s ]",hero.getName());
        }
    }

    public String removeHero(String heroName){
    if(this.heroes.containsKey(heroName)){
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

    public int getGuildSize() {return this.heroes.size();}




}

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

        }else{
            this.heroes.put(hero.getName(),hero);
        }
        return null;
    }




}

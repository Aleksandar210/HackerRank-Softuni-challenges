package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

import java.util.Arrays;

public abstract class Hero implements IHero {       //implement birthSign interfaces

    //fields
    private String name;
    private String type;
    private String description;
    private int magicka;
    private int fatigue;
    private int health;
    private boolean isHeroDead;

    public Hero(String name, int magicka, int fatigue,int health,String type){
    this.isHeroDead = false;
    }

    //properties
    private void setName(String name){
        if(name!=null && name.trim().isEmpty()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Illegal name state.");
        }
    }

    private void setMagicka(int magickaValue){
        if(magickaValue<0){
            throw new IllegalArgumentException("Illegal magicka state.");
        }else{
            this.magicka = magickaValue;
        }
    }

    protected int getMagicka() {return this.magicka;}

    private void setFatigue(int fatigueValue){
        if(fatigueValue<0){
            throw new IllegalArgumentException("Illegal fatigue state");
        }else{
            this.fatigue = fatigueValue;
        }
    }

    protected void setHealth(int value){
        if(value<0){
            throw new IllegalArgumentException("Illegal health state");
        }else{
            this.health = value;
        }
    }

    public String getName() {return this.name;}

    protected void setDescription(String description){
        if(description.contains("|")){
            this.description = description.replaceAll("|",System.lineSeparator());
        }else{
            this.description = description;
        }

    }

    protected String getHeroDescription(){
        return this.description;
    }

    protected int getFatigue() {return this.fatigue;}

    public boolean isDead(){
        return this.isHeroDead;
    }


}

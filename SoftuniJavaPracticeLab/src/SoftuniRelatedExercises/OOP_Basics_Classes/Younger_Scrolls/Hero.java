package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

import java.util.Arrays;

public abstract class Hero  {       //implement birthSign interfaces

    //fields
    private String name;
    private String type;
    private String description;
    private double offense;
    private double defense;
    private int magicka;
    private int fatigue;
    private int health;
    private boolean isHeroDead;

    public Hero(String name, int magicka, int fatigue,int health,String type){
    this.isHeroDead = false;
    }


    public String getName() {return this.name;}

    private void setName(String name){
        if(name!=null && name.trim().isEmpty()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Illegal name state.");
        }
    }

    public int getMagicka() {return this.magicka;}

    private void setMagicka(int magickaValue){
        if(magickaValue<0){
            throw new IllegalArgumentException("Illegal magicka state.");
        }else{
            this.magicka = magickaValue;
        }
    }

    public int getFatigue() {return this.fatigue;}

    private void setFatigue(int fatigueValue){
        if(fatigueValue<0){
            throw new IllegalArgumentException("Illegal fatigue state");
        }else{
            this.fatigue = fatigueValue;
        }
    }


    public int getHealth() {return this.health;}

    private void setHealth(int value){
        if(value<0){
            throw new IllegalArgumentException("Illegal health state");
        }else{
            this.health = value;
        }
    }



    protected String getHeroDescription(){
        return this.description;
    }

    protected void setDescription(String description){
        if(description.contains("|")){
            this.description = description.replaceAll("|",System.lineSeparator());
        }else{
            this.description = description;
        }

    }

    public double getOffense(){return this.offense;}

    private void setOffense(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Illegal offense state.");
        }else{
            this.offense = amount;
        }

    }

    private double getDefense(){return this.defense;}

    private void setDefense(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Illegal defense state.");
        }else{
            this.defense = amount;
        }
    }

    public void attackHero(Hero hero){

    }

    public void receiveDamage(double amount){
        this.setHealth(this.getHealth()-(int)amount);
    }

    public boolean isDead(){
        return this.isHeroDead;
    }

    @Override
    public String toString(){
        return this.getHeroDescription();
    }


}

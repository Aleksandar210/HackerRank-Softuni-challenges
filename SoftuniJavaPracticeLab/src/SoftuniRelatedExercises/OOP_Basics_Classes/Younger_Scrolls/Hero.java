package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

import sun.text.resources.de.FormatData_de_AT;

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

    public Hero(String name, int magicka, int fatigue,int health){
        this.setName(name);
        this.setMagicka(magicka);
        this.setFatigue(fatigue);
        this.setHealth(health);
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

    protected void setType(String type){
        if(type!=null && type.trim().isEmpty()){
            this.type = type;
        }else{
            throw new IllegalArgumentException("Illegal type state.");
        }
    }

    protected String getType() {return this.type;}

    protected int getMagicka() {return this.magicka;}

    protected void setMagicka(int magickaValue){
        if(magickaValue<0){
            throw new IllegalArgumentException("Illegal magicka state.");
        }else{
            this.magicka = magickaValue;
        }
    }

    protected int getFatigue() {return this.fatigue;}

    protected void setFatigue(int fatigueValue){
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

    protected void setOffense(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Illegal offense state.");
        }else{
            this.offense = amount;
        }

    }

    public double getDefense(){return this.defense;}

    protected void setDefense(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Illegal defense state.");
        }else{
            this.defense = amount;
        }
    }

    public void attackHero(Hero hero){
    hero.receiveDamage(Math.floor(this.getOffense()));
    }

    public void receiveDamage(double amount){
        if(this.getHealth()-(int)amount<=0){
            this.isHeroDead = true;
            return;
        }else{
            this.setHealth(this.getHealth()-(int)Math.floor(amount));       //check for correct calculations in books
        }

    }

    public boolean isDead(){
        return this.isHeroDead;
    }

    public double getTotalPoints(){
        return this.getDefense()+this.getOffense();
    }

    @Override
    public String toString(){
        return this.getHeroDescription();
    }


}

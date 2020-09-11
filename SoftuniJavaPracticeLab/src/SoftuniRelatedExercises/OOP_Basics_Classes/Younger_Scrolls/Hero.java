package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

public abstract class Hero implements IHero {       //implement birthSign interfaces
    //fields
    private String name;
    private String type;
    private int magicka;
    private int fatigue;
    private int health;

    public Hero(String name, int magicka, int fatigue,int health,String type){

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

    protected int getFatigue() {return this.fatigue;}




}

package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

public abstract class EnduranceHero extends Hero {
    private double magicResistance;

    public EnduranceHero(String name, int magicka, int fatigue, int health, String type) {
        super(name, magicka, fatigue, health+health);
        this.setType(type);
        this.setMagicResistance();
    }

    private void setMagicResistance(){
        if(this.getMagicka()!=0){
            this.magicResistance = (this.getMagicka()*40)*0.01;
        }else{
            this.magicResistance =0;
        }
    }

    protected double getMagicResistance(){return this.magicResistance;}
}

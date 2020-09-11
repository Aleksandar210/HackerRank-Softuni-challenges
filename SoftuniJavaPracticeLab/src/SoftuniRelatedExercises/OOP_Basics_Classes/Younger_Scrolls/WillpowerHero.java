package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

public abstract class WillpowerHero extends Hero {
    private double spellPenetration;

    public WillpowerHero(String name, int magicka, int fatigue, int health, String type) {
        super(name, magicka, fatigue, health);
        this.setType(type);
        this.setSpellPenetration();
        this.setOffense();
        this.setDefense();
    }

    private void setSpellPenetration(){
        if(this.getFatigue()!=0){
            this.spellPenetration = (this.getFatigue()*20)*0.01;
        }else{
            this.spellPenetration = 0;
        }
    }

    protected double getSpellPenetration() {return this.spellPenetration;}
}

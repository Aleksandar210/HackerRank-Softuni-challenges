package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

public abstract class StrengthHero extends Hero {
    private double magicDamage;

    public StrengthHero(String name, int magicka, int fatigue, int health,String type) {
        super(name, magicka, fatigue, health);
        this.setType(type);
        this.setMagicDamage();
    }

    protected double getMagicDamage() {
        return this.magicDamage;
    }

    private void setMagicDamage(){
        if(this.getMagicka()!=0){
            this.magicDamage = (this.getMagicka()*50)*0.01;
        }else{
            this.magicDamage = 0;
        }
    }
}

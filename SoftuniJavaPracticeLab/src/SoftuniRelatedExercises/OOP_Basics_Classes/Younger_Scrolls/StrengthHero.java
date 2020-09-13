package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

public abstract class StrengthHero extends Hero {
    private double magicDamage;

    public StrengthHero(String name, int magicka, int fatigue, int health,String type) {
        super(name, magicka, fatigue, health);
        this.setType(type);
        this.setMagicDamage();
        this.setSpecialization("Strength");
        this.setOffense(((120*this.getFatigue())*0.01)
        +((30*this.getHealth())*0.01)+this.getMagicDamage());
        this.setDefense(this.getHealth()+((this.getFatigue()*10)*0.01)); //implement logic
        this.setType(type);
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

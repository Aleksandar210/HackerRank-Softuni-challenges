package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

public class Redguard extends Hero {


    public Redguard(String name, int magicka, int fatigue, int health, String type) {
        super(name, magicka, fatigue, health, type);
    }

    @Override
    public int getHealth() {
        return 0;

    }

    @Override
    public double getOffense() {
        return 0;
    }

    @Override
    public double getDefense() {
        return 0;
    }

    @Override
    public double getTotalPoints() {
        return 0;
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public void attack(Hero hero) {

    }

    @Override
    public void receiveDamage(double amount) {

    }
}

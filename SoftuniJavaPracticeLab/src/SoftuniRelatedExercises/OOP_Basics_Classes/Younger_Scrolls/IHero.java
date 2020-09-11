package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

public interface IHero {
    String getName();
    int getHealth();
    double getOffense();
    double getDefense();
    double getTotalPoints();
    boolean isDead();
    void attack(Hero hero);
    void receiveDamage(double amount);

}

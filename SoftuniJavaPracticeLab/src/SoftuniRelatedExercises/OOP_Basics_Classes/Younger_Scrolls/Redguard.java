package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

public class Redguard extends StrengthHero {


 private final String DEFAULT_DESCRIPTION = "Redguards hail from the great desert province of Lefremmah.|" +
         " They are descended from an extensive line of warriors and mystic seers.|" +
         " Legend has it that Redguards are innately more proficient with the use of weaponry than any other race.";

    public Redguard(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health,"REDGUARD");
        this.setDescription(DEFAULT_DESCRIPTION);
    }



}

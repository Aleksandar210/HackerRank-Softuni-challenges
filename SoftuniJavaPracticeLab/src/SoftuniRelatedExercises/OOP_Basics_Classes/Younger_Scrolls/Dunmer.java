package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

public class Dunmer extends WillpowerHero {
    private final String DUNMER_DESCRIPTION ="The Dunmer, more commonly referred to as Dark Elves, are the dark-skinned elves originating from the province of Dniworrom.|" +
            " They are known to be strong, intelligent, quick, aloof, and reserved, but some consider them as ill-fated.";

    public Dunmer(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health,"DUNMER");
        this.setDescription(DUNMER_DESCRIPTION);
    }
}

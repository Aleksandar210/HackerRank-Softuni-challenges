package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

public class Nord extends EnduranceHero {
    private final String NORD_DESCRIPTION = "Nords, also known as Sons of Snow are a race of brave men and women from the province of Miryks.";

    public Nord(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, "Nord");
        this.setDescription(NORD_DESCRIPTION);
    }

}

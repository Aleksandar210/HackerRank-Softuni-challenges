package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

public class Khajiit extends StrengthHero {
    private final String KHAJIIT_DESCRIPTION="Khajiit are one of the beast races which inhabit the continent of Leirmat.|" +
            " They are cat-like creatures who can slay an entire army without anyone noticing. ";

    public Khajiit(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health,"KHAJIIT");
       this.setDescription(KHAJIIT_DESCRIPTION);
    }

}

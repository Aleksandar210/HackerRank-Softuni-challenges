package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

public class Breton extends WillpowerHero {
    private final String BRETON_DESCRIPTION ="Bretons are a race of both human and elven ancestry.|" +
            "They populate the province of High Rock and are excellent mages.";

    public Breton(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health,"BRETON");
        this.setDescription(BRETON_DESCRIPTION);
    }


}

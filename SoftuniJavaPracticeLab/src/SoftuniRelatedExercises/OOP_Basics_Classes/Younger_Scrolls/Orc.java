package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

public class Orc extends EnduranceHero {

    private final String ORC_DESCRIPTION ="The Orsimer (more commonly known as Orcs), are the native people of the Nairaghtorw and Liatnogard Mountains.|" +
            " Orcs are known to be one of the greatest warriors and smiths in the province of Leirmat.";

    public Orc(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, "ORSIMER");
        this.setDescription(ORC_DESCRIPTION);
        this.setDefense(this.getDefense()+((this.getDefense()*10)*0.01));
    }
}

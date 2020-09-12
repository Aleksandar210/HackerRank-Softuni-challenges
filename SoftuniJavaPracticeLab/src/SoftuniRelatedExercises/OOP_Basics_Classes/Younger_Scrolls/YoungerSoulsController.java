package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class YoungerSoulsController implements IRunnable {

private Scanner scan;
private HashMap<String,Province> provinces;
private HashSet<String> availableHeroTypes;

public YoungerSoulsController(){
    this.scan = new Scanner(System.in);
    this.availableHeroTypes = new HashSet<String>();
    this.availableHeroTypes.add("DUNMER");
    this.availableHeroTypes.add("NORD");
    this.availableHeroTypes.add("BRETON");
    this.availableHeroTypes.add("ORSIMER");
    this.availableHeroTypes.add("KHAJIIT");
    this.availableHeroTypes.add("REDGUARD");
}

    @Override
    public void run() {
        String enterCommand = this.scan.nextLine();
        String[] commandParts;
        while(!enterCommand.equalsIgnoreCase("end")){

        }
    }


}

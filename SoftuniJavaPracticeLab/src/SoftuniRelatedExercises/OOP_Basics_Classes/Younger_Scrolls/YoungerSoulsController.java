package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

import java.util.HashMap;
import java.util.Scanner;

public class YoungerSoulsController implements IRunnable {

private Scanner scan;
private HashMap<String,Province> provinces;
private

public YoungerSoulsController(){
    this.scan = new Scanner(System.in);
}

    @Override
    public void run() {
        String enterCommand = this.scan.nextLine();
        String[] commandParts;
        while(!enterCommand.equalsIgnoreCase("end")){

        }
    }


}

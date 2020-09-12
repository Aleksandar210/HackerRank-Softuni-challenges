package SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class YoungerSoulsController implements IRunnable {

private Scanner scan;
private Province currentlySelectedProvince;
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

    private void createProvince(String name){
    if(this.validateStringName(name)){
        Province provinceCreated = new Province(name);
        if(this.provinces.containsKey(name)){
            System.out.printf("Province %s already exists.",name);
        }else{
            this.provinces.put(name,provinceCreated);
            this.currentlySelectedProvince = provinceCreated;
            System.out.printf("Province %s created.",name);
        }

    }


    }

    private boolean validateStringName(String stringName){
    if(stringName!=null && stringName.trim().isEmpty()){
        return true;
    }else{
        return false;
    }
    }


}

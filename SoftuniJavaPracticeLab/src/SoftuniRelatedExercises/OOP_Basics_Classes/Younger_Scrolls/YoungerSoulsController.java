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

    public void selectProvince(String name){
    if(this.provinces.containsKey(name)){
        this.currentlySelectedProvince = this.provinces.get(name);
        System.out.printf("Province %s selected.",name);
    }else{
        System.out.printf("No province by the name %s was found.",name);
    }
    }

    private boolean validateStringName(String stringName){
    if(stringName!=null && stringName.trim().isEmpty()){
        return true;
    }else{
        return false;
    }
    }

    private void addHero(String...params){
    Hero currentHeroCreated;
    if(this.currentlySelectedProvince.containsGuild(params[0])){

    if(this.availableHeroTypes.contains(params[1].toUpperCase())){

    }else{
        System.out.println("Type doesn't exist");
    }

    }else{
        if(this.validateStringName(params[0])){
            Guild currentCreatedGuild = new Guild(params[0]);
            this.currentlySelectedProvince.addGuild(currentCreatedGuild);
        }else{
            throw new IllegalArgumentException("Illegal guild name");
        }

    }
    }

    private Hero createHero(String...params){
    Hero currentHeroCreated;
    switch(params[0]){
        case "BRETON":
        currentHeroCreated = new Breton(params[1],Integer.valueOf(params[2]),Integer.valueOf(params[3]),
                Integer.valueOf(params[4]));
        return currentHeroCreated;
        case "NORD":
            currentHeroCreated = new Nord(params[1],Integer.valueOf(params[2]),Integer.valueOf(params[3]),
                    Integer.valueOf(params[4]));
            return currentHeroCreated;
        case "REDGUARD":
            currentHeroCreated = new Redguard(params[1],Integer.valueOf(params[2]),Integer.valueOf(params[3]),
                    Integer.valueOf(params[4]));
            return currentHeroCreated;
        case "ORSIMER":
            currentHeroCreated = new Orc(params[1],Integer.valueOf(params[2]),Integer.valueOf(params[3]),
                    Integer.valueOf(params[4]));
            return currentHeroCreated;
        case "DUNMER":
            currentHeroCreated = new Dunmer(params[1],Integer.valueOf(params[2]),Integer.valueOf(params[3]),
                    Integer.valueOf(params[4]));
            return currentHeroCreated;
        case "KHAJIIT":
            currentHeroCreated = new Khajiit(params[1],Integer.valueOf(params[2]),Integer.valueOf(params[3]),
                    Integer.valueOf(params[4]));
            return currentHeroCreated;
        default:
            return null;
    }
    }




}

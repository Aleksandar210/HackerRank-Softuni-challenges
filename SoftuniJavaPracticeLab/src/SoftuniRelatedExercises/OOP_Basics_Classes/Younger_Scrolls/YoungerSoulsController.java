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
        commandParts = enterCommand.split(":");
        switch(commandParts[0]){
            case "ADD_GUILD":
                this.addGuild(commandParts[1]);
                break;
            case "ADD_HERO":
                this.addHero(commandParts[1].split("\\s+"));
                break;
        }
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

    try{
        currentHeroCreated = this.createHero(params[1],params[2],params[3],params[4]);
    this.currentlySelectedProvince.getGuildByName(params[0]).addHero(currentHeroCreated);
    }catch(Exception exc){
    System.out.printf("Invalid stats %s",exc.getMessage());
    }

    }else{
        System.out.println("Type doesn't exist");
    }

    }else{
        if(this.validateStringName(params[0])){
            Guild currentCreatedGuild = new Guild(params[0]);
            this.currentlySelectedProvince.addGuild(currentCreatedGuild);
            this.addHero(params);
        }else{
            throw new IllegalArgumentException("Illegal guild name");
        }

    }
    }

    public void addGuild(String guildName){
    if(this.currentlySelectedProvince.containsGuild(guildName)){
        System.out.println("Guild already exists");
    }else{
       try{
           Guild currentGuildCreated = new Guild(guildName);
           System.out.printf("Guild %s added",guildName);
       }catch(Exception exc){
           System.out.println(exc.getMessage());
       }

    }
    }


    public String removeGuild(String name){
    if(this.currentlySelectedProvince.containsGuild(name)){
        this.currentlySelectedProvince.removeGuild(this.currentlySelectedProvince.getGuildByName(name));
        return String.format("Removed guild: %s",name);
    }else{
        return String.format("Guild: %s doesn't exist");
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

    private void details(String...params){
    switch(params.length){
        case 1:
            if(this.currentlySelectedProvince.containsGuild(params[0])){
                System.out.println(this.currentlySelectedProvince.getGuildByName(params[0]));
            }else{
                System.out.println("Guild doesn't exist");
            }
            break;
        case 2:
            if(this.currentlySelectedProvince.containsGuild(params[0])){
                if(this.currentlySelectedProvince.getGuildByName(params[0]).containsHero(params[1])){
                    System.out.println(this.currentlySelectedProvince.getGuildByName(params[0]).getHeroByName(params[1]));
                }
            }else{
                System.out.println("Guild doesn't exist");
            }
            break;
        default:
            throw new IllegalArgumentException("Illegal number or params");

    }
    }




}

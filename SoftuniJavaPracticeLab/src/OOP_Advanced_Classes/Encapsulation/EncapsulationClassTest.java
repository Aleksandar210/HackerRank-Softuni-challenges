package OOP_Advanced_Classes.Encapsulation;

import sun.misc.Perf;

import java.util.HashMap;
import java.util.Scanner;

public class EncapsulationClassTest {
private Scanner scan;
    public EncapsulationClassTest(){
    this.scan = new Scanner(System.in);
    }




    //Salary increase task
    public void salaryIncrease(){
    int numberPersons = Integer.parseInt(this.scan.nextLine());
    Person[] persons = new Person[numberPersons];
    String[] getPersonData;
    Person personToCreate;
    for(int i=0;i<persons.length;i++){
        try{
            getPersonData = this.scan.nextLine().split("\\s+");
            personToCreate = new Person(getPersonData[0],Integer.valueOf(getPersonData[1]),Double.valueOf(getPersonData[2]));
            persons[i] = personToCreate;
        }catch(IllegalArgumentException exc){
            System.out.println(exc.getMessage());
        }
    }
    double percentageIncrease = Double.parseDouble(scan.nextLine());
    for(Person person:persons){
        person.increaseSalary(percentageIncrease);
        System.out.println(person);
    }
    this.scan.close();
    }


    public void footballTeamGenerator(){
        HashMap<String,FootballTeam> currentTeams = new HashMap<>();
    String enterCommand = this.scan.nextLine();
    String[] splitCommand;
    while(!enterCommand.equalsIgnoreCase("End")){
        splitCommand = enterCommand.split("\\s+");
    }
    }
    private void executeFootballTeamCommand(HashMap<String,FootballTeam>teams,String...command){

    switch(command[0]){
        case "Team":
            if(!doesTeamExist(command[1],teams)){
                try{
                    teams.put(command[1],new FootballTeam(command[1]));
                }catch(IllegalAccessError exc){
                    System.out.println(exc.getMessage());
                }
            }
            break;
        case "Add":
            if(this.doesTeamExist(command[1],teams)){
                try{
                    int[] stats = {Integer.valueOf(command[3]),Integer.valueOf(command[4])
                    ,Integer.valueOf(command[5]),Integer.valueOf(command[6]),Integer.valueOf(command[7])};
                    teams.get(command[1]).addPlayer(new FootballPlayer(command[2],stats[0],stats[1],stats[2]
                    ,stats[3],stats[4]));
                }catch(IllegalArgumentException exc){
                    System.out.println(exc.getMessage());
                }
            }
            break;
    }
    }

    private boolean doesTeamExist(String name, HashMap<String,FootballTeam>teams){
        if(teams.containsKey(name)){
            return true;
        }else{
            return false;
        }
    }
}

package OOP_Advanced_Classes.Encapsulation;

import sun.misc.Perf;

import java.util.Scanner;

public class EncapsulationClassTest {
private Scanner scan;
    public EncapsulationClassTest(){
    this.scan = new Scanner(System.in);
    }

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
    }
}

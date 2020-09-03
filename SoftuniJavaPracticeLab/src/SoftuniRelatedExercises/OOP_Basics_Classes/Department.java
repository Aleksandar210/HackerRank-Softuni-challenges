package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.util.*;

public class Department {
    //static fields and constants
    public static HashSet<String> currentDepartments = new HashSet<>();

    //fields
    String name;
    private double averageSalary;
    private
    List<Employe> currentEmployes;

    //constr
    private Department(){
        this.currentEmployes = new ArrayList<>();
    }
    public Department(String name){
        this();
        this.setName(name);
    }

    private static void enterDepartmentNameInPool(String name){
        currentDepartments.add(name.toLowerCase()); //do with lower for character difference
    }

    public double getAverageSalary(){
        //implement it so that every time you add an employee you ad to the average

        //incorrect way
        this.setAverageSalary();
        return this.averageSalary;
    }

    //implement getting average salary correctly for  now it will work with basics adds
    private void setAverageSalary(){

        //implement correct way here
       // this.currentEmployes.stream().reduce((a,b)-> {
           //implement money operations here
          //  return null;
       // });

        //some hints
        //String doubleAsText = String.valueOf();
        //double number = Double.parseDouble(doubleAsText);
        //int decimal = Integer.parseInt(doubleAsText.split("\\.")[0]);
       // int fractional = Integer.parseInt(doubleAsText.split("\\.")[1]);

        //incorrect way
        Optional<Double> currentAverageSum = this.currentEmployes.stream()
               .map(person->person.getSalary())
                .reduce((a,b)->(a+b));
        this.averageSalary = currentAverageSum.get();
    }

    public String getName(){
        return this.name;
    }

    private void setName(String name){
        if(name!=null && !name.trim().isEmpty()){
            this.name = name;
            enterDepartmentNameInPool(name);
        }else{
            throw new IllegalArgumentException("Illegal name state");
        }
    }

}

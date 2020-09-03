package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        enterDepartmentNameInPool(name);

    }

    private static void enterDepartmentNameInPool(String name){
        currentDepartments.add(name.toLowerCase()); //do with lower for character difference
    }

    public double getAverageSalary(){
        return this.averageSalary;
    }

    private void setAverageSalary(){
        this.currentEmployes.stream().reduce((a,b)-> {
           //implement money operations here
            return null;
        });
        //String doubleAsText = String.valueOf();
        //double number = Double.parseDouble(doubleAsText);
        //int decimal = Integer.parseInt(doubleAsText.split("\\.")[0]);
       // int fractional = Integer.parseInt(doubleAsText.split("\\.")[1]);
    }

}

package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.util.HashSet;

public class Department {
    //static fields and constants
    public static HashSet<String> currentDepartments = new HashSet<>();

    //fields
    String name;

    //constr
    public Department(String name){
        enterDepartmentNameInPool(name);


    }

    private static void enterDepartmentNameInPool(String name){
        currentDepartments.add(name.toLowerCase()); //do with lower for character difference
    }

}

package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.math.BigDecimal;
import java.util.*;

public class Department {
    //static fields and constants
    public static HashSet<String> currentDepartments = new HashSet<>();

    //fields
    String name;
    private double averageSalary;
    private Employee currentTopEmployee;
    List<Employee> currentEmployees;

    //constr
    private Department(){
        this.currentEmployees = new ArrayList<>();
    }
    public Department(String name){
        this();
        this.setName(name);
    }

    //behaviour and properties

    private static void enterDepartmentNameInPool(String name){
        currentDepartments.add(name.toLowerCase()); //do with lower for character difference
    }

    public double getAverageSalary(){
        return this.averageSalary;
    }

    //implement getting average salary correctly for  now it will work with basics adds
    private void setAverageSalary(){
    if(this.currentEmployees.size()==1){
        this.averageSalary = this.currentEmployees.get(this.currentEmployees.size()-1).getSalary();
    }else{
        BigDecimal resultRounded = new BigDecimal(this.currentEmployees.get(this.currentEmployees.size()-1).getSalary())
                .setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal averageSalarySum = new BigDecimal(this.averageSalary)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
        averageSalarySum.add(resultRounded);
        this.averageSalary = averageSalarySum.doubleValue();
    }
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
    //behaviours only
    public void addEmployee(Employee employeeToAdd){
        this.currentEmployees.add(employeeToAdd);
        this.setAverageSalary();
    }

}

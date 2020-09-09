package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee extends Person {

    //fields
    private double salary;
    private String department;
    private String position;
    private String email;

    public Employee(String name,double salary,String department,String position,String email,int age){
        super(name,age);
        this.setSalary(salary);
        this.setDepartment(department);
        this.setPosition(position);
        this.setEmail(email);
    }

    public Employee(String name,double salary,String department,String position,String email){
        super(name);
        this.setSalary(salary);
        this.setDepartment(department);
        this.setPosition(position);
        this.setEmail(email);
    }

    public Employee(String name,double salary,String department,String position,int age){
        super(name,age);
        this.setSalary(salary);
        this.setDepartment(department);
        this.setPosition(position);

    }

    public Employee(String name,double salary,String department,String position){
        super(name);
        this.setSalary(salary);
        this.setDepartment(department);
        this.setPosition(position);

    }


    //properties
    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        String stringSalary = String.valueOf(salary);
        int decimal = Integer.parseInt(stringSalary.split("\\.")[0]);
        int fraction = Integer.parseInt(stringSalary.split("\\.")[0]);

    }

    public String getDepartment() {
        return department;
    }

    private void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    private void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(email);
        if(m.find()){
            this.email = email;
        }else{
            throw new IllegalArgumentException("Illegal e-mail state");
        }
    }

    //overriden toString method
    @Override
    public String toString(){
        return String.format("Name:%s Position:%s Salary:%.2f",this.getName(),this.getPosition(),this.getSalary());
    }
}

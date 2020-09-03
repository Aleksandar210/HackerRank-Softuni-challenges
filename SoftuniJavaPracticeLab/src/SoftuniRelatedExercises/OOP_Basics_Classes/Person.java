package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.util.regex.Pattern;

public abstract class Person {
    //fields
    private String name;
    private String email;
    private String positon;
    private String department;
    private int age;
    double salary;

    //constr
    public Person(String name,double salary,String pos,String department,String email,int age){

    }

    public Person(String name,double salary,String pos,String department,String email){

    }

    public Person(String name,double salary,String pos,String department,int age){

    }

    public Person(String name,double salary,String pos,String department){

    }

    private Person(String email,int age){

    }

    private Person(String name){

    }

    private Person(int age){

    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        if(salary<=0){
            throw new IllegalArgumentException("Illegal salary value");
        }else{
            this.salary = salary;
        }

    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name!=null && !name.trim().isEmpty()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Illegal name state");
        }

    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        String validPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(validPattern);
        this.email = email;
    }

    public String getPositon() {
        return positon;
    }

    private void setPositon(String positon) {
        this.positon = positon;
    }

    public String getDepartment() {
        return department;
    }

    private void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }


}

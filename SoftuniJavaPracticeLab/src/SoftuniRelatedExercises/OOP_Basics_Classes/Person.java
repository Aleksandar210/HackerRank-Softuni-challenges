package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person {
    //fields
    private String name;
    private String email;
    private String position;
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
        Matcher m = pattern.matcher(email);
        if(m.find()){
            this.email = email;
        }else{
            throw new IllegalArgumentException("Illegal E-mail state");
        }

    }

    public String getPosition() {
        return position;
    }

    private void setPosition(String position) {
        if(position!=null && !position.trim().isEmpty()){
            this.position = position;
        }else{
            throw new IllegalArgumentException("Illegal name state");
        }
    }

    public String getDepartment() {

        return department;
    }

    private void setDepartment(String department) {
        if(Department.currentDepartments.contains(department.toLowerCase())){
            this.department = department;
        }else{
            throw new IllegalArgumentException("No such department found.");
        }

    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if(age<=0){
            throw new IllegalArgumentException("Illegal age state.");
        }else{
            this.age = age;
        }

    }

    @Override
    public String toString(){

        return null;
    }


}

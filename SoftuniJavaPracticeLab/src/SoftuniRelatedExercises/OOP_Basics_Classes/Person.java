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
        this(email,age);
    this.setName(name);
    this.setSalary(salary);
    this.setPosition(pos);
    this.setDepartment(department);
    }

    public Person(String name,double salary,String pos,String department,String email){
    this(email);
    this.setName(name);
    this.setSalary(salary);
    this.setPosition(pos);
    this.setDepartment(department);
    }

    public Person(String name,double salary,String pos,String department,int age){
    this(age);
    this.setName(name);
    this.setSalary(salary);
    this.setPosition(pos);
    this.setDepartment(department);
    }

    public Person(String name,double salary,String pos,String department){
    this.setName(name);
    this.setSalary(salary);
    this.setPosition(pos);
    this.setDepartment(department);
    }

    private Person(String email,int age){
    this.setEmail(email);
    this.setAge(age);
    }

    private Person(String email){
    this.setEmail(email);
    }

    private Person(int age){
    this.setAge(age);
    }


    //properties
    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {

        String doubleAsText = String.valueOf(salary);
        //double number = Double.parseDouble(doubleAsText);
        int decimal = Integer.parseInt(doubleAsText.split("\\.")[0]);
        int fractional = Integer.parseInt(doubleAsText.split("\\.")[1]);

        if(salary<=0){
            throw new IllegalArgumentException("Illegal salary value");
        }else{
            if(fractional>99){
                int increaseBy = Integer.parseInt(Integer.toString(fractional).substring(0, 1));
                decimal+=increaseBy;
                fractional -= increaseBy*100;
                this.salary = Double.parseDouble(decimal+"."+fractional);
            }else{
                this.salary = salary;
            }

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

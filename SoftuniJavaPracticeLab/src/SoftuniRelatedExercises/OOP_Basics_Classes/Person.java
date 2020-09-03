package SoftuniRelatedExercises.OOP_Basics_Classes;

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
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
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

package SoftuniRelatedExercises.OOP_Basics_Classes;

public class Employee extends Person {

    //fields
    private double salary;
    private String department;
    private String position;
    private String email;

    public Employee(String name,double salary,String department,String position,String email,int age){
        super(name,age);

    }

    public Employee(String name,double salary,String department,String position,String email){
        super(name);
    }

    public Employee(String name,double salary,String department,String position,int age){
        super(name,age);
    }

    public Employee(String name,double salary,String department,String position){
        super(name);
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
        this.email = email;
    }

    //overriden toString
    @Override
    public String toString(){
        return String.format("Name:%s Position:%s Salary:%.2f",this.getName(),this.getPosition(),this.getSalary());
    }
}

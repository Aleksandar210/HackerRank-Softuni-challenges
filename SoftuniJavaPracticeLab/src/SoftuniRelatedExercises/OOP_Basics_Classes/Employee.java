package SoftuniRelatedExercises.OOP_Basics_Classes;

public class Employee extends Person {


    public Employee(String name, double salary, String pos, String department, String email, int age) {
        super(name, salary, pos, department, email, age);
    }

    public Employee(String name, double salary, String pos, String department, String email) {
        super(name, salary, pos, department, email);
    }

    public Employee(String name, double salary, String pos, String department, int age) {
        super(name, salary, pos, department, age);
    }

    public Employee(String name, double salary, String pos, String department) {
        super(name, salary, pos, department);
    }
}

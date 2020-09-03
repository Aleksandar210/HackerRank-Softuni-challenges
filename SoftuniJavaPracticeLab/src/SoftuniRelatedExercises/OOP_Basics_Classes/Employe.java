package SoftuniRelatedExercises.OOP_Basics_Classes;

public class Employe extends Person {


    public Employe(String name, double salary, String pos, String department, String email, int age) {
        super(name, salary, pos, department, email, age);
    }

    public Employe(String name, double salary, String pos, String department, String email) {
        super(name, salary, pos, department, email);
    }

    public Employe(String name, double salary, String pos, String department, int age) {
        super(name, salary, pos, department, age);
    }

    public Employe(String name, double salary, String pos, String department) {
        super(name, salary, pos, department);
    }
}

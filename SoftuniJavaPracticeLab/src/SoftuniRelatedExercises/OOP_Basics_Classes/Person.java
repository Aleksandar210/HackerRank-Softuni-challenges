package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Person {
    //fields
    private String name;
    private int age;

    public Person(String name,int age){

    }

    public Person(String name){

    }

    public Person(int age){

    }

    //properties


    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if(name!=null && name.trim().isEmpty()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Illegal name state.");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<=0){
            throw new IllegalArgumentException("Illegal name state.");
        }else{
            this.age = age;
        }
    }
}

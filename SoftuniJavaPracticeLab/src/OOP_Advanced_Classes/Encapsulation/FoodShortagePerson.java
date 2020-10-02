package OOP_Advanced_Classes.Encapsulation;

import java.util.IllformedLocaleException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class FoodShortagePerson implements Buyer {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    protected FoodShortagePerson(String name, int age){
    this.food = 0;
    this.setName(name);
    this.setAge(age);
    }





    public String getName() {
        return this.name;
    }

    private void setName(String name){
        if(name!=null && !name.trim().isEmpty()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
    }


    public int getAge() {
        return this.age;
    }

    private void setAge(int age){
        if(age<=0){
            throw new IllegalArgumentException("Invalid age");
        }else{
            this.age = age;
        }
    }




    @Override
    public void buyFood() {
    this.food+=5;
    }

    @Override
    public int getFood() {
        return this.food;
    }
}

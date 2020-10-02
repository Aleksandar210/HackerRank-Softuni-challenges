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

    protected FoodShortagePerson(String name, int age, String id, String birthDate){
    this.food = 0;
    this.setName(name);
    this.setAge(age);
    this.setId(id);
    this.setBirthDate(birthDate);
    }

    protected FoodShortagePerson(String name, int age, String birthDate){
        this.food = 0;
        this.setName(name);
        this.setAge(age);
        this.setBirthDate(birthDate);
    }

    public String getBirthDate(){return this.birthDate;}

  private void setBirthDate(String birthDate){
        Pattern pattern = Pattern.compile("[[0-9]{2}|[0-9]{1}]/[[0-9]{2}|[0-9]{1}]/[0-9]+");
        Matcher matcher = pattern.matcher(birthDate);
        if(matcher.find()){
            this.birthDate = birthDate;
        }else{
            throw new IllegalArgumentException("Invalid birthdate");
        }
  }

  public String getId(){
        return this.id;
  }

  private void setId(String id){
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(id);
        if(matcher.find()){
            this.id = id;
        }else{
            throw new IllegalArgumentException("INVALID ID");
        }
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

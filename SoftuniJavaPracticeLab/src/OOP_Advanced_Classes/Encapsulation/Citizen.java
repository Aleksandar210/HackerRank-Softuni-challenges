package OOP_Advanced_Classes.Encapsulation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Citizen extends FoodShortagePerson {
    private String birthDate;
    private String id;
    public Citizen(String name, int age, String id, String birthDate) {
        super(name, age);
        this.setBirthDate(birthDate);
        this.setId(id);
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

    @Override
    public void buyFood() {
        for(int i=0;i<2;i++){
            super.buyFood();
        }
    }
}

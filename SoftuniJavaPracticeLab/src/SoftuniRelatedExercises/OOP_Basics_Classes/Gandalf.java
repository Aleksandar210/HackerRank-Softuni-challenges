package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gandalf {
    //resources
    private StringBuilder sb;

    private final String Default_Name = "Gandalf";
    private final int Default_Happiness_Points = 0;

    //fields
    private String name;
    private String mood;
    private int happinessPoints;
    private List<String> foodsEaten;

    public Gandalf(){
        this.name = this.Default_Name;
        this.foodsEaten = new ArrayList<String>();
        this.sb = new StringBuilder();
        this.mood =null;
        this.happinessPoints = this.Default_Happiness_Points;
    }

    private void eatFood(String food){
        switch(food.toLowerCase()){
            case "cram":
                this.happinessPoints+=2;
                break;
            case "lambas":
                this.happinessPoints+=3;
                break;
            case "apple":
            case "melon":
                this.happinessPoints++;
                break;
            case "honeycake":
                this.happinessPoints+=5;
                break;
            case "mushrooms":
                this.happinessPoints-=10;
                break;
            default:
                this.happinessPoints--;
                break;
        }
        this.sb.append(food+System.lineSeparator());
    }

    public void takeFoodBag(String...food){
        Arrays.stream(food).map(e->
        {
         this.eatFood(e);
         return e;
        });
        this.setMood();
    }

    private void setMood(){
        if(this.happinessPoints<-5){
            this.mood = "Angry";
        }else if(this.happinessPoints>=-5 && this.happinessPoints<=0){
            this.mood = "Sad";
        }else if(this.happinessPoints>0 && this.happinessPoints<=15){
            this.mood = "Happy";
        }else{
            this.mood = "JavaScript";
        }
    }

    public String getMood(){
        return this.mood;
    }

    public String getFoodEaten(){
        return this.sb.toString();
    }
}

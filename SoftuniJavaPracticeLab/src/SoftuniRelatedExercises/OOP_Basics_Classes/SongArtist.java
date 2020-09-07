package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.util.HashMap;

public class SongArtist {

    private final String Default_Song_Time = "00:00:00";

    //fields
    private String name;
    private String totalTimeOfSongs;
    private HashMap<String,String> currentSongs;        //with duration in String

    public SongArtist(String name){

    this.setName(name);
    }

    private void setName(String name){
        if(name!=null && name.trim().isEmpty()){
            if(name.length()>=3 && name.length()<=20){
                this.name = name;
            }else{
                throw new IllegalArgumentException("Illegal name length.")
            }
        }else{
            throw new NullPointerException("Illegal name state.");
        }
    }

    public String getName(){
        return this.name;
    }


}

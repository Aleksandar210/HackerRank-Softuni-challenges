package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IllformedLocaleException;

public class SongArtist {

    //fields
    private String name;
    private int[] totalTimeOfSongs;     //hour:minutes:seconds
    private HashMap<String,String> currentSongs;        //with duration in String

    public SongArtist(String name){
    this.currentSongs = new HashMap<>();
    this.setName(name);
    }

    private void setName(String name){
        if(name!=null && name.trim().isEmpty()){
            if(name.length()>=3 && name.length()<=20){
                this.name = name;
            }else{
                throw new IllegalArgumentException("Illegal name length.");
            }
        }else{
            throw new NullPointerException("Illegal name state.");
        }
    }

    public String getName(){
        return this.name;
    }

    public String getTotalTimeOfSongs(){
        return this.totalTimeOfSongs;
    }

    private boolean validateSongName(String songName){
        if(name!=null && name.trim().isEmpty()){
            if(name.length()>=3 && name.length()<=30){
            return true;
            }else{
                throw new IllegalArgumentException("Illegal name length.")
            }
        }else{
            throw new NullPointerException("Illegal name state.");
        }

    }

    private boolean validateDuration(String duration){
        int[] timeParts = Arrays.stream(duration.split(":")).mapToInt(Integer::parseInt).toArray();
        int hour = timeParts[0];
        int minutes = timeParts[1];
        int seconds = timeParts[2];

        //d valdiation here

        return false;

    }

    public void addSong(String songName, String duration){
    if(this.validateSongName(songName)){

    }else{
        throw new IllegalArgumentException("Illegal song state.");
    }


    }

    private void addToTotalTime(int...hourMinuteSecond){

    }


}

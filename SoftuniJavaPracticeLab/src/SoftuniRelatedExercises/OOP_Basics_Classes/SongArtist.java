package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.util.Arrays;
import java.util.HashMap;

public class SongArtist {

    private final String Default_Song_Time = "00:00:00";

    //fields
    private String name;
    private String totalTimeOfSongs;
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
                throw new IllegalArgumentException("Illegal name length.")
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

    }

    public void addSong(String songName, String duration){

    }


}

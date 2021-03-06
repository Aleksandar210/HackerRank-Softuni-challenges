package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.IllformedLocaleException;

public class SongArtist {
    //resources
    private StringBuilder sb;

    //constants
    private final int Default_Number_Songs = 0;

    //fields
    private String name;
    private int numberOfSongs;
    private int[] totalTimeOfSongs;     //hour:minutes:seconds
    private HashMap<String,String> currentSongs;        //with duration in String

    public SongArtist(String name){
        this.numberOfSongs = this.Default_Number_Songs;
    this.currentSongs = new HashMap<>();
    this.sb = new StringBuilder();
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

    public int getNumberSongs(){
        return this.numberOfSongs;
    }

    public String getTotalTimeOfSongs(){
       return String.format("%d:%d:%d",this.totalTimeOfSongs[0],this.totalTimeOfSongs[1],this.totalTimeOfSongs[2]);
    }

    private boolean validateSongName(String songName){
        if(name!=null && name.trim().isEmpty()){
            if(name.length()>=3 && name.length()<=30){
            return true;
            }else{
                throw new IllegalArgumentException("Illegal name length.");
            }
        }else{
            throw new NullPointerException("Illegal name state.");
        }

    }

    private boolean validateDuration(String duration){
        int hour;
        int minutes;
        int seconds;
        int[] timeParts = Arrays.stream(duration.split(":")).mapToInt(Integer::parseInt).toArray();
        if(timeParts.length==2){
            minutes = timeParts[0];
            seconds = timeParts[1];
            hour = 0;
        }else if(timeParts.length==3){
            minutes = timeParts[1];
            seconds = timeParts[2];
            hour = timeParts[0];
        }else{
            seconds= timeParts[0];
            minutes = 0;
            hour = 0;
        }

        if(hour<0 || (minutes<0 || minutes>59) || (seconds<0|| seconds>59)){
            throw new IllegalArgumentException("Illegal length state.");
        }else{
        return true;
        }

    }

    private int[] getTimePartsOfDuration(String duration){
        int hour;
        int minutes;
        int seconds;
        int[] timeParts = Arrays.stream(duration.split(":")).mapToInt(Integer::parseInt).toArray();
        if(timeParts.length==2){
            minutes = timeParts[0];
            seconds = timeParts[1];
            hour = 0;
        }else if(timeParts.length==3){
            minutes = timeParts[1];
            seconds = timeParts[2];
            hour = timeParts[0];
        }else{
            seconds= timeParts[0];
            minutes = 0;
            hour = 0;
        }

        return timeParts;
    }

    public void addSong(String songName, String duration){
    if(this.validateSongName(songName)){
    if(this.validateDuration(duration)){
        if(this.currentSongs.containsKey(songName)){
            throw new IllegalArgumentException("Song already in playlist.");
        }else{
            this.currentSongs.put(songName,duration);
            this.addToTotalTime(this.getTimePartsOfDuration(duration));
            this.sb.append(songName+" - "+duration+System.lineSeparator());
        }

    }
    }else{
        throw new IllegalArgumentException("Illegal song state.");
    }

    }

    public void removeSong(String songName){
        if(this.currentSongs.containsKey(songName)){
            this.currentSongs.remove(songName);
        }else{
            throw new IllegalArgumentException("No song found.");
        }
    }

    private void addToTotalTime(int...hourMinuteSecond){
        if(hourMinuteSecond[2]+this.totalTimeOfSongs[2]>59){
            this.totalTimeOfSongs[2]=hourMinuteSecond[2]-this.totalTimeOfSongs[2];
            this.addMinutes(1);
        }
        this.addMinutes(hourMinuteSecond[1]);
    this.totalTimeOfSongs[0]+=hourMinuteSecond[0];
    }

    private void addMinutes(int minutesToAdd){
        this.totalTimeOfSongs[1]+=minutesToAdd;
        if(this.totalTimeOfSongs[1]>59){
            this.totalTimeOfSongs[1]-=60;       //the most simple way got to improve it
            this.totalTimeOfSongs[0]+=1;
        }
    }

    @Override
    public String toString(){
        return this.sb.toString();
    }


}

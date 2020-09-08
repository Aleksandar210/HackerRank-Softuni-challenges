package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.util.HashMap;

public class RadioDataBase {
    //resources
    private StringBuilder sb;

    //constants
    private final int Default_Number_Songs = 0;
    private final int Default_Number_Artists = 0;

    //fields
    private int numberSongs;
    private int numberArtists;
    private HashMap<String,SongArtist> currentArtistsInDataBase;

    public RadioDataBase(){
        this.numberArtists = this.Default_Number_Artists;
        this.numberSongs = this.Default_Number_Songs;
        this.currentArtistsInDataBase = new HashMap<>();
    }

    private void addEntry(String artistName,String songName,String duration){
        SongArtist currentArtistToAdd;
        if(this.currentArtistsInDataBase.containsKey(artistName)){
            this.currentArtistsInDataBase.get(artistName).addSong(songName,duration);
        }else{
            currentArtistToAdd = new SongArtist(artistName);
            this.currentArtistsInDataBase.get(artistName).addSong(songName,duration);
        }
    }

    private void removeEntry(String artistName){
        if(this.currentArtistsInDataBase.containsKey(artistName)){
            this.currentArtistsInDataBase.get(artistName).removeSong();
        }
    }

    private String getArtistPlaylist(String artistName){

        return null;
    }
}

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

    public void addEntry(String artistName,String songName,String duration){
        SongArtist currentArtistToAdd;
        if(this.currentArtistsInDataBase.containsKey(artistName)){
            this.currentArtistsInDataBase.get(artistName).addSong(songName,duration);
        }else{
            currentArtistToAdd = new SongArtist(artistName);
            this.currentArtistsInDataBase.get(artistName).addSong(songName,duration);
        }
        this.numberSongs++;
        this.numberArtists++;
    }



    public void removeSongEntry(String artistName,String songName){
        if(this.currentArtistsInDataBase.containsKey(artistName)){
            this.currentArtistsInDataBase.get(artistName).removeSong(songName);
        }
        this.numberSongs--;
    }

    public void removeArtistEntry(String artistName){
        this.numberSongs-=this.currentArtistsInDataBase.get(artistName).getNumberSongs();
        if(this.currentArtistsInDataBase.containsKey(artistName)){
            this.currentArtistsInDataBase.remove(artistName);
        }
        this.numberArtists--;
    }

    public String getArtistPlaylist(String artistName){
        if(this.currentArtistsInDataBase.containsKey(artistName)){
            return this.currentArtistsInDataBase.get(artistName).toString();
        }else{
            throw new IllegalArgumentException("No artist found.");
        }
    }





    @Override
    public String toString(){
        for(SongArtist artist:this.currentArtistsInDataBase.values()){
            this.sb.append(artist.getName()+"'s playlist length is: "+artist.getTotalTimeOfSongs()+
                    System.lineSeparator()+"Songs: "+System.lineSeparator());
            this.sb.append(artist);
        }
        return this.sb.toString();
    }
}

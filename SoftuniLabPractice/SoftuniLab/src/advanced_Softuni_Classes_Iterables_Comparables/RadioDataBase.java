package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadioDataBase {
 private	Map<String,Song> songs;
	private  List<Song> sortedSongs;
	private Deque<Song> lastAddedSong;
	private int playlistLengthMinutes;
	private int playListLengthHours;
	private int playListLengthSeconds;
	private String length;
	
	public RadioDataBase() {
		this.songs = new HashMap<>();
		this.sortedSongs = new ArrayList<Song>();
		lastAddedSong = new ArrayDeque<Song>();
	}
	
	public void addSong(String songInfo) {
		try {
			String[] temp = songInfo.split(";");
			Song currentSong = new Song(temp[0],temp[1],temp[2]);
			if(songs.containsKey(currentSong.getName())) {
				
			}else {
			songs.put(currentSong.getName(), currentSong);
			sortedSongs.add(currentSong);
			lastAddedSong.push(currentSong);
			if(sortedSongs.size()==0) {
			
			}else {
				Collections.sort(sortedSongs);
			}
			}
			
		}catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private void calculateLength(Song newAddedSong) {
		
		if(this.sortedSongs.size()>1) {
			this.playListLengthSeconds = newAddedSong.getSeconds()+this.lastAddedSong.peek().getSeconds();
			this.playlistLengthMinutes = newAddedSong.getMinutes()+this.lastAddedSong.peek().getMinutes();
			if(this.playListLengthSeconds>59) {
				this.playListLengthSeconds-=59;
				this.playlistLengthMinutes+=1;
			}
			if(this.playlistLengthMinutes>59) {
				this.playlistLengthMinutes-=59;
				this.playListLengthHours+=1;
			}

		}
	}
	
	public String getLength() {
		this.length = String.format("%d.%d.%d",this.playListLengthHours,this.playlistLengthMinutes,this.playListLengthSeconds);
		return this.length;
	}

}

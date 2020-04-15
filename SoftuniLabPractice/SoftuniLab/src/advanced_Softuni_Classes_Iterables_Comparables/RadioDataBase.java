package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RadioDataBase {
	Map<String,Song> songs;
	List<Song> sortedSongs;
	
	public RadioDataBase() {
		this.songs = new HashMap<>();
		this.sortedSongs = new ArrayList<Song>();
	}
	
	public void addSong(String songInfo) {
		
	}

}

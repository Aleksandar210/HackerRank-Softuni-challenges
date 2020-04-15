package advanced_Softuni_Classes_Iterables_Comparables;

public class Song implements Comparable<Song> {
private String name;
private String artist;
private int minutes;
private int seconds;

public Song(String artist,String name,String duration) {
	setArtist(artist);
	setName(name);
	setDuration(duration);
}




@Override
public String toString() {
	return "Song [name=" + name + ", artist=" + artist + ", minutes=" + minutes + ", seconds=" + seconds + "]";
}




public String getName() {
	return name;
}

public String getArtist() {
	
	return artist;
}

public int getMinutes() {
	return minutes;
}
public int getSeconds() {
	return seconds;
}

private void setName(String name) {
	if(artist.length()<3 || artist.length()>30) {
		throw new IllegalArgumentException("Artist name shoudl be between 3 and 30 symbols");
	}
	this.name = name;
}

private void setArtist(String artist) {
	if(artist.length()<3 || artist.length()>20) {
		throw new IllegalArgumentException("Artist name shoudl be between 3 and 20 symbols");
	}
	this.artist = artist;
}

private void setMinutes(int minutes) {
	if(minutes<0 || minutes>14) {
		throw new IllegalArgumentException("Invalid length");
	}
	this.minutes = minutes;
}

private void setSeconds(int seconds) {
	if(minutes<0 || minutes>59) {
		throw new IllegalArgumentException("Invalid length");
	}
	
	this.seconds = seconds;
}

private void setDuration(String duration) {
	setMinutes(Integer.parseInt(duration.split(":")[0]));
	setSeconds(Integer.parseInt(duration.split(":")[1]));
		
	
}




@Override
public int compareTo(Song o) {
	if(this.getArtist().compareTo(o.getArtist())==0) {
		if(this.getName().compareTo(o.getName())==0) {
		if(Integer.compare(this.getMinutes(), o.getMinutes())==0) {
			if(Integer.compare(this.getSeconds(),o.getSeconds())==0) {
				return 0;
			}else {
				return Integer.compare(this.getSeconds(), o.getSeconds());
			}
		}else {
			return Integer.compare(this.getMinutes(), o.getMinutes());
		}
		}else {
			return this.getName().compareTo(o.getName());
		}
	}else {
		return this.getArtist().compareTo(o.getArtist());
	}
	
}
}

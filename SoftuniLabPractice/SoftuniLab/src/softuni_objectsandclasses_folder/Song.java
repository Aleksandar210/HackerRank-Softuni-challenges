package softuni_objectsandclasses_folder;

public class Song {
	private String type;
	private String name;
	private String duration;
	
	public Song(String n, String m, String k ) {
		this.type = n;
		this.name = m;
		this.duration = k;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getType() {
		return this.type;
	}

}

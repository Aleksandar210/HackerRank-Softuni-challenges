package softuni_objectsandclasses_folder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class AdvertiseMessage {
	private final ArrayList<String> phraseList = new ArrayList<String>(Arrays.asList("Excellent product","Such a great product","I always use that product","Best prouct of its category","Exceptional product","I cant live without taht product"));
	private final ArrayList<String> eventList = new ArrayList<String>(Arrays.asList("Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."));
	private final ArrayList<String> authorList = new ArrayList<String>(Arrays.asList("Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"));
	private final ArrayList<String> cityList = new ArrayList<String>(Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"));
	
	private String phrase;
	private String event;
	private String author;
	private String city;
	
	public AdvertiseMessage() {
		Random rand = new Random();
		
		int generatePhrase = rand.nextInt(phraseList.size());
		this.phrase = phraseList.get(generatePhrase);
		
		int generateEvent = rand.nextInt(eventList.size());
		this.event = eventList.get(generateEvent);
		
		int generateAuthor = rand.nextInt(authorList.size());
		this.author = authorList.get(generateAuthor);
		
		int generateCity = rand.nextInt(cityList.size());
		this.city = cityList.get(generateCity);
	}
	
	public void displayMessage() {
		System.out.printf("%s.%s.%s-%s", this.phrase, this.event,this.author,this.city);
	}
	
	

}

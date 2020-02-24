import java.util.ArrayList;

public class CalorieIndex {
	private ArrayList<Integer> candies;
	private int index;
	private int count;
	
	
	public CalorieIndex(int number, ArrayList<Integer> candies) {
		this.index = number;
		
		if(candies ==null) {
			this.candies = new ArrayList<Integer>();
		}else {
		this.candies = new ArrayList<Integer>(candies);
		}
		
		this.count = candies.size();
	}
	
	
	public CalorieIndex() {
		
	}
	
	

	
	
	public ArrayList<Integer> getCandies() {
		return candies;
	}

	public void setCandies(ArrayList<Integer> candies) {
		this.candies = candies;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	
	public void show() {

		System.out.println(this.candies);
	}
	
	

	

}

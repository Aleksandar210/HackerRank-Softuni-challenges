package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.Iterator;

public class Clinic implements Iterable<Pet> {
	private String name;
	
	
	
	
	private static  int CENTERED_INDEX;
	private static int RIGHT=CENTERED_INDEX;
	private static int LEFT = CENTERED_INDEX;
	private Pet[] rooms;

	
	public Clinic(String name, int roomsCount) {
		assignRooms(roomsCount);
			setName(name);
			this.rooms = new Pet[5];
		
		
		
		
	}
	
	static void assignRooms(int count) {
			CENTERED_INDEX=count;
	}
	
	@Override
	public Iterator<Pet> iterator() {
		ClinicIter clinicIter = new ClinicIter();
		
		return clinicIter;
	}
	
	public void add(Pet pet) {
		if(rooms.length==0) {
			rooms[3] = pet;
		}else if(this.rooms.length<5 && this.rooms.length>0) {
			while(!(RIGHT>this.rooms.length) || !(LEFT<0)) {
				RIGHT=RIGHT+1;
				LEFT=LEFT-1;
				if(this.rooms[RIGHT]!=null) {
					this.rooms[RIGHT] = pet;
					break;
				}else if(this.rooms[LEFT]!=null) {
					this.rooms[LEFT] = pet;
					break;
				}
			}
		}else {
			System.out.println("No Rooms in "+getName()+" CLINIC");
		}
	}
	
	public boolean release() {
		boolean hasBeenRelease = false;
		while(!hasBeenRelease) {
			if(this.rooms.length==0) {
			return false;
			}else {
				if(this.rooms[LEFT]!=null) {
					this.rooms[LEFT]=null;
					hasBeenRelease =true;
					LEFT++;
				}else {
					LEFT+=1;
					if(this.rooms[RIGHT]!=null) {
						this.rooms[RIGHT]=null;
						RIGHT--;
						hasBeenRelease = true;
					}else {
						RIGHT--;
					}
				}
			}
		}
		
		return false;
			
		
	}
	
	
	public void print(int index) {
		if(this.rooms[index]==null) {
			
		}else {
		System.out.println(this.rooms[index]);
		}
	}
	
	public boolean hasEmptyRooms() {
		if(this.rooms.length==5) {
			return false;
		}else {
			return true;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	private class ClinicIter implements Iterator<Pet>{
		int index = 0;

		@Override
		public boolean hasNext() {
			if(this.index<rooms.length) {
				return true;
			}
			return false;
		}

		@Override
		public Pet next() {
			return rooms[index++];
			
		}
	}

}

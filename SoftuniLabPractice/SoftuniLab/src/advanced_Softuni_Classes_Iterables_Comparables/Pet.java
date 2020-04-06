package advanced_Softuni_Classes_Iterables_Comparables;

public class Pet implements Comparable<Pet> {
	private int age;
	private String name;
	private String kind;
	
    public Pet(String name, int age, String kind) {
	setName(name);
	setAge(age);
	setKind(kind);
	}
    
    
    
    
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	@Override
	public boolean equals(Object other) {
		if(this==other) {
			return true;
		}
		
		if(other==null || this.getClass()!=other.getClass()) {
			return false;
		}
		
		Pet guest = (Pet)other;
		return (getKind()==guest.getKind()) &&
	              (getName()!=null && getName().equals(guest.getName())) &&
	              (getAge()!=0 && (getAge()==guest.getAge()));
	}
	
	@Override
	public int hashCode() {
		int result = 0;
		result=result*31+(getName()!=null? getName().hashCode():0);
		result=result*31+(getKind()!=null? getKind().hashCode():0);
		result=result*31+(getAge());
		return result;
	}
	


	@Override
	public int compareTo(Pet other) {
		if(getName().length()==other.getName().length()) {
			if(getName().compareTo(other.getName())==0) {
				if(getAge()==other.getAge()) {
					if(getKind().length()==other.getKind().length()) {
						if(getKind().compareTo(other.getKind())==0) {
							return 0;
						}else if(getKind().compareTo(other.getKind())<0) {
							return -1;
						}else {
							return 1;
						}
					}else {
						return getKind().length()-other.getKind().length();
					}
				}else{
					return getAge()-other.getAge();
				}
			}else if(getName().compareTo(other.getName())<0) {
				return -1;
			}else {
				return 1;
			}
		}else{
			return getName().length()-other.getName().length();
		}
		
	}

	

}

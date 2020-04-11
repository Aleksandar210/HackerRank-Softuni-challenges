package advanced_Softuni_Classes_Iterables_Comparables;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person implements Comparable<Person> {
	private static final double DEFAULT_SALARY = 0;
	private String name;
	
	private int age;
	private String town;
	private String firstName;
	private String lastName;
	private String mail;
	private double salary;
	private BankAccount bankAccount;
	
	
	public Person(String name,int age, String town) {
		setName(name);
		setAge(age);
		setTown(town);
		setSalary(DEFAULT_SALARY);
		setFirstName();
		setLastName();
	}
	
	public Person(String name,int age) {
		setName(name);
		setAge(age);
		setSalary(DEFAULT_SALARY);
		setFirstName();
		setLastName();
	}
	
	public void connectToBankAccount(Map<Integer,BankAccount> accounts) {
		if(this.bankAccount == null) {
			boolean confirmed =false;
			int select;
			Scanner scan = new Scanner(System.in);
			do {
				
			System.out.println("Need to connect a Bank Account");
			System.out.println("1| Connect: ");
			System.out.println("2| Cancel");
			System.out.println("Select: ");
			select = Integer.parseInt(scan.nextLine());
			}while(!confirmed);
			switch(select) {
			case 1:
				System.out.println("Seelct Account Id: ");
				for(Map.Entry<Integer, BankAccount> entry:accounts.entrySet()) {
					System.out.println(entry.getKey()+" "+entry.getValue().getName());
				}
				boolean temp = false;
				while(!temp) {
				int pickAccount = Integer.parseInt(scan.nextLine());
				if(accounts.get(pickAccount).getName().compareTo(this.getName())==0) {
					temp=true;
				}
				}
				break;
				
			case 2:
				return;
				
			}
		}else {
			
			
		}
		
	}
	
	
	public void increaseSalary(double increaseBy) {
		if(increaseBy<0) {
			return;
		}else {
			if(this.getAge()<30) {
				this.setSalary(this.getSalary()+(increaseBy/=2));
			}else {
			this.setSalary(this.getSalary()+increaseBy);
			}
		}
		
		
	}
	
	public String getFirstName() {
		if(this.firstName.isEmpty()) {
			throw new NullPointerException("No first name found");
		}else {
			return this.firstName;
		}
	}
	
	public String getLastName() {
		if(this.lastName.isEmpty()) {
			throw new NullPointerException("No last name found");
		}else {
			return this.lastName;
		}
	}
	
	
	public void setBankAccount(BankAccount currentAcc) {
		this.bankAccount = currentAcc;
	}

	
	private void setFirstName() {
		if(this.getName().contains("\\s+")) {
		this.firstName = this.getName().split("\\s+")[0];
		}else {
			
		}
		
	}
	
	public void setLastName() {
		if(this.getName().contains("\\+s")) {
			this.lastName = this.getName().split("\\s+")[1];
		}else {
			
		}
	}
	
	public void setMail(String mail) {
		String regex = "[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@\r\n" + 
				"[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
		Pattern mailPattern = Pattern.compile(regex);
		Matcher match = mailPattern.matcher(mail);
		if(match.find()) {
		this.mail = mail;
		}else {
			throw new IllegalArgumentException("E-Mial is incorect format");
		}
	}
	
	public String getMail() {
		return this.mail;
	}
	
	
	
	public double getSalary() {
		if(this.bankAccount==null) {
			System.out.println("Need to add Bank Account!");
			return 0;
		}else {
		return this.salary;
		}
	}
	
	public void setSalary(double salary) {
		
	this.salary = salary;
	}
	
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTown() {
		return this.town;
	}
	public void setTown(String town) {
		this.town = town;
	}


	@Override
	public int compareTo(Person o) {
		
		if(!getTown().isEmpty()) {
		
		if(getName().length()==o.getName().length()) {
			if(getName().compareTo(o.getName())==0) {
			if(getAge()==o.getAge()) {
				if(getTown().compareTo(o.getTown())==0) {
					return 0;
				}else if(getTown().compareTo(o.getTown())<0) {
					return -1;
				}else {
					return 1;
				}
			}else {
				return getAge()-o.getAge();
			}
			}else if(getName().compareTo(o.getName())<0) {
				return -1;
			}else {
				return 1;
			}
		}else {
			return getName().length()-o.getName().length();
		}
		
		}else {
			if(this.getName().length()==o.getName().length()) {
				if(this.getName().compareTo(o.getName())==0) {
					if(this.getAge()==o.getAge()) {
						return 0;
					}else {
						return this.getAge()-o.getAge();
					}
				}else {
					return this.getName().compareTo(o.getName());
					}
				}
			}
		
		return 0;
		
		}
	}
	
	



import java.math.BigInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import softuni_objectsandclasses_folder.Song;
import softuni_objectsandclasses_folder.Student;
import softuni_objectsandclasses_folder.AdvertiseMessage;
import softuni_objectsandclasses_folder.Article;
import softuni_objectsandclasses_folder.Person;
import softuni_objectsandclasses_folder.Employe;
import softuni_objectsandclasses_folder.Department;
public class ObjectsAndClasses {
	static Scanner scan  =new Scanner(System.in);
	public static void main(String[] args) {
		//scrambleRandom();
		//twoSums();
		//song();
		//student();
		//advertiseMessage();
		//Article();
		//personAbove30();
		//ArticleModed();
		//studentWithGrades();
		//employe();
		
	}
	
	static void employe() {
		int numberEmployes = Integer.parseInt(scan.nextLine());
		ArrayList<Employe> employes = new ArrayList<Employe>(numberEmployes);
		ArrayList<Department> departments = new ArrayList<Department>();
		int departmentsIndex =-1;
		while(numberEmployes>0) {
			String enterData = scan.nextLine();
			String[] splitedData = enterData.split(" ");
			if(splitedData.length==6) {
				if(departments.size()==0) {
				Employe emp = new Employe(splitedData[0],Double.parseDouble(splitedData[1]),splitedData[2],splitedData[3],Integer.parseInt(splitedData[4]),splitedData[5]);
				employes.add(emp);
				Department dep = new Department(emp.getDepartment(),emp.getSalary());
				departments.add(dep);
				departmentsIndex++;
				}else {
					Employe emp = new Employe(splitedData[0],Double.parseDouble(splitedData[1]),splitedData[2],splitedData[3],Integer.parseInt(splitedData[4]),splitedData[5]);
					employes.add(emp);
					if(!emp.getDepartment().equalsIgnoreCase(departments.get(departmentsIndex).name)) {
						Department dep = new Department(emp.getDepartment(),emp.getSalary());
						departments.add(dep);
						departmentsIndex++;
					}
				}
			}else {
				if(departments.size()==0) {
					Employe emp = new Employe(splitedData[0],Double.parseDouble(splitedData[1]),splitedData[2],splitedData[3],splitedData[4]);
					employes.add(emp);
					Department dep = new Department(emp.getDepartment(),emp.getSalary());
					departments.add(dep);
					departmentsIndex++;
					}else {
						Employe emp = new Employe(splitedData[0],Double.parseDouble(splitedData[1]),splitedData[2],splitedData[3],splitedData[4]);
						employes.add(emp);
						if(!emp.getDepartment().equalsIgnoreCase(departments.get(departmentsIndex).name)) {
							Department dep = new Department(emp.getDepartment(),emp.getSalary());
							departments.add(dep);
							departmentsIndex++;
						}
					}
			}
			numberEmployes--;
		}
		
		
		
		for(int i =0;i<departments.size();i++) {
			double sum = 0;
			int count=0;
			for(int j =0;j<employes.size();j++) {
				if(departments.get(i).name.equalsIgnoreCase(employes.get(j).getDepartment())) {
					sum+=employes.get(j).getSalary();
					count++;
				}
			}
			sum/=count;
			departments.get(i).averageSalaryOfEmployes=sum;
			
		}
		
		String largesAverageSalary = departmentWithLargestAverageSalay(departments);
		
		for(Employe emp: employes) {
			if(emp.getDepartment().equalsIgnoreCase(largesAverageSalary)) {
				System.out.println(emp);
			}
		}
		
		
		
	}
	static String departmentWithLargestAverageSalay(ArrayList<Department> dep) {
		double max = dep.get(0).averageSalaryOfEmployes;
		String name = dep.get(0).name;
		for(int i =1;i<=dep.size();i++) {
			if(dep.get(i).averageSalaryOfEmployes>max);
			max = dep.get(i).averageSalaryOfEmployes;
			name = dep.get(i).name;
		}
		return name;
	}
	
	static void studentWithGrades() {
		int number = Integer.parseInt(scan.nextLine());
		ArrayList<Student> students= new ArrayList<Student>(number);
		while(number>0) {
		String enterStudentData = scan.nextLine();
		String[] data = enterStudentData.split(" ");
		Student stud = new Student(data[0],data[1],Double.parseDouble(data[2]));
		students.add(stud);
		number--;
		}
		
		compareGrades(students);
		
		for(Student stud: students) {
			System.out.println(stud);
		}
		
	}
	
	static void compareGrades(ArrayList<Student> studs) {
		Student temp = new Student();
		for(int i =0;i<studs.size()-1;i++) {
			if(studs.get(i).getGrade()<studs.get(i+1).getGrade()) {
				temp = studs.get(i);
				studs.set(i,studs.get(i+1));
				studs.set(i+1, temp);
			}
		}
	}
	
	static void articleModed() {
		int numberArticles = Integer.parseInt(scan.nextLine());
		ArrayList<Article> articles= new ArrayList<Article>(numberArticles);
		while(numberArticles>0) {
		String enter = scan.nextLine();
		String[] fieldsToEnter = enter.split(",");
		Article article = new Article(fieldsToEnter[0],fieldsToEnter[1],fieldsToEnter[2]);
		articles.add(article);
		}
		String orderBy = scan.nextLine();
		switch(orderBy.toLowerCase()) {
		case "title":
			for(int i =0;i<articles.size()-1;i++) {
				String first = articles.get(i).getTitle();
				String second = articles.get(i+1).getTitle();
				if(compareStrings(first, second, i)==1) {
					Article currentArticle= new Article();
					currentArticle = articles.get(i+1);
					articles.set(i+1,articles.get(i));
					articles.set(i, currentArticle);
				}
			}
			break;
		case "author":
			
			for(int i =0;i<articles.size()-1;i++) {
				String first = articles.get(i).getAuthor();
				String second = articles.get(i+1).getAuthor();
				if(compareStrings(first, second, i)==1) {
					Article currentArticle = new Article();
					currentArticle = articles.get(i+1);
					articles.set(i+1,articles.get(i));
					articles.set(i, currentArticle);
				}
			}
			break;
			
		case "content":
			for(int i =0;i<articles.size()-1;i++) {
				String first = articles.get(i).getContent();
				String second = articles.get(i+1).getContent();
				if(compareStrings(first, second, i)==1) {
					Article currentArticle= new Article();
					currentArticle = articles.get(i+1);
					articles.set(i+1,articles.get(i));
					articles.set(i, currentArticle);
				}
			}
			break;
			
		}
		
		for(Article article:articles) {
			System.out.println(article);
		}
		
		
		
	
	}
	static int compareStrings(String first, String second, int atChar) {
	  int returnValue = 0;
		if(first.toLowerCase().charAt(atChar)<first.toLowerCase().charAt(atChar)) {
			
		}else if(first.toLowerCase().charAt(atChar)>first.toLowerCase().charAt(atChar)) {
			returnValue = 1;
		}else {
			compareStrings(first, second,atChar+1);
		}
		
		return returnValue;
	}
	
	static void personAbove30() {
		int numberPeople = Integer.parseInt(scan.nextLine());
		ArrayList<Person> people = new ArrayList<Person>(numberPeople);
		while(numberPeople>0) {
			String enterInformation = scan.nextLine();
			String[] splitedEnter = enterInformation.split(" ");
			Person person  = new Person(splitedEnter[0],Integer.parseInt(splitedEnter[1]));
			if(Integer.parseInt(splitedEnter[1])>30) {
				people.add(person);
			}
				
		numberPeople--;
		}
		
		for(Person person:people) {
			System.out.println(person);
		}
	}
	
	static void Article() {
		String enter = scan.nextLine();
		String[] fieldsToEnter = enter.split(",");
		Article article = new Article(fieldsToEnter[0],fieldsToEnter[1],fieldsToEnter[2]);
		int numberCommands = Integer.parseInt(scan.nextLine());
		while(numberCommands>0) {
			String enterCommand = scan.nextLine();
			String[] splitedEnter  =enterCommand.split(":");
			switch(splitedEnter[0].toLowerCase()) {
			case "edit":
				article.edit(scan.nextLine());
				numberCommands--;
				break;
			case "changeauthor":
				article.changeAuthor(scan.nextLine());
				numberCommands--;
				break;
			case "rename":
				article.rename(scan.nextLine());
				numberCommands--;
				break;
			}
		}
		System.out.println(article);
	}
	
	static void advertiseMessage() {
		int numberOfMessages = Integer.parseInt(scan.nextLine());
		ArrayList<AdvertiseMessage> messages = new ArrayList<AdvertiseMessage>(numberOfMessages);
		for(int i =0;i<numberOfMessages;i++) {
			messages.add(new AdvertiseMessage());
		}
		
		for(AdvertiseMessage message:messages) {
			message.displayMessage();
		}
	}
	
	static void student() {
		String enterStudentData;
		ArrayList<Student> students = new ArrayList<Student>();
		do {
			enterStudentData= scan.nextLine();
			String[] temp = enterStudentData.split(" ");
			if(doesStudentExist(students,temp[0],temp[1])) {
				
				changeName(temp);
				
			}else {
			Student student = new Student(temp[0],temp[1],Integer.parseInt(temp[2]), temp[3]);
			students.add(student);
			}
			
		}while(!enterStudentData.equals("end"));
		
		String enterTown = scan.nextLine();
			for(Student student: students) {
				if(student.getTown().equalsIgnoreCase(enterTown)) {
					System.out.println(student.displayStudentInfo());
				}
			}
	}
	static boolean doesStudentExist(ArrayList<Student>students, String firstName, String lastName) {
		boolean doesExist=false;
		
		
		if(students.size()==0) {
			return false;
		}
		
		for(Student student:students) {
			if(student.getName().equalsIgnoreCase(firstName+" "+lastName)) {
				return true;
			}
		}
		return doesExist;
	}
	
	static void changeName(String[] studentData) {
		System.out.println("Student exists!");
		System.out.print("change first name: ");
		String firstName =scan.nextLine();
		System.out.print("change last name: ");
		String lastName = scan.nextLine();
		
		if(firstName.equalsIgnoreCase(studentData[0])&& lastName.equalsIgnoreCase(studentData[1])) {
			changeName(studentData);
		}
	
		
		
		
	}
	
	static void song() {
		int numberSongs = Integer.parseInt(scan.nextLine());
		ArrayList<Song> songs = new ArrayList<Song>(numberSongs);
		
		while(songs.size()<numberSongs) {
		String enterSongData = scan.nextLine();
		String[] temp = enterSongData.split("_");
		Song song = new Song(temp[0], temp[1],temp[2]);
		songs.add(song);
	}
		String type =scan.nextLine();
		if(type.equalsIgnoreCase("all")) {
			for(Song song:songs) {
				System.out.println(song.getName());
			}
		}else {
		for(Song song:songs) {
			if(song.getType().equalsIgnoreCase(type)) {
				System.out.println(song.getName());
			}
		}
		}
	}
	
	
	static void twoSums() {
		
		BigInteger number1 = new BigInteger(scan.nextLine());
		BigInteger number2 = new BigInteger(scan.nextLine());
		BigInteger result = number1.add(number2);
		System.out.println(result);
		
		
	}
	
	


	static void scrambleRandom() {
		
		String enterWords = scan.nextLine();
		ArrayList<String> words = randomiseWordsInList(enterWords);
		for(String word: words) {
			System.out.println(word);
		}
	}
	
	static ArrayList<String> randomiseWordsInList(String words){
		String[] array = words.split(" ");
		
		ArrayList<String> temp = new ArrayList<String>(Arrays.asList(array));
		Collections.shuffle(temp);
		return temp;
		
		}
		
	
	
	
	
	//tool
		static ArrayList<String> enterWordsList(String words){
			String[] array = words.split(" ");
			ArrayList<String> temp = new ArrayList<String>(Arrays.asList(array));
			return temp;
		}
		
		static ArrayList<Integer> parseLineList(String enter){
			String[] temp = enter.split(" ");
			ArrayList<Integer> list = new ArrayList<Integer>(temp.length);
			for(int i =0;i<list.size();i++) {
				list.add(Integer.parseInt(temp[i]));
			}
			return list;
		}

}

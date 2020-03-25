package advanced_Softuni;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

import javafx.scene.shape.Path;



public class Files_Streams {
	static String path = "D:\\FileFolder";
	public static void main(String[] args) {
		//displayFileInformation();
		//transferDataBetween();
		//transferBites();
		//readThirdLine()
		//readThirdLine();
	    //transferModifiedData();
		//extractIntgers();
		//extractIntegers()
		//printFodlerInfo();
		//sortTheContent()
		//sumOfLine();
		//sumOfLine();
		//sumOfBytes();
		//sumOfBytes();
		//changeCase();
		
	}
	
	
	
	
	
	static void changeCase() {
		String readFile = "\\fileRead.txt";
		String writeFile = "\\fileWrite.txt";
		
		try(BufferedReader bfr = new BufferedReader(new FileReader(path+readFile));
				PrintWriter pw = new PrintWriter(new FileWriter(path+writeFile))){
			
			String line = bfr.readLine();
			while(line != null) {
				line = line.toUpperCase();
				pw.println(line);
				line = bfr.readLine();
				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	static void sumOfBytes() {
		String readFrom = "\\readFile.txt";
		java.nio.file.Path pathster = Paths.get(path+readFrom);
		try {
			
			byte[] byteSum = Files.readAllBytes(pathster);
			String temp = String.join("", String.valueOf(byteSum));
			System.out.println(Long.parseLong(temp));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
	}
	
	
	
	
	
	
	
	static void sumOfLine() {
		String readFile = "\\readFile.txt";
	
		try(BufferedReader bfr = new BufferedReader(new FileReader(path+readFile))){
			String line = bfr.readLine();
			while(line !=null) {
				System.out.println(line+" "+getSum(line));
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
	static long getSum(String line) {
		 long sum=0;
		for(int i =0;i<line.length();i++) {
			sum+=line.charAt(i);
		}
		return sum;
	}

	
	
	
	
	
	//skeleton
	/*static void listFolders() {
		Path filePath = Paths.get(someStringWithPath);
	File mainFile = new File();
	PrintWriter pw = new PrintWriter(new FilOutputStream(stringPath)); //with blocks
	Files[] filesListed mainFile.listFiles();
	for(int i =0;i<filesListed.length;i++) {
		if(!filesListed[i].isDirectory()) {
			String printThis = String.valueOf(filesListed[i].length());
			
			pw.println(printThis);
		}
	}
	}
	*/
		
	
	
	
	
	


	
	
	static void sortTheContent() {
		String readFrom = "\\readFile.txt";
		String writeTo = "\\writeFile.txt";
		java.nio.file.Path pathster = Paths.get(path+readFrom);
		java.nio.file.Path pathTo = Paths.get(path+writeTo);
		
		try {
			java.util.List<String> content = Files.readAllLines(pathster);
			content = content.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
			Files.write(pathTo,content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	
	}
	
	
	
	
	static void extractIntegers() {
		String readFrom ="\\readFile.txt";
		String writeFile = "\\writeFile.txt";
		try(Scanner currentScan = new Scanner(new FileInputStream(path+readFrom));
				PrintWriter pw = new PrintWriter(new FileOutputStream(path+writeFile))){
			
			while(currentScan.hasNext()) {
				if(currentScan.hasNextInt()) {
					pw.println(currentScan.nextInt());
					
				}
				currentScan.next();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (@SuppressWarnings("hiding") IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	static void readThirdLine() {
		String writeFile = "\\writeFile.txt";
		String readFile = "\\readFile.txt";
		java.nio.file.Path readFrom = Paths.get(path+readFile);
		java.nio.file.Path writeTo = Paths.get(path+writeFile);
		
		try(BufferedReader bfr =  Files.newBufferedReader(readFrom);
				PrintWriter pw = new PrintWriter(Files.newBufferedWriter(writeTo))) {
			String readLines = bfr.readLine();
			int counter =1;
			while(readLines !=null) {
				if(counter%3==0) {
					pw.println(readLines);
				}
				readLines = bfr.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	
	
	
	
	
	
	
	static void transferBites() {
		String writeFile = "\\writeFile.txt";
		String readFile = "\\readFile.txt";
		
		try (FileInputStream fis = new FileInputStream(path+readFile);
				FileOutputStream fos = new FileOutputStream(path+writeFile)){
			
			int readB = fis.read();
			while(readB>-1) {
			if(readB == 10 || readB ==32) {
				fos.write(readB);
			}else {
				String getDigits = String.valueOf(readB);
				for(int i =0;i<getDigits.length();i++) {
					fos.write(getDigits.charAt(i));
				}
			}
			readB = fis.read();
			}
			
		} catch (FileNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	static void transferModifiedData() {
		String readFrom = "\\Read.txt";
		String writeFile = "\\Put.txt";
		//java.nio.file.Path getFileData = Paths.get(path+readFrom);
		//java.nio.file.Path putFileData = Paths.get(path+writeFile);
		
		try (BufferedReader  bfr = new BufferedReader(new FileReader(path+readFrom));
				PrintWriter pw = new PrintWriter(new FileWriter(path+writeFile))){
			
			String readLine = bfr.readLine();
			while(readLine!=null) {
				pw.println(readLine);
				readLine = bfr.readLine();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//------------------------------------------------------------------------------
	
	static void transferDataBetween() {
		String readFrom = "\\readFile.txt";
		String writeFile = "\\writeFile.txt";
		
		try(FileInputStream fis = new FileInputStream(path+readFrom);
				FileOutputStream fos = new FileOutputStream(path+writeFile)){
			
			int read = fis.read();
			while(read>-1) {
				fos.write(read);
				fis.read();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//------------------------------------------------------------------------------------
	
	
	static void displayFileInformation() {
		String fileName = "\\readFile.txt";
		try(FileInputStream fis = new FileInputStream(path+fileName)){
			int numberRead = fis.read();
			while(numberRead > -1) {
				System.out.print(numberRead);
				numberRead  = fis.read();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

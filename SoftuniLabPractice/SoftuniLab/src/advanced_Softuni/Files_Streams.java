package advanced_Softuni;

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
import java.util.Scanner;

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
		//
		//
		
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

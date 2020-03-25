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
import java.nio.file.Paths;



public class Files_Streams {
	static String path = "D:\\FileFolder";
	public static void main(String[] args) {
		//displayFileInformation();
		//transferDataBetween();
		//
		//
		//
	//	transferModifiedData();
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

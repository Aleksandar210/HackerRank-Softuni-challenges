package advanced_Softuni;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Files_Streams {
	static String path = "D:\\textFilesStreamsFiles";
	public static void main(String[] args) {
		//displayFileInformation();
		//transferDataBetween();
		
	}
	
	
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

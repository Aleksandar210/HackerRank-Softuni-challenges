package advanced_Softuni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Workshop_Tasks {
public static void main(String[] main) {
	//smartArray();
	//smartStack();
	//smartLinkedList();
	//
	//
}

static void smartArray() {
	SmartArray  sa = new SmartArray();
	
}

static void smartStack() {
	SmartStack ss = new SmartStack();
}

public void smartLinkedList() {
	SmartLinkedList sll = new SmartLinkedList();
}

public void customDoublyLinkedList() {
	CustomDoublyLinkedList cdll = new CustomDoublyLinkedList();
}





















static int getInt() {
	try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))){
		return Integer.parseInt( bfr.readLine());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return -1;
}


static double getDouble() {
	try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))){
		return Double.parseDouble( bfr.readLine());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return -1;
}


static String getString() {
	try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))){
		return bfr.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
}

}

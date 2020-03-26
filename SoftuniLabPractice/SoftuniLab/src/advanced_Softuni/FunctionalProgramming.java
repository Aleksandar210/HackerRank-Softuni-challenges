package advanced_Softuni;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalProgramming {
	public static void main(String[] args) {
		sortEvenNumbers();
		countUpperCase();
		
		
	}
	//-------------------------------------------------------------------------------
	static void countUpperCase() {
		Predicate<String> isUpperCase = e -> e.startsWith("[A-Z]");
		List<String> getUpperCase = Arrays.stream(getString().split(" "))
				.filter(isUpperCase).collect(Collectors.toList());
		System.out.println(getUpperCase.size());
		getUpperCase.forEach(e -> System.out.println());
	}
	//-------------------------------------------------------------------------------
	
	
	
	
	//-------------------------------------------------------------------------------
	static void sortEvenNumbers() {
		String getNumbers = getString();
		
		
		List<String> evenNumbers = Arrays.stream(getNumbers.split(", ")).map((e) -> Integer.parseInt(e))
				.filter(e -> e%2==0).map(e -> String.valueOf(e)).collect(Collectors.toList());
		
		System.out.println(String.join(",",evenNumbers));
		
		evenNumbers = evenNumbers.stream().map(e-> Integer.parseInt(e)).sorted((a,b) ->a.compareTo(b))
				.map(e ->String.valueOf(e)).collect(Collectors.toList());
		System.out.println(String.join(",", evenNumbers));
	}
	//-------------------------------------------------------------------------------
	
	
	
	
	
	
	
	//some bufferedReader experiments;
	//these functions may be used //reason they are here. it is said that the BufferedReader
	//is way faster than the Scanner and I want to try it out and start using it.
	//-------------------------------------------------------------------------------
	
	static String getString() {
		try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));) {
			String currentString = bfr.readLine();
			return currentString;
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (String) null;
	}

	
	
	
	@SuppressWarnings("null")
	static double getDouble() {
		try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));) {
			double number = Double.parseDouble(bfr.readLine());
			return number;
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Double) null;
	}
	
	
	
	@SuppressWarnings("null")
	static int getInt() {
		try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));) {
			int number = Integer.parseInt(bfr.readLine());
			return number;
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Integer) null;
	}
//---------------------------------------------------------------------------------------
}

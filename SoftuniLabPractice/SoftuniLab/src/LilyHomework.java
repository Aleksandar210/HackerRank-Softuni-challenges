import java.util.Scanner;

//HACKER RANK
public class LilyHomework {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String enterDigit = scan.nextLine();
	int[] digits = addElementsToArray(enterDigit);
	int count=0;
	while(isSorted(digits)==false) {
		int temp;
		if(digits[digits.length-1]<digits[0]) {
			temp=digits[0];
			digits[0]=digits[digits.length-1];
			digits[digits.length-1]=temp;
			count++;
		}
	}
	System.out.println(count);
	
}

static int[] addElementsToArray(String elem) {
	String[] data = elem.split(" ");
	int[] temp = new int[data.length];
	for(int i =0;i<data.length;i++) {
		temp[i]=Integer.parseInt(data[i]);
  }
	return temp;
 }

//check if array is sorted i natural order
static boolean isSorted(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
        if (array[i] > array[i + 1])
            return false;
    }
    return true;
}
}

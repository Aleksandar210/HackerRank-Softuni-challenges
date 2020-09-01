import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import sun.misc.FloatingDecimal;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Scanner scan = new Scanner(System.in);   //the scanner is used as static to access it anywhere

    public static void main(String[] args) {
       //testTaskWithNumbers();     //first thing I did when i installed Inteliji IDE;
        

    }




    private static void testTaskWithNumbers(){
        HashMap<String, ArrayList<Integer>> currentNumbersPersonHas = new HashMap<String, ArrayList<Integer>>();
        System.out.print("Enter person name and numbers with whitespace: ");
        String enterPersonData = scan.nextLine();

        while (!enterPersonData.equalsIgnoreCase("end")) {
            String[] temp = enterPersonData.split(" ");
            insertNumbersInPersonAccount(currentNumbersPersonHas,temp);
            System.out.print("Enter person name and numbers with whitespace: ");
            enterPersonData = scan.nextLine();
        }
        System.out.print("Search for name: ");
        String enterPersonToReceiveNumbers = scan.nextLine();
        while(!enterPersonToReceiveNumbers.equalsIgnoreCase("end")){
            try{
                System.out.printf("Name:%s%nNumbers:%s%n",enterPersonToReceiveNumbers,displayPersonNumbers(currentNumbersPersonHas,enterPersonToReceiveNumbers));
            }catch(IllegalStateException exc){
                System.out.println(exc.getMessage());
            }

            System.out.print("Search for name: ");
            enterPersonToReceiveNumbers = scan.nextLine();
        }
    }

    private static String displayPersonNumbers(HashMap<String,ArrayList<Integer>> accounts,String entered){
        StringBuilder sb = new StringBuilder();
        if(accounts.containsKey(entered)){
            Iterator<Integer> iter = accounts.get(entered).iterator();
            while(iter.hasNext())
            {
                sb.append(iter.next());
                if(iter.hasNext()){
                    sb.append(",");
                }
            }
            return sb.toString();
        }else{
            throw new IllegalStateException("Name not found in accounts");
        }
    }

    private static void insertNumbersInPersonAccount(HashMap<String,ArrayList<Integer>> accounts,String[] data) {
        if (accounts.containsKey(data[0])) {
            int[] numbersOfPerson = Arrays.stream(data).filter(e -> Character.isDigit(e.charAt(0)))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for(Integer item : numbersOfPerson){
                accounts.get(data[0]).add(item);
            }
        }else{
            accounts.put(data[0],new ArrayList<Integer>());
            insertNumbersInPersonAccount(accounts,data);
        }
    }

}

import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){

    }

    private static void greenVsRedTask(){
        String[] enterInitalInput;
        //entering grid details
        while(true){
            try{
                do{
                    enterInitalInput = scan.nextLine().split("\\s+");
                    if(Integer.parseInt(enterInitalInput[0])>Integer.parseInt(enterInitalInput[1]) ||
                            Integer.parseInt(enterInitalInput[1])>1000){
                        throw new IllegalArgumentException("Entered data must be in rage x<=y<1000");
                    }
                }while(Integer.parseInt(enterInitalInput[0])>Integer.parseInt(enterInitalInput[1]) ||
                        Integer.parseInt(enterInitalInput[1])>=1000);
                break;
            }catch(IllegalArgumentException exc){
                System.out.println(exc.getMessage());
            }
        }
        //grid details
        int row = Integer.parseInt(enterInitalInput[0]);
        int col = Integer.parseInt(enterInitalInput[1]);

        Character[][] grid = new Character[row][col];

    }
}

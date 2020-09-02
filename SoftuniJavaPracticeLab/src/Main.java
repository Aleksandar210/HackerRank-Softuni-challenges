import SoftuniRelatedExercises.Fundamental;
import jdk.nashorn.internal.runtime.OptimisticReturnFilters;
import noneSoftuniRelatedTasks.GreenVsRed.Cell;
import noneSoftuniRelatedTasks.GreenVsRed.GridController;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
       //greenVsRedTask();

        //Fundamentals
        Fundamental fund = new Fundamental();
        //fund.countCharsInString();
        //fund.minerTask();
    }



    //Intern task
    //------------------------------------------------------------------------------------------------------
    private static void greenVsRedTask(){
        String[] enterInitialInput=null;
        //entering grid details
                do{
                    try{
                        enterInitialInput = scan.nextLine().split("\\s+");
                        if(Integer.parseInt(enterInitialInput[0])>Integer.parseInt(enterInitialInput[1]) ||
                                Integer.parseInt(enterInitialInput[1])>1000){
                            throw new IllegalArgumentException("Entered data must be in rage x<=y<1000");
                        }
                    }catch(IllegalArgumentException exc){
                        System.out.println(exc.getMessage());
                    }

                }while(Integer.parseInt(enterInitialInput[0])>Integer.parseInt(enterInitialInput[1]) ||
                        Integer.parseInt(enterInitialInput[1])>=1000);


        //grid details
        int row = Integer.parseInt(enterInitialInput[0]);
        int col = Integer.parseInt(enterInitialInput[1]);

        Cell[][] grid = new Cell[row][col];
        GridController master = new GridController(grid);
        master.buildGrid();
        String[] enterFinalInput = scan.nextLine().split("\\s+");
        int[] resultCellLocation = {Integer.parseInt(enterFinalInput[0]),Integer.parseInt(enterFinalInput[1])};
        int numberGenIterations = Integer.parseInt(enterFinalInput[2]);

        for(int i=0;i<numberGenIterations;i++){
            master.determineFutureGenStateCell();
            master.goThroughGen();
        }
        System.out.println(grid[resultCellLocation[0]][resultCellLocation[1]]);

    }
    //------------------------------------------------------------------------------------------------------

}

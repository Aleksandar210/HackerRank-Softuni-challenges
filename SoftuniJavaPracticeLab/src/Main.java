import jdk.nashorn.internal.runtime.OptimisticReturnFilters;
import noneSoftuniRelatedTasks.GreenVsRed.Cell;
import noneSoftuniRelatedTasks.GreenVsRed.GridController;

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
}

package noneSoftuniRelatedTasks.GreenVsRed;

import java.util.Scanner;

public class GridController {
    //resources
    private Scanner scan ;

    //fields
    private Cell[][] field;
    private int rows;
    private int columns;

    //constructors
    public GridController(Cell[][] currentGrid){
        this.scan = new Scanner(System.in);
    this.field = currentGrid;
    this.rows = this.field.length;
    this.columns = this.field[0].length;
    }

    //builds grid
    public void buildGrid(){
        char[] enterRowCells;
        for(int i =0;i<this.rows;i++){
            while(true){
                try{
                    do{
                        enterRowCells = this.scan.nextLine().toCharArray();
                        if(enterRowCells.length!=this.columns){
                            throw new IllegalArgumentException(String.format("Error: entered data'slength %d/%d",
                                    enterRowCells.length,this.columns));
                        }
                    }while(enterRowCells.length!=this.columns);
                    break;
                }catch(IllegalArgumentException exc){
                    System.out.println(exc.getMessage());
                    continue;
                }

            }

          for(int j=0;j<enterRowCells.length;j++){
              this.field[i][j] = new Cell();
          }
        }
    }

}

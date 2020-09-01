package noneSoftuniRelatedTasks.GreenVsRed;

import java.util.Arrays;
import java.util.OptionalInt;
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
              this.field[i][j] = new Cell(enterRowCells[j]);
          }
        }
        this.scan.close();  //dispose of scanner after work
    }

    public void determineFutureGenStateCell(){
    for(int i=0;i<this.field.length;i++){
        for(int j=0;j<this.field[0].length;j++){
        this.field[i][j].determineFutureState(this.getGreenNeighboursForCell(i,j));
        }
    }

    }



    public void goThroughGen(){
    for(int i=0;i<this.field.length;i++){
        for(int j =0;j<this.field[0].length;j++){
            this.field[i][j].updateState();
        }
    }
    }


    private int getGreenNeighboursForCell(int...cellLocation){

        if(cellLocation[0]==0){
            if(cellLocation[1]==0){
            return this.returnReduceNeighbourStateRes(cellLocation,"down","down-right");
            }else if(cellLocation[1]>0 && cellLocation[1]<this.field[0].length-1){
                return this.returnReduceNeighbourStateRes(cellLocation,"down","down-right","down-left","left","right");
            }else{
                return this.returnReduceNeighbourStateRes(cellLocation,"down","down-left","left");
            }
        }else if(cellLocation[0]>0 && cellLocation[0]<this.field.length-1){
            if(cellLocation[1]==0){
                return this.returnReduceNeighbourStateRes(cellLocation,"down","upper","down-right","upper-right","right");
            }else if(cellLocation[1]>0 && cellLocation[1]<this.field[0].length-1){
                return this.returnReduceNeighbourStateRes(cellLocation,"down","down-right","down-left","left","right","upper","upper-right","upper-left");
            }else{
                return this.returnReduceNeighbourStateRes(cellLocation,"down","down-left","left","upper-left","upper");
            }
        }else if(cellLocation[0]==this.field.length-1){
            if(cellLocation[1]==0){
                return this.returnReduceNeighbourStateRes(cellLocation,"upper","upper-right","right");
            }else if(cellLocation[1]>0 && cellLocation[1]<this.field[0].length-1){
                return this.returnReduceNeighbourStateRes(cellLocation,"left","right","upper","upper-right","upper-left");
            }else{
                return this.returnReduceNeighbourStateRes(cellLocation,"left","upper-left","upper");
            }
        }
        return 0;       //never comes

    }
    private int returnReduceNeighbourStateRes(int[] cellLocation, String...dir){
        OptionalInt numberGreenNeighbours = null;
        numberGreenNeighbours = Arrays.stream(this.selectNeighbours(cellLocation,dir))
                .reduce((a,b)->a+b);
        return numberGreenNeighbours.getAsInt();
    }

    //can take right,left,upper-right,down-right,upper,down and so on
    private int[] selectNeighbours(int[] start,String...directions){
        int currentIndex = 0;
        int[] currentNeighbourStatesColl = new int[directions.length];
        for(String dir : directions){
            switch(dir.toLowerCase()){
                case"upper":
                   currentNeighbourStatesColl[currentIndex] = this.field[start[0]+1][start[1]].getCurrentState();
                   currentIndex++;
                    break;
                case "down":
                    currentNeighbourStatesColl[currentIndex] = this.field[start[0]-1][start[1]].getCurrentState();
                    currentIndex++;
                    break;
                case"right":
                    currentNeighbourStatesColl[currentIndex] = this.field[start[0]][start[1]+1].getCurrentState();
                    currentIndex++;
                    break;
                case "left":
                    currentNeighbourStatesColl[currentIndex] = this.field[start[0]][start[1]-1].getCurrentState();
                    currentIndex++;
                    break;
                case "upper-right":
                    currentNeighbourStatesColl[currentIndex] = this.field[start[0]-1][start[1]+1].getCurrentState();
                    currentIndex++;
                    break;
                case "upper-left":
                    currentNeighbourStatesColl[currentIndex] = this.field[start[0]-1][start[1]-1].getCurrentState();
                    currentIndex++;
                    break;
                case "down-right":
                    currentNeighbourStatesColl[currentIndex] = this.field[start[0]+1][start[1]+1].getCurrentState();
                    currentIndex++;
                    break;
                case "down-left":
                    currentNeighbourStatesColl[currentIndex] = this.field[start[0]+1][start[1]-1].getCurrentState();
                    currentIndex++;
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Invalid dir value: %s",dir));

            }
        }
        return null;
    }

}

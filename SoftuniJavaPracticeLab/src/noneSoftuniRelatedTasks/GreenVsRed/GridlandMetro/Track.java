package noneSoftuniRelatedTasks.GreenVsRed.GridlandMetro;

import java.util.HashMap;

public class Track {
    private StringBuilder sb;

    private int[][] array;
    private HashMap<Integer,int[]> currentRaiWaysPlaced;        //the array holds the beginning and the end in programmer count
    private int row;
    private int col;
    int numberLamPostsToBePlaced;
    private int currentStringBuilderChangeNumber;
    private int stringBuilderChangeTracker;


    public Track(int row, int col){
        this.row = row;
        this.col = col;
        array = new int[row][col];
        this.initialiseDefaultArrayState();
        this.sb = new StringBuilder();
        this.currentStringBuilderChangeNumber = 0;
        this.stringBuilderChangeTracker = 0;
    }

    public int getRow(){return this.row;}
    public int getCol(){return this.col;}

    private void initialiseDefaultArrayState(){
        for(int i =0;i<this.array.length;i++){
            for(int j =0;j<this.array[1].length;j++){
                this.array[i][j] = 0;
            }
        }
    }

    public void placeRailWay(int row, int start, int finish){
        if(start>finish){
            int temp =0;
            temp = start;
            start = finish;
            finish = temp;
        }
        if((start>=this.currentRaiWaysPlaced.get(row)[0] && finish<this.currentRaiWaysPlaced.get(row)[1])
        ||(start>this.currentRaiWaysPlaced.get(row)[0] && finish<=this.currentRaiWaysPlaced.get(row)[1])){

        }else if(start<this.currentRaiWaysPlaced.get(row)[0]){

        }

        for(int i=start;i<=finish;i++){
            this.array[row][i] = 1;
        }
        this.stringBuilderChangeTracker++;
    }

    public void undoRailWay(int row, int start, int finish){
        for(int i=start;i<=finish;i++){
            this.array[row][i] = 0;
        }
        this.stringBuilderChangeTracker++;
    }

    @Override
    public String toString() {
        if(this.currentStringBuilderChangeNumber!=this.stringBuilderChangeTracker){
            this.sb = new StringBuilder();
            this.currentStringBuilderChangeNumber = this.stringBuilderChangeTracker;
            for(int i=0;i<this.array.length;i++){
                for(int j=0;j<this.array[0].length;j++){
                    this.sb.append(this.array[i][j]);
                }
                this.sb.append(System.lineSeparator());
            }
        }

        return this.sb.toString();
    }
}

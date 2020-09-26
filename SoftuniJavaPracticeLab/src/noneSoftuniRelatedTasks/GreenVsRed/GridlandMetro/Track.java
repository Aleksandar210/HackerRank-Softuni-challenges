package noneSoftuniRelatedTasks.GreenVsRed.GridlandMetro;

public class Track {
    private StringBuilder sb;

    private int[][] array;
    int numberLamPostsToBePlaced;
    private int currentStringBuilderChangeNumber;
    private int stringBuilderChangeTracker;


    public Track(int row, int col){
        array = new int[row][col];
        this.initialiseDefaultArrayState();
        this.sb = new StringBuilder();
        this.currentStringBuilderChangeNumber = 0;
        this.stringBuilderChangeTracker = 0;
    }

    private void initialiseDefaultArrayState(){
        for(int i =0;i<this.array.length;i++){
            for(int j =0;j<this.array[1].length;j++){
                this.array[i][j] = 1;
            }
        }
    }

    public void placeRailWay(int row, int start, int finish){
        for(int i=start;i<=finish;i++){
            this.array[row][i] = 1;
        }
        this.stringBuilderChangeTracker++;
    }

    public void undoRailWay(int row, int start, int finish){
        for(int i=start;i<=finish;i++){
            this.array[row][i] = 0;
        }
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

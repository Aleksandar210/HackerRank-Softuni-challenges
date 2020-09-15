package SoftuniRelatedExercises.OOP_Basics_Classes.JediGalaxy;

public class Galaxy {
    //fields
    private int[][] field;

    public Galaxy(){
        this.field = new int[5][5];
        this.initialiseValuesInThField();
    }

    private void initialiseValuesInThField(){
        int counter =0;
        for(int i=0;i<this.field.length;i++){
            for(int j =0;j<this.field[0].length;j++){
                this.field[i][j] = counter;
                counter++;
            }
        }
    }

    public void doGalaxyRun(int[] coordinates){

    }

}

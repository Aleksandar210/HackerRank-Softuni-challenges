package SoftuniRelatedExercises.OOP_Basics_Classes.JediGalaxy;

public class Galaxy {
    //fields
    private int[][] field;

    public Galaxy(int rows, int cols){
        if(this.validateGalaxyParameters(rows,cols)){
            this.field = new int[5][5];
            this.initialiseValuesInThField();
        }

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

    private boolean validateGalaxyParameters(int...params){
        if(params[0]<=0 || params[1]<=0){
            throw new IllegalArgumentException("Illegal galaxy params");
        }else{
            return true;
        }
    }

    public void doGalaxyRunJedi(int[] coordinates){
    while(true){

    }
    }

    private void doGalaxyRunSith(int[] coordinates){

    }

}

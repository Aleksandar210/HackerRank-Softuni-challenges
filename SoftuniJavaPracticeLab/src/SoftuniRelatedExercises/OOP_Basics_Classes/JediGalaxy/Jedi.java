package SoftuniRelatedExercises.OOP_Basics_Classes.JediGalaxy;

public class Jedi {

    //consts
    private final int DEFAULT_SCORE_STARTING = 0;

    private int rowLocation;
    private int colLocation;
    private int score;

    public Jedi(int row, int col){
        this.setRowLocation(row);
        this.setColLocation(col);
        this.score = DEFAULT_SCORE_STARTING;
    }

    public int getRowLocation(){return this.rowLocation;}

    private void setRowLocation(int rowLocation){

    }

    private int getColLocation(){return this.colLocation;}

    private void setColLocation(int colLocation){

    }

    public void collectStarValue(int value){
        this.score+=value;
    }


}

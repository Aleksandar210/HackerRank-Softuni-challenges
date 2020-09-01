package noneSoftuniRelatedTasks.GreenVsRed;

public class Cell {
    //fields
    private char currentState;  //0 - red, 1 - green
    private char futureState;


    public Cell(char initialState){

    }

    public void setFutureState(char state){
        if(state=='1' || state=='0'){
            this.futureState = state;
        }else{
            throw new IllegalArgumentException("Invalid state format must be [0,1]");
        }
    }

    public void updateState(){
        this.currentState = this.futureState;
    }

}

package noneSoftuniRelatedTasks.GreenVsRed;

public class Cell {

    //finals
    private final int DEFAULT_TIMESGREEN=0;
    //fields
    private int timesGreenState;
    private int currentState;  //0 - red, 1 - green
    private int futureState;


    public Cell(char initialState){
        this.timesGreenState = DEFAULT_TIMESGREEN;
    this.setCurrentState(Character.getNumericValue(initialState));
    }

    private void setFutureState(int state){
        if(state==1 || state==0){
            this.futureState = state;
        }else{
            throw new IllegalArgumentException("Invalid state format must be [0,1]");
        }
    }

    private void setCurrentState(int state){
        if(state==1 || state==0){
            this.currentState = state;
        }else{
            throw new IllegalArgumentException("Invalid state format must be [0,1]");
        }
    }
    public int getCurrentState(){
        return this.currentState;
    }

    public void updateState(){
        this.currentState = this.futureState;
        if(this.getCurrentState()==1){
            this.timesGreenState+=1;
        }
    }

    public void determineFutureState(int numberGreenNeighbours){
        switch(this.currentState){
            case 1:
                if(numberGreenNeighbours==2 ||numberGreenNeighbours==3 || numberGreenNeighbours==6){
                    this.setFutureState(1);
                }else{
                    this.setFutureState(0);
                }
                break;
            case 0:
                if(numberGreenNeighbours==3 || numberGreenNeighbours==6){
                    this.setFutureState(1);
                }
                else{
                    this.setFutureState(0);
                }
                break;
        }
    }

    @Override
    public String toString(){
        if(this.currentState==1){
           return String.format("Cell was green: %d in totall%nIts current state is:%s",this.timesGreenState,"green");
        }else{
            return String.format("Cell was green: %d in totall%nIts current state is:%s",this.timesGreenState,"red");
        }


    }

}

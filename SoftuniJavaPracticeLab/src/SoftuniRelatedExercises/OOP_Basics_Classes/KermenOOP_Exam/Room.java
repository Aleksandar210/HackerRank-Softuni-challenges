package SoftuniRelatedExercises.OOP_Basics_Classes.KermenOOP_Exam;

import java.util.List;

public class Room {
private double electricityCost;

public Room(double electricityCost){

}

private void setElectricityCost(double electricityCost){
    if(electricityCost<=0){
        throw new IllegalArgumentException("Illegal electricity cost state.");
    }else{
        this.electricityCost = electricityCost;
    }
}


}

package SoftuniRelatedExercises.OOP_Basics_Classes.KermenOOP_Exam;

public class Item {
    private String name;
    private double electricityCost;

    public Item(String name){
    this.setName(name);
    }

    private void setName(String name){
        if(name!=null && name.trim().isEmpty()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Illegal name state.");
        }
    }

    public String getName(){
        return this.name;
    }

    public double getElectricityCost(){
        return this.electricityCost;
    }

}

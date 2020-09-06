package SoftuniRelatedExercises.OOP_Basics_Classes.KermenOOP_Exam;


public abstract class KermenCitizen{
    private final double Default_Income =0;
    private double income;


    public KermenCitizen(double income){
      this.setIncome(income);
    }

    public KermenCitizen(){
        this.income = this.Default_Income;
    }

    private void setIncome(double income){
        if(income<=0){
            throw new IllegalArgumentException("Illegal income state.");
        }else{
            this.income = income;
        }
    }

    protected double getIncome() {return this.income;}

}

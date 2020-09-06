package SoftuniRelatedExercises.OOP_Basics_Classes.KermenOOP_Exam;

public class KermenAdault extends KermenCitizen {

    public KermenAdault(double income){
        super(income);
    }

    public double getCitizenIncome(){
        return this.getIncome();
    }

}

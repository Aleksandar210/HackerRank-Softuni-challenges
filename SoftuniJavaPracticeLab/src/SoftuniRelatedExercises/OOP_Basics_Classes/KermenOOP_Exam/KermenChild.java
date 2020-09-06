package SoftuniRelatedExercises.OOP_Basics_Classes.KermenOOP_Exam;

import java.math.BigDecimal;

public class KermenChild extends KermenCitizen {
    private final double Defualt_Overall_Expenses =0;
    private double overallExpenses;
    public KermenChild(double...expenses){
        super();
        this.overallExpenses = this.Defualt_Overall_Expenses;
        this.setExpenses(expenses);
    }

    private void setExpenses(double...expenses){
        BigDecimal currentDecimal;
        BigDecimal currentExpenses = new BigDecimal(this.overallExpenses).setScale(2,BigDecimal.ROUND_HALF_UP);
        for (double expens : expenses) {
            if(expens>=0) {
                currentDecimal = new BigDecimal(expens).setScale(2, BigDecimal.ROUND_HALF_UP);
                currentExpenses.add(currentDecimal);
            }

        }
        this.overallExpenses = currentExpenses.doubleValue();
    }
    public double getExpenses() {return this.overallExpenses;}
}

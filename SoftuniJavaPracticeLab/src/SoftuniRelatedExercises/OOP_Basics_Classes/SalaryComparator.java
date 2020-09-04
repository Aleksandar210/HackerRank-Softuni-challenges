package SoftuniRelatedExercises.OOP_Basics_Classes;

import java.math.BigDecimal;
import java.util.Comparator;

public class SalaryComparator implements Comparator<Department> {

    @Override
    public int compare(Department o1, Department o2) {
        BigDecimal objA = new BigDecimal(o1.getAverageSalary()).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal objB = new BigDecimal(o2.getAverageSalary()).setScale(2, BigDecimal.ROUND_HALF_UP);

        return objB.compareTo(objA);
    }

}

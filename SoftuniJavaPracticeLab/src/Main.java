import SoftuniRelatedExercises.Fundamental;
import SoftuniRelatedExercises.OOP_Basics_Classes.Department;
import SoftuniRelatedExercises.OOP_Basics_Classes.Employee;
import noneSoftuniRelatedTasks.GreenVsRed.Cell;
import noneSoftuniRelatedTasks.GreenVsRed.GridController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
       //greenVsRedTask();

        //Fundamentals
        Fundamental fund = new Fundamental();
        //fund.countCharsInString();
        //fund.minerTask();

        //test
//        StringBuilder sb = new StringBuilder();
//        String enter = scan.nextLine();
//        while(!enter.equalsIgnoreCase("end")){
//            sb.append(enter+ System.lineSeparator());
//            enter = scan.nextLine();
//        }
//        String[] allLines = sb.toString().split(System.getProperty("line.separator"));
//        for(String item:allLines){
//            System.out.println(item);
//        }

        double sum = 0;


    }



    //Intern task
    //------------------------------------------------------------------------------------------------------
    private static void greenVsRedTask(){
        String[] enterInitialInput=null;
        //entering grid details
                do{
                    try{
                        enterInitialInput = scan.nextLine().split("\\s+");
                        if(Integer.parseInt(enterInitialInput[0])>Integer.parseInt(enterInitialInput[1]) ||
                                Integer.parseInt(enterInitialInput[1])>1000){
                            throw new IllegalArgumentException("Entered data must be in rage x<=y<1000");
                        }
                    }catch(IllegalArgumentException exc){
                        System.out.println(exc.getMessage());
                    }

                }while(Integer.parseInt(enterInitialInput[0])>Integer.parseInt(enterInitialInput[1]) ||
                        Integer.parseInt(enterInitialInput[1])>=1000);


        //grid details
        int row = Integer.parseInt(enterInitialInput[0]);
        int col = Integer.parseInt(enterInitialInput[1]);

        Cell[][] grid = new Cell[row][col];
        GridController master = new GridController(grid);
        master.buildGrid();
        String[] enterFinalInput = scan.nextLine().split("\\s+");
        int[] resultCellLocation = {Integer.parseInt(enterFinalInput[0]),Integer.parseInt(enterFinalInput[1])};
        int numberGenIterations = Integer.parseInt(enterFinalInput[2]);

        for(int i=0;i<numberGenIterations;i++){
            master.determineFutureGenStateCell();
            master.goThroughGen();
        }
        System.out.println(grid[resultCellLocation[0]][resultCellLocation[1]]);

    }
    //------------------------------------------------------------------------------------------------------

    //OOP Basics tasks
    //------------------------------------------------------------------------------------------------------

    private static void companyRosterTask(){
        HashMap<String, Department> currentDepartments = new HashMap<>();
        int numberEmployees = Integer.parseInt(scan.nextLine());
        String enterEmployeeData;
        String[] temp;
        Employee currentEmployeeCreated = null;
        for(int i =0;i<numberEmployees;i++){

            enterEmployeeData = scan.nextLine();
            temp = enterEmployeeData.split("\\s+");
            currentEmployeeCreated = createEmployeeObject(temp);

            if(currentDepartments.containsKey(currentEmployeeCreated.getDepartment().toUpperCase())){
                currentDepartments.get(currentEmployeeCreated.getDepartment().toUpperCase()).addEmployee(currentEmployeeCreated);
            }else{
                currentDepartments.put(currentEmployeeCreated.getDepartment().toUpperCase(),
                        new Department(currentEmployeeCreated.getDepartment().toUpperCase()));
                currentDepartments.get(currentEmployeeCreated.getDepartment().toUpperCase()).addEmployee(currentEmployeeCreated);
            }
        }

        //get the department with the largest averageSalary
        Department currentLargestSalaryDep = null;
        for(Map.Entry<String,Department> item:currentDepartments.entrySet()){
            if(currentLargestSalaryDep==null){
                currentLargestSalaryDep = item.getValue();
            }else{
                if(currentLargestSalaryDep.getAverageSalary()<item.getValue().getAverageSalary()){
                    currentLargestSalaryDep = item.getValue();
                }
            }
        }
        System.out.println(currentLargestSalaryDep);        //override to string to do

    }


    private static Employee createEmployeeObject(String...data){
        switch(data.length){
            case 6:
                return new Employee(data[0],Double.parseDouble(data[1]),data[2],data[3],data[4],Integer.parseInt(data[5]));
            case 5:
                if(isInteger(data[4])){
                    return new Employee(data[0],Double.parseDouble(data[1]),data[2],data[3],Integer.parseInt(data[4]));
                }else{
                    return new Employee(data[0],Double.parseDouble(data[1]),data[2],data[3],data[4]);
                }
            case 4:
                return new Employee(data[0],Double.parseDouble(data[1]),data[2],data[3]);
            default:
                throw new IllegalArgumentException("Illegal data or not full data passed");
        }

    }

    //------------------------------------------------------------------------------------------------------



    //General use algorithms
    //------------------------------------------------------------------------------------------------------
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}

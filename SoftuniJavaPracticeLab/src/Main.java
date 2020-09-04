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

    public static void main(String[] args) {
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
    private static void greenVsRedTask() {
        String[] enterInitialInput = null;
        //entering grid details
        do {
            try {
                enterInitialInput = scan.nextLine().split("\\s+");
                if (Integer.parseInt(enterInitialInput[0]) > Integer.parseInt(enterInitialInput[1]) ||
                        Integer.parseInt(enterInitialInput[1]) > 1000) {
                    throw new IllegalArgumentException("Entered data must be in rage x<=y<1000");
                }
            } catch (IllegalArgumentException exc) {
                System.out.println(exc.getMessage());
            }

        } while (Integer.parseInt(enterInitialInput[0]) > Integer.parseInt(enterInitialInput[1]) ||
                Integer.parseInt(enterInitialInput[1]) >= 1000);


        //grid details
        int row = Integer.parseInt(enterInitialInput[0]);
        int col = Integer.parseInt(enterInitialInput[1]);

        Cell[][] grid = new Cell[row][col];
        GridController master = new GridController(grid);
        master.buildGrid();
        String[] enterFinalInput = scan.nextLine().split("\\s+");
        int[] resultCellLocation = {Integer.parseInt(enterFinalInput[0]), Integer.parseInt(enterFinalInput[1])};
        int numberGenIterations = Integer.parseInt(enterFinalInput[2]);

        for (int i = 0; i < numberGenIterations; i++) {
            master.determineFutureGenStateCell();
            master.goThroughGen();
        }
        System.out.println(grid[resultCellLocation[0]][resultCellLocation[1]]);

    }
    //------------------------------------------------------------------------------------------------------

    //OOP Basics tasks
    //------------------------------------------------------------------------------------------------------

    private static void companyRosterTask() {
        HashMap<String,Department> departments = new HashMap<>();
        int numberEmployees = Integer.parseInt(scan.nextLine());
        for(int i =0;i<numberEmployees;i++){

        }

    }

    private static void addCompanyRosterEmployee(HashMap<String,Department> dep,String...data){
       Employee current = createCompanyRosterEmployee(data);
        if(dep.containsKey(data[2])){
            dep.put(data[2].toUpperCase(),new Department(data[2]));
            dep.get(data[2]).addEmployee(current);
        }else{
            dep.get(data[2].toUpperCase()).addEmployee(current);
        }

    }

    private static Employee createCompanyRosterEmployee(String...data){
        Employee current = null;
        switch(data.length){
            case 4:
                current = new Employee(data[0],Double.parseDouble(data[1]),data[2],data[3]);
                break;
            case 5:
                if(isInteger(data[4])){
                    current  = new Employee(data[0],Double.parseDouble(data[1]),data[2],data[3],Integer.parseInt(data[4]));
                }else{
                    current  = new Employee(data[0],Double.parseDouble(data[1]),data[2],data[3],data[4]);
                }
                break;
            case 6:
                current  = new Employee(data[0],Double.parseDouble(data[1]),data[2],data[3],data[4],Integer.parseInt(data[5]));
                break;
        }
        return current;
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

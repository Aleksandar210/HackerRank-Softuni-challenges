import SoftuniRelatedExercises.Fundamental;
import SoftuniRelatedExercises.OOP_Basics_Classes.*;
import noneSoftuniRelatedTasks.GreenVsRed.Cell;
import noneSoftuniRelatedTasks.GreenVsRed.GridController;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //Local tasks ->this class only
        //greenVsRedTask();
        //companyRosterTask();
        //radioDataBaseTask();

        //Fundamentals exercises -> Fundamentals class methods(tasks),
        Fundamental fund = new Fundamental();
        //fund.countCharsInString();
        //fund.minerTask();


        int[] currentRowData = {0,1,0,1,0,1};
        int[][] grid = new int[6][6];
        for(int i=0;i<grid.length;i++){
            grid[i] = currentRowData;
        }

        System.out.println("Enter rows and cols for the subArrays: ");
        int rows = Integer.parseInt(scan.nextLine());           //lets say 3by3 validations will be ignored!!
        int cols = Integer.parseInt(scan.nextLine());

        int numberSubArrays = (grid.length-(grid.length/rows))*(grid[0].length-(grid[0].length/cols));

        List<int[][]> currentSubGrids = new ArrayList<int[][]>(numberSubArrays);
        while(true){

        }


    }

    private static void addSubArraysToList(List<int[][]> currentList,int[][] mainGrid){

    }

    private static int[][] createSubAArrayTempMain(int[][] mainGrid,int rowAt,int columnAt, int desiredRows, int desiredColumns){
        int[][] temp = new int[desiredRows][desiredColumns];
        for(int i =rowAt;i<desiredRows;i++){
            for(int j=columnAt;j<desiredColumns;j++){
                temp[i][j] = mainGrid[rowAt][columnAt];
            }
        }

        return temp;
    }

    //Sudden tasks
    //--------------------------------------------------------------------------------------------------------
    private static void hourglass2dArray(){
        int rows = 5;
        int cols = 6;
        int[][] grid = new  int[rows][cols];
        for(int i=0;i<rows;i++){
         grid[i] = createArrayForRow();
        }

        System.out.printf("Largest sum of hour glass is %d",getLargestSumGlass(grid));

    }
    private static int[] createArrayForRow(){
        String currentInput;
        do{
         currentInput = scan.nextLine();
        }while(currentInput.length()!=6);
        int[] currentArray = Arrays.stream(currentInput.chars().toArray()).map(e->e-'0').toArray();
        return currentArray;
    }

    private static int getLargestSumGlass(int[][] grid){
        int largestSum =0;
        int[][] gridWithTheLargestSum;

        return -1;
    }

    private List<int[][]> getSubGrids(int[][]mainGrid,int row, int col){
        List<int[][]> currentSubGrids = new ArrayList<int[][]>();

        return null;
    }
    //--------------------------------------------------------------------------------------------------------



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
        String[] employeeData;
        for(int i =0;i<numberEmployees;i++){
        employeeData = scan.nextLine().split("\\s+");
        addCompanyRosterEmployee(departments,employeeData);
        }


        List<Department> departmentsOrderedBySalaryDescending = new ArrayList<Department>(departments.values());
        departmentsOrderedBySalaryDescending.sort(new SalaryComparator());
        StringBuilder sb = new StringBuilder();
        for(Department item:departmentsOrderedBySalaryDescending){
            sb.append(item+System.lineSeparator());
        }
        System.out.println(sb.toString());
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


    private static void simpleGandalfTask(){
        String[] enterFoodSupply = scan.nextLine().split("\\s+");
        Gandalf theGrey = new Gandalf();
        theGrey.takeFoodBag(enterFoodSupply);
        System.out.println(theGrey.getHappinessPoints());
        System.out.println(theGrey.getMood());
        System.out.println("Food eaten by the Grey:"+System.lineSeparator()+theGrey.getFoodEaten());

    }

    private static void radioDataBaseTask(){
        RadioDataBase currentDataBase = new RadioDataBase();
        //number songs to enter;
        int numberEntries = Integer.parseInt(scan.nextLine());
        String enterData;
        String[] gatheredData;
        for(int i=0;i<numberEntries;i++){
        enterData = scan.nextLine();
        gatheredData = enterData.split(";");
        try{
            currentDataBase.addEntry(gatheredData[0],gatheredData[1],gatheredData[2]);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        }
        System.out.println(currentDataBase);
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

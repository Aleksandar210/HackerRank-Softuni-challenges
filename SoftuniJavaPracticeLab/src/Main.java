import OOP_Advanced_Classes.Encapsulation.EncapsulationClassTest;
import OOP_Advanced_Classes.Hero.DarkKnight;
import OOP_Advanced_Classes.NFS.SportsCar;
import OOP_Advanced_Classes.NFS.Vehicle;
import SoftuniRelatedExercises.Fundamental;
import SoftuniRelatedExercises.OOP_Basics_Classes.*;
import SoftuniRelatedExercises.OOP_Basics_Classes.GreedyTask.Bag;
import SoftuniRelatedExercises.OOP_Basics_Classes.Younger_Scrolls.YoungerSoulsController;
import noneSoftuniRelatedTasks.GreenVsRed.Cell;
import noneSoftuniRelatedTasks.GreenVsRed.GridController;
import noneSoftuniRelatedTasks.GreenVsRed.GridlandMetro.Track;
import sun.security.util.ArrayUtil;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        //Local tasks ->this class only
        //greenVsRedTask();
        //companyRosterTask();
        //radioDataBaseTask();
        //hourglass2dArray();
        // flattenArray();
        //flowerWreaths();
        //greedyIsGood();




        //Fundamentals exercises -> Fundamentals class methods(tasks),
          //Fundamental fund = new Fundamental();
        //fund.countCharsInString();
        //fund.minerTask();

        //DarkKnight currentKnight = new DarkKnight("Aleksandar",50);
        //System.out.println(currentKnight);


        //gridlandMetroTask();      //DEPRICATED

        EncapsulationClassTest encapstasks = new EncapsulationClassTest();
        encapstasks.salaryIncrease();



    }





    //Sudden tasks
    //--------------------------------------------------------------------------------------------------------

    //HackerRank Gridland Metro task
    //enter k and for each k do the thing with row and col but place them in Track as fields

    //remeber that the data gien by the input is not programmer counting
    private static void gridlandMetroTask(){
        int numberTracks;
        do{
            System.out.print("Enter number tracks: ");
        numberTracks = Integer.parseInt(scan.nextLine());
        }while(numberTracks<0 || numberTracks>1000);

        Track[] currentTracks = new Track[numberTracks];
        for(int i=0;i< currentTracks.length;i++){
            currentTracks[i] = createTrack();
            enterTrackDirections(currentTracks[i]);
        }

    }

    private static Track createTrack(){
        int[]rowAndCol = enterData();
        Track currentTrack = new Track(rowAndCol[0],rowAndCol[1]);
        return currentTrack;
    }

    private static void enterTrackDirections(Track currentTrack){
        int[] rowAndCol = new int[]{currentTrack.getRow(), currentTrack.getCol()};
        int counter =1;
        int[] directionsForRailWay;
        while(counter<=currentTrack.getRow()){
            directionsForRailWay = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            if(validateEnteredDirections(rowAndCol,directionsForRailWay)){
                currentTrack.placeRailWay(directionsForRailWay[0],directionsForRailWay[1],directionsForRailWay[2]);
                counter++;
            }
        }
    }

    private static int[] enterData(){
        int[] enteredData = new int[2];  //0 is row and 1 is col
    do {
        System.out.print("Enter Row: ");
        enteredData[0] = Integer.parseInt(scan.nextLine());
        System.out.print("Enter Col: ");
        enteredData[1] = Integer.parseInt(scan.nextLine());
    }while(!validateRowAndCol(enteredData));

    return enteredData;
    }
    private static boolean validateRowAndCol(int...entered){
        if((entered[0]>=1 && entered[0]<=Math.pow(10,9)) && ((entered[1]>=1 && entered[1]<=Math.pow(10,9)))){
        return true;
        }else{
            return false;
        }
    }

    //rowAndCol Will be the track object
    private static boolean validateEnteredDirections(int[]rowAndCol, int[] enteredDirections){
        if(enteredDirections[0]<0 || enteredDirections[0]>rowAndCol[0]-1){
            return false;
        }else{
            if((enteredDirections[1]<0 && enteredDirections[1]>rowAndCol[1]-1)
                    &&((enteredDirections[2]<0 && enteredDirections[2]>rowAndCol[1]-1))){
            return false;
            }else{
                return true;
            }
        }
    }

    

    private static void greedyIsGood(){

        int bagSize = Integer.valueOf(scan.nextLine());
        Bag currentBag = new Bag(bagSize);

        String[] enterItemsForLooting = scan.nextLine().split("\\s+");
        String[] gathered = new String[enterItemsForLooting.length/2];

        for (int i = 1; i < enterItemsForLooting.length; i+=2) {
            gathered[i-1] = enterItemsForLooting[i-1]+" "+enterItemsForLooting[i];
        }

        for (int i =0;i<gathered.length;i++){
            currentBag.addItem(gathered[i]);
        }

        System.out.println(currentBag);
    }

    private static void test(){
        String[] entered = scan.nextLine().split("\\s+");
        String[] gathered = new String[entered.length/2];
        for (int i = 1; i < entered.length; i+=2) {
            gathered[i-1] = entered[i-1]+" "+entered[i];
        }
    }


   private static void flattenArray(){
        String enterInput = scan.nextLine();
        enterInput = enterInput.replaceAll("\\[","");
        enterInput = enterInput.replaceAll("\\]","");
        List<Integer> flattenList = Arrays.stream(enterInput.split(","))
                .filter(e->!e.equalsIgnoreCase("null"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(flattenList);

   }


    private static void hourglass2dArray(){

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scan.nextLine().split(" ");
            scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }



        List<int[][]> currentList = new ArrayList<int[][]>();
        for(int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                currentList.add(buildSubArray(arr,i,j));
            }
        }

        currentList.sort(Comparator.comparingInt(Main::getHourGlassSum));
        System.out.println(displayHourGlass(currentList.get(currentList.size()-1)));
    }


    private static int[][]buildSubArray(int[][] arr,int rowAt, int colAt){
        int[][] subArray = new int[3][3];
        subArray[0][0] = arr[rowAt][colAt];
        subArray[0][1] = arr[rowAt][colAt+1];
        subArray[0][2] = arr[rowAt][colAt+2];

        subArray[1][0] = arr[rowAt+1][colAt];
        subArray[1][1] = arr[rowAt+1][colAt+1];
        subArray[1][2] = arr[rowAt+1][colAt+2];

        subArray[2][0] = arr[rowAt+2][colAt];
        subArray[2][1] = arr[rowAt+2][colAt+1];
        subArray[2][2] = arr[rowAt+2][colAt+2];

        return subArray;
    }



    private static int getHourGlassSum(int[][] hourGlass){
        int sum=0;
        sum+= Arrays.stream(hourGlass[0]).reduce((a,b)->a+b).getAsInt();
        sum+=hourGlass[1][1];
        sum+=Arrays.stream(hourGlass[2]).reduce((a,b)->a+b).getAsInt();
        return sum;
    }

    private static String displayHourGlass(int[][] hourGlass){
        StringBuilder sb = new StringBuilder();
        sb.append(getHourGlassSum(hourGlass)+System.lineSeparator());
        sb.append(System.lineSeparator());
        for(int i=0;i<hourGlass.length;i++){
            for(int j=0;j<hourGlass[0].length;j++){
                if((i==1 && j==0) || (i==1&&j==2)){
                    sb.append(" ");
                }else{
                    sb.append(hourGlass[i][j]);
                }

            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }



    //--------------------------------------------------------------------------------------------------------



    //Intern task
    //--------------------------------------------------------------------------------------------------------

    private static void flowerWreaths(){
        List<Integer> lilies = Arrays.stream(scan.nextLine().split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> roses = Arrays.stream(scan.nextLine().split(",")).map(Integer::parseInt)
                .collect(Collectors.toList());
        int leftOverFlowers = 0;
        int numberWreaths =0;

        while(lilies.size()>0 && roses.size()>0){
        if(lilies.get(lilies.size()-1)+roses.get(0)==15){
            numberWreaths++;
            lilies.remove(lilies.size()-1);
            roses.remove(0);
        }else if(lilies.get(lilies.size()-1)+roses.get(0)>15){
            lilies.set(lilies.size()-1,lilies.get(lilies.size()-1)-2);
        }else{
            leftOverFlowers += roses.get(0);
            roses.remove(0);
            leftOverFlowers+=lilies.get(lilies.size()-1);
            lilies.remove(lilies.size()-1);
        }
        }

        if(leftOverFlowers>0){
            int timesAddedToWreths= (leftOverFlowers - leftOverFlowers % 15) / 15;
            numberWreaths+=timesAddedToWreths;
            leftOverFlowers-=(15*timesAddedToWreths);
        }

        if(numberWreaths>=5 && leftOverFlowers>0){
            System.out.printf("Congratulations you are going to teh contest with %d and you have %d flowers left"
                    ,numberWreaths,leftOverFlowers);
        }else if(numberWreaths>=5 && leftOverFlowers==0){
            System.out.printf("Congratulations you are going to teh contest with %d and you have no leftover flowers"
                    ,numberWreaths);
        }else if(numberWreaths<5){
            System.out.printf("Sorry not enough wreths you have %d",numberWreaths);
        }

    }

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

    private static void youngerSoulsTask(){
        YoungerSoulsController controller = new YoungerSoulsController();
        controller.run();
    }

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

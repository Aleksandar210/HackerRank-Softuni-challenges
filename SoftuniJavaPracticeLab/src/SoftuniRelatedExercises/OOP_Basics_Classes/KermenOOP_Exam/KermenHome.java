package SoftuniRelatedExercises.OOP_Basics_Classes.KermenOOP_Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class KermenHome {
    private List<KermenCitizen> kermenCitizensLivingInHome;
    private List<Room> rooms;
    private List<Item> itemsInHome;
    private double overallHomeMoney;
    private double overallElectricityCost;
    private double overallChildExpenses;
    private double overallBill;

   private KermenHome(){
       this.kermenCitizensLivingInHome = new ArrayList<KermenCitizen>();
       this.rooms = new ArrayList<>();
       this.itemsInHome = new ArrayList<>();
   }
    public KermenHome(String type,double[]homeOwnerIncomes,){
    this();

    }

    private void addKermenAdaults(double...adaults){
       KermenCitizen current;
       for(Double adault:adaults){
           try{
               current = new KermenAdault(adault);
               this.kermenCitizensLivingInHome.add(current);
           }catch(IllegalArgumentException ex){

           }
       }

    }

    private void addKermenChildren(String childrenData){
    String[] temp = childrenData.split("|");
    double[] currentChildExpenses;
    KermenCitizen currentChild;
        for (String childData : temp) {
            currentChildExpenses = Arrays.stream(childData.split(",")).mapToDouble(Double::parseDouble).toArray();
            currentChild = new KermenChild(currentChildExpenses);
            this.kermenCitizensLivingInHome.add(currentChild);
        }

    }

    //private void setHomeOwners

}

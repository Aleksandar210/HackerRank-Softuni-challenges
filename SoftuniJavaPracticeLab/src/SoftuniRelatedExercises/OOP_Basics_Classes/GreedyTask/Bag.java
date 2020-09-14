package SoftuniRelatedExercises.OOP_Basics_Classes.GreedyTask;

import java.util.HashMap;
import java.util.IllformedLocaleException;
import java.util.Map;

public class Bag {
    //resources.
    private String[] currentItemParts;
    private int capacity;
    private HashMap<String,Integer> currentLootAmount;

    public Bag(int capacity){
    this.setCapacity(capacity);
    this.currentLootAmount = new HashMap<>();
    this.currentLootAmount.put("Money",0);
    this.currentLootAmount.put("Gold",0);
    this.currentLootAmount.put("Gem",0);
    }

    private void setCapacity(int value){
        if(value<1){
            throw new IllformedLocaleException("Illegal bag state.");
        }else{
            this.capacity = value;
        }
    }

    public void addItem(String item){
        this.currentItemParts = item.split("\\s+");
        if(currentItemParts[0].length()==3){
            if(!((Integer.valueOf(currentItemParts[1])+this.currentLootAmount.get("Money"))
                    >this.currentLootAmount.get("Gem"))){
                int addMoney =this.currentLootAmount.get("Money")+Integer.valueOf(currentItemParts[1]);
                this.currentLootAmount.put("Money",addMoney);
            }
        }else{
        if(currentItemParts[0].contains("gem")){
            if(!((Integer.valueOf(currentItemParts[1])+this.currentLootAmount.get("Gem"))
                    >this.currentLootAmount.get("Gold"))){
                int addGem =this.currentLootAmount.get("Gem")+Integer.valueOf(currentItemParts[1]);
                this.currentLootAmount.put("Gem",addGem);
            }
        }else{
        int addGold = Integer.valueOf(currentItemParts[1])+this.currentLootAmount.get("Gold");
        this.currentLootAmount.put("Gold",addGold);
        }
        }

    }

    @Override
    public String toString(){
        String currentItems= "Looted Items: "+System.lineSeparator();
        for (Map.Entry<String,Integer> items:this.currentLootAmount.entrySet()){
            currentItems+=items.getKey()+" "+items.getValue()+System.lineSeparator();
        }
        return currentItems;
    }

}

package SoftuniRelatedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fundamental {
//resources
    Scanner scan;
    public Fundamental(){
this.scan = new Scanner(System.in);
    }

    //Associate arrays exercises.
    //------------------------------
    public void countCharsInString(){
        HashMap<Character,Integer> currentCharCount = new HashMap<Character,Integer>();
        System.out.print("Enter text: ");
        String enterString = this.scan.nextLine();
        for(char letter:enterString.toCharArray()){
            if(letter!=' '){
                if(!currentCharCount.containsKey(letter)){
                    currentCharCount.put(letter,1);
                }else{
                    currentCharCount.put(letter,currentCharCount.get(letter)+1);
                }
            }
        }
        int spaces = enterString.replaceAll("[^ ]", "").length();
        currentCharCount.put(' ',spaces);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> item:currentCharCount.entrySet()){
            if(item.getKey()==' '){
                sb.append(String.format("%s is contained %d times%n","[whitespace]",item.getValue()));
            }else{
                sb.append(String.format("%c is contained %d times%n",item.getKey(),item.getValue()));
            }

        }
        System.out.println(sb.toString());

    }

    public void minerTask(){
        HashMap<String,Integer> currentResources = new HashMap<>();
        int counter =0;
        String enterData = this.scan.nextLine();
        String lastEnteredResource=" ";
        while(!enterData.equalsIgnoreCase("end")){
            if(counter%2==0){
            currentResources.putIfAbsent(enterData,0);
            lastEnteredResource = enterData;
            }else{
                currentResources.put(lastEnteredResource,currentResources.get(lastEnteredResource)+Integer.parseInt(enterData));
            }
            counter++;
            enterData = this.scan.nextLine();
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> item:currentResources.entrySet()){
            sb.append(String.format("Resource:%s amount:%d%n",item.getKey(),item.getValue()));
        }
        System.out.println(sb.toString());
    }

    public void legendaryFarming(){
        HashMap<String,String> currentShop =new HashMap<>();
        currentShop.put("250 shards","Shadowmourne");       //some item names
        currentShop.put("250 fragments","Valanyr");
        currentShop.put("250 motes","Dragonwrath");
    HashMap<String,Integer> currentLoot = new HashMap<>();

    }


    //------------------------------
}

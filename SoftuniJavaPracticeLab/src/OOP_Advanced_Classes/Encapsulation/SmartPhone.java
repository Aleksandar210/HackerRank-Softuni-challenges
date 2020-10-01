package OOP_Advanced_Classes.Encapsulation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmartPhone implements Callable, Browsable {
    private String name;
    Pattern linkPattern;
    Matcher matcher;

    public SmartPhone(String name){
        this.linkPattern = Pattern.compile("http://[a-zA-Z]+\\.");
    }

    public String getName(){
        return this.name;
    }

    private void setName(String name){
        if(name!=null && !name.trim().isEmpty()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
    }
    @Override
    public String browse(String link) {
        this.matcher = this.linkPattern.matcher(link);
       if(this.matcher.find()){
        return String.format("Browsing: %s",link);
       }else{
           throw new IllegalArgumentException("Link is invalid");
       }
    }

    @Override
    public String call(String phoneNumber) {
        if(phoneNumber.length()!=11){
            throw new IllegalArgumentException("Number is not valid");
        }else{
            return String.format("Calling: %s",phoneNumber);
        }
    }
}

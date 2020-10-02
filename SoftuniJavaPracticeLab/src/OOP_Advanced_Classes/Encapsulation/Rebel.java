package OOP_Advanced_Classes.Encapsulation;

public class Rebel extends FoodShortagePerson {
    private String groupName;
    public Rebel(String name, int age, String group) {
        super(name, age);
        this.setGroup(groupName);
    }

    private void setGroup(String groupName){
        if(groupName!=null && !groupName.trim().isEmpty()){
        this.groupName = groupName;
        }else{
            throw new IllegalArgumentException("Invalid groupName name");
        }
    }

    public String getGroup(){return this.groupName;}

    @Override
    public void buyFood() {
    super.buyFood();
    }

}

package OOP_Advanced_Classes.Encapsulation;

public class Rebel extends FoodShortagePerson {
    private String groupName;
    public Rebel(String name, int age, String group, String birthDate) {
        super(name, age, birthDate);
    }

    private void setGroup(String groupName){
        if(groupName!=null && !groupName.trim().isEmpty()){
        this.groupName = groupName;
        }else{
            throw new IllegalArgumentException("Invalid groupName name");
        }
    }

    @Override
    public String getId() {
        return this.groupName;
    }

    @Override
    public void buyFood() {
    super.buyFood();
    }

}

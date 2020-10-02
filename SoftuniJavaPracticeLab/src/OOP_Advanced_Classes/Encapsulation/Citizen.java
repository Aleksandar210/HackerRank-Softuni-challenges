package OOP_Advanced_Classes.Encapsulation;

public class Citizen extends FoodShortagePerson {

    public Citizen(String name, int age, String id, String birthDate) {
        super(name, age, id, birthDate);
    }

    @Override
    public void buyFood() {
        for(int i=0;i<2;i++){
            super.buyFood();
        }
    }
}

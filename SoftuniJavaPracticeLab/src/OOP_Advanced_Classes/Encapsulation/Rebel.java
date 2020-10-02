package OOP_Advanced_Classes.Encapsulation;

public class Rebel extends FoodShortagePerson {

    public Rebel(String name, int age, String id, String birthDate) {
        super(name, age, id, birthDate);
    }

    @Override
    public void buyFood() {
    super.buyFood();
    }

}

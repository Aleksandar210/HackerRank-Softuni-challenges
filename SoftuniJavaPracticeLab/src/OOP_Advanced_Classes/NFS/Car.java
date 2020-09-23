package OOP_Advanced_Classes.NFS;

public abstract class Car extends Vehicle {

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower,3);
    }

    protected Car(double fuel,int horsePower,double DEF_CONS){
        super(fuel, horsePower,DEF_CONS);
    }


}

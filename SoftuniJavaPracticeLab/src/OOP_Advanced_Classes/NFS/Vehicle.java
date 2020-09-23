package OOP_Advanced_Classes.NFS;

import java.sql.SQLInvalidAuthorizationSpecException;

public abstract class Vehicle {
    public final static double DEFAULT_FUEL_CONSUMPTION =1.25;

    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel,int horsePower){
    this.setFuel(fuel);
    this.setHorsePower(horsePower);
    this.fuelConsumption = DEFAULT_FUEL_CONSUMPTION;

    }




    public double getFuel(){return this.fuel;}

    private void setFuel(double fuel){
        if(fuel<1){
            throw new IllegalArgumentException("Illegal fuel state.");
        }else{
            this.fuel = fuel;
        }
    }

    public int getHorsePower(){return this.horsePower;}

    private void setHorsePower(int horsePower){
        if(horsePower<1){
            throw new IllegalArgumentException("Illegal fuel state.");
        }else{
            this.horsePower = horsePower;
        }
    }

    public void drive(double kilometers){
    double fuelConsumed = kilometers*this.fuelConsumption;
    if(fuelConsumed<this.getFuel()){
        this.setFuel(this.getFuel()-fuelConsumed);
    }else if(fuelConsumed>=this.getFuel()){
        this.setFuel(0);
    }

    }


}

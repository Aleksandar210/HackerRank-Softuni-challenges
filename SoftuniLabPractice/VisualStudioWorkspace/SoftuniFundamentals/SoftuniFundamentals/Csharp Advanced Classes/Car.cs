using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
   public class Car
    {
        //adding constant for default values
        private const string DefaultRegistrationnumber = "Unknown";
        private const int DefaultTravelledDistance = 0;

        //adding fields
        private string make;
        private string model;
        string registrationNumber;
        private int year;
        private double fuelQuantity;
        private double currentFuelAmount;
        private double fuelConsumption;
        private int travelledDistance;

        public Car() : this("VW", "Golf", 2025, 200, 10,DefaultRegistrationnumber)
        {
            
        }

        public Car(string make,string model,int year)
        {
            this.Make = make;
            this.Model = model;
            this.Year = year;
            this.TravelledDitance = DefaultTravelledDistance;
        }

        public Car(string make,string model,int year,double fuelQuantity,double fuelConsumption,string registrationNumber)
            :this(make,model,year)
        {
            
            this.FuelQuantity = fuelQuantity;
            this.FuelConsumption = fuelConsumption;
            this.RegistrationNumber = registrationNumber;
            

        }

        public Car(string model,double currentFuel,double fuelConsumption):this()
        {
            this.Model = model;
            this.CurrentFuelAmount = currentFuel;
            this.FuelConsumption = fuelConsumption;

        }

        //adding properties with validation
        public string Make { get; set; }
        public string Model { get; set; }

        public int Year
        {
             get { return this.year; }

            private set
            { 
                if(value<=0 || value<=1950)
                {
                    throw new ArgumentException("year cannot be les or equal to 0 or 1960");
                }
                else
                {
                    this.year = value;
                }
            }
        }

        public double CurrentFuelAmount
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Fuel cannot be 0 or below");
                }

                if(value>=this.FuelQuantity)
                {
                    this.currentFuelAmount = this.FuelQuantity;
                }
                else if(value<this.FuelQuantity)
                {
                    double neededFuel = this.FuelQuantity - this.CurrentFuelAmount;
                    if(value>=neededFuel)
                    {
                        this.CurrentFuelAmount = this.FuelQuantity;
                    }
                    else
                    {
                        this.CurrentFuelAmount += neededFuel;
                    }

                }
            }
            get { return this.currentFuelAmount; }
         }

        public int TravelledDitance { private set; get; }

        public double FuelQuantity
        {
            get { return this.fuelQuantity; }
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Quantity has to above 0");
                }
                else
                {
                    this.fuelConsumption = value;
                }
            }
        }

        public double FuelConsumption
        {
            get { return this.fuelConsumption;  }
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Consumption has to be above 0");
                }
                else
                {
                    this.fuelConsumption = value;
                }
            }
        }

        public string RegistrationNumber
        {
            get { return this.registrationNumber; }
            private set
            {
                if(value!=null)
                {
                    this.registrationNumber = value;
                }
                else
                {
                    throw new ArgumentException("No Data received for registration number");
                }
            }
        }


        //adding behaviour
        public void DriveCar(double kilometers)
        {
            double fuelConsumCalculation = (this.fuelConsumption * kilometers);
            bool canDriveThisFar = fuelConsumCalculation<=this.CurrentFuelAmount;
            if(canDriveThisFar)
            {
                this.CurrentFuelAmount -= fuelConsumCalculation;
                this.TravelledDitance += (int)kilometers;
            }
            else
            {
                throw new ArgumentException("Insuficent Fuel");
            }

        }
        

        //method for re-fuelling
        public void AddFuel(double amountFuel)
        {
            double neededFuel = this.FuelQuantity - this.CurrentFuelAmount;
            if(amountFuel==neededFuel || amountFuel>neededFuel)
            {
                this.CurrentFuelAmount = this.FuelQuantity;
            }
            else
            {
                this.currentFuelAmount += amountFuel;
            }
        }
        

        //override toString()
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append($"Make: {this.Make} Model: {this.Model } Year: {this.Year}"+Environment.NewLine);
            sb.Append($"FuelQuantity: {this.FuelQuantity} FuelConsumption: {this.FuelConsumption}"+Environment.NewLine);
            sb.Append($"Plate: {this.RegistrationNumber}");

            return sb.ToString();
        }

    }
}

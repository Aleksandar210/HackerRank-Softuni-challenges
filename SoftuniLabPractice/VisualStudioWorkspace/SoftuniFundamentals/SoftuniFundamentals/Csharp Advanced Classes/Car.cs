using System;
using System.Collections.Generic;
using System.Linq;
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
        private string registrationNumber;
        private int year;
        private int travelledDistance;
        private double fuelQuantity;
        private double currentFuelAmount;
        private double fuelConsumption;
        private Tire[] currentTires;
        private Engine currentEngine;
        private Cargo currentCargo;


        public Car() : this("VW", "Golf", 2025, 200, 10, DefaultRegistrationnumber)
        {
            this.currentTires = new Tire[4];
        }

        public Car(string model) : this()
        {
            this.Model = model;
        }

        public Car(string model, int engineSpeed, int enginePower, double cargoWeight, string cargoType,
            double tire1P, int tire1A, double tire2P, int tire2A, double tire3P, int tire3A, double tire4P, int tire4A)
            : this()
        {
            this.Engine = new Engine(engineSpeed, enginePower);
            this.Tires[0] = new Tire(tire1P, tire1A);
            this.Tires[1] = new Tire(tire2P, tire2A);
            this.Tires[2] = new Tire(tire3P, tire3A);
            this.Tires[3] = new Tire(tire4P, tire4A);
            this.Cargo = new Cargo(cargoType, cargoWeight);

        }


        public Car(string make, string model, int year)
        {
            this.Make = make;
            this.Model = model;
            this.Year = year;
            this.TravelledDitance = DefaultTravelledDistance;
            this.currentTires = new Tire[4];
        }

        public Car(string make, string model, int year, double fuelQuantity, double fuelConsumption, string registrationNumber)
            : this(make, model, year)
        {

            this.FuelQuantity = fuelQuantity;
            this.FuelConsumption = fuelConsumption;
            this.RegistrationNumber = registrationNumber;


        }

        public Car(string model, double currentFuel, double fuelConsumption) : this()
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
                if (value <= 0 || value <= 1950)
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
                if (value <= 0)
                {
                    throw new ArgumentException("Fuel cannot be 0 or below");
                }

                if (value >= this.FuelQuantity)
                {
                    this.currentFuelAmount = this.FuelQuantity;
                }
                else if (value < this.FuelQuantity)
                {
                    double neededFuel = this.FuelQuantity - this.CurrentFuelAmount;
                    if (value >= neededFuel)
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
                if (value <= 0)
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
            get { return this.fuelConsumption; }
            private set
            {
                if (value <= 0)
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
                if (value != null)
                {
                    this.registrationNumber = value;
                }
                else
                {
                    throw new ArgumentException("No Data received for registration number");
                }
            }
        }

        public Engine Engine { private set; get; }

        public Tire[] Tires { private set; get; }

        public Cargo Cargo {private set; get;}

       
        


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

        public void BalanceTirePressure()
        {
            double maxPressure = double.MinValue;
            foreach (var item in this.currentTires)
            {
                if (item.Pressure > maxPressure)
                {
                    maxPressure = item.Pressure;
                }
            }

            this.currentTires = this.currentTires.Select(e =>
            {
                e.UpdatedPressure(maxPressure);
                return e;
            }
            ).ToArray();
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
            sb.Append($"Travelled Ditance: {this.TravelledDitance}"+Environment.NewLine);
            sb.Append($"Plate: {this.RegistrationNumber}");

            return sb.ToString();
        }

    }
}

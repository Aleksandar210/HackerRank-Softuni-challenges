using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
   public class Car
    {
        //adding fields
        private string make;
        private string model;
        private int year;
        private double fuelQuantity;
        private double fuelConsumption;

        public Car()
        {

        }

        public Car(string make,string model,int year,double fuelQuantity,double fuelConsumption)
        {

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
                    throw new ArgumentException("yer cannot be les or equal to 0 or 1960");
                }
            }
        }

    }
}

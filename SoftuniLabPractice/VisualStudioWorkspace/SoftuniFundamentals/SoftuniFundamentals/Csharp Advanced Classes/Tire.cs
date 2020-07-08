using System;
using System.Collections.Generic;
using System.Data;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    public class Tire
    {
        //adding consts
        private const double DefaultPressure = 1;

        //adding fields
        double pressure;
        int age;


        //adding constructors
        public Tire()
        {
            this.Pressure = DefaultPressure;
        }

        public Tire(double pressure,int age)
        {
            this.Pressure = pressure;

        }

        //adding properties
        public double Pressure 
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Invalid amount of pressure.");
                }
                else
                {
                    this.pressure = value;
                }
            }

            get { return this.pressure; }
        }

        public int Age
        {
            private set
            {
                if(age<0)
                {
                    throw new ArgumentException("Age cannot be negative number");
                }
                else
                {
                    this.age = value;
                }
            }

            get { return this.age; }
        }

        //adding behaviour
        public void UpdatedPressure(double pressure)
        {
            this.Pressure = pressure;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    class Tire
    {
        //adding consts
        private const double DefaultPressure = 1;

        //adding fields
        double pressure;


        //adding constructors
        public Tire()
        {
            this.Pressure = DefaultPressure;
        }

        public Tire(double pressure)
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
    }
}

using System;
using System.Collections.Generic;
using System.Text;

namespace Restaurant
{
    public abstract class Beverage : Product
    {
        private double milliliters;

        protected Beverage(string name, decimal price, double milliliters):base(name,price)
        {
            this.Milliliters = milliliters;
        }

        public double Milliliters
        {
            private set 
            {
                if(value<=0)
                {
                    throw new ArgumentException("Millilters cannot be 0 or negative.");
                }
                else
                {
                    this.milliliters = value;
                }
            }

            get => this.milliliters;
        }

    }
}

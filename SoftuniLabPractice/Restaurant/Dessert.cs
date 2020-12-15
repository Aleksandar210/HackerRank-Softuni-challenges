using System;
using System.Collections.Generic;
using System.Text;

namespace Restaurant
{
    public abstract class Dessert : Food
    {
        private double calories;
        protected Dessert(string name, decimal productPrice, double grams,double calories) : base(name, productPrice, grams)
        {
            this.Calories = calories;
        }

        protected Dessert(string name):base(5m,250)
        {
            this.Name = name;
            this.Calories = 1000;
        }

        public double Calories
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Calories cannot be 0 or negative number.");
                }
                else
                {
                    this.calories = value;
                }
            }

            get => this.calories;
        }

    }
}

using System;
using System.Collections.Generic;
using System.Text;

namespace Restaurant
{
    public abstract class Food:Product
    {
        private double grams;

        protected Food(string name,Decimal productPrice,double grams) : base(name,productPrice)
        {
            this.Grams = grams;
        }

        protected Food(Decimal price, double grams):base(price)
        {
            this.Grams = grams;
        }

     

        public Double Grams
        {

            protected set
            {
                if (value<=0)
                {
                    throw new ArgumentException("Grams cannot be 0 or negative.");
                }
                else
                {
                    this.grams = value;
                }
            }

            get => this.grams;
        }
    }
}

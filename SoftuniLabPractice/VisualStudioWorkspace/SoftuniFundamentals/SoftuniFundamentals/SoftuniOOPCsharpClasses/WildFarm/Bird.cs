using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public abstract class Bird : Animal
    {
        private double wingSize;
        
        protected Bird(string name,double wingSize, double weight,int foodEaten) :base(name,weight)
        {
            this.WingSize = wingSize;
            this.FoodEaten = foodEaten;
        }

        public double WingSize
        {
            private set
            {
                if(value<0)
                {
                    throw new ArgumentException("Wing Size cannot be 0 or negative");
                }
                else
                {
                    this.wingSize = value;
                }
            }

            get => this.wingSize;
        }
    }
}

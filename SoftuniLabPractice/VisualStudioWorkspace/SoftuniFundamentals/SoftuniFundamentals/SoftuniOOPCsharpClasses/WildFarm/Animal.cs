using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public abstract class Animal
    {
        string name;
        double weight;
        int foodEaten;

        protected Animal(string name,double weight)
        {
            this.Name = name;
            this.Weight = weight;
            this.FoodEaten = 0;
        }

        public string Name
        {
            private set
            {
                if(!String.IsNullOrEmpty(value) || !String.IsNullOrWhiteSpace(value))
                {
                    this.name = value;
                }
                else
                {
                    throw new ArgumentException("Name cannot be null or empty.");
                }
            }
            get => this.name;
        }

        public double Weight
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Weight cannot be 0 or negative.");
                }
                else
                {
                    this.weight = value;
                }
            }

            get => this.weight;
        }
        public int FoodEaten
        {
            protected set
            {
                if(value<0)
                {
                    throw new ArgumentException("Food eaten cannot be negative number.");
                }
            }

            get => this.foodEaten;
        }

        public abstract void EatFood(Food food);
    }
}

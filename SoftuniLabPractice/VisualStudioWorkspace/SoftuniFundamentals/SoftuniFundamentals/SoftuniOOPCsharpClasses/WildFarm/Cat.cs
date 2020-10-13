using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public class Cat : Feline
    {
        public Cat(string name,double weight, string breed, string livingRegion) : base(name,weight, breed, livingRegion)
        {
        }

        public override void EatFood(Food food)
        {

            if (food is Meat || food is Vegetable)
            {
                this.FoodEaten += food.Quantity;
                this.Weight += (food.Quantity * 0.30);
            }
            else
            {
                throw new ArgumentException($"{this.GetType().Name} cannot eat {food.GetType().Name}");
            }
        }
        public override string ToString()
        {
            return "Mew!";
        }
    }
}

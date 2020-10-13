using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public class Dog : Mammal
    {
        public Dog(string name,double weight,string livingRegion) : base(name,weight,livingRegion)
        {
        }

        public override void EatFood(Food food)
        {

            if (food is Meat)
            {
                this.FoodEaten += food.Quantity;
                this.Weight += (food.Quantity * 0.40);
            }
            else
            {
                throw new ArgumentException($"{this.GetType().Name} cannot eat {food.GetType().Name}");
            }
        }

        public override string ToString()
        {
            return "Woof!";
        }
    }
}

using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public class Tiger : Feline
    {
        public Tiger(string name,double weight,string breed,string livingRegion) : base(name,weight,breed, livingRegion)
        {
        }

        public override void EatFood(Food food)
        {
           if(food is Meat)
            {
                this.FoodEaten += food.Quantity;
                this.Weight += (food.Quantity * 1.00);
            }
            else
            {
                throw new ArgumentException($"Tiger cannot eat {food.GetType().Name}");
            }
        }
    }
}

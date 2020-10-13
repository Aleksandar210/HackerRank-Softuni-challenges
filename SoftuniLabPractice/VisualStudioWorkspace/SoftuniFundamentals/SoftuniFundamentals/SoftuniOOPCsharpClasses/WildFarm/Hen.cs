using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public class Hen : Bird
    {
        public Hen(string name,double weight,double wingSize,int foodEaten) : base(name,weight,wingSize,foodEaten)
        {
        }

        public override void EatFood(Food food)
        {
            this.FoodEaten += food.Quantity;
            this.Weight += (food.Quantity * 0.35);
        }

        public override string ToString()
        {
            return "Cluck Cluck";
        }
    }
}

using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public class Owl : Bird
    {
        public Owl(string name,double weight,double wingSize,int foodEaten) : base(name,weight,wingSize,foodEaten) { }
        

        public override void EatFood(Food food)
        {
           
        }
    }
}

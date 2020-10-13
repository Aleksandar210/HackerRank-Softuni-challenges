using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public class Cat : Feline
    {
        public Cat(string name, string livingRegion, string breed) : base(name, livingRegion, breed)
        {
        }

        public override void EatFood(Food food)
        {
            throw new System.NotImplementedException();
        }
    }
}

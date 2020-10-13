using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public class Tiger : Feline
    {
        public Tiger(string name,double weight,string livingRegion, string breed) : base(name,weight,livingRegion, breed)
        {
        }

        public override void EatFood(Food food)
        {
            throw new NotImplementedException();
        }
    }
}

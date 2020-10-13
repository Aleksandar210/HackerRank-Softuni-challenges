using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public class Mouse : Mammal
    {
        public Mouse(string name,double weight,string livingRegion) : base(name,weight,livingRegion)
        {
        }

        public override void EatFood(Food food)
        {
            throw new NotImplementedException();
        }
    }
}

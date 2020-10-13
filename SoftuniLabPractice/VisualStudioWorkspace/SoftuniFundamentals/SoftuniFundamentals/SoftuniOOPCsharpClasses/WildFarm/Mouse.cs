using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public class Mouse : Mammal
    {
        public Mouse(string name, string livingRegion) : base(name, livingRegion)
        {
        }

        public override void EatFood(Food food)
        {
            throw new NotImplementedException();
        }
    }
}

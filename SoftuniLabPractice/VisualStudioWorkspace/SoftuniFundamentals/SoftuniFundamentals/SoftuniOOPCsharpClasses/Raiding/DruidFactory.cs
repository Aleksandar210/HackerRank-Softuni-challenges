using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.Raiding
{
    public class DruidFactory : BaseHeroFactory
    {

        public override BaseHero GetHero(string name)
        {
            return new Druid(name);
        }
    }
}

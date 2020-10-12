using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.Raiding
{
    public class PaladinFactory : BaseHeroFactory
    {
        public override BaseHero GetHero(string name)
        {
            return new Paladin(name);
        }
    }
}

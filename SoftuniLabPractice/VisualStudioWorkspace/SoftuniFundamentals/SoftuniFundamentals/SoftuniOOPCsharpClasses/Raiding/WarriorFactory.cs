using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.Raiding
{
    public class WarriorFactory : BaseHeroFactory
    {
        public override BaseHero GetHero(string name)
        {
          return new Warrior(name);
        }
    }
}

using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.Raiding
{
    public class Paladin : BaseHero
    {
        public Paladin(string name) : base(name, 100) { }

        public override string CastAbility()
        {
            return $"{GetType().Name} - {this.Name} healed for {this.Power} power";
        }
    }
}

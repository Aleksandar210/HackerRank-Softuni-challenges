using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.Raiding
{
    public class Druid : BaseHero
    {

        public Druid(string name) : base(name, 80) { }
        

        public override string CastAbility()
        {
            return $"{GetType().Name} - {this.Name} healed for {this.Power} power";
        }
    }
}

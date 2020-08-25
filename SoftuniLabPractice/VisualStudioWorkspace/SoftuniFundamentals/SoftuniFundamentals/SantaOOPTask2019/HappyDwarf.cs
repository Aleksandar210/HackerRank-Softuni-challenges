using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    public class HappyDwarf:Dwarf
    {

        public HappyDwarf(string name):base(name,100)
        {
            
        }

        public override void Work()
        {
            this.Energy -= 10;
        }
    }
}

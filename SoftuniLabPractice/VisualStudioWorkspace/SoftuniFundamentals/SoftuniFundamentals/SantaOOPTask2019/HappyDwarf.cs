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
            this.IsReady = true;        //it has to get any value true or false doesnt matter
            if(this.IsReady)
            {
                if (this.instruments.Count > 0 && this.currentInstrumentUsed is null)
                {
                    this.currentInstrumentUsed = this.instruments[0];
                }

                 this.currentInstrumentUsed.Use();
                 this.Energy -= 10;
            }
            else
            {
                throw new InvalidOperationException("Dwarf is not ready for work.");
            }

        }
    }
}

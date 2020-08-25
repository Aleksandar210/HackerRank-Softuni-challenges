using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    public class Instrument : IInstrument
    {
        private int power;

        public Instrument(int power)
        {
            
        }
        public int Power
        {
            private set
            {
                this.power = value;
                if(value<=0)
                {
                    this.power = 0;
                }
            }
            get { return this.power; }
        }

        public bool IsBroken => throw new NotImplementedException();

        public void Use()
        {
            throw new NotImplementedException();
        }
    }
}

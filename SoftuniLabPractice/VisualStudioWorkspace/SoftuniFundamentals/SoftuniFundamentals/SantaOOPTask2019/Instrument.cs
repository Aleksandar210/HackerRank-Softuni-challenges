using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    public class Instrument : IInstrument
    {
        private int power;
        private bool isBroekn;

        public Instrument(int power)
        {
            this.isBroekn = false;
        }
        public int Power
        {
            private set
            {
                this.power = value;
                if(value<=0)
                {
                    this.power = 0;
                    this.isBroekn = true;
                }
            }
            get { return this.power; }
        }

        public bool IsBroken => this.IsBroken;

        public void Use()
        {
            this.Power -= 10;
        }
    }
}

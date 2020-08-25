using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    public class Instrument : IInstrument
    {
        private int power;
        private bool isBroken;

        public Instrument(int power)
        {
            this.isBroken = false;
        }
        public int Power
        {
            private set
            {
                this.power = value;
                if(value<=0)
                {
                    this.power = 0;
                    this.isBroken = true;
                }
            }
            get { return this.power; }
        }

        public bool IsBroken => this.isBroken;

        public void Use()
        {
            this.Power -= 10;
        }
    }
}

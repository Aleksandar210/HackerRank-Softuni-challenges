using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    public abstract class Dwarf : IDwarf
    {
        protected string name;
        protected int energy;
        protected Dictionary<string, Instrument> instruments;
        public string Name 
        {
           private set
            {
                if(String.IsNullOrEmpty(value) || String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("Dwarf name cannot be null or empty.");
                }
                else
                {
                    this.name = value;
                }
            }
            get { return this.name; }
        }
        public int Energy
        { 
            private set
            {
                this.energy = value;

                if(value<=0)
                {
                    this.energy = 0;
                }
                
            }

            get { return this.energy; }
        }
        public Dictionary<string, Instrument> Instruments
        {
            get => throw new NotImplementedException(); set => throw new NotImplementedException();
        }
    }
}

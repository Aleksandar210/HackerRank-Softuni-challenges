using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    public abstract class Dwarf : IDwarf
    {
        protected string name;
        protected int energy;
        protected List<Instrument> instruments;

        public Dwarf(string name, int energy)
        {
            this.instruments = new List<Instrument>();
            this.Name = name;
            this.Energy = energy;
        }
        
        public string Name 
        {
           protected set
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
            protected set
            {
                this.energy = value;

                if(value<=0)
                {
                    this.energy = 0;
                }
                
            }

            get { return this.energy; }
        }


        public abstract void Work();
        

        public void AddInstrument(Instrument currentInstrument)
        {
            this.instruments.Add(currentInstrument);
        }
    }
}

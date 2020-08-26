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
        protected Instrument currentInstrumentUsed;
        protected bool isReady;

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

        public bool IsReady
        {
            set
            {
                if(this.instruments.Count>0 && this.Energy>=50)
                {
                    this.isReady = true;
                }
                else if(this.instruments.Count==0 && this.Energy>=50)
                {
                    this.isReady = false;
                }
                else if(this.instruments.Count == 0 && this.Energy < 50)
                {
                    this.isReady = false;
                }
                
            }
            get 
            {
                this.IsReady = true;
                return this.isReady; 
            }
        }

        public abstract void Work();

        public void AddInstrument(int power)
        {
            this.instruments.Add(new Instrument(power));
        }

        public override string ToString()
        {
            string dwarfInfo = $"Name: {this.Name}" + Environment.NewLine + $"Energy: {this.Energy}"
                + Environment.NewLine + $"Instruments : {this.instruments.Count} not broken left."
            +Environment.NewLine;
            return dwarfInfo;
        }
    }
}

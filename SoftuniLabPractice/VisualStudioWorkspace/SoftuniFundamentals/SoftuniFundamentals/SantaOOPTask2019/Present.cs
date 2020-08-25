using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    public class Present : IPresent
    {
        private string name;
        private int energyRequired;
        private bool isDone;

        public Present(string name, int energy)
        {
            this.isDone = false;
            this.Name = name;
            this.EnergyRequired = energy;
            
        }

        public string Name
        {
            private set
            {
                if(String.IsNullOrEmpty(value) || String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("Present name cannot be null or empty.");
                }
                else
                {
                    this.name = value;
                }
            }
            get { return this.name; }
        }

        public int EnergyRequired
        {
            private set
            {
                this.energyRequired = value;
                if(value<0)
                {
                    this.energyRequired = 0;
                    this.isDone = true; 
                }
            }

            get { return this.energyRequired; }
        }

        public bool IsDone => this.isDone;
     

        public void GetCrafted()
        {
           
        }
    }
}

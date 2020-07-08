using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
       public  class Cargo
    {
        private string type;
        private double weight;

        public Cargo()
        {
            this.Weight = 1;
            this.Type = "unknown";
        }

        public Cargo(string type,double weight)
        {
            this.Weight = weight;
            this.Type = type;
        }

        //ading properties
        public double Weight
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Cargo cannot be 0 or below");
                }
                else
                {
                    this.weight = value;
                }
            }

            get { return this.weight; }
        }

        public string Type { private set; get; }
    }
}

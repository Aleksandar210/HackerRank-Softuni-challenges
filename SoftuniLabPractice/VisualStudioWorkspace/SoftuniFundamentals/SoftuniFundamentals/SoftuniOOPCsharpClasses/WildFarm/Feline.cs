using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public abstract class Feline : Mammal
    {
        string breed;
        protected Feline(string name,double weight,string livingRegion,string breed) : base(name, weight,livingRegion)
        {
        }

        public string Breed
        {
            private set
            {
                if (!String.IsNullOrEmpty(value) || ! String.IsNullOrWhiteSpace(value))
                {
                    this.breed = value;
                }
                else
                {
                    throw new ArgumentException("Breed cannot be null or empty");
                }
            }

            get => this.breed;
        }
    }
}

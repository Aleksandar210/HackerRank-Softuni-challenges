using System;
using System.Collections.Generic;
using System.Reflection.Metadata;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public abstract class Mammal : Animal
    {
        private string livingRegion;
        protected Mammal(string name,double weight,string livingRegion) : base(name,weight)
        {
            this.LivingRegion = livingRegion;
        }

        public string LivingRegion
        {
            private set
            {
                if(!String.IsNullOrEmpty(value) || !String.IsNullOrWhiteSpace(value))
                {
                    this.livingRegion = value;
                }
                else
                {
                    throw new ArgumentException("Region cannot be null or empty.");
                }
            }

            get => this.livingRegion;
        }
    }
}

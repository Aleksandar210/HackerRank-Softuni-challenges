using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.Raiding
{
    public abstract class BaseHero
    {
        private string name;
        private int power;

        public BaseHero(string name, int power)
        {
            this.Name = name;
            this.Power = power;
        }

        public string Name 
        { 
            private set
            {
                if(!String.IsNullOrEmpty(value) || !String.IsNullOrWhiteSpace(value))
                {
                    this.name = value;
                }
            }

             get => this.name;
        }

        public int Power
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Hero power cannot be 0 or below than 0.");
                }
                else
                {
                    this.power = value;
                }
            }

            get => this.power;
        }

        public abstract string CastAbility();

        public override string ToString()
        {
            return $"{this.GetType().Name}: {this.Name} with {this.Power} power.";
        }

    }
}

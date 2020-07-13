using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Runtime.InteropServices.ComTypes;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    class Rabbit : IComparable<Rabbit>
    {
        private const bool DefaultAvailable = true;

        private string name;
        private string species;
        private bool available;

        public Rabbit(string name,string species)
        {
            this.Name = name;
            this.Species = species;
            this.available = DefaultAvailable;
        }

        public string Name
        {
            private set
            {
                if(value!=null)
                {
                    this.name = value;
                }
                else
                {
                    throw new ArgumentException("Name connot be null");
                }
            }

            get { return this.name; }
        }

        public string Species
        {
            private set
            {
                if(value!=null)
                {
                    this.species = value;
                }
                else
                {
                    throw new ArgumentException("Species cannot be null");
                }
            }

            get { return this.species; }
        }

        public int CompareTo([AllowNull] Rabbit other)
        {
            var compareResult = this.Name.CompareTo(other.Name);
            if(compareResult==0)
            {
                compareResult = this.Species.CompareTo(other.Species);
                if(compareResult==0)
                {
                    return 0;
                }
                else
                {
                    return compareResult;
                }
            }
            else
            {
                return compareResult;
            }
        }

        public override string ToString()
        {
            return $"Rabbit ({this.Species}: {this.Name})";
        }
    }
}

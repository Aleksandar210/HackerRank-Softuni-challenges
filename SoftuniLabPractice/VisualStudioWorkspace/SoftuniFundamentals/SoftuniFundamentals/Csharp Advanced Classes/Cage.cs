using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Text;
using System.Threading;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    class Cage : IEnumerable<Rabbit>
    {

        private const int DefaultCount = -1;

        private string name;
        private int capacity;
        private int currentCount;
        private Dictionary<string, Rabbit> data;

        public Cage(string name, int capacity)
        {
            this.Name = name;
            this.capacity = capacity;
            this.data = new Dictionary<string, Rabbit>(capacity);
            this.currentCount = DefaultCount;
        }

        public string Name
        {
            private set
            {
                if (value != null)
                {
                    this.name = value;
                }
                else
                {
                    throw new NullReferenceException("Name cannot be null");
                }
            }
            get { return this.name; }
        }

        private int Capacity        //used only inside the class
        {
             set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Caacity cannot be 0 or below");
                }
                else
                {
                    this.capacity = value;
                }
            }

            get { return this.capacity;  }
        }

        public int Count => this.currentCount;

        //adding behaviour

        public void AddRabbit(Rabbit currentRabbit)
        {
            if(this.Count+1<=this.Capacity)
            {
                this.currentCount += 1;
                if(!this.data.ContainsKey(currentRabbit.Name))
                {
                    this.data.Add(currentRabbit.Name, currentRabbit);
                }
                else
                {
                    this.currentCount -= 1;
                }
               
            }
        }
        
    }
}

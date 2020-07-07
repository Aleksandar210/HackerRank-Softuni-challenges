using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    class Parking
    {
        //adding fields
        private Dictionary<string, Car> currentParking;
        private int capacity;

        public Parking()
        {
            this.currentParking = new Dictionary<string, Car>();
            this.capacity = 0;
        }

        public Parking(int capacity)
        {

        }

        //adding prperties
        public int Capacity
        {
            get { return this.capacity; }

            private set 
            {
                if(value<=0)
                {
                    throw new ArgumentException("Space cannot be 0 or below that");
                }
                else
                {
                    this.capacity = value;
                }
            }
        }
    }
}

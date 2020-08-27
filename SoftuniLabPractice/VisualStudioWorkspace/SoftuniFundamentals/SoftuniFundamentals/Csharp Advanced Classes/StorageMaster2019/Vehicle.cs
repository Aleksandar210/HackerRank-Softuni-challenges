using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public abstract class Vehicle : IVehicle
    {
        private bool isFull;
        private bool isEmpty;
        private int capacity;
        private IReadOnlyCollection<Product> trunk;
        private double sumOfProductWeight;

        public Vehicle(int capacity)
        {
            this.Capacity = capacity;
        }

        public bool IsFull
        {
            private set
            {
                //if()
               // {

               // }
            }
            get { return this.isFull; }
        }

        public bool IsEmpty
        {
            get { return this.isEmpty; } 
        }

        public int Capacity
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Invalid capacity value.");
                }
                else
                {
                    this.capacity = value;
                }
            }
            get { return this.capacity; }
        }

        public IReadOnlyCollection<Product> Trunk
        {

            get { return this.trunk; }
        }

        private double SumOfProductWeight()
        {
            double sum = 0;
            foreach(var item in this.Trunk)
            {
                sum += item.Weight;
            }
            return sum;
        }
           
    }
}

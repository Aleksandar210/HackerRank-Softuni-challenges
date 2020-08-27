using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public abstract class Vehicle : IVehicle
    {

        //consts 
        private const int StartingSumWeight = 0;

        //fields
        private bool isFull;
        private bool isEmpty;
        private int capacity;
        private List<Product> currentTrunkCollection;
        private ReadOnlyCollection<Product> trunk;
        private double sumOfProductWeight;

        public Vehicle(int capacity)
        {
            this.Capacity = capacity;
            this.currentTrunkCollection = new List<Product>();
            this.trunk = new ReadOnlyCollection<Product>(this.currentTrunkCollection);
        }

        public bool IsFull
        {
            private set
            {
                if(this.SumOfProductWeight()>=this.Capacity)
                {
                    this.isFull = true;
                }
                else
                {
                    this.isFull = false;
                }
            }
            get { return this.isFull; }
        }

        public bool IsEmpty
        {
            private set
            {
                if(this.currentTrunkCollection.Count==0)
                {
                    this.isEmpty = true;
                }
                else
                {
                    this.isEmpty = false;
                }
            }
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

        public ReadOnlyCollection<Product> Trunk => this.trunk;
        
        public void LoadProduct(Product product)
        {
            if(this.IsFull)
            {
                throw new InvalidOperationException("Vehicle is full.");
            }
            else
            {
                this.currentTrunkCollection.Add(product);
            }
        }

        public void Unlaod()
        {
            if(this.IsEmpty)
            {
                throw new InvalidOperationException("No products left in vehicle!");
            }
            else
            {
                this.currentTrunkCollection.RemoveAt(this.currentTrunkCollection.Count - 1);
            }
        }

        private decimal SumOfProductWeight()
        {
            decimal sum = 0;
            foreach(var item in this.Trunk)
            {
                sum += (decimal)item.Weight;
            }
            return sum;
        }
           
    }
}

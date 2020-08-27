using MoreLinq;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public abstract class Storage : IStorage
    {
        //resources
        StringBuilder sb;
        //fields
        protected string name;
        protected int capacity;
        protected int garageSlots;
        protected bool isFull;
        protected List<Product> productCollection;
        protected ReadOnlyCollection<Product> products;
        protected Vehicle[] garageCollection;
        protected ReadOnlyCollection<Vehicle> garage;

        public Storage(string name,int capacity,int garageSlots)
        {
            this.Name = name;
            this.Capacity = capacity;
            this.GarageSlots = garageSlots;
            this.productCollection = new List<Product>();
            this.products = new ReadOnlyCollection<Product>(productCollection);
            this.garageCollection = new Vehicle[this.GarageSlots];
            this.garage = new ReadOnlyCollection<Vehicle>(this.garageCollection);
            this.sb = new StringBuilder();

        }

        public string Name
        {
            private set
            {
                if(String.IsNullOrEmpty(value) || String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("Invalid name.");
                }
                else
                {
                    this.name = value;
                }
            }

            get => this.name;

        }

        public int Capacity
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Invalid storage value.");
                }
                else
                {
                    this.capacity = value;
                }
            }
            get => this.capacity;
        }

        public int GarageSlots
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Invalid garage slot value.");
                }
                else
                {
                    this.garageSlots = value;
                }
            }
            get => this.garageSlots;
        }

        public bool IsFull
        {
            private set
            {
                //if()
               // {

               // }
            }
            get
            {
                this.IsFull = true;
                return this.isFull;
            }
        }

        public ReadOnlyCollection<Vehicle> Garage => this.garage;

        public ReadOnlyCollection<Product> Products => this.products;

        public Vehicle GetVehicle(int garageNumber)
        {
            if(garageNumber<0 || garageNumber>this.GarageSlots-1)
            {
                throw new InvalidOperationException("Invalid garae slot.");
            }
            else
            {
                if(this.garage[garageNumber] is null)
                {
                    throw new InvalidOperationException($"No vehicle found in {garageNumber}");
                }
                else
                {
                    return this.garage[garageNumber];
                }
            }
        }

        public int SendVehicleTo(int garageNumber, Storage storageToSend)
        {
            //implment
            return 0;
        }

        public int UnloadVehicle(int garageNumber)
        { 
          //implement
            return 0;
        }

        private decimal GetStorageCurrentWeight()
        {
            decimal sum = 0;
            sum = this.products.Select(pr => Convert.ToDecimal(pr.Weight)).Aggregate((a,b)=>a+b);
            return sum;
        }

        public override string ToString()
        {
            
        }
    }
}

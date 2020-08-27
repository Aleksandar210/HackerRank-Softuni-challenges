using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public abstract class Storage : IStorage
    {
        //fields
        protected string name;
        protected int capacity;
        protected int garageSlots;
        protected bool isFull;
        protected List<Product> productCollection;
        protected IReadOnlyCollection<Product> products;
        protected Vehicle[] garageCollection;
        protected IReadOnlyCollection<Vehicle> garage;

        public Storage(string name,int capacity,int garageSlots)
        {

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

        public int Capacity => throw new NotImplementedException();

        public int GarageSlots => throw new NotImplementedException();

        public bool IsFull => throw new NotImplementedException();

        public ReadOnlyCollection<Vehicle> Garage => throw new NotImplementedException();

        public ReadOnlyCollection<Product> Products => throw new NotImplementedException();

        public Vehicle GetVehicle(int garageNumber)
        {
            throw new NotImplementedException();
        }

        public int SendVehicleTo(int garageNumber, Storage storageToSend)
        {
            throw new NotImplementedException();
        }

        public int UnloadVehicle(int garageNumber)
        {
            throw new NotImplementedException();
        }
    }
}

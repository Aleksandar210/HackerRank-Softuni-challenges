using MoreLinq;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Runtime.ExceptionServices;
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
        protected decimal totalPrice;
        protected int garageSlots;
        protected bool isFull;
        protected List<Product> productCollection;
        protected Dictionary<string, List<Product>> currentProductsCount;
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
            this.currentProductsCount = new Dictionary<string,List<Product>>();
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
                    bool isThereFreeSpace = false;
                    foreach(var item in this.garage)
                    {
                        if(item is null)
                        {
                            isThereFreeSpace = true;
                            break;
                        }
                    }

                if(isThereFreeSpace)
                {
                    this.isFull = false;
                }
                else
                {
                    this.isFull = true;
                }

            }
            get
            {
                this.IsFull = true;
                return this.isFull;
            }
        }

        public ReadOnlyCollection<Vehicle> Garage => this.garage;

        public ReadOnlyCollection<Product> Products
        {
            private set
            {
                this.totalPrice = this.products.Select(e=>Convert.ToDecimal(e.Price)).Aggregate((a, b) => a + b);
            }
            get => this.products;
        }

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

        public Decimal GetStorageTotalPrice
        {
            private set
            {
                this.totalPrice = this.products.Select(a=>Convert.ToDecimal(a)).Aggregate((a, b) => a + b);
            }

            get => this.totalPrice;
        }

        public int SendVehicleTo(int garageNumber, Storage storageToSend)
        {
            
            int returnGarageNumberOfDestination = storageToSend.ReceiveVehicle(this.GetVehicle(garageNumber));
            this.garageCollection[garageNumber] = null;
            return returnGarageNumberOfDestination;
        }

        

        public int UnloadVehicle(int garageNumber)
        {
            int numberOfProductsBeforeUnlaod = this.productCollection.Count;
            this.productCollection.Add(this.garage[garageNumber].Unlaod());
            return 0;
        }

        private decimal GetStorageCurrentWeight()
        {
            decimal sum = 0;
            sum = this.products.Select(pr => Convert.ToDecimal(pr.Weight)).Aggregate((a,b)=>a+b);
            return sum;
        }

        private void SortProductsForDisplay()
        {
            this.currentProductsCount = this.currentProductsCount.OrderByDescending(e => e.Value.Count)
                .ThenBy(e=>e.Key)
                .ToDictionary(e => e.Key, e => e.Value);
        }

        public int ReceiveVehicle(Vehicle vehicle)
        {
            int garageSlotAddedTo=-1;
            if(this.IsThereSpaceInGarege())
            {
                for(int i=0;i<this.garageCollection.Length;i++)
                {
                    switch(this.garageCollection[i])
                    {
                        case null:
                            this.garageCollection[i] = vehicle;
                            garageSlotAddedTo = i;
                            goto exitLoop;
                            
                    }
                }
            }
            else
            {
                throw new InvalidOperationException($"No free space in {this.Name} storage");
            }

        exitLoop:
            return garageSlotAddedTo;

        }

        private bool IsThereSpaceInGarege()
        {
            bool free = false;
            this.garage.Select(e=>
            {
                switch(e)
                {
                    case null:
                        free = true;
                        break;
                }
                return e;
            }
            );

            return free;
        }


        
        public override string ToString()
        {
            this.SortProductsForDisplay();
            this.sb.Clear();
            this.sb.Append($"Stock: {this.GetStorageCurrentWeight()}/{this.Capacity}" + "[");
            var countOfProducts = this.currentProductsCount.Count;
            var counter = -1;
            foreach(var item in this.currentProductsCount)
            {
                counter++;
                if(counter==countOfProducts-1)
                {
                    this.sb.Append(item.Key + $" ({item.Value.Count})]");
                }
                else
                {
                    this.sb.Append(item.Key+$" ({item.Value.Count}), ");
                }
                
            }

            this.sb.Append(Environment.NewLine);
            this.sb.Append("[");
            counter = -1;
            foreach(var item in this.garageCollection)
            {
                counter++;
                
                if(counter==this.GarageSlots-1 && item is null)
                {
                    this.sb.Append("Empty]");
                }
                else if(counter != this.GarageSlots - 1 && item is null)
                {
                    this.sb.Append("Empty|");
                }
                else if(counter != this.GarageSlots - 1 && !(item is null))
                {
                    this.sb.Append("Empty|");
                }
                else
                {
                    this.sb.Append($"{item.GetType().Name}|");
                }
                
            }
                 
            return this.sb.ToString();

        }
    }
}

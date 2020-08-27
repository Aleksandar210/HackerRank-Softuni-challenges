using System;
using System.Collections.Generic;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public class StorageMaster : IStorageMaster
    {
        //fields
        private List<Product> productPool;
        private Dictionary<string, Storage> storagePool;
        private Vehicle currentVehicle;
        public StorageMaster()
        {
            this.productPool = new List<Product>();
            this.storagePool = new Dictionary<string, Storage>();
        }

        public string AddProduct(string type, double price)
        {
            switch(type.ToLower())
            {
                case "ram":
                    this.productPool.Add(new Ram(price));
                    break;
                case "gpu":
                    this.productPool.Add(new Gpu(price));
                    break;
                case "harddrive":
                    this.productPool.Add(new HardDrive(price));
                    break;
                case "solidstatedrive":
                    this.productPool.Add(new SolidStateDrive(price));
                    break;
                default:
                    throw new InvalidOperationException("Invalid product type!");
                    
            }

            return $"Added {type} to pool.";
        }

        public string GetStorageStatus(string storageName)
        {
            throw new NotImplementedException();
        }

        public string GetSummary()
        {
            throw new NotImplementedException();
        }

        public string LoadVehicle(IEnumerable<Product> products)
        {
            throw new NotImplementedException();
        }

        public string RegisterStorage(string type, string name)
        {
            switch(type.ToLower())
            {
                case "warehouse":
                    if(!this.DoesNameExistInPool(name))
                    {
                        this.storagePool.Add(name, new Warehouse(name));
                    }
                    break;
                case "automatedwarehouse":
                    if (!this.DoesNameExistInPool(name))
                    {
                        this.storagePool.Add(name, new AutomatedWarehouse(name));
                    }
                    break;
                case "distributioncenter":
                    if (!this.DoesNameExistInPool(name))
                    {
                        this.storagePool.Add(name, new DistributionCenter(name));
                    }
                    break;
                default:
                    throw new InvalidOperationException("Invalid type.");
                   
            }

            return $"Registered {name}.";
        }

        private bool DoesNameExistInPool(string name)
        {
            if(this.storagePool.ContainsKey(name))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public string SelectVehicle(string storageName, int garageSlot)
        {
            if(this.storagePool.ContainsKey(storageName))
            {
               if(this.storagePool[storageName].Garage[garageSlot] is null)
                {
                    throw new InvalidOperationException($"No vehicle found in {garageSlot} garage slot");
                }
                else
                {
                    this.currentVehicle = this.storagePool[storageName].GetVehicle(garageSlot);
                    return $"Selected {currentVehicle.GetType().Name}.";
                }
            }
            else
            {
                throw new InvalidOperationException("Storage not found.");
            }
        }

        public string SendVehicleTo(string sourceName, int sourceGarageSlot, string destinationName)
        {
            throw new NotImplementedException();
        }

        public string UnloadVehicle(string storageName, int garageSlot)
        {
            throw new NotImplementedException();
        }
    }
}

using System;
using System.Collections.Generic;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public class StorageMaster : IStorageMaster
    {
        //fields
        List<Product> productPool;
        public StorageMaster()
        {
            this.productPool = new List<Product>();
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

            return $"Added {type} to pool".;
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
            throw new NotImplementedException();
        }

        public string SelectVehicle(string storageName, int garageSlot)
        {
            throw new NotImplementedException();
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

using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public interface IStorageMaster
    {
        string AddProduct(string type, double price);
        string RegisterStorage(string type, string name);
        string SelectVehicle(string storageName, int garageSlot);
        string LoadVehicle(IEnumerable<Product>products);
        string SendVehicleTo(string sourceName, int sourceGarageSlot, string destinationName);
        string UnloadVehicle(string storageName, int garageSlot);
        string GetStorageStatus(string storageName);
        string GetSummary();

    }
}

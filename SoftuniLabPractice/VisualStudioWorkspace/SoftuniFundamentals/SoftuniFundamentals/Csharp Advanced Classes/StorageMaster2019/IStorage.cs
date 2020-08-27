using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public interface IStorage
    {
        //properties
        string Name { get; }
        int Capacity { get; }
        int GarageSlots { get; }
        bool IsFull { get; }
        ReadOnlyCollection<Vehicle> Garage { get; }
        ReadOnlyCollection<Product> Products { get; }

        //behaviour
        Vehicle GetVehicle(int garageNumber);
        int SendVehicleTo(int garageNumber, Storage storageToSend);     //return the garage number when it was trafnsferd
        int UnloadVehicle(int garageNumber);        //returns number unloaded packages

    }
}

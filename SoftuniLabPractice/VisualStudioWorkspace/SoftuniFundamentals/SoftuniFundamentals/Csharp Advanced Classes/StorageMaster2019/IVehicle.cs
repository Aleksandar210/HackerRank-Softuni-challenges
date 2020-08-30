using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public interface IVehicle
    {
        bool IsFull { get; }
        bool IsEmpty { get; }
        int Capacity { get; }
        ReadOnlyCollection<Product> Trunk { get; }        //it will use a list
        void LoadProduct(Product product);
        Product Unlaod();      //unloads the last product if passed if it has no products exc


    }
}

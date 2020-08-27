using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public interface IVehicle
    {
        bool IsFull { get; }
        bool IsEmpty { get; }
        int Capacity { get; }
         IReadOnlyCollection<Product> Trunk { get; }

    }
}

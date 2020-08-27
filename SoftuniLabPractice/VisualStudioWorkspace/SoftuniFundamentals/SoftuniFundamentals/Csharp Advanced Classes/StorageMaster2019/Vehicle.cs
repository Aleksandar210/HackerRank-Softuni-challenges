using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public abstract class Vehicle : IVehicle
    {
        public bool IsFull => throw new NotImplementedException();

        public bool IsEmpty => throw new NotImplementedException();

        public int Capacity => throw new NotImplementedException();

        public IReadOnlyCollection<Product> Trunk => throw new NotImplementedException();
    }
}

using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    public interface IPresent
    {
        string Name { get; }
        int EnergyRequired { get; }
        bool IsDone { get; }
        void GetCrafted();
    }
}

using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    public interface IPresnet
    {
        string Name { get; }
        int EnergyRequired { get; }
        bool IsDone { get; }
        void GetCrafted();
    }
}

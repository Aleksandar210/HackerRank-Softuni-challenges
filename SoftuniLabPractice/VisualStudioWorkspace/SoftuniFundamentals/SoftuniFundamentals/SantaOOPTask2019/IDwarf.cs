using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
   public interface IDwarf
    {
        
        string Name { get;  }
        int Energy { get; }
        bool IsReady { get; }
        void AddInstrument(int power);
        abstract void Work();
    }
}

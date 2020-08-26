using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
   public interface IDwarf
    {
        
        string Name { get;  }
        int Energy { get; }
        void AddInstrument(int power);
    }
}

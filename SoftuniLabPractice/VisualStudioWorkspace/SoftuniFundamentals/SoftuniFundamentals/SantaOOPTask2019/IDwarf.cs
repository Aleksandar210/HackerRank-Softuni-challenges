using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
   public interface IDwarf
    {
        
        string Name { get;  }
        int Energy { get; }
        Dictionary<string, Instrument> Instruments { get;}
    }
}

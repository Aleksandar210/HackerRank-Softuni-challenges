using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
   public interface IDwarf
    {
        
        string Name { get; set; }
        int Energy { get; set; }
        Dictionary<string, Instrument> Instruments { get; set;}
    }
}

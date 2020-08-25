using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    interface IInstrument
    {
        int Power { get; }
        bool IsBroken { get; }
        void Use();
    }
}

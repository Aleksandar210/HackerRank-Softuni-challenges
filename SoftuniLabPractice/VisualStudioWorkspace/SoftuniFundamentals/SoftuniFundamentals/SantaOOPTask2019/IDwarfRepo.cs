using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    interface IDwarfRepo
    {
        void Add(IDwarf dwarfToAdd);
        bool Remove(IDwarf dwarfToRemove);
        IDwarf FindByName(string name);
    }
}

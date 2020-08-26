using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    public interface IController
    {
        void AddDwarf(string type,string name);
        void AddInstrumentToDwarf(string name, int power);
        void AddPresent(string name, int energy);
        void CraftPresent(string presentName);
        void Report();
    }
}

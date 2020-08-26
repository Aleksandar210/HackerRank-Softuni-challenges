using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    interface IPresentRepo
    {
        void AddPresent(IPresent presentToAdd);
        bool RemovePresent(IPresent presentToRemove);
        IPresent FindByName(string name);

        
    }
}

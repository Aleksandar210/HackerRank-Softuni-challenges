using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    class Workshop : IWorkshop
    {

        public Workshop()
        {

        }
        public void Craft(IPresent present, IDwarf dwarf)
        {
            while(true)
            {
                dwarf.Work();
                present.GetCrafted();
                if(present.IsDone)
                {
                    break;
                }
            }
           
        }

        
    }
}

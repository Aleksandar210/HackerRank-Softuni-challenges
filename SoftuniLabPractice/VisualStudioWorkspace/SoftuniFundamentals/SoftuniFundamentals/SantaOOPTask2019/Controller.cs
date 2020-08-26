using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    class Controller:IController
    {
        private DwarfRepository currentDwarfs;
        private PresentRepository currentPresents;
        public Controller()
        {
            this.currentDwarfs = new DwarfRepository();
            this.currentPresents = new PresentRepository();
        }

        public void AddDwarf(string type, string name)
        {
            throw new NotImplementedException();
        }

        public void AddInstrumentToDwarf(string name, int power)
        {
            this.currentDwarfs.FindByName(name).AddInstrument(power);
        }

        public void AddPresent(string name, int energy)
        {
            throw new NotImplementedException();
        }

        public void CraftPresent(string presentName)
        {
            throw new NotImplementedException();
        }
    }
}

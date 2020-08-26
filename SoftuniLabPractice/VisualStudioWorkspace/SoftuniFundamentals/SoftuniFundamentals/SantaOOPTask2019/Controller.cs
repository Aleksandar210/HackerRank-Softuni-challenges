using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    class Controller:IController
    {
        //consts
        private const int StartingCount = 0;

        //fields
        private int presentsCrafted;
        private DwarfRepository currentDwarfs;
        private PresentRepository currentPresents;
        public Controller()
        {
            this.currentDwarfs = new DwarfRepository();
            this.currentPresents = new PresentRepository();
        }

        public void AddDwarf(string type, string name)
        {
            Dwarf currentDwarfToAdd = null;
            switch(type.ToLower())
            {
                case "sleepydwarf":
                    this.currentDwarfs.Add(currentDwarfToAdd = new SleepyDwarf(name));
                    Console.WriteLine($"Successfully added {type} named {name}.");
                break;

                case "happydwarf":
                    this.currentDwarfs.Add(currentDwarfToAdd = new HappyDwarf(name));
                    Console.WriteLine($"Successfully added {type} named {name}.");
                    break;
                default:
                    throw new InvalidOperationException("Invalid dwarf type.");
                    
            }
        }

        

        public void AddInstrumentToDwarf(string name, int power)
        {
            this.currentDwarfs.FindByName(name).AddInstrument(power);
        }

        public void AddPresent(string name, int energy)
        {
            Present currentPresentToAdd;
            this.currentPresents.AddPresent(currentPresentToAdd = new Present(name,energy));
        }

        public void CraftPresent(string presentName)
        {
            //implement
        }
    }
}

using MoreLinq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
    class Controller:IController
    {
        //resources
        StringBuilder sb;
        //consts
        private const int StartingCount = 0;

        //fields
        private int presentsCrafted;
        private DwarfRepository currentDwarfs;
        private PresentRepository currentPresents;
        private Workshop currentWorkshop;
        public Controller()
        {
            this.presentsCrafted = StartingCount;
            this.currentDwarfs = new DwarfRepository();
            this.currentPresents = new PresentRepository();
            this.currentWorkshop = new Workshop();
            this.sb = new StringBuilder();
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
            Dwarf dwarfToCraftIt;
            Present presentToCraft;

            //get availabel dwarfs for the present
            var availableDwarfs = this.currentDwarfs.Where(dwarf => dwarf.IsReady).ToList();
            //if no dwarfs
            if(availableDwarfs.Count==0)
            {
                Console.WriteLine("No Available Dwarfs.");
                return;
            }
            else //if it has dwarfs get the first
            {
                dwarfToCraftIt = (Dwarf)availableDwarfs[0];

                //find the present in the repo
                try
                {
                    presentToCraft = (Present)this.currentPresents.FindByName(presentName);
                    this.currentWorkshop.Craft(presentToCraft,dwarfToCraftIt);
                    if(presentToCraft.IsDone)
                    {
                        this.presentsCrafted++;
                    }

                    if(!dwarfToCraftIt.IsReady) //not sure if it will be executed
                    {
                        this.currentDwarfs.Remove(dwarfToCraftIt);
                    }

                }
                catch(NullReferenceException exc) //if present is not found display error message and continue
                {
                    Console.WriteLine(exc.Message);
                    return;
                }
                catch(InvalidOperationException ex)
                {
                    this.currentDwarfs.Remove(dwarfToCraftIt);
                }
                
            }            
            
        }

        public void Report()
        {
            this.sb.Clear();
            this.sb.Append("Presents crafted" + ": " + this.presentsCrafted + Environment.NewLine);
            this.sb.Append(new String('-', 10) + Environment.NewLine);
            this.sb.Append("Dwarf info: " + Environment.NewLine);
            this.currentDwarfs.ForEach(e => this.sb.Append(e + Environment.NewLine));
            Console.WriteLine(this.sb.ToString());
        }
    }
}

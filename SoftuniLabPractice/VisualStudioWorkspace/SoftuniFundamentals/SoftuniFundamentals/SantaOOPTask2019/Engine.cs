using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SantaOOPTask2019
{
   public class Engine:IEngine
    {
        //fields
        private Controller currentController;
        private bool isExit;
        
        public Engine()
        {
            currentController = new Controller();
            this.isExit = false;
        }

        public bool IsExit => this.isExit;

        public void ReadInput(string input)
        {
            string[] temp = input.Split(" ",StringSplitOptions.RemoveEmptyEntries);
            switch(input.ToLower())
            {
                case "adddwarf":
                    this.currentController.AddDwarf(temp[1], temp[2]);
                    break;
                case "addpresent":
                    this.currentController.AddPresent(temp[1], int.Parse(temp[2]));
                    break;
                case "addinstrumenttodwarf":
                    this.currentController.AddInstrumentToDwarf(temp[1], int.Parse(temp[2]));
                    break;
                case "craftpresent":
                    this.currentController.CraftPresent(temp[1]);
                    break;
                case "report":
                    this.currentController.Report();
                    break;
                case "exit":
                    this.isExit = true;
                    break;
            }
        }

        
    }
}

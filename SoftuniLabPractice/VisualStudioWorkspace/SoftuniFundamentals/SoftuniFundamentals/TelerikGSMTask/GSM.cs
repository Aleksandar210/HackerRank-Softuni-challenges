using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text;
using System.Text.RegularExpressions;
using System.Transactions;

namespace SoftuniFundamentals.TelerikGSMTask
{
    class GSM
    {
        private const double PRICE_DEFAULT = 0.0;

        private double price;
        private string owner;
        private string manufacturer;
        private string model;
        private Battery battery;
        private Display display;




        public double Price
            {
             get
            {
                return this.price;
            }

             set
            {
                if (value <= 0)
                {
                    throw new ArgumentException("Invalid Price");
                }
                else
                {
                    this.price = value;
                }
            }

            }



        public string OwnerName 
        {
            get
            {
                return this.owner;
            }

            set
            {
                if (ValidateOwnerName(value) == true)
                {
                    this.owner = value;
                }
                else
                {
                    throw new ArgumentException("Invalid Name");
                }
            }
        }


        public string Manufacturer
        {
            get
            {
                return this.manufacturer;
            }

            set
            {
                if (ValidateManufacturer(value) == true)
                {
                    this.manufacturer = value;
                }
                else
                {
                    throw new ArgumentException("Invalid Manufacturer");
                }
            }
        }
        public string Model { get; set; }




        public GSM(string model, string manufacturer, string owner, double price,string batteryType)
        {
            this.Price = price;
            this.model = model;
            this.manufacturer = manufacturer;
            this.owner = owner;
            

        }

        private bool ValidateOwnerName(string enteredName)
        {
            Regex currentRegex = new Regex("[A-Z][a-z]+ [A-Z][a-z]+");
            Match currentMatcher = currentRegex.Match(enteredName);
            if (currentMatcher.Success)
            {
                return true;

            }
            else
            {
                return false;
            }

        }

        private bool ValidateManufacturer(string enterd)
        {
            Regex current = new Regex("^[_A-z0-9]*((-|\\s)*[_A-z0-9])*$");
            Match currentMatcher = current.Match(enterd);
            if (currentMatcher.Success)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        private void CreateBatteryClass(string enteredType)
        {
            switch (enteredType.ToLower())
            {
                case "nimh":
                    this.battery = new Battery();

                    break;
            }
        }

        private enum BatteryType
        {
            NiMH,
            LiON,
            NiCD
        }
            


        
    }
}

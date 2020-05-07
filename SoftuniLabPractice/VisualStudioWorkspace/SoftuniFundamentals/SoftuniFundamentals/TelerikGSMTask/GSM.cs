using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text;
using System.Text.RegularExpressions;

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
                    throw new ArgumentException("Price is not Valid");
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



        public GSM(string model, string manufacturer, string owner, double price)
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

        private enum BatteryTypes
        {

        }
            


        
    }
}

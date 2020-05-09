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
        private const double PRICE_MINUTE = 0.37;
        private bool uknownBattery;
        private double price;
        private string owner;
        private string manufacturer;
        private string model;
        private Battery battery;
        private Display display;
        private List<Call> currentMadeCalls;
        private double currentPhoneBill;
        private Call currentCallDialed;
        private string phoneNumber;


        public GSM(string model, string manufacturer, string owner,string number ,double price, string batteryType)
        {
            this.Price = price;
            this.model = model;
            this.manufacturer = manufacturer;
            this.owner = owner;
            currentMadeCalls = new List<Call>();

        }

        public GSM()
        {
            currentMadeCalls = new List<Call>();
        }


        public void AddCall(string[] info)
        {
            Call currentCall = new Call(PRICE_MINUTE);
            currentCall.MakeCall(info);
            this.currentCallDialed = currentCall;
        }

        

        public void DeleteCall()
        {
            if (this.currentMadeCalls.Count == 0)
            {
                Console.WriteLine("Empty History!");
            }
            else
            {
                int counter = 1;
                foreach (var call in this.currentMadeCalls)
                {
                    Console.WriteLine(counter + ": "  + call);
                    Console.WriteLine();
                }
                int select;
                do
                {
                    select = int.Parse(Console.ReadLine());
                    if (!(select < 1 || (select > counter)))
                    {
                        this.currentMadeCalls.RemoveAt(select);
                    }
                    else
                    {
                        Console.WriteLine("Invalid Call Index");
                    }
                }
                while (select < 1 || select > counter);
            }
           

        }

        public void ClearHistory()
        {
            this.currentMadeCalls.Clear();
        }

        public void ShowHisotry()
        {
            foreach(Call item in currentMadeCalls)
            {
                Console.WriteLine(item);
                Console.WriteLine();
            }
        }





        private void CreateBatteryClass(string enteredType)
        {
            switch (enteredType.ToLower())
            {
                case "nimh":
                    this.uknownBattery = false;
                    this.battery = new Battery(BatteryType.NiMH.ToString(),20,6);
                    break;
                case "lion":
                    this.uknownBattery = false;
                    this.battery = new Battery(BatteryType.LiON.ToString(), 24, 10);
                    break;
                case "nicd":
                    this.uknownBattery = false;
                    this.battery = new Battery(BatteryType.NiCD.ToString(), 30, 15);
                    break;
                default:
                    this.battery = new Battery();
                    this.uknownBattery = true;
                    break;
            }
        }


        public string CurrentNumber
        {
            get
            {
                return this.phoneNumber;
            }
            set
            {
                Regex regex = new Regex("^[0-9]{10}$");
                if (regex.IsMatch(value))
                {
                    this.phoneNumber = value;
                }
                else
                {
                    throw new ArgumentException("Invalid Phone");
                }

            }
        }


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

        public bool IsStockBattery
        {
            get
            {
                return this.uknownBattery;
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





        private enum BatteryType
        {
            NiMH,
            LiON,
            NiCD
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



        public override string ToString()
        {
            return $"{this.Manufacturer}, {this.Model}- current Model, to -{this.OwnerName} {Environment.NewLine}" +
                $"{this.battery} {Environment.NewLine} {this.display} ";
        }

    }
}

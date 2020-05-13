using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Globalization;
using System.Runtime.CompilerServices;
using System.Text;

namespace SoftuniFundamentals.TelerikGSMTask
{
    class Call
    {
        private bool nameAvailable;
        private int minutes;
        private DateTime currentDateDialed;
        private Stopwatch currentStopWatch;
        private double priceOfCall;
        private double currentPriceForCall;
        private string phoneDialed;
        private string nameDialed;
        

        public Call(double price)
        {
            
            this.currentDateDialed = new DateTime();
            this.currentStopWatch = new Stopwatch();
            this.currentPriceForCall = price;
        }

        public double Price
        {
            get
            {
                return this.priceOfCall;
            }
           
        }

        public string DateOfCall
        {
            get
            {
                string text = this.currentDateDialed.ToString("MM/dd/yyyy",CultureInfo.InvariantCulture);
                return text;
                               
            }
        } 

        public void MakeCall(string[] information)
        {
            if (information.Length > 1)
            {
                this.nameDialed = information[0];
                this.phoneDialed = information[1];
                this.nameAvailable = true;
            }
            else
            {
                this.nameAvailable = false;
                this.phoneDialed = information[0];
            }

            currentDateDialed = DateTime.Now;
            this.currentStopWatch.Start();
            
        }

        public void EndCall()
        {
            this.currentStopWatch.Stop();
            string currentTime = string.Format("{0:hh\\:mm\\:ss}", this.currentStopWatch.Elapsed);
            string[] getTimeComponents = currentTime.Split(':');
            this.minutes = (int.Parse(getTimeComponents[0])*60)+ int.Parse(getTimeComponents[1]);
            this.priceOfCall = currentPriceForCall * minutes;
        }

        

        public override string ToString()
        {
            if (this.nameAvailable)
            {
                return $"{this.DateOfCall} : {this.nameDialed}-{this.phoneDialed}";
            }
            else
            {
                
                return this.DateOfCall+" "+this.phoneDialed;
            }
           
        }
    }
}

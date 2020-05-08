using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.TelerikGSMTask
{
    class Battery
    {
        private const int TALK_DEFAULT = 0;
        private const int IDLE_TIME_DEFAULT = 0;
        private const string DEFAULT_MODEL ="N/A";
        private string model;
        private int hourIdle;
        private int hourTalk;


        public Battery()
        {
            this.model = DEFAULT_MODEL;
            this.hourTalk = TALK_DEFAULT;
            this.hourIdle = IDLE_TIME_DEFAULT;

        }



        public Battery(string model, int talk, int idle)
        {
            this.IdleTime = idle;
            this.TalkTime = talk;
            this.Model = model;
            
        }



        public int IdleTime
        {
            get
            {
                return this.hourIdle;
            }
            set
            {
                if (ValidateHour(value))
                {
                    this.hourIdle = value;
                }
                else
                {
                    throw new ArgumentException("Invalid Idle");
                }
            }
        }

        public int TalkTime 
        {
            get
            {
                return this.hourTalk;
            }
            set
            {
                if (ValidateHour(value))
                {
                    this.hourTalk = value;
                }
                else
                {
                    throw new ArgumentException("Invalid Talk");
                }
            }
        }

        public string Model { get; set;  }


        private bool ValidateHour(int entered)
        {
            if (entered <= 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        public override string ToString()
        {
            string current = $"{this.Model} with {this.IdleTime} idel time and {this.TalkTime} talking time";
            return current;
        }


    }

  
}

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
            
        }



        public int IdleTime
        {
            get
            {
                return this.hourIdle;
            }
            set
            {
                if (ValidatedIdle(value))
                {
                    this.hourIdle = value;
                }
                else
                {
                    throw new ArgumentException("Invalid Idle");
                }
            }
        }


        private bool ValidatedIdle(int entered)
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

    }

  
}

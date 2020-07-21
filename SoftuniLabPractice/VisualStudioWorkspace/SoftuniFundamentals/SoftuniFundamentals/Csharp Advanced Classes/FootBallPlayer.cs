using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    class FootBallPlayer
    {
        //cosnts
        private int DefaultStatValue = 0;

        //fields
        private string name;
        // stats of player
        private int endurance;      
        private int sprint;
        private int drible;
        private int passing;
        private int shooting;


        //constructors
        public FootBallPlayer(string name, params int[] stats):this(name)
        {
            this.InitialiseStats(stats);
        }

        private FootBallPlayer(string name)
        {
            this.Name = name;
            this.Endurance = DefaultStatValue;
            this.Sprint = DefaultStatValue;
            this.Drible = DefaultStatValue;
            this.Passing = DefaultStatValue;
            this.Shooting = DefaultStatValue;
        }
            
        private void InitialiseStats(int[] currentStatsGiven)
        {
            switch(currentStatsGiven.Length)
            {
                case 0: break;
                case 1: this.Endurance = currentStatsGiven[0]; break;
                case 2:
                    this.Endurance = currentStatsGiven[0];
                    this.Sprint = currentStatsGiven[1];
                    break;
                case 3:
                    this.Endurance = currentStatsGiven[0];
                    this.Sprint = currentStatsGiven[1];
                    this.Drible = currentStatsGiven[2];
                    break;
                case 4:
                    this.Endurance = currentStatsGiven[0];
                    this.Sprint = currentStatsGiven[1];
                    this.Drible = currentStatsGiven[2];
                    this.Passing = currentStatsGiven[3];
                    break;
                case 5:
                    this.Endurance = currentStatsGiven[0];
                    this.Sprint = currentStatsGiven[1];
                    this.Drible = currentStatsGiven[2];
                    this.Passing = currentStatsGiven[3];
                    this.Shooting = currentStatsGiven[4];
                    break;

            }
        }

        //properties
        public string Name
        {
            private set
            {
                if(String.IsNullOrEmpty(value))
                {
                    throw new NullReferenceException("Invalid or missing name!");
                }
                else
                {
                    this.name = value;
                }
            }
            get { return this.name; }
        }

        public int Endurance
        {
            private set
            {
                if(value<0 || value>100)
                {
                    throw new ArgumentException("Invalid range for stat [0-100]");
                }
                else
                {
                    this.endurance = value;
                }
            }
            get { return this.endurance; }
        }

        public int Sprint
        {
            private set
            {
                if (value < 0 || value > 100)
                {
                    throw new ArgumentException("Invalid range for stat [0-100]");
                }
                else
                {
                    this.sprint = value;
                }
            }
            get { return this.sprint; }
        }

        public int Drible
        {
            private set
            {
                if (value < 0 || value > 100)
                {
                    throw new ArgumentException("Invalid range for stat [0-100]");
                }
                else
                {
                    this.drible = value;
                }
            }
            get { return this.drible; }
        }

        public int Passing
        {
            private set
            {
                if (value < 0 || value > 100)
                {
                    throw new ArgumentException("Invalid range for stat [0-100]");
                }
                else
                {
                    this.passing = value;
                }
            }
            get { return this.passing; }
        }

        public int Shooting
        {
            private set
            {
                if (value < 0 || value > 100)
                {
                    throw new ArgumentException("Invalid range for stat [0-100]");
                }
                else
                {
                    this.shooting = value;
                }
            }
            get { return this.shooting; }
        }
    }
}

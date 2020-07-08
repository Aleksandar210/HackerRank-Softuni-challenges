using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
   public class Engine
    {
        //adding consts
        private const int DefaultSpeed = 100;
        private const int DefaultPower = 250;

        //adding fields
      private int engineSpeed;
      private int enginePower;

        //adding constructs
        public Engine()
        {
            this.EnginePower = DefaultPower;
            this.EngineSpeed = DefaultSpeed;
        }

        public Engine(int engineSpeed,int enginePower)
        {
            this.EnginePower = enginePower;
            this.EngineSpeed = engineSpeed;
        }

        //adding properties
        public int EngineSpeed
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Speed cannot be 0 or below");
                }
                else
                {
                    this.engineSpeed = value;
                }

            }

             get { return this.engineSpeed; }
        }
        

        public int EnginePower
        {
            private set
            {
                if (value <= 0)
                {
                    throw new ArgumentException("Speed cannot be 0 or below");
                }
                else
                {
                    this.enginePower = value;
                }

            }

            get { return this.enginePower; }
        }

        //adding behaviour


    }
}

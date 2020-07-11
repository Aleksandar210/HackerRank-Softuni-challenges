using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    class Player
    {
        //adding consts
        private const string DefaultRank = "Trial";
        private const string DefaultDescription = "n/a";

        //adding fields
        private string name;
        private string playerClass;
        private string description;
        private string playerRank;

        //adding constructors

        public Player(string name, string playerClass)
        {

        }

        //adding properties
        public string Name
        {
            private set
            {
                if (value != null)
                {
                    this.name = value;
                }
                else
                {
                    throw new ArgumentException("Invalid Player Name");
                }
            }

            get { return this.name; }
        }

    }
}

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
            this.Name = name;
            this.Class = playerClass;
            this.Rank = DefaultRank;
            this.Desicrption = DefaultDescription;
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

        public string Class
        {
            private set
            {
                if (value != null && value.Length>3)
                {
                    this.playerClass = value;
                }
                else
                {
                    throw new ArgumentException("Invalid Class For Player");
                }

            }

            get { return this.playerClass; }
        }


        public string Rank { private set; get; }

        public string Desicrption { set; get; }


        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append($"Name: {this.Name}- {this.Class}"+Environment.NewLine);
            sb.Append($"Rank: {this.Rank}" + Environment.NewLine);
            if(!this.Desicrption.Equals(DefaultDescription))
            {
                sb.Append(this.Desicrption);
            }
            Console.WriteLine(sb.ToString());
            
        }
    }
}

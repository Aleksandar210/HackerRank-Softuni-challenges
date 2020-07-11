using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    class Player : IComparable<Player>
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


        public string Rank { set; get; }

        public string Desicrption { set; get; }


        // add logic for comparing it with other objects of same type
        public int CompareTo( Player other)
        {
            var compareResult =this.Name.CompareTo(other.Name);
            if(compareResult==0)
            {
               if(this.Rank.Equals("Trial",StringComparison.OrdinalIgnoreCase) &&
                    other.Rank.Equals("Trial", StringComparison.OrdinalIgnoreCase))
                {
                    compareResult = this.Class.CompareTo(other.Class);
                    if(compareResult==0)
                    {
                        if(this.Rank.Equals(DefaultDescription, StringComparison.OrdinalIgnoreCase) &&
                    other.Rank.Equals(DefaultDescription, StringComparison.OrdinalIgnoreCase))
                        {
                            return 0;
                        }
                        else if(this.Rank.Equals(DefaultDescription, StringComparison.OrdinalIgnoreCase) &&
                   !(other.Rank.Equals(DefaultDescription, StringComparison.OrdinalIgnoreCase)))
                        {
                            return 1;
                        }
                        else
                        {
                            return -1;
                        }
                    }
                    else
                    {
                        return compareResult;
                    }
                }
                else if(this.Rank.Equals("Trial", StringComparison.OrdinalIgnoreCase) &&
                    !(other.Rank.Equals("Trial", StringComparison.OrdinalIgnoreCase)))
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
            else
            {
                return compareResult;
            }
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append($"Name: {this.Name}- {this.Class}"+Environment.NewLine);
            sb.Append($"Rank: {this.Rank}" + Environment.NewLine);
            if(!this.Desicrption.Equals(DefaultDescription))
            {
                sb.Append(this.Desicrption);
            }
            return sb.ToString();
            
        }
    }
}

using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    class Guild: IEnumerable<Player>
    {
        //adding fields;
        private string name;
        private int capacity;
        private int index = 0;

        private Dictionary<string,Player> roster;
        HashSet<string> playerClassesInRoster;

        //adding constructors
        public Guild(string name,int capacity)
        {
            this.Name = name;
            this.Capacity = capacity;
            this.roster = new Dictionary<string, Player>(capacity);
            this.playerClassesInRoster = new HashSet<string>(capacity);
            this.index = -1;
        }

        //adding properties

        public string Name 
        {
            private set
            {
                if(value!=null)
                {
                    this.name = value;
                }
                else
                {
                    throw new ArgumentException("Invalid Name or Null");
                }
            }

            get { return this.name; }
        }

        public int Capacity
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Invaid Capacity cannot be 0 or below");
                }
                else
                {
                    this.capacity = value;
                }
            }

            get { return this.capacity; }
        }

        public int Count => this.index;
        


        //adding behaviour
        public void AddPlayer(Player currentPlayer)
        {

            if (this.index + 1 <= this.Capacity)
            {
                this.index += 1;
                
                if(this.roster.ContainsKey(currentPlayer.Name))
                {
                    this.index -= 1;
                }
                else
                {
                    this.roster.Add(currentPlayer.Name, currentPlayer);
                    this.playerClassesInRoster.Add(currentPlayer.Class);
                }
                
            }
            else
            {
                throw new IndexOutOfRangeException("Index out  of range or Roster already full");
            }

        }

        public void ExpandGuild(int number)
        {
            if(number>this.Capacity)
            {
                this.Capacity = number;
            }
            else
            {
                throw new ArgumentException("Expand Count cannot be below or equal to current");
            }
        }

        public Player RemovePlayer(string name)
        {
            if(this.roster.ContainsKey(name))
            {
                Player currentRemovedPlayer = this.roster[name];
                this.roster.Remove(name);
                this.index -= 1;
                return currentRemovedPlayer;
            }
            else
            {
                throw new ArgumentException("No such player in the roster");
            }
        }


        public List<Player> KickPlayerByClass(string playerClass)
        {
            if(this.playerClassesInRoster.Contains(playerClass))
            {
                this.playerClassesInRoster.Remove(playerClass);

                //Colletion of removed players with playerClass name
                List<Player> currentRemovedPlayers = new List<Player>();

                // get Dictionary without the players with the className
                this.roster = this.roster.Where(player =>
                {
                    if(player.Value.Class.Equals(playerClass))
                    {
                        currentRemovedPlayers.Add(player.Value);
                        this.index--;
                        this.roster.Remove(player.Key);
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }).ToDictionary(e => e.Key, e=>e.Value);

                return currentRemovedPlayers;
            }

            return null;
        }


        public void PromotePlayer(string name)
        {
            if (this.roster.ContainsKey(name))
            {
                this.roster[name].Rank = "Member";
            }
            else throw new ArgumentException("No uh player found");
        }

        public void DemotePlayer()
        {
            if (this.roster.ContainsKey(name))
            {
                this.roster[name].Rank = "Trial";
            }
            else throw new ArgumentException("No uh player found");
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append($"Players in {this.Name}: {this.index + 1}" + Environment.NewLine);
            this.roster.Select(e =>
            {
                sb.Append(e.Value + Environment.NewLine);
                return e;
            }
            );
            return sb.ToString();
        }

        public string Report()
        {
            return this.ToString();
        }


        //Interface Enumerable implementation
        public IEnumerator<Player> GetEnumerator()
        {
            foreach(var item in this.roster)
            {
                yield return item.Value;
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            throw new NotImplementedException();
        }
    }
}

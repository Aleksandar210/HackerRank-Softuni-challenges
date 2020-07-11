using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes
{
    class Guild
    {
        //adding fields;
        private string name;
        private int capacity;
        private int index = 0;

        private Dictionary<string,Player> roster;

        //adding constructors
        public Guild(string name,int capacity)
        {
            this.Name = name;
            this.Capacity = capacity;
            this.roster = new Dictionary<string, Player>(capacity);
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
                }
                
            }
            else
            {
                throw new IndexOutOfRangeException("Index out  of range or Roster already full");
            }

        }

        public void ExpandGuild(int number)
        {
            if(number>this.roster.Length)
            {
                Player[] tempRosterArray = new Player[number];
                for(int i =0;i<this.roster.Length;i++)
                {
                    tempRosterArray[i] = this.roster[i];
                }

                this.roster = tempRosterArray;
            }
            else
            {
                throw new ArgumentException("Expand Count cannot be below or equal to current");
            }
        }

        public Player RemovePlayer()
        {

        }

    }
}

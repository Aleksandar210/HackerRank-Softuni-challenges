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

        private Player[] roster;

        //adding constructors
        public Guild(string name,int capacity)
        {
            this.Name = name;
            this.Capacity = capacity;
            this.roster = new Player[this.Capacity];
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

            if (this.index + 1 <= this.roster.Length)
            {
                this.roster[++this.index] = currentPlayer;
            }
            else
            {

            }

        }

    }
}

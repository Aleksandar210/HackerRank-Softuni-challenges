using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GreedyTimes
{
    public class Bag
    {
        private const int startingBagSpace = 0;
        private int capacity;
        private int currentBagSpace;
        private Dictionary<string, int> currentItemsinBag;

        public Bag(int capacity)
        {
            this.Capacity = capacity;
            this.currentBagSpace = startingBagSpace;
            this.currentItemsinBag = new Dictionary<string, int>();
            this.InitialiseStartingValuesForBag();
        }

        private void InitialiseStartingValuesForBag()
        {
            this.currentItemsinBag.Add("gem", 0);
            this.currentItemsinBag.Add("money", 0);
            this.currentItemsinBag.Add("gold", 0);
        }
        public int Capacity
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Bag capacity cannot be 0 or negative.");
                }
                else
                {
                    this.capacity = value;
                }
            }

            get => this.capacity;
        }

        public void PutItemInBag(string item)
        {
            //splits the item between his type and value liek - Gold 50
            string[] itemTypeValue = item.Split(" ", StringSplitOptions.RemoveEmptyEntries);

            //item type name
            string itemType = itemTypeValue[0];

            //item value
            int itemValue = int.Parse(itemTypeValue[1]);

            if(this.CheckCapacity(itemValue)== true && this.CheckItemRules(itemType,itemValue)==true)
            {
                this.currentItemsinBag[this.FindOutItemType(itemType)] += itemValue;
            }


        }

        //checks if the item can be added without breaking the bag(more than the capacity)
        private bool CheckCapacity(int itemValue)
        {
            if((itemValue+this.currentBagSpace)<=this.Capacity)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        //checks the rules for each item to be puted in
        private bool CheckItemRules(string itemType, int itemValue)
        {
          
            switch(this.FindOutItemType(itemType))
            {
                case "gold":
                    return true;  // the gold amount should always be high in the bag
                case "money":
                    if((itemValue+this.currentItemsinBag["money"])>this.currentItemsinBag["gem"])
                    {
                        return false;
                    }
                    else
                    {
                        return true;
                    }
                case "gem":
                    if((itemValue+this.currentItemsinBag["gem"])>this.currentItemsinBag["gold"])
                    {
                        return false;
                    }
                    else
                    {
                        return true;
                    }
            }

            return false;

        }

        private string FindOutItemType(string itemType)
        {
            string type;
            if (itemType.Length == 3)
            {
                type = "money";
            }
            else if (itemType.Equals("Gold", StringComparison.OrdinalIgnoreCase))
            {
                type = "gold";
            }
            else
            {
                type = "gem";
            }

            return type;
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            this.currentItemsinBag = this.currentItemsinBag.OrderByDescending(x => x.Key)
                .ThenBy(x=>x.Value).ToDictionary(x => x.Key, x => x.Value);
            foreach(var item in this.currentItemsinBag)
            {
                sb.Append(item.Key + ": " + item.Value + Environment.NewLine);
            }

            return sb.ToString();
        }
    }
}

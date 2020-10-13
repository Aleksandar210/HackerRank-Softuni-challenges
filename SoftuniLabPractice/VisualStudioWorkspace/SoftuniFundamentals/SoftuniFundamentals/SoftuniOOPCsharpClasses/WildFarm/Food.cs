using MoreLinq.Extensions;
using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.SoftuniOOPCsharpClasses.WildFarm
{
    public abstract class Food
    {
        int quantity;

        protected Food(int quantity)
        {
            this.Quantity = quantity;
        }

        public int Quantity
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Food quantity cannot be 0 or negative");
                }
                else
                {
                    this.quantity = value;
                }
            }

            get => this.quantity;
        }
    }
}

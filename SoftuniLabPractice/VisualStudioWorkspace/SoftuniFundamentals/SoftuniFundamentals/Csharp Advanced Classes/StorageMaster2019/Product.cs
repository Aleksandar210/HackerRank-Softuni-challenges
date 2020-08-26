using System;
using System.Collections.Generic;
using System.Text;

namespace SoftuniFundamentals.Csharp_Advanced_Classes.StorageMaster2019
{
    public abstract class Product:IProduct
    {
        //fields
        protected double price;
        protected double weight;

        public Product(double price,double weight)
        {
            this.Price = price;
            this.Weight = weight;
        }

        public double Price
        {
            protected set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Invalid price value.");
                }
            }

            get => this.price;
        }

        public double Weight
        {
            private set
            {
                if(value<=0)
                {
                    throw new ArgumentException("Invalid weight value.");
                }
            }
            get => this.weight;
        }
    }
}

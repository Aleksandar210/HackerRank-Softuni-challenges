using System;
using System.Collections.Generic;
using System.Text;

namespace Restaurant
{
    public abstract class Product
    {

        private string name;
        private Decimal price;

        public Product(string name,decimal productPrice)
        {
            this.Name = name;
            this.Price = productPrice;
        }

        protected Product(Decimal price)
        {
            this.Price = price;
        }
   


        public string Name
        {
            protected set
            {
                if(String.IsNullOrEmpty(value) || String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("Name cannot be empty or null.");
                }
                else
                {
                    this.name = value;
                }
            }

            get => this.name;
        }

        public Decimal Price
        {
            protected set
            {
                if(value<=0)
                {
                    throw new ArgumentException("price cannot be 0 or negative.");
                }
                else
                {
                    this.price = value;
                }
            }

            get => this.price;
        }

        public void DisplayProductPrice()
        {
            String productPriceToBeDisplayed = String.Format("{ 0:C}", this.price);
            Console.WriteLine(productPriceToBeDisplayed)
        }
    }
}

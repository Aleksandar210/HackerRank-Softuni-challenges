using System;
using System.Collections.Generic;
using System.Text;

namespace SalesDataBaseCodeFirstEntityFrameworkCore.Data.Models
{
    public class Product
    {
        public int ProductId { get; set; }
        public string ProductName { get; set; }
        public double Quantity { get; set; }
        public decimal Price { get; set; }
        public string Description { get; set; } = "No Description";
        public ICollection<Sale> Sales { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.Text;

namespace SalesDataBaseCodeFirstEntityFrameworkCore.Data.Models
{
    public class Store
    {
        public int StoreId { get; set; }
        public string StoreName { get; set; }
        public ICollection<Sale> Sales { get; set; }
    }
}

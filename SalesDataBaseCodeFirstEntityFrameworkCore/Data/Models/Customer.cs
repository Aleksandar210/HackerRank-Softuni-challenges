using System;
using System.Collections.Generic;
using System.Text;

namespace SalesDataBaseCodeFirstEntityFrameworkCore.Data.Models
{
    public class Customer
    {
        public int CustomerId { get; set; }
        public string FirstName { get; set; }
        public string MiddleName { get; set; }
        public string LastName { get; set; }
        public string Email { get; set; }
        public string CreditCartNumber { get; set; }
        public ICollection<Sale> Sales { get; set; }

    }
}

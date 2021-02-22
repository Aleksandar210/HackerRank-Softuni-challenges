using System;
using System.Collections.Generic;

#nullable disable

namespace BookShopEntityFrameWorkCoreDbDatabaseFirst.Models
{
    public partial class Category
    {
        public Category()
        {
            BookCategories = new HashSet<BookCategory>();
        }

        public int CategoryId { get; set; }
        public string CategoryName { get; set; }

        public virtual ICollection<BookCategory> BookCategories { get; set; }
    }
}

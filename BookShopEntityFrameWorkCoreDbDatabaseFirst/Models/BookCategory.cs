using System;
using System.Collections.Generic;

#nullable disable

namespace BookShopEntityFrameWorkCoreDbDatabaseFirst.Models
{
    public partial class BookCategory
    {
        public int CategoryId { get; set; }
        public int BookId { get; set; }

        public virtual Book Book { get; set; }
        public virtual Category Category { get; set; }
    }
}

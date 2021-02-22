using System;
using System.Collections.Generic;

#nullable disable

namespace BookShopEntityFrameWorkCoreDbDatabaseFirst.Models
{
    public partial class Book
    {
        public Book()
        {
            BookCategories = new HashSet<BookCategory>();
        }

        public int BookId { get; set; }
        public string AgeRestriction { get; set; }
        public int? AuthorId { get; set; }
        public int Copies { get; set; }
        public DateTime? ReleaseDate { get; set; }
        public string Title { get; set; }
        public string Description { get; set; }
        public decimal Price { get; set; }
        public string EditionType { get; set; }

        public virtual Author Author { get; set; }
        public virtual ICollection<BookCategory> BookCategories { get; set; }
    }
}

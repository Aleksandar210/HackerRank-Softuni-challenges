using BookShopEntityFrameWorkCoreDbDatabaseFirst.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BookShopEntityFrameWorkCoreDbDatabaseFirst
{
    class Program
    {
        static void Main(string[] args)
        {
            var dbContext = new BookShopDbContext(); 
        }

        public static string GetBooksByAgeRestriction(BookShopDbContext dbContext,string command)
        {
            if(command.Equals("Minor") || command.Equals("Teen") || command.Equals("Adult"))
            {
                StringBuilder sb = new StringBuilder();

                var booksByAgeRestriction = dbContext.Books
                    .Where(book => book.AgeRestriction.Equals(command))
                    .Select(book => new
                    {
                        BookTitle = book.Title,
                        BookReleaseDate = book.ReleaseDate,
                        BookCateogries = String.Join(", ", book.BookCategories.Select(bc => bc.Category.CategoryName)),
                        BookDescription = book.Description
                    }).ToArray();

                foreach(var item in booksByAgeRestriction)
                {
                    sb.Append(item.BookTitle + Environment.NewLine
                        + item.BookReleaseDate + Environment.NewLine
                        + item.BookCateogries + Environment.NewLine
                        + item.BookDescription + Environment.NewLine);
                    sb.Append("-------------------------------------");
                }

                return sb.ToString();
            }
            else
            {
                throw new ArgumentException($"Invalid Book Age restriction: {command} restrictions are: Minor,Teen,Adult");
            }
        }

        public static string GetAllGoldenBooks(BookShopDbContext dbContext)
        {
            StringBuilder sb = new StringBuilder();

            var goldenBooks = dbContext.Books
                .Where(book => book.EditionType.Equals("Golden"))
                .Select(b => b.Title)
                .ToArray();

            foreach(var item in goldenBooks)
            {
                sb.Append(" " + item);
            }

            return sb.ToString().Trim();
        }

        public static string GetBooksByPrice(BookShopDbContext dbContext)
        {
            StringBuilder sb = new StringBuilder();

            var booksWithPriceHigherThan40 = dbContext.Books
                .Where(b => b.Price > 40)
                .Select(b => new
                {
                    BookTitle = b.Title,
                    BookPrice = b.Price
                }).ToArray();

            foreach(var item in booksWithPriceHigherThan40)
            {
                sb.Append(item.BookTitle + " " + item.BookPrice + Environment.NewLine);
            }

            return sb.ToString();
        }

        public static string BooksByCategory(BookShopDbContext dbContext,string category)
        {
            StringBuilder sb = new StringBuilder();

            var booksByCategory = dbContext.Books
                .Where(b => b.BookCategories.Any(c => c.Category.CategoryName.Equals(category)))
                .Select(b => new
                {
                    BookTitle = b.Title,
                    BookDescription = b.Description,
                    BookCategories = String.Join(", ", b.BookCategories.Select(bc => bc.Category.CategoryName)).Trim()
                }).ToArray();

            foreach(var book in booksByCategory)
            {
                sb.Append(book.BookTitle 
                    + Environment.NewLine 
                    + book.BookDescription 
                    + Environment.NewLine 
                    + book.BookCategories 
                    + Environment.NewLine);
                sb.Append("----------------------------");
            }

            return sb.ToString();
        }

        public static string BooksNotReleasedIn(BookShopDbContext dbContext,DateTime releaseDate)
        {
            int year = releaseDate.Year;

            StringBuilder sb = new StringBuilder();

            var booksNotReleasedInYear = dbContext.Books
                .Where(b => b.ReleaseDate.HasValue && b.ReleaseDate.Value.Year != year)
                .Select(b => b.Title)
                .ToArray();

            foreach(var book in booksNotReleasedInYear)
            {
                sb.Append(book + Environment.NewLine);
            }

           return sb.ToString();
        }

        public static string BooksReleasedBefore(BookShopDbContext dbContext, DateTime releaseDate)
        {
            StringBuilder sb = new StringBuilder();

            var booksBeforeDateGiven = dbContext.Books
                .Where(b => b.ReleaseDate.HasValue && (releaseDate.Year < b.ReleaseDate.Value.Year && releaseDate.Month < b.ReleaseDate.Value.Month
                && releaseDate.Day < b.ReleaseDate.Value.Day))
                .Select(b => b.Title)
                .ToArray();

            foreach(var book in booksBeforeDateGiven)
            {
                sb.Append(book + Environment.NewLine);
            }

            return sb.ToString();
        }

        public static string GetBooksByAuthorNameEndingWith(BookShopDbContext dbContext, string input)
        {
            StringBuilder sb = new StringBuilder();

            var booksWithAuthorNameEndingWith = dbContext.Books
                .Where(b => b.Author.LastName.EndsWith(input))
                .Select(x => new
                {
                    BookTitle = x.Title,
                    BookAuthor = x.Author.FirstName+" "+x.Author.LastName
                }).ToArray();

            foreach(var book in booksWithAuthorNameEndingWith)
            {
                sb.Append(book.BookTitle + " Writen by: " + book.BookAuthor + Environment.NewLine);
            }

            return sb.ToString();
        }

        public static string GetBooksByNameContaining(BookShopDbContext dbContext, string input)
        {
            StringBuilder sb = new StringBuilder();

            var booksNameContaining = dbContext.Books
                .Where(b => b.Title.Contains(input))
                .Select(b => b.Title)
                .ToArray();

            foreach(var book in booksNameContaining)
            {
                sb.Append(book + Environment.NewLine);
            }

            return sb.ToString();
        }

        public static int GetBookCountByLengthNameAbove(BookShopDbContext dbContext, int length)
        {
            StringBuilder sb = new StringBuilder();

            var booksWithNameLengthAbove = dbContext.Books
                .Where(b => b.Title.Length > length)
                .Count();

            return booksWithNameLengthAbove;
        }

    }
}

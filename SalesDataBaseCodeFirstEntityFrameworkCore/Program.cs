using Microsoft.EntityFrameworkCore;
using SalesDataBaseCodeFirstEntityFrameworkCore.Data.Models;
using System;
using System.IO;

namespace SalesDataBaseCodeFirstEntityFrameworkCore
{
    class Program
    {
        static void Main(string[] args)
        {
            SalesDbContext dbContext = new SalesDbContext();

            dbContext.Database.Migrate();
        }


        //TODO FINISH THE METHOD LAST
        public static void Seed(SalesDbContext dbContext)
        {
            var storeNames = File.ReadAllLines(@"D:\SalesDataBaseCodeFirstEntityFrameworkCore\Data\RandomStoreNames.txt");

            foreach(var storeName in storeNames)
            {
                dbContext.Stores.Add(new Store { StoreName = storeName });
            }

            dbContext.SaveChanges();

            var productNames = File.ReadAllLines(@"D:\SalesDataBaseCodeFirstEntityFrameworkCore\Data\RandomProductNames.txt");

            foreach(var productName in productNames)
            {
                //dbContext.Products.Add()
            }

        }

    }
}

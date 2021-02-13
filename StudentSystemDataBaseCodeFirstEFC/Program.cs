using Microsoft.EntityFrameworkCore;
using StudentSystemDataBaseCodeFirstEFC.Data.Models;
using System;

namespace StudentSystemDataBaseCodeFirstEFC
{
    class Program
    {
        static void Main(string[] args)
        {
           using StudentDbContext dbContext = new StudentDbContext();

            dbContext.Database.Migrate();
        }
    }
}

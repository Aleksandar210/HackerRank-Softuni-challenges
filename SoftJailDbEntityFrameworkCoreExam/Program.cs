using Microsoft.EntityFrameworkCore;
using SoftJailDbEntityFrameworkCore.Data;
using System;

namespace SoftJailDbEntityFrameworkCoreExam
{
    class Program
    {
        static void Main(string[] args)
        {
            var DbSet = new SoftJailDbContext();
            DbSet.Database.Migrate();
        }
    }
}

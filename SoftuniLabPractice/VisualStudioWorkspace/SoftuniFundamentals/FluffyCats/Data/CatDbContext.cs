using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using FluffyCats.Models;
using Microsoft.EntityFrameworkCore;

namespace FluffyCats.Data
{
   
    public class CatDbContext : DbContext
    {
        DbSet<Cat> Cats { get; set; }
        
    }
}

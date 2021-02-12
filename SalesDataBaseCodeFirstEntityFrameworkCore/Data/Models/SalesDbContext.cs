using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;
using static SalesDataBaseCodeFirstEntityFrameworkCore.Data.DataValidations.Validation;

namespace SalesDataBaseCodeFirstEntityFrameworkCore.Data.Models
{
    public class SalesDbContext: DbContext
    {
        protected override void OnConfiguring(DbContextOptionsBuilder options)
        {
            if(!options.IsConfigured)
            {
                options.UseSqlServer("Server=.\\SQLEXPRESS;Database=SalesDatabase;Integrated security = true;");
            }
        }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            builder.Entity<Sale>()
                .HasOne(sale => sale.Customer)
                .WithMany(customer => customer.Sales)
                .HasForeignKey(sale => sale.CustomerId);

            builder.Entity<Sale>()
                .HasOne(sale => sale.Store)
                .WithMany(store => store.Sales)
                .HasForeignKey(sale => sale.StoreId);

            builder.Entity<Sale>()
                .HasOne(sale => sale.Product)
                .WithMany(product => product.Sales)
                .HasForeignKey(sale => sale.ProductId);

            builder.Entity<Product>()
                .Property(p => p.ProductName)
                .HasMaxLength(ProductValidation.productNameLength)
                .IsUnicode();

            builder.Entity<Customer>()
                .Property(c => c.FirstName)
                .HasMaxLength(CustomerVaidation.customerNameMaxLength / 3)
                .IsRequired()
                .IsUnicode();

            builder.Entity<Customer>()
                .Property(c => c.MiddleName)
                .IsUnicode()
                .HasMaxLength(CustomerVaidation.customerNameMaxLength / 3);

            builder.Entity<Customer>()
               .Property(c => c.LastName)
               .IsUnicode()
               .IsRequired()
               .HasMaxLength(CustomerVaidation.customerNameMaxLength / 3);

            builder.Entity<Customer>()
                .Property(c => c.Email)
                .IsRequired()
                .HasMaxLength(CustomerVaidation.customerEmailMaxLength);

            builder.Entity<Store>()
                .Property(s => s.StoreName)
                .HasMaxLength(StoreValidation.storeNameMaxLength)
                .IsUnicode();

            builder.Entity<Product>()
                .Property(p => p.Description)
                .HasMaxLength(250)
                .IsRequired();

            builder.Entity<Sale>()
                .Property(s => s.Date)
                .HasColumnType("datetime2")
                .HasDefaultValueSql("GETDATE()")
                .IsRequired();
                
        }

        public DbSet<Store> Stores { get; set; }
        public DbSet<Sale> Sales { get; set; }
        public DbSet<Customer> Customers { get; set; }
        public DbSet<Product> Products { get; set; }
    }
}

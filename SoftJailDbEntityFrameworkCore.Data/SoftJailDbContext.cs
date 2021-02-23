using Microsoft.EntityFrameworkCore;
using SoftJailDbEntityFrameworkCore.Data.Models;
using System;
using System.Collections.Generic;
using System.Text;

namespace SoftJailDbEntityFrameworkCore.Data
{
    public class SoftJailDbContext : DbContext
    {
        public DbSet<Prisoner> Prisoners { get; set; }
        public DbSet<Officer> Officers { get; set; }
        public DbSet<Mail> Mails { get; set; }
        public DbSet<Position> Positions { get; set; }
        public DbSet<Weapon> Weapons { get; set; }
        public DbSet<Department> Departments { get; set; }
        public DbSet<Cell> Cells { get; set; }
        public DbSet<OfficerPrisoner> OfficerPrisoners { get; set; }

        protected override void OnModelCreating(ModelBuilder builder)
        { 

            builder.Entity<Prisoner>(entity =>
            {
                entity.HasMany(p => p.Mails)
                .WithOne(m => m.Prisoner)
                .HasForeignKey(m => m.PrisonerId);                

                entity.HasOne(p => p.Cell)
                .WithMany(c => c.Prisoners)
                .HasForeignKey(p => p.CellId);

                entity.Property(p => p.FullName)
                .HasMaxLength(20)
                .IsRequired(true)
                .IsUnicode(true);

                entity.Property(p => p.CellId)
                .IsRequired(true);

                entity.Property(p => p.Nickname)
                .IsRequired(true);                            
            });

            builder.Entity<Officer>(entity =>
            {
                entity.Property(o => o.FullName)
                .HasMaxLength(30)
                .IsRequired(true)
                .IsUnicode(true);

                entity.Property(o => o.Salary)
                .IsRequired(true);

                entity.Property(o => o.DepartmentId)
                .IsRequired(true);

                entity.Property(p => p.WeaponId)
                .IsRequired(true);

                entity.Property(p => p.PositionId)
                .IsRequired(true);

            });

            builder.Entity<OfficerPrisoner>(entity =>
            {
                entity.HasKey(op => new { op.PrisonerId, op.OfficerId });

                entity.HasOne(op => op.Prisoner)
                .WithMany(P => P.Officers)
                .HasForeignKey(op => op.PrisonerId)
                .OnDelete(DeleteBehavior.Restrict);

                entity.HasOne(op => op.Officer)
                .WithMany(o => o.Prisoners)
                .HasForeignKey(op => op.OfficerId)
                .OnDelete(DeleteBehavior.Restrict);
            });

            builder.Entity<Department>(entity =>
            {
                entity.Property(d => d.DepartmentName)
                .HasMaxLength(25)
                .IsUnicode(true);

                entity.HasMany(d => d.Cells)
                .WithOne(c => c.Department)
                .HasForeignKey(c => c.DepartmentId);

                entity.HasMany(d => d.Officers)
                .WithOne(o => o.Department)
                .HasForeignKey(o => o.DepartmentId);
            });

        }

        protected override void OnConfiguring(DbContextOptionsBuilder options)
        {
            if(!options.IsConfigured)
            {
                options.UseSqlServer("Server=.\\SQLEXPRESS;Database=SoftJailDb;Integrated security = true;");
            }
        }
    }
}

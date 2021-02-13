using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;

namespace StudentSystemDataBaseCodeFirstEFC.Data.Models
{
    public class StudentDbContext: DbContext
    {
        protected override void OnConfiguring(DbContextOptionsBuilder options)
        {
            if(!options.IsConfigured)
            {
                options.UseSqlServer("Server=.\\SQLEXPRESS;Database = StudentDb;Integrated security = true;");
            }
        }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            builder.Entity<StudentCourses>().HasKey(sc => new { sc.StudentId, sc.CourseId });

            builder.Entity<StudentCourses>()
                .HasOne(sc => sc.Student)
                .WithMany(s => s.Courses)
                .HasForeignKey(sc => sc.StudentId);

            builder.Entity<StudentCourses>()
                .HasOne(sc => sc.Course)
                .WithMany(c => c.Students)
                .HasForeignKey(sc => sc.CourseId);

            builder.Entity<Course>()
                .HasMany(c => c.Resources)
                .WithOne(r => r.Course)
                .HasForeignKey(r => r.CourseId);

            builder.Entity<Course>()
                .HasMany(c => c.HomeworkSubmisions)
                .WithOne(h => h.Course)
                .HasForeignKey(h => h.CourseId);

            builder.Entity<Student>()
                .HasMany(s => s.HomeworkSubmisions)
                .WithOne(h => h.Student)
                .HasForeignKey(h => h.StudentId);

            builder.Entity<Student>()
                .Property(s => s.FirstName)
                .HasMaxLength(100 / 3)
                .IsRequired()
                .IsUnicode();

            builder.Entity<Student>()
                .Property(s => s.MiddleName)
                .HasMaxLength(100 / 3)
                .IsUnicode();

            builder.Entity<Student>()
                .Property(s => s.LastName)
                .HasMaxLength(100 / 3)
                .IsRequired()
                .IsUnicode();

            builder.Entity<Student>()
                .Property(s => s.PhoneNumber)
                .HasMaxLength(10)
                .IsFixedLength();

            builder.Entity<Course>()
            .Property(c => c.CourseName)
            .HasMaxLength(80)
            .IsRequired()
            .IsUnicode();

            builder.Entity<Course>()
                .Property(c => c.Description)
                .IsUnicode();

            builder.Entity<Resource>(enttiy =>
            {
                enttiy.Property(r => r.ResourceName)
                .HasMaxLength(50)
                .IsUnicode()
                .IsRequired();

                enttiy.Property(r => r.URL)
                .IsRequired();
            });

        }

        public DbSet<Course> Courses { get; set; }
        public DbSet<HomeworkSubmision> HomeworkSubmisions { get; set; }
        public DbSet<Student> Students { get; set; }
        public DbSet<StudentCourses> StudentCourses { get; set; }
        public DbSet<Resource> Resources { get; set; }
    }
}

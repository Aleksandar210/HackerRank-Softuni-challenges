using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Text;
using static EntityFrameworkHospitalAppCodeFirst.Data.PatientDataValidation;

namespace EntityFrameworkHospitalAppCodeFirst.Data.Models
{
    public class HospitalContext: DbContext
    {
        public HospitalContext()
        {

        }

        public HospitalContext(DbContextOptions options)
            : base(options)
        {

        }

        protected override void OnConfiguring(DbContextOptionsBuilder options)
        {
            if(!options.IsConfigured)
            {
                options.UseSqlServer("Server=.\\SQLEXPRESS;Database=HospitalDataBase;Integrated security =true");
            }
        }
        
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Medicament>(entity =>
            {
                entity.Property(m => m.MeicamentName)
                .HasMaxLength(50)
                .IsRequired()
                .IsUnicode()
                .HasColumnName("Name");
            });

            modelBuilder.Entity<Visitation>(entity =>
            {
                entity.Property(v => v.Comments)
                .HasMaxLength(500)
                .IsUnicode();

                entity.Property(v => v.VisitationDate)
                .HasColumnType("datetime2")
                .IsRequired();
            });

            modelBuilder.Entity<Patient>(entity =>
            {
                entity.Property(p => p.FirstName)
                .IsRequired()
                .IsUnicode()
                .HasMaxLength(PatientNameLength);

                entity.Property(p => p.MiddleName)
                .IsUnicode()
                .HasMaxLength(PatientNameLength);

                entity.Property(p => p.LastName)
                .IsUnicode()
                .HasMaxLength(PatientNameLength)
                .IsRequired();

                entity.Property(p => p.EmailAddress)
                .HasMaxLength(EmailAddressLength)
                .IsRequired();

                entity.Property(p => p.Address)
                .HasMaxLength(AddressLength)
                .IsRequired()
                .IsUnicode();
            });

            modelBuilder.Entity<Diagnose>(entity =>
            {
                entity.Property(d => d.DiagnoseComments)
                .HasMaxLength(250);

                entity.Property(d => d.DiagnoseName)
                .HasColumnName("Name")
                .HasMaxLength(50)
                .IsRequired();

            });

            modelBuilder.Entity<Doctor>(entity =>
            {
                entity.Property(d => d.DoctorName)
                .HasMaxLength(100)
                .IsRequired()
                .IsUnicode();

                entity.Property(d => d.Specialty)
                .HasMaxLength(100)
                .IsUnicode();

                entity.Property(d => d.EmailAddress)
                .HasMaxLength(100)
                .IsRequired();

                entity.Property(d => d.Password)
                .HasMaxLength(50)
                .IsRequired()
                .HasColumnType("BINARY(64)");

            });

            //1 to many Visitations - 1 patient can have multiple visitations but 1 visitation has 1 patient
            modelBuilder.Entity<Visitation>()
                .HasOne(v => v.Patient)
                .WithMany(p => p.Visitations)
                .HasForeignKey(v => v.PatientId);

            modelBuilder.Entity<Visitation>()
                .HasOne(v => v.Docotor)
                .WithMany(d => d.Visitations)
                .HasForeignKey(v => v.DoctorId);

            modelBuilder.Entity<PatientMedicaments>()
                .HasKey(pm => new {pm.PatientId,pm.MedicamentId });

            modelBuilder.Entity<PatientMedicaments>()
                .HasOne(pm => pm.Medicament)
                .WithMany(m => m.Patients)
                .HasForeignKey(pm => pm.MedicamentId);

            modelBuilder.Entity<PatientMedicaments>()
                .HasOne(pm => pm.Patient)
                .WithMany(p => p.Medicaments)
                .HasForeignKey(pm => pm.PatientId);

            modelBuilder.Entity<Diagnose>()
                .HasOne(d => d.Patient)
                .WithMany(p => p.Diagnoses)
                .HasForeignKey(d => d.PatientId);
                
        }

        public DbSet<Doctor> Doctors { get; set; }
        public DbSet<Patient> Patients { get; set; }
        public DbSet<Medicament> Medicaments { get; set; }
        public DbSet<PatientMedicaments> PatientsMedicaments { get; set; }
        public DbSet<Diagnose> Diagnoses { get; set; }
        public DbSet<Visitation> Visitations { get; set; }
        
    }
}

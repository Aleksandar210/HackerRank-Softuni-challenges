
using EntityFrameworkHospitalAppCodeFirst.Data;
using EntityFrameworkHospitalAppCodeFirst.Data.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Linq;
using System.Text;

namespace EntityFrameworkHospitalAppCodeFirst
{
    public class Program
    {
        static void Main(string[] args)
        {
            //using var dbContext = new HospitalContext();
            // dbContext.Database.Migrate();

            //Doctor DoctorLoged = null;

           

        }

        public static Doctor Login(HospitalContext dbContext,string emailAddress,string password)
        {
            var doctorLoged = dbContext.Doctors
                .FirstOrDefault(d => d.EmailAddress.Equals(emailAddress)
                && d.Password.Equals(EncryptionHelper.Encrypt(password)));
                
            return doctorLoged;
        }

        public static bool AddDoctor(HospitalContext dbContext)
        {
            Console.Clear();
            Console.Write("Enter name: ");
            string doctorName = Console.ReadLine();

            Console.Write("Enter specialty: ");
            string specialty = Console.ReadLine();

            Console.Write("Enter E-Mail Address: ");
            string emailAddress = Console.ReadLine();

            Console.Write("Enter Password: ");
            string password = EncryptionHelper.Encrypt(Console.ReadLine());

            if (PatientDataValidation.IsEmailAddressValid(emailAddress))
            {
                dbContext.Add(new Doctor
                {
                    DoctorName = doctorName,
                    Specialty = specialty,
                    EmailAddress = emailAddress,
                    Password = password
                });

                dbContext.SaveChanges();

                return true;
            }
            else
            {
                return false;
            }
        }

       
        public static void AddPatient(HospitalContext dbContext)
        {
            Console.Write("Enter first name: ");
            string firstName = Console.ReadLine();
            Console.Write("Enter middle name: ");
            string middleName = Console.ReadLine();
            Console.Write("Enter last name: ");
            string lastName = Console.ReadLine();
            Console.Write("Enter address: ");
            string address = Console.ReadLine();
            Console.WriteLine("Enter E-Mail Address: ");
            string emailAddress = Console.ReadLine();

            char insurenceAnswer;

            do
            {
                Console.Clear();
                Console.WriteLine("Has Insurence? ");
                Console.WriteLine("Y/N");
                insurenceAnswer = Console.ReadLine()[0];
            }
            while (!(insurenceAnswer.Equals('Y') || insurenceAnswer.Equals('y'))
            && !(insurenceAnswer.Equals('N') || insurenceAnswer.Equals('n')));

            bool hasInsurence = false;

            if(insurenceAnswer.Equals('Y')||insurenceAnswer.Equals('y'))
            {
                hasInsurence = true;
            }
            else if(insurenceAnswer.Equals('N') || insurenceAnswer.Equals('n'))
            {
                hasInsurence = false;
            }

            Patient patient = null;
            try
            {
                patient = new Patient(firstName,middleName,lastName,address,emailAddress,hasInsurence);
                dbContext.Patients.Add(patient);

                dbContext.SaveChanges();

                Console.WriteLine($"Patient {firstName + " " + middleName + " " + lastName} was added to database");
            }
            catch(ArgumentException exc)
            {
                Console.WriteLine(exc.Message);
                Console.WriteLine("Patient was not added to database");
            }
        }

        //TODO Finish methods
        public static Patient SelectPatient(HospitalContext dbContext)
        {
            
            int optionSelected;

            do
            {
                Console.Clear();
                Console.WriteLine("1|Find patient by data-enter");
                Console.WriteLine("2|Display current patients");
                Console.WriteLine("3|Display current selected patient");
                Console.WriteLine("4|Back");

                Console.Write("Select: ");
                optionSelected = int.Parse(Console.ReadLine());

                switch(optionSelected)
                {
                    case 1:
                        //AND SO ON
                        break;
                }
            }
            while (optionSelected!=4);
            
        }

        private static string DisplayCurrentPatients(HospitalContext dbContext)
        {
            StringBuilder sb = new StringBuilder();

            var patients = dbContext.Patients.Select(patient => new
            {
                PatientID = patient.PatientId,
                FirstNamePatient = patient.FirstName,
                MiddleNamePatient = patient.MiddleName,
                LastNamePatient = patient.LastName,
                PatientMailAddress = patient.EmailAddress,
                HasInsurancePatient = patient.HasInsurence,
                MedicamentCount = patient.Medicaments.Count()

            }).ToArray();

            foreach(var item in patients)
            {
                sb.Append("Name: " + " " + item.FirstNamePatient + " " + item.MiddleNamePatient + " " + item.LastNamePatient
                    + Environment.NewLine + "E-Mail: " + item.PatientMailAddress 
                    + Environment.NewLine + "On " + item.MedicamentCount + " medicamentions"
                    + Environment.NewLine);
            }

            return sb.ToString();
        }

        private static Patient FindPatientById(HospitalContext dbContext, int patientId)
        {
           Patient patientFound = dbContext.Patients.FirstOrDefault(patient => patient.PatientId == patientId);

           return patientFound;
        }

        //TODO FINISH METHDO BUT MAKE IT SO THAT MIDDLE NAME CAN BE PASSED AS NULL
        private static Patient FindPatientByName(HospitalContext dbContext,params string[] names)
        {
            dbContext.Patients.Where(p => p.FirstName.Equals(names[0]) || p.MiddleName.Equals(names[]));
            return null;
        }

        public static void AssignMedicamentToPatient(HospitalContext dbContext)
        {

        }

        public static void AddMedicament(HospitalContext dbContext)
        {
            Console.Write("Medicament name: ");
            string medicamentName = Console.ReadLine();

            dbContext.Medicaments.Add(new Medicament { MeicamentName = medicamentName });
            dbContext.SaveChanges();
        }

        public static void AssignDiagnose(HospitalContext dbContext)
        {

        }

        public static void CreateVisitation(HospitalContext dbContext)
        {

        }

    }
}

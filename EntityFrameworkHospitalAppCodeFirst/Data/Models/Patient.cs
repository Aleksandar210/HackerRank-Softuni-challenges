using System;
using System.Collections.Generic;
using System.Text;

namespace EntityFrameworkHospitalAppCodeFirst.Data.Models
{
    public class Patient
    {
        public Patient(string firstName,string middleName,string lastName,string address,string emailAddress,bool hasInsurence)
        {
            this.FirstName = firstName;
            this.MiddleName = middleName;
            this.LastName = lastName;
            this.Address = address;
            this.HasInsurence = hasInsurence;

            if(PatientDataValidation.IsEmailAddressValid(emailAddress))
            {
                this.EmailAddress = emailAddress;
            }
            else
            {
                throw new ArgumentException($"Invalid EmailAddress {emailAddress}");
            }
        }
        public int PatientId { get; set; }
        public string FirstName { get; set; }
        public string MiddleName { get; set; }
        public string LastName { get; set; }
        public string Address { get; set; }
        public string EmailAddress { get; set; }
        public bool HasInsurence { get; set; }
        public ICollection<Visitation> Visitations { get; set; }
        public ICollection<Diagnose> Diagnoses { get; set; }
        public ICollection<PatientMedicaments> Medicaments { get; set; }
    }
}

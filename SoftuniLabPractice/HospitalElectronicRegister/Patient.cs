using System;
using System.Collections.Generic;
using System.Text;

namespace HospitalElectronicRegister
{
    public class Patient
    {
        private string patientFirstName;
        private string patientMiddleName;
        private string patientLastName;
        private int patientAge;
        private char patientGender;
        private DateTime patientDateOfEntry;

        public Patient(string patientFullName,int patientAge,char patientGender,DateTime patientDateOfEntry)
        {
            string[] patientNames = patientFullName.Split(" ", StringSplitOptions.RemoveEmptyEntries);
            this.PatientFirstName = patientNames[0];
            this.patientMiddleName = patientNames[1];
            this.patientLastName = patientNames[2];
            this.patientAge = patientAge;
            this.PatientGender = patientGender;
            this.PatientDateOfEntry = patientDateOfEntry;
        }

        public string PatientFullName => String.Concat(this.patientFirstName + " ", this.patientMiddleName + " ", this.patientLastName);

        public string PatientFirstName
        {
            private set
            {
                if(String.IsNullOrEmpty(value)||String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("First name cannot be null or empty");
                }
                else
                {
                    this.patientFirstName = value;
                }

            }

            get => this.patientFirstName;
          
        }

        public string PatientMiddelName
        {
            private set
            {
                if (String.IsNullOrEmpty(value) || String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("First name cannot be null or empty");
                }
                else
                {
                    this.patientMiddleName = value;
                }

            }

            get => this.patientMiddleName;

        }

        public string PatientLastName
        {
            private set
            {
                if (String.IsNullOrEmpty(value) || String.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("First name cannot be null or empty");
                }
                else
                {
                    this.patientLastName = value;
                }

            }

            get => this.patientLastName;
        }

        public int PatientAge
        {
            private set
            {
                if(value<0)
                {
                    throw new ArgumentException("Patient's age cannot be negative")
                }
                else
                {
                    this.patientAge = value;
                }
            }

            get => this.patientAge;
        }

        public char PatientGender
        {
            private set
            {
                if((value.Equals('M')||value.Equals('m')) || (value.Equals('F')||value.Equals('f')))
                {
                    this.patientGender = value;
                }
                else
                {
                    throw new ArgumentException("Gender cannot be different from M or F");
                }
            }

            get => this.patientGender;
        }

        public DateTime PatientDateOfEntry
        {
            private set
            {
                if(value.Year<2020)
                {
                    throw new ArgumentException("Year cannot be before 2020.");
                }
                else
                {
                    this.patientDateOfEntry = value;
                }
            }

            get => this.patientDateOfEntry;
        }


    }
}

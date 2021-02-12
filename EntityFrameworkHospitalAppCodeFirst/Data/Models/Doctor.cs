using System;
using System.Collections.Generic;
using System.Text;

namespace EntityFrameworkHospitalAppCodeFirst.Data.Models
{
    public class Doctor
    {
        public int DoctorId { get; set; }
        public string DoctorName { get; set; }
        public string EmailAddress { get; set; }
        public string Password { get; set; }
        public string Specialty { get; set; }
        public ICollection<Visitation> Visitations { get; set; }
    }
}

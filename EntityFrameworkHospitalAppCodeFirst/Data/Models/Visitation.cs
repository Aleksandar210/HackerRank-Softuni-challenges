using System;
using System.Collections.Generic;
using System.Text;

namespace EntityFrameworkHospitalAppCodeFirst.Data.Models
{
    public class Visitation
    {
        public int VisitationId { get; set; }
        public DateTime VisitationDate { get; set; }
        public string Comments { get; set; }
        public int DoctorId { get; set; }
        public Doctor Docotor { get; set; }
        public int PatientId { get; set; }
        public Patient Patient { get; set; }
    }
}

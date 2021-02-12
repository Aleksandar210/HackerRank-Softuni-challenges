using System;
using System.Collections.Generic;
using System.Text;

namespace EntityFrameworkHospitalAppCodeFirst.Data.Models
{
    public class PatientMedicaments
    {
        public int PatientId { get; set; }
        public Patient Patient { get; set; }
        public int MedicamentId { get; set; }
        public Medicament Medicament { get; set; }
    }
}

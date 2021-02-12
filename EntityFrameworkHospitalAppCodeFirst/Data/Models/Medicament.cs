using System;
using System.Collections.Generic;
using System.Text;

namespace EntityFrameworkHospitalAppCodeFirst.Data.Models
{
    public class Medicament
    {
        public int MedicamentId { get; set; }
        public string MeicamentName { get; set; } 
        public ICollection<PatientMedicaments> Patients { get; set; }
    }
}

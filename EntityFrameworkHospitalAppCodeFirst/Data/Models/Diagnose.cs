using System;
using System.Collections.Generic;
using System.Text;

namespace EntityFrameworkHospitalAppCodeFirst.Data.Models
{
    public class Diagnose
    {
        public int DiagnoseId { get; set; }
        public string DiagnoseName { get; set; }
        public string DiagnoseComments { get; set; }
        public int PatientId { get; set; }
        public Patient Patient { get; set; }
    }
}

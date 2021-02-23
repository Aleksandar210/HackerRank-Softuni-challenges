using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace SoftJailDbEntityFrameworkCore.Data.Models
{
    public class Department
    {
        public int DepartmentId { get; set; }
        [Required]
        public string DepartmentName { get; set; }
        public ICollection<Cell> Cells { get; set; }
        public ICollection<Officer> Officers { get; set; }
    }
}

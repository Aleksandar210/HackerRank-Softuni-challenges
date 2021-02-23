using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace SoftJailDbEntityFrameworkCore.Data.Models
{
    public class Cell
    {
        public int CellId { get; set; }

        [Range(1,10000)]
        [Required]
        public int CellNumber { get; set; }
        [Required]
        public bool HasWindow { get; set; } = false;
        [Required]
        public int DepartmentId { get; set; }
        [Required]
        public Department Department { get; set; }
        public ICollection<Prisoner> Prisoners { get; set; }
    }
}

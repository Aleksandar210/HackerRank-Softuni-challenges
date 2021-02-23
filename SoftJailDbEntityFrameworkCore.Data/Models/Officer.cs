using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace SoftJailDbEntityFrameworkCore.Data.Models
{
    public class Officer
    {
        public int OfficerId { get; set; }
        public string FirstName { get; set; }
        public string MiddleName { get; set; }
        public string LastName { get; set; }
        public string FullName { get; set; }
        public decimal Salary { get; set; }
        public int PositionId { get; set; }
        public Position Position { get; set; }
        public int WeaponId { get; set; }
        public Weapon Weapon { get; set; }
        public int DepartmentId { get; set; }
        public Department Department { get; set; }
        public ICollection<OfficerPrisoner> Prisoners { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace SoftJailDbEntityFrameworkCore.Data.Models
{
    public class Prisoner
    {
        public int PrisonerId { get; set; }
        public string FullName { get; set; }
        public string Nickname { get; set; }

        [Range(18,65)]
        public int Age { get; set; }

        [Required]
        public DateTime IncarcerationDate { get; set; }
        public DateTime ReleaseDate { get; set; }
        public decimal Bail { get; set; }
        public int CellId { get; set; }
        public Cell Cell { get; set; }
        public ICollection<Mail> Mails { get; set; }
        public ICollection<OfficerPrisoner> Officers { get; set; }
    }
}

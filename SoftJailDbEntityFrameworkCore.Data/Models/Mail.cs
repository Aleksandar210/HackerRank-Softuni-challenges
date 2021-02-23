using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text;

namespace SoftJailDbEntityFrameworkCore.Data.Models
{
    public class Mail
    {
        public int MailId { get; set; }
        [Required]
        public string Description { get; set; }
        [Required]
        public string Sender { get; set; }
        [Required]
        public string Address { get; set; }
        [Required]
        public int PrisonerId { get; set; }
        [Required]
        public Prisoner Prisoner { get; set; }

    }
}

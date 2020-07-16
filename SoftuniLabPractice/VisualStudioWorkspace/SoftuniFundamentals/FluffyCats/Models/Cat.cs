using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace FluffyCats.Models
{
    public class Cat
    {
        [Key]
        [MaxLength(40)]
        public string Name { get; set; }

        [MaxLength(40)]
        public string Breed { get; set; }
        [Range(0,30)]
        public int Age { get; set; }

        [MaxLength(2000)]
        public string URL { get; set; }


        
    }
}

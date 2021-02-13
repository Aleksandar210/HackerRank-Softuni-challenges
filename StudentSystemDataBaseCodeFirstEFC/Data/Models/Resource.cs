using System;
using System.Collections.Generic;
using System.Text;

namespace StudentSystemDataBaseCodeFirstEFC.Data.Models
{
    public class Resource
    {
        public int ResourceId { get; set; }
        public int CourseId { get; set; }
        public Course Course { get; set; }
        public string ResourceName{ get; set; }
        public int ResourceType { get; set; }
        public string URL { get; set; }
    }
}

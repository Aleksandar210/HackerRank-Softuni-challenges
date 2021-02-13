using System;
using System.Collections.Generic;
using System.Text;

namespace StudentSystemDataBaseCodeFirstEFC.Data.Models
{
    public class Course
    {
        public int CourseId { get; set; }
        public string Description { get; set; }
        public DateTime EndDate { get; set; }
        public string CourseName { get; set; }
        public decimal Price { get; set; }
        public DateTime StartDate { get; set; }
        public ICollection<Resource> Resources {get;set;}
        public ICollection<HomeworkSubmision> HomeworkSubmisions { get; set; }
        public ICollection<StudentCourses> Courses { get; set; }
        public ICollection<StudentCourses> Students { get; set; }
    }
}

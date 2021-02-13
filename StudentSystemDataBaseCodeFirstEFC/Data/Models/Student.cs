using System;
using System.Collections.Generic;
using System.Text;

namespace StudentSystemDataBaseCodeFirstEFC.Data.Models
{
    public class Student
    {
        public int StudentId { get; set; }
        public DateTime Birthday { get; set; }
        public string FirstName { get; set; }
        public string MiddleName { get; set; }
        public string LastName { get; set; }
        public string PhoneNumber { get; set; }
        public DateTime RegisteredOn { get; set; }
        public ICollection<StudentCourses> Courses { get; set; }
        public ICollection<HomeworkSubmision> HomeworkSubmisions { get; set; }
    }
}

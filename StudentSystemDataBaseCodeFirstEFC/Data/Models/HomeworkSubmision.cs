using System;
using System.Collections.Generic;
using System.Text;

namespace StudentSystemDataBaseCodeFirstEFC.Data.Models
{
    public class HomeworkSubmision
    {
        public int HomeworkSubmisionId { get; set; }
        public string HomeworkContent { get; set; }
        public string ContentType { get; set; }
        public string Content { get; set; }
        public int CourseId { get; set; }
        public Course Course { get; set; }
        public int StudentId { get; set; }
        public Student Student { get; set; }
        public DateTime SubmisionTime { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebApiEscuela.Models
{
    public class TeacherModel
    {

        string ConnectionString = "";

        public int IDTeacher { get; set; }

        public string NameTeacher { get; set; }

        public string FirstLastNameTeacher { get; set; }

        public string SecondLastNameTeacher { get; set; }

        public string PictureTeacher { get; set; }

        public string PasswordTeacher { get; set; }

        public string MailTeacher { get; set; }

    }
}

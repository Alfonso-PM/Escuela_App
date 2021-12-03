using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebApiEscuela.Models
{
    public class StudentModel
    {
        string ConnectionString = "";

        public int IDStudent { get; set; }

        public string NameStudent { get; set; }

        public string FirstLastNameStudent { get; set; }

        public string SecondLastNameStudent { get; set; }

        public string PictureStudent { get; set; }

        public string PasswordStudent { get; set; }

        public string MailStudent { get; set; }



    }
}

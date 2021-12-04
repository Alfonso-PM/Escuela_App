using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebApiEscuela.Models
{
    public class ClassModel
    {
        string ConnectionString = "Server=tcp:escuelaappserver.database.windows.net,1433;Initial Catalog=Escuela_DataBase;Persist Security Info=False;User ID=escuelaappuser;Password=Escuelapass01;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;";

        public int IDClass { get; set; }

        public int IDTeacher { get; set; }

        public string NameClass { get; set; }

        public string DescriptionClass { get; set; }

        public string PictureClass { get; set; }

        public TeacherModel Teacher { get; set; }
    }
}

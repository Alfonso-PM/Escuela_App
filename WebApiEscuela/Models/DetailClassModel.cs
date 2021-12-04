using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebApiEscuela.Models
{
    public class DetailClassModel
    {
        string ConnectionString = "Server=tcp:escuelaappserver.database.windows.net,1433;Initial Catalog=Escuela_DataBase;Persist Security Info=False;User ID=escuelaappuser;Password=Escuelapass01;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;";

        public int IDDetailClass { get; set; }

        public int IDClass { get; set; }

        public int IDStudent { get; set; }

        public StudentModel Student { get; set; }

        public ClassModel Class { get; set; }


    }
}

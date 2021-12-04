using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebApiEscuela.Models
{
    public class DetailClassModel
    {
        string ConnectionString = "";

        public int IDClass { get; set; }

        public int IDStudent { get; set; }

        public StudentModel Student { get; set; }

    }
}

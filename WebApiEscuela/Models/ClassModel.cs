using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebApiEscuela.Models
{
    public class ClassModel
    {
        string ConnectionString = "";

        public int IDClass { get; set; }

        public string NameClass { get; set; }

        public string DescriptionClass { get; set; }

        public int Grade1P { get; set; }

        public int Grade2P { get; set; }

        public int Grade3P { get; set; }
        public string PictureClass { get; set; }
    }
}

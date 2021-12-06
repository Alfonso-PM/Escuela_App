using Microsoft.AspNetCore.Mvc;
using WebApiEscuela.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace WebApiEscuela.Controllers
{
    [Route("tch/[controller]")]
    [ApiController]
    public class TeacherController : ControllerBase
    {
        // GET: api/<TeacherController>
        [HttpGet]
        public ResponseModel Get()
        {
            return new TeacherModel().GetAllTeachers();
        }

        // GET api/<TeacherController>/5
        [HttpGet("{id}")]
        public ResponseModel Get(int id)
        {
            return new TeacherModel().GetTeacherbyID(id);
        }


        [HttpGet("/namet+{name}")]
        public ResponseModel GetbyName(string name)
        {
            return new StudentModel().GetStudentbyName(name);
        }

        [HttpGet("/namet+{name}+passt+{password}")]
        public ResponseModel GetbyNameandPass(string name, string password)
        {
            return new StudentModel().GetStudentbyNameAndPass(name, password);
        }

        // POST api/<TeacherController>
        [HttpPost]
        public ResponseModel Post([FromBody] TeacherModel teacher)
        {
            return teacher.InsertTeacher();
        }

        // PUT api/<TeacherController>/5
        [HttpPut("{id}")]
        public ResponseModel Put([FromBody] TeacherModel teacher)
        {
            return teacher.UpdateTeacher();
        }

        // DELETE api/<TeacherController>/5
        /* [HttpDelete("{id}")]
         public void Delete(int id)
         {

         }*/
    }
}

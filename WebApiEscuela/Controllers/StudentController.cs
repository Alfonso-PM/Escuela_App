using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebApiEscuela.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace WebApiEscuela.Controllers
{
    [Route("std/[controller]")]
    [ApiController]
    public class StudentController : ControllerBase
    {
        // GET: api/<StudentController>  
        [HttpGet]
        public ResponseModel Get()
        {
            return new StudentModel().GetAllStudents();
        }

        // GET api/<StudentController>/5
        [HttpGet("{id}")]
        public ResponseModel Get(int id)
        {
            return new StudentModel().GetStudentbyID(id);
        }

        // POST api/<StudentController>
        [HttpPost]
        public ResponseModel Post([FromBody] StudentModel student)
        {
            return student.InsertStudent();
        }

        // PUT api/<StudentController>/5
        [HttpPut("{id}")]
        public ResponseModel Put([FromBody] StudentModel student)
        {
            return student.UpdateStudent();
        }

        // DELETE api/<StudentController>/5
        /*[HttpDelete("{id}")]
        public void Delete(int id)
        {
        }*/
    }
}

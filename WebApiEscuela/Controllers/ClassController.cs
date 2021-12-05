using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebApiEscuela.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace WebApiEscuela.Controllers
{
    [Route("cls/[controller]")]
    [ApiController]
    public class ClassController : ControllerBase
    {
        // GET: cls/<ClassController>
        [HttpGet]
        public ResponseModel Get()
        {
            return new ClassModel().GetAllClasses();
        }

        [HttpGet("/detail")]
        public ResponseModel GetDetail()
        {
            return new DetailClassModel().GetAllDetailClasses();
        }

        // GET cls/<ClassController>/5
        [HttpGet("{id}")]
        public ResponseModel Get(int id)
        {
            return new ClassModel().GetClassbyID(id);
        }


        [HttpGet("tch/{id}")]
        public ResponseModel GetTeacher(int id)
        {
            return new ClassModel().GetClassesbyTeacherID(id);
        }

        [HttpGet("std/{id}")]
        public ResponseModel GetStudent(int id)
        {
            return new DetailClassModel().GetDetailClassbyStudentID(id);
        }

        [HttpGet("cls/{id}")]
        public ResponseModel GetClass(int id)
        {
            return new DetailClassModel().GetDetailClassbyClassID(id);
        }

        // POST api/<ClassController>
        [HttpPost]
        public ResponseModel Post([FromBody] ClassModel classes)
        {
            return classes.InsertClass();
        }

        [HttpPost("/detail")]
        public ResponseModel PostDetail([FromBody] DetailClassModel classes)
        {
            return classes.InsertDetailClass();
        }

        // PUT api/<ClassController>/5
        /* [HttpPut("{id}")]
         public void Put(int id, [FromBody] string value)
         {
         }

         // DELETE api/<ClassController>/5
         [HttpDelete("{id}")]
         public void Delete(int id)
         {
         }*/
    }
}

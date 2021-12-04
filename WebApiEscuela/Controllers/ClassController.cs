using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace WebApiEscuela.Controllers
{
    [Route("cls/[controller]")]
    [ApiController]
    public class ClassController : ControllerBase
    {
        // GET: api/<ClassController>
        [HttpGet]
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET api/<ClassController>/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value";
        }

        // POST api/<ClassController>
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/<ClassController>/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/<ClassController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}

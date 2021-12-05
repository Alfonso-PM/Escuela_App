using System;
using System.Collections.Generic;
using System.Data.SqlClient;
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

        public ResponseModel GetAllClasses()
        {
            List<ClassModel> list = new List<ClassModel>();
            try
            {
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "SELECT * FROM Class INNER JOIN Teacher ON Class.IDTeacher = Teacher.IDTeacher";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                list.Add(new ClassModel
                                {
                                    IDClass = (int)reader["IDClass"],
                                    NameClass = reader["NameClass"].ToString(),
                                    DescriptionClass = reader["DescriptionClass"].ToString(),
                                    PictureClass = reader["PictureClass"].ToString(),
                                    Teacher = new TeacherModel
                                    {
                                        IDTeacher = (int)reader["IDTeacher"],
                                        NameTeacher = reader["NameTeacher"].ToString(),
                                        FirstLastNameTeacher = reader["FirstLastNameTeacher"].ToString(),
                                        SecondLastNameTeacher = reader["SecondLastNameTeacher"].ToString(),
                                        PictureTeacher = reader["PictureTeacher"].ToString(),
                                        PasswordTeacher = reader["PasswordTeacher"].ToString(),
                                        MailTeacher = reader["MailTeacher"].ToString()
                                    }
                                });
                            }
                        }
                    }
                }
                return new ResponseModel
                {
                    IsSuccess = true,
                    Message = "the classes were successfully obtained",
                    Result = list
                };
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"an error was generated when obtaining the classes ({ex.Message})",
                    Result = null
                };
            }

        }




        public ResponseModel GetClassesbyTeacherID(int id)
        {
            List<ClassModel> list = new List<ClassModel>();
            try
            {
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "SELECT * FROM Class INNER JOIN Teacher ON Class.IDTeacher = Teacher.IDTeacher WHERE Class.IDTeacher = @IDTeacher";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {

                        cmd.Parameters.AddWithValue("@IDTeacher", id);
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                list.Add(new ClassModel
                                {
                                    IDClass = (int)reader["IDClass"],
                                    IDTeacher = (int)reader["IDTeacher"],
                                    NameClass = reader["NameClass"].ToString(),
                                    DescriptionClass = reader["DescriptionClass"].ToString(),
                                    PictureClass = reader["PictureClass"].ToString(),
                                    Teacher = new TeacherModel
                                    {
                                        IDTeacher = (int)reader["IDTeacher"],
                                        NameTeacher = reader["NameTeacher"].ToString(),
                                        FirstLastNameTeacher = reader["FirstLastNameTeacher"].ToString(),
                                        SecondLastNameTeacher = reader["SecondLastNameTeacher"].ToString(),
                                        PictureTeacher = reader["PictureTeacher"].ToString(),
                                        PasswordTeacher = reader["PasswordTeacher"].ToString(),
                                        MailTeacher = reader["MailTeacher"].ToString()
                                    }
                                });
                            }
                        }
                    }
                }
                return new ResponseModel
                {
                    IsSuccess = true,
                    Message = "Class were successfully obtained",
                    Result = list
                };
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"An error was generated while getting the class ({ex.Message})",
                    Result = null
                };
            }

        }



        public ResponseModel GetClassbyID(int id)
        {
            ClassModel obj = new ClassModel();
            try
            {
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "SELECT * FROM Class INNER JOIN Teacher ON Class.IDTeacher = Teacher.IDTeacher WHERE IDClass = @IDClass";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {

                        cmd.Parameters.AddWithValue("@IDClass", id);
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                obj = (new ClassModel
                                {
                                    IDClass = (int)reader["IDClass"],
                                    NameClass = reader["NameClass"].ToString(),
                                    DescriptionClass = reader["DescriptionClass"].ToString(),
                                    PictureClass = reader["PictureClass"].ToString(),
                                    Teacher = new TeacherModel
                                    {
                                        IDTeacher = (int)reader["IDTeacher"],
                                        NameTeacher = reader["NameTeacher"].ToString(),
                                        FirstLastNameTeacher = reader["FirstLastNameTeacher"].ToString(),
                                        SecondLastNameTeacher = reader["SecondLastNameTeacher"].ToString(),
                                        PictureTeacher = reader["PictureTeacher"].ToString(),
                                        PasswordTeacher = reader["PasswordTeacher"].ToString(),
                                        MailTeacher = reader["MailTeacher"].ToString()
                                    }

                                });
                            }
                        }
                    }
                }
                return new ResponseModel
                {
                    IsSuccess = true,
                    Message = "Class were successfully obtained",
                    Result = obj
                };
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"An error was generated while getting the class ({ex.Message})",
                    Result = null
                };
            }

        }



        public ResponseModel InsertClass()
        {
            try
            {
                object newID;
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "INSERT INTO Class (IDTeacher, NameClass, DescriptionClass, PictureClass) VALUES(@IDTeacher, @NameClass, @DescriptionClass ,@PictureClass ); SELECT SCOPE_IDENTITY();";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Parameters.AddWithValue("@IDTeacher", IDTeacher);
                        cmd.Parameters.AddWithValue("@NameClass", NameClass);
                        cmd.Parameters.AddWithValue("@DescriptionClass", DescriptionClass);
                        cmd.Parameters.AddWithValue("@PictureClass", PictureClass);
                        newID = cmd.ExecuteScalar();
                        if (newID != null && newID.ToString().Length > 0)
                        {
                            return new ResponseModel
                            {
                                IsSuccess = true,
                                Message = "The class was successfully added",
                                Result = newID
                            };
                        }
                        else
                        {
                            return new ResponseModel
                            {
                                IsSuccess = false,
                                Message = $"an error was generated when inserting a class",
                                Result = null
                            };
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"an error was generated when inserting a class({ex.Message})",
                    Result = null
                };
            }
        }

    }
}

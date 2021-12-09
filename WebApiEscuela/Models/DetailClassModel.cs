using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace WebApiEscuela.Models
{
    public class DetailClassModel
    {
        string ConnectionString = "Server=tcp:escuelaappserver.database.windows.net,1433;Initial Catalog=Escuela_DataBase;Persist Security Info=False;User ID=escuelaappuser;Password=Escuelapass01;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;";

        public int IDDetailClass { get; set; }

        public int IDClassdtl { get; set; }

        public int IDStudentdtl { get; set; }

        public int Grade1P { get; set; }

        public int Grade2P { get; set; }

        public int Grade3P { get; set; }

        public StudentModel Student { get; set; }

        public ClassModel Class { get; set; }



        public ResponseModel GetAllDetailClasses()
        {
            List<DetailClassModel> list = new List<DetailClassModel>();
            try
            {
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "SELECT * FROM DetailClass INNER JOIN Class ON DetailClass.IDClass = Class.IDClass INNER JOIN Student ON DetailClass.IDStudent = Student.IDStudent    INNER JOIN Teacher ON Class.IDTeacher = Teacher.IDTeacher";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                list.Add( new DetailClassModel
                                {
                                    IDDetailClass = (int)reader["IDClass"],
                                    Grade1P = (int)reader["Grade1P"],
                                    Grade2P = (int)reader["Grade2P"],
                                    Grade3P = (int)reader["Grade3P"],
                                    Class = new ClassModel
                                    {
                                        IDClass = (int)reader["IDClass"],
                                        IDTeachertch = (int)reader["IDTeacher"],
                                        NameClass = reader["NameClass"].ToString(),
                                        Schedule = reader["Schedule"].ToString(),
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
                                    },
                                    Student = new StudentModel
                                    {
                                        IDStudent = (int)reader["IDStudent"],
                                        NameStudent = reader["NameStudent"].ToString(),
                                        FirstLastNameStudent = reader["FirstLastNameStudent"].ToString(),
                                        SecondLastNameStudent = reader["SecondLastNameStudent"].ToString(),
                                        PictureStudent = reader["PictureStudent"].ToString(),
                                        PasswordStudent = reader["PasswordStudent"].ToString(),
                                        MailStudent = reader["MailStudent"].ToString()
                                    }

                                });
                            }
                        }
                    }
                }
                return new ResponseModel
                {
                    IsSuccess = true,
                    Message = "the detail were successfully obtained",
                    Result = list
                };
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"an error was generated when obtaining the detail ({ex.Message})",
                    Result = null
                };
            }

        }




        public ResponseModel GetDetailClassbyClassID(int id)
        {
            List<DetailClassModel> list = new List<DetailClassModel>();
            try
            {
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "SELECT * FROM DetailClass INNER JOIN Class ON DetailClass.IDClass = Class.IDClass INNER JOIN Student ON DetailClass.IDStudent = Student.IDStudent   INNER JOIN Teacher ON Class.IDTeacher = Teacher.IDTeacher   WHERE DetailClass.IDClass = @IDClass";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {

                        cmd.Parameters.AddWithValue("@IDClass", id);
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                list.Add(new DetailClassModel
                                {
                                    IDDetailClass = (int)reader["IDClass"],
                                    Grade1P = (int)reader["Grade1P"],
                                    Grade2P = (int)reader["Grade2P"],
                                    Grade3P = (int)reader["Grade3P"],
                                    Class = new ClassModel
                                    {
                                        IDClass = (int)reader["IDClass"],
                                        IDTeachertch = (int)reader["IDTeacher"],
                                        NameClass = reader["NameClass"].ToString(),
                                        Schedule = reader["Schedule"].ToString(),
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
                                    },
                                    Student = new StudentModel
                                    {
                                        IDStudent = (int)reader["IDStudent"],
                                        NameStudent = reader["NameStudent"].ToString(),
                                        FirstLastNameStudent = reader["FirstLastNameStudent"].ToString(),
                                        SecondLastNameStudent = reader["SecondLastNameStudent"].ToString(),
                                        PictureStudent = reader["PictureStudent"].ToString(),
                                        PasswordStudent = reader["PasswordStudent"].ToString(),
                                        MailStudent = reader["MailStudent"].ToString()
                                    }

                                });
                            }
                        }
                    }
                }
                return new ResponseModel
                {
                    IsSuccess = true,
                    Message = "Detail were successfully obtained",
                    Result = list
                };
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"An error was generated while getting the detail ({ex.Message})",
                    Result = null
                };
            }

        }



        public ResponseModel GetDetailClassbyStudentID(int id)
        {
            List<DetailClassModel> list = new List<DetailClassModel>();
            try
            {
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "SELECT * FROM DetailClass INNER JOIN Class ON DetailClass.IDClass = Class.IDClass INNER JOIN Student ON DetailClass.IDStudent = Student.IDStudent   INNER JOIN Teacher ON Class.IDTeacher = Teacher.IDTeacher  WHERE DetailClass.IDStudent = @IDStudent";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {

                        cmd.Parameters.AddWithValue("@IDStudent", id);
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                list.Add(new DetailClassModel
                                {
                                    IDDetailClass = (int)reader["IDClass"],
                                    Grade1P = (int)reader["Grade1P"],
                                    Grade2P = (int)reader["Grade2P"],
                                    Grade3P = (int)reader["Grade3P"],
                                    Class = new ClassModel
                                    {
                                        IDClass = (int)reader["IDClass"],
                                        IDTeachertch = (int)reader["IDTeacher"],
                                        NameClass = reader["NameClass"].ToString(),
                                        Schedule = reader["Schedule"].ToString(),
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
                                    },
                                    Student = new StudentModel
                                    {
                                        IDStudent = (int)reader["IDStudent"],
                                        NameStudent = reader["NameStudent"].ToString(),
                                        FirstLastNameStudent = reader["FirstLastNameStudent"].ToString(),
                                        SecondLastNameStudent = reader["SecondLastNameStudent"].ToString(),
                                        PictureStudent = reader["PictureStudent"].ToString(),
                                        PasswordStudent = reader["PasswordStudent"].ToString(),
                                        MailStudent = reader["MailStudent"].ToString()
                                    }

                                });
                            }
                        }
                    }
                }
                return new ResponseModel
                {
                    IsSuccess = true,
                    Message = "Detail were successfully obtained",
                    Result = list
                };
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"An error was generated while getting the detail ({ex.Message})",
                    Result = null
                };
            }

        }



        public ResponseModel InsertDetailClass()
        {
            try
            {
                object newID;
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "INSERT INTO DetailClass (IDClass, IDStudent, Grade1P, Grade2P, Grade3P) VALUES(@IDClass, @IDStudent, @Grade1P, @Grade2P, @Grade3P ); SELECT SCOPE_IDENTITY();";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Parameters.AddWithValue("@IDClass", IDClassdtl);
                        cmd.Parameters.AddWithValue("@IDStudent", IDStudentdtl);
                        cmd.Parameters.AddWithValue("@Grade1P", Grade1P);
                        cmd.Parameters.AddWithValue("@Grade2P", Grade2P);
                        cmd.Parameters.AddWithValue("@Grade3P", Grade3P);
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
                                Message = $"an error was generated when inserting a detail",
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
                    Message = $"an error was generated when inserting a detail({ex.Message})",
                    Result = null
                };
            }
        }


    }
}

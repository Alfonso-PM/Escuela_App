using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace WebApiEscuela.Models
{
    public class TeacherModel
    {

        string ConnectionString = "Server=tcp:escuelaappserver.database.windows.net,1433;Initial Catalog=Escuela_DataBase;Persist Security Info=False;User ID=escuelaappuser;Password=Escuelapass01;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;";

        public int IDTeacher { get; set; }

        public string NameTeacher { get; set; }

        public string FirstLastNameTeacher { get; set; }

        public string SecondLastNameTeacher { get; set; }

        public string PictureTeacher { get; set; }

        public string PasswordTeacher { get; set; }

        public string MailTeacher { get; set; }



        public ResponseModel GetAllStudents()
        {
            List<TeacherModel> list = new List<TeacherModel>();
            try
            {
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "SELECT * FROM Teacher";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                list.Add(new TeacherModel
                                {
                                    IDTeacher = (int)reader["IDTeacher"],
                                    NameTeacher = reader["NameTeacher"].ToString(),
                                    FirstLastNameTeacher = reader["FirstLastNameTeacher"].ToString(),
                                    SecondLastNameTeacher = reader["SecondLastNameTeacher"].ToString(),
                                    PictureTeacher = reader["PictureTeacher"].ToString(),
                                    PasswordTeacher = reader["PasswordTeacher"].ToString(),
                                    MailTeacher = reader["MailTeacher"].ToString()

                                });
                            }
                        }
                    }
                }
                return new ResponseModel
                {
                    IsSuccess = true,
                    Message = "Teachers were successfully obtained",
                    Result = list
                };
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"An error was generated while getting the teachers ({ex.Message})",
                    Result = null
                };
            }

        }



        public ResponseModel GetStudentbyID(int id)
        {
            TeacherModel obj = new TeacherModel();
            try
            {
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "SELECT * FROM Teacher WHERE IDTeacher = @IDTeacher";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {

                        cmd.Parameters.AddWithValue("@IDTeacher", id);
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                obj = (new TeacherModel
                                {
                                    IDTeacher = (int)reader["IDTeacher"],
                                    NameTeacher = reader["NameTeacher"].ToString(),
                                    FirstLastNameTeacher = reader["FirstLastNameTeacher"].ToString(),
                                    SecondLastNameTeacher = reader["SecondLastNameTeacher"].ToString(),
                                    PictureTeacher = reader["PictureTeacher"].ToString(),
                                    PasswordTeacher = reader["PasswordTeacher"].ToString(),
                                    MailTeacher = reader["MailTeacher"].ToString()

                                });
                            }
                        }
                    }
                }
                return new ResponseModel
                {
                    IsSuccess = true,
                    Message = "Teacher were successfully obtained",
                    Result = obj
                };
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"An error was generated while getting the teacher ({ex.Message})",
                    Result = null
                };
            }

        }



        public ResponseModel UpdateStudent()
        {
            try
            {

                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "UPDATE Student SET NameStudent = @NameStudent, FirstLastNameStudent = @FirstLastNameStudent, SecondLastNameStudent = @SecondLastNameStudent, PictureStudent = @PictureStudent  WHERE IDStudent = @IDStudent;";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Parameters.AddWithValue("@NameTeacher", NameTeacher);
                        cmd.Parameters.AddWithValue("@FirstLastNameTeacher", FirstLastNameTeacher);
                        cmd.Parameters.AddWithValue("@SecondLastNameTeacher", SecondLastNameTeacher);
                        cmd.Parameters.AddWithValue("@PictureTeacher", PictureTeacher);
                        cmd.Parameters.AddWithValue("@IDTeacher", IDTeacher);
                        cmd.ExecuteNonQuery();
                        return new ResponseModel
                        {
                            IsSuccess = true,
                            Message = "The teacher has been updated successfully",
                            Result = IDTeacher
                        };
                    }
                }
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"an error was generated when updating a teacher ({ex.Message})",
                    Result = null
                };
            }
        }



        public ResponseModel InsertStudent()
        {
            try
            {
                object newID;
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "INSERT INTO Student (NameStudent, FirstLastNameStudent, SecondLastNameStudent, Grade1P, Grade2P, Grade3P, PictureStudent, PasswordStudent, MailStudent) VALUES(@NameStudent, @FirstLastNameStudent, @SecondLastNameStudent,@Grade1P, @Grade2P, @Grade3P, @PictureStudent, @PasswordStudent, @MailStudent ); SELECT SCOPE_IDENTITY();";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Parameters.AddWithValue("@NameTeacher", NameTeacher);
                        cmd.Parameters.AddWithValue("@FirstLastNameTeacher", FirstLastNameTeacher);
                        cmd.Parameters.AddWithValue("@SecondLastNameTeacher", SecondLastNameTeacher);
                        cmd.Parameters.AddWithValue("@PictureTeacher", PictureTeacher);
                        cmd.Parameters.AddWithValue("@PasswordTeacher", PasswordTeacher);
                        cmd.Parameters.AddWithValue("@MailTeacher", MailTeacher);
                        newID = cmd.ExecuteScalar();
                        if (newID != null && newID.ToString().Length > 0)
                        {
                            return new ResponseModel
                            {
                                IsSuccess = true,
                                Message = "The teacher was successfully added",
                                Result = newID
                            };
                        }
                        else
                        {
                            return new ResponseModel
                            {
                                IsSuccess = false,
                                Message = $"an error was generated when inserting a teacher",
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
                    Message = $"an error was generated when inserting a teacher({ex.Message})",
                    Result = null
                };
            }
        }

    }
}

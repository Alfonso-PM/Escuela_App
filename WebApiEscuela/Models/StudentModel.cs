using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace WebApiEscuela.Models
{
    public class StudentModel
    {
        string ConnectionString = "Server=tcp:escuelaappserver.database.windows.net,1433;Initial Catalog=Escuela_DataBase;Persist Security Info=False;User ID=escuelaappuser;Password=Escuelapass01;MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;";

        public int IDStudent { get; set; }

        public string NameStudent { get; set; }

        public string FirstLastNameStudent { get; set; }

        public string SecondLastNameStudent { get; set; }

        public string PictureStudent { get; set; }

        public int Grade1P { get; set; }

        public int Grade2P { get; set; }

        public int Grade3P { get; set; }

        public string PasswordStudent { get; set; }

        public string MailStudent { get; set; }


        //With this method we are bringing all the students who have registered
        public ResponseModel GetAllStudents()
        {
            List<StudentModel> list = new List<StudentModel>();
            try
            {
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "SELECT * FROM Student";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                list.Add(new StudentModel
                                {
                                    IDStudent = (int)reader["IDStudent"],
                                    NameStudent = reader["NameStudent"].ToString(),
                                    FirstLastNameStudent = reader["FirstLastNameStudent"].ToString(),
                                    SecondLastNameStudent = reader["SecondLastNameStudent"].ToString(),
                                    Grade1P = (int)reader["Grade1P"],
                                    Grade2P = (int)reader["Grade2P"],
                                    Grade3P = (int)reader["Grade3P"],
                                    PictureStudent = reader["PictureStudent"].ToString(),
                                    PasswordStudent = reader["PasswordStudent"].ToString(),
                                    MailStudent = reader["MailStudent"].ToString()

                                });
                            }
                        }
                    }
                }
                return new ResponseModel
                {
                    IsSuccess = true,
                    Message = "Students were successfully obtained",
                    Result = list
                };
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"An error was generated while getting the students ({ex.Message})",
                    Result = null
                };
            }

        }



        public ResponseModel GetStudentbyID(int id)
        {
            StudentModel obj = new StudentModel();
            try
            {
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "SELECT * FROM Student WHERE IDStudent = @IDStudent";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {

                        cmd.Parameters.AddWithValue("@IDStudent", id);
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                obj = (new StudentModel
                                {
                                    IDStudent = (int)reader["IDStudent"],
                                    NameStudent = reader["NameStudent"].ToString(),
                                    FirstLastNameStudent = reader["FirstLastNameStudent"].ToString(),
                                    SecondLastNameStudent = reader["SecondLastNameStudent"].ToString(),
                                    Grade1P = (int)reader["Grade1P"],
                                    Grade2P = (int)reader["Grade2P"],
                                    Grade3P = (int)reader["Grade3P"],
                                    PictureStudent = reader["PictureStudent"].ToString(),
                                    PasswordStudent = reader["PasswordStudent"].ToString(),
                                    MailStudent = reader["MailStudent"].ToString()
                                });
                            }
                        }
                    }
                }
                return new ResponseModel
                {
                    IsSuccess = true,
                    Message = "Student were successfully obtained",
                    Result = obj
                };
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"An error was generated while getting the student ({ex.Message})",
                    Result = null
                };
            }

        }



        public ResponseModel GetStudentbyIDAndPass(int id, string password)
        {
            StudentModel obj = new StudentModel();
            try
            {
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "SELECT * FROM Student WHERE IDStudent = @IDStudent AND PasswordStudent = @PasswordStudent ";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {

                        cmd.Parameters.AddWithValue("@IDStudent", id);
                        cmd.Parameters.AddWithValue("@PasswordStudent", password);
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                obj = (new StudentModel
                                {
                                    IDStudent = (int)reader["IDStudent"],
                                    NameStudent = reader["NameStudent"].ToString(),
                                    FirstLastNameStudent = reader["FirstLastNameStudent"].ToString(),
                                    SecondLastNameStudent = reader["SecondLastNameStudent"].ToString(),
                                    Grade1P = (int)reader["Grade1P"],
                                    Grade2P = (int)reader["Grade2P"],
                                    Grade3P = (int)reader["Grade3P"],
                                    PictureStudent = reader["PictureStudent"].ToString(),
                                    PasswordStudent = reader["PasswordStudent"].ToString(),
                                    MailStudent = reader["MailStudent"].ToString()
                                });
                            }
                        }
                    }
                }
                return new ResponseModel
                {
                    IsSuccess = true,
                    Message = "Student were successfully obtained",
                    Result = obj
                };
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"An error was generated while getting the student ({ex.Message})",
                    Result = null
                };
            }

        }




        public ResponseModel GetStudentbyNameAndPass(string name,string password)
        {
            StudentModel obj = new StudentModel();
            try
            {
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "SELECT * FROM Student WHERE NameStudent = @NameStudent AND PasswordStudent = @PasswordStudent ";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {

                        cmd.Parameters.AddWithValue("@NameStudent", name);
                        cmd.Parameters.AddWithValue("@PasswordStudent", password);
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                obj = (new StudentModel
                                {
                                    IDStudent = (int)reader["IDStudent"],
                                    NameStudent = reader["NameStudent"].ToString(),
                                    FirstLastNameStudent = reader["FirstLastNameStudent"].ToString(),
                                    SecondLastNameStudent = reader["SecondLastNameStudent"].ToString(),
                                    Grade1P = (int)reader["Grade1P"],
                                    Grade2P = (int)reader["Grade2P"],
                                    Grade3P = (int)reader["Grade3P"],
                                    PictureStudent = reader["PictureStudent"].ToString(),
                                    PasswordStudent = reader["PasswordStudent"].ToString(),
                                    MailStudent = reader["MailStudent"].ToString()
                                });
                            }
                        }
                    }
                }
                return new ResponseModel
                {
                    IsSuccess = true,
                    Message = "Student were successfully obtained",
                    Result = obj
                };
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"An error was generated while getting the student ({ex.Message})",
                    Result = null
                };
            }

        }


        public ResponseModel GetStudentbyName(string name)
        {
            StudentModel obj = new StudentModel();
            try
            {
                using (SqlConnection conn = new SqlConnection(ConnectionString))
                {
                    conn.Open();
                    string tsql = "SELECT * FROM Student WHERE NameStudent = @NameStudent";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {

                        cmd.Parameters.AddWithValue("@NameStudent", name);
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            if (reader.Read())
                            {
                                obj = (new StudentModel
                                {
                                    IDStudent = (int)reader["IDStudent"],
                                    NameStudent = reader["NameStudent"].ToString(),
                                    FirstLastNameStudent = reader["FirstLastNameStudent"].ToString(),
                                    SecondLastNameStudent = reader["SecondLastNameStudent"].ToString(),
                                    Grade1P = (int)reader["Grade1P"],
                                    Grade2P = (int)reader["Grade2P"],
                                    Grade3P = (int)reader["Grade3P"],
                                    PictureStudent = reader["PictureStudent"].ToString(),
                                    PasswordStudent = reader["PasswordStudent"].ToString(),
                                    MailStudent = reader["MailStudent"].ToString()
                                });
                            }
                        }
                    }
                }
                return new ResponseModel
                {
                    IsSuccess = true,
                    Message = "Student were successfully obtained",
                    Result = obj
                };
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"An error was generated while getting the student ({ex.Message})",
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
                    string tsql = "UPDATE Student SET NameStudent = @NameStudent, FirstLastNameStudent = @FirstLastNameStudent, SecondLastNameStudent = @SecondLastNameStudent, Grade1P = @Grade1P, Grade2P = @Grade2P, Grade3P = @Grade3P, PictureStudent = @PictureStudent  WHERE IDStudent = @IDStudent;";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Parameters.AddWithValue("@NameStudent", NameStudent);
                        cmd.Parameters.AddWithValue("@FirstLastNameStudent", FirstLastNameStudent);
                        cmd.Parameters.AddWithValue("@SecondLastNameStudent", SecondLastNameStudent);
                        cmd.Parameters.AddWithValue("@Grade1P", Grade1P);
                        cmd.Parameters.AddWithValue("@Grade2P", Grade2P);
                        cmd.Parameters.AddWithValue("@Grade3P", Grade3P);
                        cmd.Parameters.AddWithValue("@PictureStudent", PictureStudent);
                        cmd.Parameters.AddWithValue("@IDStudent", IDStudent);
                        cmd.ExecuteNonQuery();
                        return new ResponseModel
                        {
                            IsSuccess = true,
                            Message = "The student has been updated successfully",
                            Result = IDStudent
                        };
                    }
                }
            }
            catch (Exception ex)
            {
                return new ResponseModel
                {
                    IsSuccess = false,
                    Message = $"an error was generated when updating a student ({ex.Message})",
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
                        cmd.Parameters.AddWithValue("@NameStudent", NameStudent);
                        cmd.Parameters.AddWithValue("@FirstLastNameStudent", FirstLastNameStudent);
                        cmd.Parameters.AddWithValue("@SecondLastNameStudent", SecondLastNameStudent);
                        cmd.Parameters.AddWithValue("@Grade1P", Grade1P);
                        cmd.Parameters.AddWithValue("@Grade2P", Grade2P);
                        cmd.Parameters.AddWithValue("@Grade3P", Grade3P);
                        cmd.Parameters.AddWithValue("@PictureStudent", PictureStudent);
                        cmd.Parameters.AddWithValue("@PasswordStudent", PasswordStudent);
                        cmd.Parameters.AddWithValue("@MailStudent", MailStudent);
                        newID = cmd.ExecuteScalar();
                        if (newID != null && newID.ToString().Length > 0)
                        {
                            return new ResponseModel
                            {
                                IsSuccess = true,
                                Message = "The student was successfully added",
                                Result = newID
                            };
                        }
                        else
                        {
                            return new ResponseModel
                            {
                                IsSuccess = false,
                                Message = $"an error was generated when inserting a student",
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
                    Message = $"an error was generated when inserting a student({ex.Message})",
                    Result = null
                };
            }
        }

    }
}

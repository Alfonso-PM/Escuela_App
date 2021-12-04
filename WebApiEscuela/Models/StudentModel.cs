using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;

namespace WebApiEscuela.Models
{
    public class StudentModel
    {
        string ConnectionString = "";

        public int IDStudent { get; set; }

        public string NameStudent { get; set; }

        public string FirstLastNameStudent { get; set; }

        public string SecondLastNameStudent { get; set; }

        public string PictureStudent { get; set; }

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
                    string tsql = "UPDATE Student SET NameStudent = @NameStudent, FirstLastNameStudent = @FirstLastNameStudent, SecondLastNameStudent = @SecondLastNameStudent, PictureStudent = @PictureStudent  WHERE IDStudent = @IDStudent;";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Parameters.AddWithValue("@NameStudent", NameStudent);
                        cmd.Parameters.AddWithValue("@FirstLastNameStudent", FirstLastNameStudent);
                        cmd.Parameters.AddWithValue("@SecondLastNameStudent", SecondLastNameStudent);
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
                    string tsql = "INSERT INTO Student (NameStudent, FirstLastNameStudent, SecondLastNameStudent, PictureStudent, PasswordStudent, MailStudent) VALUES(@NameStudent, @FirstLastNameStudent, @SecondLastNameStudent, @PictureStudent, @PasswordStudent, @MailStudent ); SELECT LAST_INSERT_ID();";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Parameters.AddWithValue("@NameStudent", NameStudent);
                        cmd.Parameters.AddWithValue("@FirstLastNameStudent", FirstLastNameStudent);
                        cmd.Parameters.AddWithValue("@SecondLastNameStudent", SecondLastNameStudent);
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

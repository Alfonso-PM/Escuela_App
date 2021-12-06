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
                    string tsql = "SELECT * FROM DetailClass INNER JOIN Class ON DetailClass.IDClass = Class.IDClass INNER JOIN Student ON DetailClass.IDStudent = Student.IDStudent";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {
                        using (SqlDataReader reader = cmd.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                list.Add( new DetailClassModel
                                {
                                    IDDetailClass = (int)reader["IDClass"],
                                    Class = new ClassModel
                                    {
                                        IDClass = (int)reader["IDClass"],
                                        IDTeachertch = (int)reader["IDTeacher"],
                                        NameClass = reader["NameClass"].ToString(),
                                        DescriptionClass = reader["DescriptionClass"].ToString(),
                                        PictureClass = reader["PictureClass"].ToString()
                                    },
                                    Student = new StudentModel
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
                    string tsql = "SELECT * FROM DetailClass INNER JOIN Class ON DetailClass.IDClass = Class.IDClass INNER JOIN Student ON DetailClass.IDStudent = Student.IDStudent WHERE DetailClass.IDClass = @IDClass";
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
                                    Class = new ClassModel
                                    {
                                        IDClass = (int)reader["IDClass"],
                                        IDTeachertch = (int)reader["IDTeacher"],
                                        NameClass = reader["NameClass"].ToString(),
                                        DescriptionClass = reader["DescriptionClass"].ToString(),
                                        PictureClass = reader["PictureClass"].ToString()
                                    },
                                    Student = new StudentModel
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
                    string tsql = "SELECT * FROM DetailClass INNER JOIN Class ON DetailClass.IDClass = Class.IDClass INNER JOIN Student ON DetailClass.IDStudent = Student.IDStudent WHERE DetailClass.IDStudent = @IDStudent";
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
                                    Class = new ClassModel
                                    {
                                        IDClass = (int)reader["IDClass"],
                                        IDTeachertch = (int)reader["IDTeacher"],
                                        NameClass = reader["NameClass"].ToString(),
                                        DescriptionClass = reader["DescriptionClass"].ToString(),
                                        PictureClass = reader["PictureClass"].ToString()
                                    },
                                    Student = new StudentModel
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
                    string tsql = "INSERT INTO DetailClass (IDClass, IDStudent) VALUES(@IDClass, @IDStudent ); SELECT SCOPE_IDENTITY();";
                    using (SqlCommand cmd = new SqlCommand(tsql, conn))
                    {
                        cmd.CommandType = System.Data.CommandType.Text;
                        cmd.Parameters.AddWithValue("@IDClass", IDClassdtl);
                        cmd.Parameters.AddWithValue("@IDStudent", IDStudentdtl);
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

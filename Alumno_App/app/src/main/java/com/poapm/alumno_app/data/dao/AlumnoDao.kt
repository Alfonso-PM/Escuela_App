package com.poapm.alumno_app.data.dao

import androidx.room.*
import com.poapm.alumno_app.domain.model.Alumno

@Dao
interface AlumnoDao {

    @Transaction
    @Query("SELECT * FROM Alumno WHERE Alumno.idStudent = :id AND Alumno.passwordStudent = :password")
    fun findAlumno(id: Int, password: String): Alumno?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAlumno(alumno: List<Alumno>): List<Long>

    @Update
    fun updateAlumno(alumno: Alumno): Int
}
package com.poapm.alumno_app.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.poapm.alumno_app.domain.model.Alumno

@Dao
interface AlumnoDao {

    @Transaction
    @Query("SELECT * FROM Alumno WHERE Alumno.idStudent = :id AND Alumno.password = :password")
    fun findAlumno(id: String, password: String): Alumno?
}
package com.poapm.alumno_app.domain.repository

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.poapm.alumno_app.core.exception.Failure
import com.poapm.alumno_app.core.functional.Either
import com.poapm.alumno_app.domain.model.Alumno

interface AlumnoRepository {

    fun findAlumno(id: String, password: String): Either<Failure, Alumno>

}
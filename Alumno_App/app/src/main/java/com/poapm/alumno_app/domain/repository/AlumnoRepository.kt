package com.poapm.alumno_app.domain.repository

import com.poapm.alumno_app.core.exception.Failure
import com.poapm.alumno_app.core.functional.Either
import com.poapm.alumno_app.data.dto.AlumnoResponse
import com.poapm.alumno_app.domain.model.Alumno

interface AlumnoRepository {

    fun findAlumno(id: String, password: String): Either<Failure, Alumno>

    fun getAllAlumnos(): Either<Failure, AlumnoResponse>

    fun getAlumno(): Either<Failure, Alumno>

    fun doLogout(): Either<Failure, Boolean>

    fun saveAlumno(alumno: List<Alumno>): Either<Failure, Boolean>

    fun updateAlumno(alumno: Alumno): Either<Failure, Boolean>

}
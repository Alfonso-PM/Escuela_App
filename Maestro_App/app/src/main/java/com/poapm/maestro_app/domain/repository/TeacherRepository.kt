package com.poapm.maestro_app.domain.repository

import com.poapm.maestro_app.core.exception.Failure
import com.poapm.maestro_app.core.functional.Either
import com.poapm.maestro_app.data.dto.TeacherResponse
import com.poapm.maestro_app.domain.model.Teacher

interface TeacherRepository {

    fun getAllTeachers(): Either<Failure, TeacherResponse>

    fun getLocalTeachers(): Either<Failure, Teacher>

    fun doLogout(): Either<Failure, Boolean>

    fun findTeacher(id: String, password: String): Either<Failure, Teacher>

    fun saveTeacher(teacher: List<Teacher>): Either<Failure, Boolean>

    fun updateTeacher(teacher: Teacher): Either<Failure, Boolean>
}
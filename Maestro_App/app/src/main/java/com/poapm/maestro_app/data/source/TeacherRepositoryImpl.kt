package com.poapm.maestro_app.data.source

import com.poapm.maestro_app.core.exception.Failure
import com.poapm.maestro_app.core.functional.Either
import com.poapm.maestro_app.core.plataform.AuthManager
import com.poapm.maestro_app.core.plataform.NetworkHandler
import com.poapm.maestro_app.data.api.TeacherApi
import com.poapm.maestro_app.data.dao.TeacherDao
import com.poapm.maestro_app.data.dto.TeacherResponse
import com.poapm.maestro_app.domain.model.Teacher
import com.poapm.maestro_app.domain.repository.TeacherRepository
import com.poapm.maestro_app.framework.api.ApiRequest
import com.poapm.maestro_app.presentation.login.LoginFailure
import javax.inject.Inject

class TeacherRepositoryImpl  @Inject constructor(
    private val authManager: AuthManager,
    private val teacherApi: TeacherApi,
    private val teacherDao: TeacherDao,
    private val networkHandler: NetworkHandler
)  : TeacherRepository, ApiRequest {

    override fun getAllTeachers(): Either<Failure, TeacherResponse> {
        val result = makeRequest(networkHandler, teacherApi.getAllTeachers(), { it }, TeacherResponse(emptyList()))

        return result
    }

    override fun getLocalTeachers(): Either<Failure, Teacher> {
        val result = authManager.teacher

        return result?.let {
            Either.Right(it)
        } ?: Either.Left(Failure.Unauthorized)
    }

    override fun doLogout(): Either<Failure, Boolean> {
        authManager.teacher = null
        return Either.Right(true)
    }

    override fun findTeacher(id: Int, password: String): Either<Failure, Teacher> {
        val result = teacherDao.findTeacher(id, password)

        return result?.let {
            authManager.teacher = it
            Either.Right(it)
        } ?: Either.Left(LoginFailure.NotFound)
    }

    override fun saveTeacher(teacher: List<Teacher>): Either<Failure, Boolean> {
        val result = teacherDao.saveTeacher(teacher)
        return if (result.size == teacher.size) Either.Right(true)
        else Either.Left(Failure.DatabaseError)
    }

    override fun updateTeacher(teacher: Teacher): Either<Failure, Boolean> {
        val result = teacherDao.updateTeacher(teacher)
        return  Either.Right(true)
    }

}
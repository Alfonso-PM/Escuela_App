package com.poapm.alumno_app.data.source

import com.poapm.alumno_app.core.exception.Failure
import com.poapm.alumno_app.core.functional.Either
import com.poapm.alumno_app.core.plataform.AuthenticationM
import com.poapm.alumno_app.core.plataform.NetworkHandler
import com.poapm.alumno_app.data.api.AlumnoApi
import com.poapm.alumno_app.data.dao.AlumnoDao
import com.poapm.alumno_app.domain.model.Alumno
import com.poapm.alumno_app.domain.repository.AlumnoRepository
import com.poapm.alumno_app.framework.api.ApiRequest
import com.poapm.alumno_app.presentation.login.LoginFailure
import javax.inject.Inject

class AlumnoRepositoryImpl @Inject constructor(
    private val authenticationM: AuthenticationM,
    private val alumnoApi: AlumnoApi,
    private val alumnoDao: AlumnoDao,
    private val networkHandler: NetworkHandler
    ) : AlumnoRepository, ApiRequest {
    override fun findAlumno(id: String, password: String): Either<Failure, Alumno> {
        val result = alumnoDao.findAlumno(id, password)

        return result?.let {
            authenticationM.alumno = it
            Either.Right(it)
        } ?: Either.Left(LoginFailure.NotFound)
    }
}
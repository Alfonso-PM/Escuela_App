package com.poapm.alumno_app.domain.usecase

import com.poapm.alumno_app.core.exception.Failure
import com.poapm.alumno_app.core.functional.Either
import com.poapm.alumno_app.core.interactor.UseCase
import com.poapm.alumno_app.domain.model.Alumno
import com.poapm.alumno_app.domain.repository.AlumnoRepository
import javax.inject.Inject

class GetAlumno @Inject constructor(private val alumnoRepository: AlumnoRepository):
UseCase<Alumno, UseCase.None>(){
    override suspend fun run(params: None) = alumnoRepository.getAlumno()
}
package com.poapm.alumno_app.domain.usecase

import com.poapm.alumno_app.core.exception.Failure
import com.poapm.alumno_app.core.functional.Either
import com.poapm.alumno_app.core.interactor.UseCase
import com.poapm.alumno_app.data.dto.AlumnoResponse
import com.poapm.alumno_app.domain.repository.AlumnoRepository
import javax.inject.Inject

class GetAllAlumnos @Inject constructor(private val alumnoRepository: AlumnoRepository):
UseCase<AlumnoResponse, String>(){
    override suspend fun run(params: String)=alumnoRepository.getAllAlumnos()
}
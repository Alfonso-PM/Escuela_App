package com.poapm.alumno_app.domain.usecase

import com.poapm.alumno_app.core.exception.Failure
import com.poapm.alumno_app.core.functional.Either
import com.poapm.alumno_app.core.interactor.UseCase
import com.poapm.alumno_app.domain.model.Alumno
import com.poapm.alumno_app.domain.repository.AlumnoRepository
import javax.inject.Inject

class SaveAlumno @Inject constructor(private val alumnoRepository: AlumnoRepository):
UseCase<Boolean, List<Alumno>>(){
    override suspend fun run(params: List<Alumno>)=alumnoRepository.saveAlumno(params)
}
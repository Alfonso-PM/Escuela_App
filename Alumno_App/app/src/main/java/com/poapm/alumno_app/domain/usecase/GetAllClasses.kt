package com.poapm.alumno_app.domain.usecase

import com.poapm.alumno_app.core.interactor.UseCase
import com.poapm.alumno_app.data.dto.ClassResponse
import com.poapm.alumno_app.domain.repository.ClassRepository
import javax.inject.Inject

class GetAllClasses @Inject constructor(private val classRepository: ClassRepository) :
    UseCase<ClassResponse, String>() {

    override suspend fun run(params: String) = classRepository.getAllClasses()
}
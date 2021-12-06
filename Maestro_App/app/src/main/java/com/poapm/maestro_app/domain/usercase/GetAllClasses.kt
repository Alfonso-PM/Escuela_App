package com.poapm.maestro_app.domain.usercase

import com.poapm.maestro_app.core.interactor.UseCase
import com.poapm.maestro_app.data.dto.ClassResponse
import com.poapm.maestro_app.domain.repository.ClassRepository
import javax.inject.Inject

class GetAllClasses @Inject constructor(private val classRepository: ClassRepository) :
    UseCase<ClassResponse, String>() {

    override suspend fun run(params: String) = classRepository.getAllClasses()
}